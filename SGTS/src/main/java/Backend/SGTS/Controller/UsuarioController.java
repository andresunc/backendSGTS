package Backend.SGTS.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import Backend.SGTS.Service.PersonaService;
import Backend.SGTS.Service.RecursoService;
import Backend.SGTS.Service.UserDetailServiceImpl;
import Backend.SGTS.Service.UsuarioService;
import Backend.SGTS.security.AuthCreateRoleRequest;
import Backend.SGTS.security.AuthCreateUserRequest;

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

	// Obtengo todos los usuarios
	@GetMapping("/getAll")
	public List<UsuarioEntity> getAll() {
		return usuarioService.getAll();
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
        AuthCreateUserRequest updatedUserRequest = new AuthCreateUserRequest(username, password, idRecurso, roleRequest);
        
        this.userDetailService.createUser(updatedUserRequest);
	}

	// Actualizo un usuario
	@PutMapping("/update/{id}")
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
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteLogicoUsuario(@PathVariable Integer id) {
		usuarioService.deleteUsuarioLogica(id);
		return ResponseEntity.noContent().build();
	}
}
