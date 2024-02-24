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

import Backend.SGTS.Entity.EstadoEntity;
import Backend.SGTS.Entity.RecursoGgEntity;
import Backend.SGTS.Service.RecursoService;

@RestController
@RequestMapping("/recurso")
public class RecursoController {

	// Inyecto Servicio de Recurso
	@Autowired
	RecursoService recursoService;

	// Obtengo todos los estados no eliminados
	@GetMapping("/getAllNotDeleted")
	public List<RecursoGgEntity> getAllNotDeleted() {
		return recursoService.getAllNotDeleted();
	}

	// Obtengo todos los estados eliminados
	@GetMapping("/getAllDeleted")
	public List<RecursoGgEntity> getAllDeleted() {
		return recursoService.getAllDeleted();
	}

	// Obtengo todos los recursos
	@GetMapping("/getAll")
	public List<RecursoGgEntity> getAll() {
		return recursoService.getAll();
	}

	// Obtengo un recurso por id
	@GetMapping("/{id}")
	public RecursoGgEntity getById(@PathVariable Integer id) {
		return recursoService.getById(id);
	}

	// Creo un recurso
	@PostMapping("/create")
	public RecursoGgEntity create(@RequestBody RecursoGgEntity recurso) {
		return recursoService.create(recurso);
	}

	// Actualizo un recurso
	@PutMapping("/update/{id}")
	public RecursoGgEntity update(@PathVariable("id") Integer id, @RequestBody RecursoGgEntity recurso) {

		RecursoGgEntity upDateRecurso = recursoService.getById(id);
		upDateRecurso.setRolIdRol(recurso.getRolIdRol());
		upDateRecurso.setPersonaIdPersona(recurso.getPersonaIdPersona());
		upDateRecurso.setEliminado(recurso.getEliminado());
		recursoService.update(upDateRecurso);

		return upDateRecurso;
	}

	// Elimino un recurso
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		recursoService.delete(id);
	}
}
