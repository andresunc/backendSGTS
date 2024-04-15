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

import Backend.SGTS.Entity.PermisoEntity;
import Backend.SGTS.Service.PermisoService;

@RestController
@RequestMapping("/permiso")
public class PermisoController {

	// Inyecto Servicio de Permiso
	@Autowired
	PermisoService permisoService;
	
	// Obtengo todos los permisos
	@GetMapping("/getAll")
	public List<PermisoEntity> getAll() {
		return permisoService.getAll();
	}
	
	// Obtengo un permiso por id
	@GetMapping("/{id}")
	public PermisoEntity getById(@PathVariable Integer id) {
		return permisoService.getById(id);
	}
	
	// Creo un permiso
	@PostMapping("/create")
	public PermisoEntity create(@RequestBody PermisoEntity permiso) {
		return permisoService.create(permiso);
	}
	
	// Actualizo un permiso
	@PutMapping("/update/{id}")
	public PermisoEntity update(@PathVariable("id") Integer id, @RequestBody PermisoEntity permiso) {

		PermisoEntity upDatePermiso = permisoService.getById(id);

		upDatePermiso.setNombre(permiso.getNombre());
		permisoService.update(upDatePermiso);

		return upDatePermiso;
	}
	
	// Elimino un permiso
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		permisoService.delete(id);
	}
}
