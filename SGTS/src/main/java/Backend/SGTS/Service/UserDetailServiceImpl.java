package Backend.SGTS.Service;

import Backend.SGTS.Entity.RolEntity;
import Backend.SGTS.Entity.UsuarioEntity;
import Backend.SGTS.Entity.Dto.RolDto;
import Backend.SGTS.Repository.RolRepository;
import Backend.SGTS.Repository.UsuarioRepository;
import Backend.SGTS.Repository.Dto.DtoRepositoryRol;
import Backend.SGTS.Utils.JwtUtils;
import Backend.SGTS.security.AuthCreateUserRequest;
import Backend.SGTS.security.AuthLoginRequest;
import Backend.SGTS.security.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private RolRepository rolRepository;
    
    @Autowired
    private DtoRepositoryRol dtoRepositoryRol;

    @Override
    public UserDetails loadUserByUsername(String username) {

        UsuarioEntity userEntity = userRepository.findUsuarioEntityByUsername(username).orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        userEntity.getRoles().forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEmun().name()))));

        userEntity.getRoles().stream().flatMap(role -> role.getPermisoList().stream()).forEach(permiso -> authorityList.add(new SimpleGrantedAuthority(permiso.getNombre())));


        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.isEnabled(), userEntity.isAccountNoExpired(), userEntity.isCredentialNoExpired(), userEntity.isAccountNoLocked(), authorityList);
    }

    public AuthResponse createUser(AuthCreateUserRequest createRoleRequest) {

        String username = createRoleRequest.username();
        String password = createRoleRequest.password();
        Integer id_recursogg = createRoleRequest.id_recurso();

        List<String> rolesRequest = createRoleRequest.roleRequest().roleListName();

        Set<RolEntity> roleEntityList = rolRepository.findByRoleEnumIn(rolesRequest).stream().collect(Collectors.toSet());

        if (roleEntityList.isEmpty()) {
            throw new IllegalArgumentException("El rol especifico no existe.");
        }

        UsuarioEntity userEntity = UsuarioEntity.builder().username(username)
                .password(passwordEncoder.encode(password))
                .roles(roleEntityList)
                .isEnabled(true)
                .accountNoLocked(true)
                .accountNoExpired(true)
                .credentialNoExpired(true)
                .recursoGgIdRecursoGg(id_recursogg)
                .build();

        UsuarioEntity userSaved = userRepository.save(userEntity);

        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

        userSaved.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEmun().name()))));

        userSaved.getRoles().stream().flatMap(role -> role.getPermisoList().stream()).forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getNombre())));

        SecurityContext securityContextHolder = SecurityContextHolder.getContext();
        Authentication authentication = new UsernamePasswordAuthenticationToken(userSaved, null, authorities);

        String accessToken = jwtUtils.createToken(authentication);

        List<RolDto> roles = dtoRepositoryRol.obtenerRolesPorUsuario(userEntity.getIdUsuario());
        AuthResponse authResponse = new AuthResponse(username, userEntity.getIdUsuario(), userEntity.getRecursoGgIdRecursoGg(), roles, "usuario creado con exito", accessToken, true);
        return authResponse;
    }

    public AuthResponse loginUser(AuthLoginRequest authLoginRequest) {

        String username = authLoginRequest.username();
        String password = authLoginRequest.password();

        Optional<UsuarioEntity> userOptional = userRepository.findUsuarioEntityByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("El usuario " + username + " no existe.");
        }
        UsuarioEntity usuario = userOptional.get();
        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);

        List<RolDto> roles = dtoRepositoryRol.obtenerRolesPorUsuario(usuario.getIdUsuario());
        AuthResponse authResponse = new AuthResponse(username, usuario.getIdUsuario(), usuario.getRecursoGgIdRecursoGg(),  roles, "User loged succesfully", accessToken, true);
        return authResponse;
    }

    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException(String.format("Invalid username or password"));
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
        	System.out.println("Invalid username or password");
            throw new BadCredentialsException("Invalid username or password");
        }

        if (!userDetails.isEnabled()) {
        	System.out.println("Usuario Deshabilitado");
            throw new BadCredentialsException("Usuario Deshabilitado");
        }

        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
    }
    
    public AuthResponse updateUser(Integer userId, AuthCreateUserRequest updateUserRequest, boolean isEnabled) {
        // Buscar el usuario existente por ID
        UsuarioEntity userEntity = userRepository.findById(userId)
            .orElseThrow(() -> new UsernameNotFoundException("El usuario con ID " + userId + " no existe."));

        // Actualizar los campos necesarios
        //userEntity.setUsername(updateUserRequest.username());
        userEntity.setPassword(passwordEncoder.encode(updateUserRequest.password()));
        userEntity.setEnabled(isEnabled);
        //userEntity.setRecursoGgIdRecursoGg(updateUserRequest.id_recurso());

        // Actualizar roles
        List<String> rolesRequest = updateUserRequest.roleRequest().roleListName();
        Set<RolEntity> roleEntityList = rolRepository.findByRoleEnumIn(rolesRequest).stream().collect(Collectors.toSet());
        if (roleEntityList.isEmpty()) {
            throw new IllegalArgumentException("El rol especifico no existe.");
        }
        userEntity.setRoles(roleEntityList);

        // Guardar los cambios
        UsuarioEntity updatedUser = userRepository.save(userEntity);

        // Preparar respuesta
        List<RolDto> roles = dtoRepositoryRol.obtenerRolesPorUsuario(updatedUser.getIdUsuario());
        AuthResponse authResponse = new AuthResponse(updatedUser.getUsername(), updatedUser.getIdUsuario(), updatedUser.getRecursoGgIdRecursoGg(), roles, "Usuario actualizado con exito", null, true);
        return authResponse;
    }
    
    public void reset(Integer id, String password) {
        // Buscar el usuario existente por ID
        UsuarioEntity userEntity = userRepository.findById(id)
            .orElseThrow(() -> new UsernameNotFoundException("El usuario con ID " + id + " no existe."));

        String encodedPassword = passwordEncoder.encode(password);
        System.out.println(password);
        System.out.println("Encoded password: " + encodedPassword);

        userEntity.setPassword(encodedPassword);
        // Guardar los cambios
        userRepository.save(userEntity);
    }
}
