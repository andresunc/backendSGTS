package Backend.SGTS.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Entity.PersonaEntity;
import Backend.SGTS.Entity.RecursoGgEntity;
import Backend.SGTS.Entity.UsuarioEntity;
import Backend.SGTS.Entity.Dto.UsuarioDto;
import Backend.SGTS.Repository.Dto.DtoRepositoryUsuario;
import Backend.SGTS.Service.PersonaService;
import Backend.SGTS.Service.RecursoService;
import Backend.SGTS.Service.UserDetailServiceImpl;
import Backend.SGTS.Service.UsuarioService;
import Backend.SGTS.security.AuthCreateRoleRequest;
import Backend.SGTS.security.AuthCreateUserRequest;
import Backend.SGTS.security.AuthResponse;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	// Inyecto Servicio de Usuario
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	PersonaService personaService;
	@Autowired
	RecursoService recursoService;
	@Autowired
	private UserDetailServiceImpl userDetailService;
	@Autowired
	private DtoRepositoryUsuario dtoRepositoryUsuario;

	// Obtengo todos los usuarios
	@GetMapping("/getAll")
	public List<UsuarioEntity> getAll() {
		return usuarioService.getAll();
	}

	@GetMapping("/getUsersDto")
	public List<UsuarioDto> obtenerUsuarios() {
		return dtoRepositoryUsuario.obtenerUsuarios();
	}

	// Obtengo un usuario por id
	@GetMapping("/{id}")
	public UsuarioEntity getById(@PathVariable Integer id) {
		return usuarioService.getById(id);
	}

	// Creo un usuario
	@PostMapping("/create")
	public UsuarioEntity create(@RequestBody UsuarioEntity usuario) {
		return usuarioService.create(usuario);
	}

	// Creo un usuario
	@Transactional
	@PostMapping("/registro")
	public void registro(@RequestBody Map<String, Object> requestMap) {

		String username = (String) requestMap.get("username");
		String password = (String) requestMap.get("password");
		String nombre = (String) requestMap.get("nombre");
		String apellido = (String) requestMap.get("apellido");
		String dni = (String) requestMap.get("dni");
		String telefono = (String) requestMap.get("telefono");
		String email = (String) requestMap.get("email");
		String rol = (String) requestMap.get("rol");
		List<String> roles = new ArrayList<>();
		roles.add(rol);

		PersonaEntity persona = new PersonaEntity();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setDni(dni);
		persona.setTelefono(telefono);
		persona.setEmail(email);
		personaService.create(persona);

		Integer idPersona = persona.getIdPersona();

		RecursoGgEntity recurso = new RecursoGgEntity();
		recurso.setPersonaIdPersona(idPersona);
		recurso.setEliminado((byte) 0);
		recursoService.create(recurso);

		Integer idRecurso = recurso.getIdRecursoGg();

		// Crear la solicitud de usuario con el idRecurso y la lista de roles
		AuthCreateRoleRequest roleRequest = new AuthCreateRoleRequest(roles);
		AuthCreateUserRequest updatedUserRequest = new AuthCreateUserRequest(username, password, idRecurso,
				roleRequest);

		this.userDetailService.createUser(updatedUserRequest);
	}

	@PutMapping("/update")
	public ResponseEntity<AuthResponse> updateUser(@RequestBody UsuarioDto usuarioDto) {

		Integer idUsuario = usuarioDto.getIdUsuario();
		Integer idPersona = usuarioDto.getIdPersona();
		String nombre = usuarioDto.getNombre();
		String apellido = usuarioDto.getApellido();
		String dni = usuarioDto.getDni();
		String telefono = usuarioDto.getTelefono();
		String email = usuarioDto.getEmail();
		String rol = usuarioDto.getRol();
		Boolean isEnabled = usuarioDto.getIsEnabled();

		PersonaEntity upDatePersona = personaService.getById(idPersona);
		
		upDatePersona.setDni(dni);
		upDatePersona.setNombre(nombre);
		upDatePersona.setApellido(apellido);
		upDatePersona.setTelefono(telefono);
		upDatePersona.setEmail(email);
		personaService.update(upDatePersona);

		List<String> roles = new ArrayList<>();
		roles.add(rol);

		AuthCreateRoleRequest roleRequest = new AuthCreateRoleRequest(roles);
		AuthCreateUserRequest updatedUserRequest = new AuthCreateUserRequest(""/* no se puede editar el usuario */,
				"", /* no se edita desde acá, se resetea en resetPassword() */
				000, /* no se puede editar el idRecurso */
				roleRequest);
		AuthResponse response = userDetailService.updateUser(idUsuario, updatedUserRequest, isEnabled);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/resetpassword/{id}")
	public ResponseEntity<Map<String, String>> resetPassword(@PathVariable("id") Integer id,
			@RequestBody Map<String, String> request) {
		try {
			String password = request.get("password");
			if (password == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(Collections.singletonMap("message", "Password is required"));
			}
			userDetailService.reset(id, password);
			return ResponseEntity.ok(Collections.singletonMap("message", "OK"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Collections.singletonMap("message", "NO OK"));
		}
	}

	@PutMapping("/changepassword/{id}")
	public ResponseEntity<Map<String, String>> changePassword(@PathVariable("id") Integer id,
			@RequestBody Map<String, String> request) {
		try {
			String password = request.get("password");
			if (password == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(Collections.singletonMap("message", "Password is required"));
			}
			userDetailService.reset(id, password);
			return ResponseEntity.ok(Collections.singletonMap("message", "OK"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Collections.singletonMap("message", "NO OK"));
		}
	}

	// Actualizo un usuario
	@PutMapping("/updater/{id}")
	public UsuarioEntity update(@PathVariable("id") Integer id, @RequestBody UsuarioEntity usuario) {

		// Solo puede actualizar el password y el estado del usuario
		UsuarioEntity upDateUsuario = usuarioService.getById(id);

		// Actualizo solo si el usuario y los roles no son nulos o vacíos
		if (usuario != null && usuario.getRoles() != null && !usuario.getRoles().isEmpty()) {
			// Actualizo los roles
			upDateUsuario.setRoles(usuario.getRoles());
		}

		upDateUsuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

		usuarioService.update(upDateUsuario);

		return upDateUsuario;
	}

	// Elimino un usuario de manera logica
	@DeleteMapping("/deletelogico/{id}")
	public ResponseEntity<Void> deleteLogicoUsuario(@PathVariable Integer id) {
		usuarioService.deleteUsuarioLogica(id);
		return ResponseEntity.noContent().build();
	}

	// Elimino un usuario de manera logica
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		UsuarioEntity currentUser = this.getById(id);
		
		Integer recursoId = currentUser.getRecursoGgIdRecursoGg();
		RecursoGgEntity recurso = recursoService.getById(recursoId);
		recurso.setEliminado((byte) 1);
		recursoService.update(recurso);
		
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
