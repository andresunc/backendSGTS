package Backend.SGTS.Controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Entity.RenovarServicioEntity;
import Backend.SGTS.Entity.ServicioEntity;
import Backend.SGTS.Service.ServicioService;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

	// Inyecto Servicio de Servicio
	@Autowired
	ServicioService servicioService;
	
	// Obtengo todos los servicios
	@GetMapping("/getAll")
	public List<ServicioEntity> getAll() {
		return servicioService.getAll();
	}
	
	// Obtengo un servicio por id
	@GetMapping("/{id}")
	public ServicioEntity getById(@PathVariable Integer id) {
		return servicioService.getById(id);
	}
	
	// Creo un servicio
	@PostMapping("/create")
	public ServicioEntity create(@RequestBody ServicioEntity servicio) {
		return servicioService.create(servicio);
	}
	
	// Actualizo un servicio
	@PutMapping("/update/{id}")
	public ServicioEntity update(@PathVariable("id") Integer id, @RequestBody ServicioEntity servicio) {

		ServicioEntity upDateServicio = servicioService.getById(id);
		
		// Verificar y actualizar los atributos solo si han cambiado
	    if (Objects.nonNull(servicio.getFechaVencExpediente())) {
	        upDateServicio.setFechaVencExpediente(servicio.getFechaVencExpediente());
	    }
	    if (Objects.nonNull(servicio.getFechaHoraAlertaVenc())) {
	        upDateServicio.setFechaHoraAlertaVenc(servicio.getFechaHoraAlertaVenc());
	    }
	    if (Objects.nonNull(servicio.getRecurrencia())) {
	        upDateServicio.setRecurrencia(servicio.getRecurrencia());
	    }
	    /* Se supone que el Tipo de servicio no es editable
	    if (Objects.nonNull(servicio.getTipoServicioIdTipoServicio())) {
	        upDateServicio.setTipoServicioIdTipoServicio(servicio.getTipoServicioIdTipoServicio());
	    }
	    */
	    if (Objects.nonNull(servicio.getReferenciaIdServicio())) {
	        upDateServicio.setReferenciaIdServicio(servicio.getReferenciaIdServicio());
	    }
	    if (Objects.nonNull(servicio.getComentario())) {
	        upDateServicio.setComentario(servicio.getComentario());
	    }
	    if (Objects.nonNull(servicio.getExpediente())) {
	        upDateServicio.setExpediente(servicio.getExpediente());
	    }

	    servicioService.update(upDateServicio);

		return upDateServicio;
	}
	
	@PostMapping("/renovarServicio")
	public Integer renovarServicio(@RequestBody RenovarServicioEntity request) {
        return servicioService.renovarServicio(request.getId_Servicio(), 
                                               request.getCosto_Servicio(), 
                                               request.getRecurso_GG_id_Recurso_GG(), 
                                               request.getEstado_id_Estado());
    }
	
	/* Función anulada, no se puede borrar directamente un servicio */
	/*
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		servicioService.delete(id);
	}
	*/
}
