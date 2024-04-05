package Backend.SGTS.Controller;

import java.sql.Timestamp;
import java.time.Instant;
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

import Backend.SGTS.Entity.HistoricoEstadoEntity;
import Backend.SGTS.Service.HistoricoEstadoService;

@RestController
@RequestMapping("/historicoestado")
public class HistoricoEstadoController {

	// Inyecto Servicio de HistoricoEstado
	@Autowired
	HistoricoEstadoService historicoestadoService;
	
	// Obtengo todos los historicoestados
	@GetMapping("/getAll")
	public List<HistoricoEstadoEntity> getAll() {
		return historicoestadoService.getAll();
	}
	
	// Obtengo un historicoestado por id
	@GetMapping("/{id}")
	public HistoricoEstadoEntity getById(@PathVariable Integer id) {
		return historicoestadoService.getById(id);
	}
	
	// Creo un historicoestado
	@PostMapping("/create")
	public HistoricoEstadoEntity create(@RequestBody HistoricoEstadoEntity historicoestado) {
		
		// Establecer la fecha y hora actual
		historicoestado.setFecha(Timestamp.from(Instant.now()));
		return historicoestadoService.create(historicoestado);
	}
	
	// Actualizo un historicoestado
	@PutMapping("/update/{id}")
	public HistoricoEstadoEntity update(@PathVariable("id") Integer id,
			@RequestBody HistoricoEstadoEntity historicoestado) {

		HistoricoEstadoEntity upDateHistoricoEstado = historicoestadoService.getById(id);
		upDateHistoricoEstado.setFecha(historicoestado.getFecha());
		upDateHistoricoEstado.setServicioIdServicio(upDateHistoricoEstado.getServicioIdServicio());
		upDateHistoricoEstado.setEstadoIdEstado(historicoestado.getEstadoIdEstado());
		historicoestadoService.update(upDateHistoricoEstado);

		return upDateHistoricoEstado;
	}
	
	// Elimino un historicoestado
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		historicoestadoService.delete(id);
	}
}
