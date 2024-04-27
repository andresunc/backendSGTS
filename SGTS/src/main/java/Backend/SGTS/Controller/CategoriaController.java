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

import Backend.SGTS.Entity.CategoriaEntity;
import Backend.SGTS.Service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	// Inyecto categoria service
	@Autowired
	CategoriaService categoriaService;

	// Obtener todas las categorias
	@GetMapping("/getAll")
	public List<CategoriaEntity> getAll() {
		return categoriaService.getAll();
	}

	// Obtengo una categoria por id
	@GetMapping("/{id}")
	public CategoriaEntity getById(@PathVariable Integer id) {
		return categoriaService.getById(id);
	}

	// Creo una categoria
	@PostMapping("/create")
	public CategoriaEntity create(@RequestBody CategoriaEntity categoria) {
		return categoriaService.create(categoria);
	}

	// Actualizo una categoria
	@PutMapping("/update/{id}")
	public CategoriaEntity update(@PathVariable("id") Integer id,
			@RequestBody CategoriaEntity categoria) {

		CategoriaEntity upDateCategoria = categoriaService.getById(id);
		upDateCategoria.setCategoria(categoria.getCategoria());
		categoriaService.update(upDateCategoria);

		return upDateCategoria;
	}

	/*
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		categoriaService.delete(id);
	}
	*/

}
