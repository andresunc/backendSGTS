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

import Backend.SGTS.Entity.TipoServicioEntity;
import Backend.SGTS.Service.TipoServicioService;

@RestController
@RequestMapping("/tipoServicio")
public class TipoServicioController {

	// Inyecto Servicio de TipoServicio
	@Autowired
	TipoServicioService tipoServicioService;
	
	// Obtengo todos los tipoServicios no eliminados
	@GetMapping("/getAllNotDeleted")
	public List<TipoServicioEntity> getAllNotDeleted() {
		return tipoServicioService.getAllNotDeleted();
	}
	
	// Obtengo todos los tipoServicios eliminados
	@GetMapping("/getAllDeleted")
	public List<TipoServicioEntity> getAllDeleted() {
		return tipoServicioService.getAllDeleted();
	}
	
	// Obtengo todos los tipoServicios
	@GetMapping("/getAll")
	public List<TipoServicioEntity> getAll() {
		return tipoServicioService.getAll();
	}
	
	// Obtengo un tipoServicio por id
	@GetMapping("/{id}")
	public TipoServicioEntity getById(@PathVariable Integer id) {
		return tipoServicioService.getById(id);
	}
	
	// Creo un tipoServicio
	@PostMapping("/create")
	public TipoServicioEntity create(@RequestBody TipoServicioEntity tipoServicio) {
		return tipoServicioService.create(tipoServicio);
	}
	
	// Actualizo un tipoServicio
	@PutMapping("/update/{id}")
	public TipoServicioEntity update(@PathVariable("id") Integer id, @RequestBody TipoServicioEntity tipoServicio) {

		TipoServicioEntity upDateTipoServicio = tipoServicioService.getById(id);
		upDateTipoServicio.setTipoServicio(tipoServicio.getTipoServicio());
		tipoServicioService.update(upDateTipoServicio);

		return upDateTipoServicio;
	}
	
	// Elimino un tipoServicio
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		// Agregar lógica para eliminar un tipoServicio de manera lógica
	}
}
