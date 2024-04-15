package Backend.SGTS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Backend.SGTS.Entity.UsuarioEntity;
import Backend.SGTS.Service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	// Inyecto Servicio de Usuario
	@Autowired
	UsuarioService usuarioService;
	
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
	
	// Actualizo un usuario
	@PutMapping("/update/{id}")
	public UsuarioEntity update(@PathVariable("id") Integer id, @RequestBody UsuarioEntity usuario) {

		// Solo puede actualizar el password y el estado del usuario
		UsuarioEntity upDateUsuario = usuarioService.getById(id);
		upDateUsuario.setUsername(usuario.getUsername());
		upDateUsuario.setPassword(usuario.getPassword());
		upDateUsuario.setEnabled(usuario.isEnabled());
		upDateUsuario.setRecursoGgIdRecursoGg(usuario.getRecursoGgIdRecursoGg());
		usuarioService.update(upDateUsuario);

		return upDateUsuario;
	}
	
	// Elimino un usuario
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		usuarioService.delete(id);
	}
}
