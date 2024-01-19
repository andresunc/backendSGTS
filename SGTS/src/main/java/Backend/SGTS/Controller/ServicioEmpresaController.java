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
	
	// Creo un servicioEmpresa	
	@PostMapping("/create")
	public ServicioEmpresaEntity create(@RequestBody ServicioEmpresaEntity servicioEmpresa) {
		return servicioEmpresaService.create(servicioEmpresa);
	}
	
	// Actualizo un servicioEmpresa
	@PutMapping("/update/{id}")
	public ServicioEmpresaEntity update(@PathVariable("id") Integer id,
			@RequestBody ServicioEmpresaEntity servicioEmpresa) {

		ServicioEmpresaEntity upDateServicioEmpresa = servicioEmpresaService.getById(id);
		
		upDateServicioEmpresa.setCostoServicio(servicioEmpresa.getCostoServicio());
		upDateServicioEmpresa.setAlta(servicioEmpresa.getAlta());
		/* Evito que se cambie el ID del servicio original aunque sí se puede editar el servicio original */
		upDateServicioEmpresa.setServicioIdServicio(upDateServicioEmpresa.getServicioIdServicio());
		upDateServicioEmpresa.setEmpresaIdEmpresa(servicioEmpresa.getEmpresaIdEmpresa());
		upDateServicioEmpresa.setRecursoGgIdRecursoGg(servicioEmpresa.getRecursoGgIdRecursoGg());
		upDateServicioEmpresa.setEliminado(servicioEmpresa.getEliminado());
		
		servicioEmpresaService.update(upDateServicioEmpresa);

		return upDateServicioEmpresa;
	}
	
	/* Función anulada, no se puede borrar directamente un servicio-empresa */
	/*
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		servicioEmpresaService.delete(id);
	}
	*/
	
}
