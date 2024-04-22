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
import Backend.SGTS.Entity.RubroEntity;
import Backend.SGTS.Service.RubroService;

@RestController
@RequestMapping("/rubro")
public class RubroController {

	// Inyecto Servicio de Rubro
	@Autowired
	RubroService rubroService;
	
	// Obtengo todos los rubros no eliminados
		@GetMapping("/getAllNotDeleted")
		public List<RubroEntity> getAllNotDeleted() {
			return rubroService.getAllNotDeleted();
		}
		
		// Obtengo todos los rubros eliminados
		@GetMapping("/getAllDeleted")
		public List<RubroEntity> getAllDeleted() {
			return rubroService.getAllDeleted();
		}
	
	// Obtengo todos los rubros
	@GetMapping("/getAll")
	public List<RubroEntity> getAll() {
		return rubroService.getAll();
	}
	
	// Obtengo un rubro por id
	@GetMapping("/{id}")
	public RubroEntity getById(@PathVariable Integer id) {
		return rubroService.getById(id);
	}
	
	// Creo un rubro
	@PostMapping("/create")
	public RubroEntity create(@RequestBody RubroEntity rubro) {
		return rubroService.create(rubro);
	}
	
	// Actualizo un rubro
	@PutMapping("/update/{id}")
	public RubroEntity update(@PathVariable("id") Integer id, @RequestBody RubroEntity rubro) {
		
		RubroEntity upDateRubro = rubroService.getById(id);
		upDateRubro.setRubro(rubro.getRubro());

 		rubroService.update(upDateRubro);
 		
 		return upDateRubro;
	}
	
	// Elimino un rubro de manera lógica
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		rubroService.delete(id);
	}

}
