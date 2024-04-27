package Backend.SGTS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Entity.EstadoEntity;
import Backend.SGTS.Service.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	// Inyecto Servicio de Estado
	@Autowired
	EstadoService estadoService;
	
	// Obtengo todos los estados no eliminados
	@GetMapping("/getAllNotDeleted")
	public List<EstadoEntity> getAllNotDeleted() {
		return estadoService.getAllNotDeleted();
	}
	
	// Obtengo todos los estados eliminados
	@GetMapping("/getAllDeleted")
	public List<EstadoEntity> getAllDeleted() {
		return estadoService.getAllDeleted();
	}
	
	// Obtengo todos los estados
	@GetMapping("/getAll")
	public List<EstadoEntity> getAll() {
		return estadoService.getAll();
	}
	
	// Obtengo un estado por id
	@GetMapping("/{id}")
	public EstadoEntity getById(@PathVariable Integer id) {
		return estadoService.getById(id);
	}
	
	// Creo un estado
	@PostMapping("/create")
	public EstadoEntity create(@RequestBody EstadoEntity estado) {
		return estadoService.create(estado);
	}
	
	// Actualizo un estado
	@PutMapping("/update/{id}")
	public EstadoEntity update(@PathVariable("id") Integer id, @RequestBody EstadoEntity estado) {

		EstadoEntity upDateEstado = estadoService.getById(id);
		upDateEstado.setTipoEstado(estado.getTipoEstado());
		upDateEstado.setEliminado(estado.getEliminado());
		upDateEstado.setIdCategoria(estado.getIdCategoria());
		estadoService.update(upDateEstado);

		return upDateEstado;
	}
	
	// Método para eliminar un estado de manera lógica
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		estadoService.delete(id);
	}
	
}
