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

import Backend.SGTS.Entity.RolEntity;
import Backend.SGTS.Service.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {

	// Inyecto servicio
	@Autowired
	RolService rolService;
	
	// Obtengo todos los roles
	@GetMapping("/getAll")
	public List<RolEntity> getAll() {
		return rolService.getAll();
	}
	
	// Obtengo un rol por id
	@GetMapping("/{id}")
	public RolEntity getById(@PathVariable Integer id) {
		return rolService.getById(id);
	}
	
	// Creo un rol
	@PostMapping("/create")
	public RolEntity create(@RequestBody RolEntity rol) {
		return rolService.create(rol);
	}
	
	// Actualizo un rol
	@PutMapping("/update/{id}")
	public RolEntity update(@PathVariable("id") Integer id, @RequestBody RolEntity rol) {

		RolEntity upDateRol = rolService.getById(id);
		upDateRol.setRoleEmun(rol.getRoleEmun());
		rolService.update(upDateRol);

		return upDateRol;
	}
	
	// Elimino un rol
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		rolService.delete(id);
	}
}
