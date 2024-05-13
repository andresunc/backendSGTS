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

import Backend.SGTS.Entity.ItemEntity;
import Backend.SGTS.Entity.RiesgoEntity;
import Backend.SGTS.Service.RiesgoService;

@RestController
@RequestMapping("/riesgo")
public class RiesgoController {

	// Inyecto Servicio de Riesgo
	@Autowired
	RiesgoService riesgoService;

	// Obtengo todos los riesgos
	@GetMapping("/getAll")
	public List<RiesgoEntity> getAll() {
		return riesgoService.getAll();
	}

	// Obtengo todos los items no eliminados
	@GetMapping("/getAllNotDeleted")
	public List<RiesgoEntity> getAllNotDeleted() {
		return riesgoService.getAllNotDeleted();
	}

	// Obtengo todos los items eliminados
	@GetMapping("/getAllDeleted")
	public List<RiesgoEntity> getAllDeleted() {
		return riesgoService.getAllDeleted();
	}

	// Obtengo un riesgo por id
	@GetMapping("/{id}")
	public RiesgoEntity getById(@PathVariable Integer id) {
		return riesgoService.getById(id);
	}

	// Creo un riesgo
	@PostMapping("/create")
	public RiesgoEntity create(@RequestBody RiesgoEntity riesgo) {
		return riesgoService.create(riesgo);
	}

	// Actualizo un riesgo
	@PutMapping("/update/{id}")
	public RiesgoEntity update(@PathVariable("id") Integer id, @RequestBody RiesgoEntity riesgo) {

		RiesgoEntity upDateRiesgo = riesgoService.getById(id);
		upDateRiesgo.setRiesgo(riesgo.getRiesgo());
		riesgoService.update(upDateRiesgo);

		return upDateRiesgo;
	}

	// Elimino un riesgo de manera lógica
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		riesgoService.delete(id);
	}
}
