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

import Backend.SGTS.Entity.RequisitoEntity;
import Backend.SGTS.Service.RequisitoService;

@RestController
@RequestMapping("/requisito")
public class RequisitoController {

	// Inyecto Servicio de Requisito
	@Autowired
	RequisitoService requisitoService;

	// Obtengo todos los requisitos
	@GetMapping("/getAll")
	public List<RequisitoEntity> getAll() {
		return requisitoService.getAll();
	}

	// Obtengo todos los requisitos no eliminados
	@GetMapping("/getAllNotDeleted")
	public List<RequisitoEntity> getAllNotDeleted() {
		return requisitoService.getAllNotDeleted();
	}

	// Obtengo todos los requisitos eliminados
	@GetMapping("/getAllDeleted")
	public List<RequisitoEntity> getAllDeleted() {
		return requisitoService.getAllDeleted();
	}

	// Obtengo un requisito por id
	@GetMapping("/{id}")
	public RequisitoEntity getById(@PathVariable Integer id) {
		return requisitoService.getById(id);
	}

	// Creo un requisito
	@PostMapping("/create")
	public RequisitoEntity create(@RequestBody RequisitoEntity requisito) {
		return requisitoService.create(requisito);
	}

	// Actualizo un requisito
	@PutMapping("/update/{id}")
	public RequisitoEntity update(@PathVariable("id") Integer id, @RequestBody RequisitoEntity requisito) {

		RequisitoEntity upDateRequisito = requisitoService.getById(id);
		upDateRequisito.setDescripcion(requisito.getDescripcion());

		requisitoService.update(upDateRequisito);

		return upDateRequisito;
	}

	// Elimino un requisito
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		requisitoService.delete(id);
	}
}
