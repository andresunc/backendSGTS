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

import Backend.SGTS.Entity.HistoricoNotificacionesEntity;
import Backend.SGTS.Service.HistoricoNotificacionesService;

@RestController
@RequestMapping("/historiconotificaciones")
public class HistoricoNotificacionesController {

	// Inyecto Servicio de HistoricoNotificaciones
	@Autowired
	HistoricoNotificacionesService historiconotificacionesService;
	
	// Obtengo todos los historiconotificaciones
	@GetMapping("/getAll")
	public List<HistoricoNotificacionesEntity> getAll() {
		return historiconotificacionesService.getAll();
	}
	
	// Obtengo un historiconotificaciones por id
	@GetMapping("/{id}")
	public HistoricoNotificacionesEntity getById(@PathVariable Integer id) {
		return historiconotificacionesService.getById(id);
	}
	
	// Creo un historiconotificaciones
	@PostMapping("/create")
	public HistoricoNotificacionesEntity create(@RequestBody HistoricoNotificacionesEntity historiconotificaciones) {
		return historiconotificacionesService.create(historiconotificaciones);
	}
	
	// Actualizo un historiconotificaciones
	@PutMapping("/update/{id}")
	public HistoricoNotificacionesEntity update(@PathVariable("id") Integer id,
			@RequestBody HistoricoNotificacionesEntity historiconotificaciones) {

		HistoricoNotificacionesEntity upDateHistoricoNotificaciones = historiconotificacionesService.getById(id);
		
		upDateHistoricoNotificaciones.setFecha(historiconotificaciones.getFecha());
		upDateHistoricoNotificaciones.setResuelto(historiconotificaciones.getResuelto());
		upDateHistoricoNotificaciones.setItemChecklistIdItemChecklist(historiconotificaciones.getItemChecklistIdItemChecklist());
		
		historiconotificacionesService.update(upDateHistoricoNotificaciones);
		return upDateHistoricoNotificaciones;
	}
	
	// Elimino un historiconotificaciones
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		historiconotificacionesService.delete(id);
	}
}
