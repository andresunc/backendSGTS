package Backend.SGTS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Entity.ServicioEmpresaEntity;
import Backend.SGTS.Service.ServicioEmpresaService;

@RestController
@RequestMapping("/servicioEmpresa")
public class ServicioEmpresaController {

	// Inyecto Servicio de ServicioEmpresa
	@Autowired
	ServicioEmpresaService servicioEmpresaService;

	// Obtengo todos los servicioEmpresa
	@GetMapping("/getAll")
	public List<ServicioEmpresaEntity> getAll() {
		return servicioEmpresaService.getAll();
	}

	// Obtengo un servicioEmpresa por id
	@GetMapping("/{id}")
	public ServicioEmpresaEntity getById(@PathVariable Integer id) {
		return servicioEmpresaService.getById(id);
	}

	// Obtengo un servicioEmpresa por id
	@GetMapping("byIdServicio/{id}")
	public ServicioEmpresaEntity getByIdServicio(@PathVariable Integer id) {
		return servicioEmpresaService.getByServicioIdServicio(id);
	}

	// Creo un servicioEmpresa
	@PostMapping("/create")
	public ServicioEmpresaEntity create(@RequestBody ServicioEmpresaEntity servicioEmpresa) {
		return servicioEmpresaService.create(servicioEmpresa);
	}

	// Actualizo un servicioEmpresa
	@PutMapping("/updateById/{id}")
	public ServicioEmpresaEntity update(@PathVariable("id") Integer id,
			@RequestBody ServicioEmpresaEntity servicioEmpresa) {

		ServicioEmpresaEntity upDateServicioEmpresa = servicioEmpresaService.getById(id);

		upDateServicioEmpresa.setCostoServicio(servicioEmpresa.getCostoServicio());
		upDateServicioEmpresa.setAlta(servicioEmpresa.getAlta());
		/*
		 * Evito que se cambie el ID del servicio original aunque sí se puede editar el
		 * servicio original
		 */
		upDateServicioEmpresa.setServicioIdServicio(upDateServicioEmpresa.getServicioIdServicio());
		upDateServicioEmpresa.setEmpresaIdEmpresa(servicioEmpresa.getEmpresaIdEmpresa());
		upDateServicioEmpresa.setRecursoGgIdRecursoGg(servicioEmpresa.getRecursoGgIdRecursoGg());
		upDateServicioEmpresa.setEliminado(servicioEmpresa.getEliminado());

		servicioEmpresaService.update(upDateServicioEmpresa);

		return upDateServicioEmpresa;
	}

	// Actualizo un servicioEmpresa buscando por ServicioIdServicio
	@PutMapping("/update/{id}")
	public ResponseEntity<ServicioEmpresaEntity> updateByServicioIdServicio(@PathVariable("id") Integer servicioId,
			@RequestBody ServicioEmpresaEntity servicioEmpresa) {

		// Busca el objeto ServicioEmpresaEntity por su ID
		ServicioEmpresaEntity upDateServicioEmpresa = servicioEmpresaService.getByServicioIdServicio(servicioId);

		if (upDateServicioEmpresa == null) {
			return ResponseEntity.notFound().build();
		}

		if (servicioEmpresa.getCostoServicio() != upDateServicioEmpresa.getCostoServicio()) {
			upDateServicioEmpresa.setCostoServicio(servicioEmpresa.getCostoServicio());
		}

		servicioEmpresaService.update(upDateServicioEmpresa);
		return ResponseEntity.ok(upDateServicioEmpresa);
	}

	// Eliminar un servicioEmpresa buscando por ServicioIdServicio
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteLogicoServicioEmpresa(@PathVariable("id") Integer servicioId) {

		// Busca el objeto ServicioEmpresaEntity por su ID
		ServicioEmpresaEntity servicioEmpresa = servicioEmpresaService.getByServicioIdServicio(servicioId);

		if (servicioEmpresa == null) {
			return ResponseEntity.notFound().build();
		}

		if (servicioEmpresa.getEliminado() == 0) {
			servicioEmpresa.setEliminado(Byte.valueOf((byte) 1));
			servicioEmpresaService.update(servicioEmpresa);
		}

		return ResponseEntity.noContent().build();
	}

	/* Función anulada, no se puede borrar directamente un servicio-empresa */
	/*
	 * @DeleteMapping("/delete/{id}") public void delete(@PathVariable Integer id) {
	 * servicioEmpresaService.delete(id); }
	 */

}
