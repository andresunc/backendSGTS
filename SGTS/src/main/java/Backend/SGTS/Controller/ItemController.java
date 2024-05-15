package Backend.SGTS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Entity.ItemEntity;
import Backend.SGTS.Entity.RequisitoEntity;
import Backend.SGTS.Service.ItemService;
import Backend.SGTS.Service.RequisitoService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/item")
public class ItemController {

	// Inyecto Servicio de Item
	@Autowired
	ItemService itemService;
	@Autowired
	RequisitoService requisitoService;

	// Obtengo todos los items
	@GetMapping("/getAll")
	public List<ItemEntity> getAll() {
		return itemService.getAll();
	}

	// Obtengo todos los items no eliminados
	@GetMapping("/getAllNotDeleted")
	public List<ItemEntity> getAllNotDeleted() {
		return itemService.getAllNotDeleted();
	}

	// Obtengo todos los items eliminados
	@GetMapping("/getAllDeleted")
	public List<ItemEntity> getAllDeleted() {
		return itemService.getAllDeleted();
	}

	// Obtengo un item por id
	@GetMapping("/{id}")
	public ItemEntity getById(@PathVariable Integer id) {
		return itemService.getById(id);
	}

	// Creo un item
	@PostMapping("/create")
	@Transactional
	public ResponseEntity<?> create(@RequestBody ItemEntity item) {

		try {
			// Crear el requisito primero
			RequisitoEntity requisito = new RequisitoEntity();
			// Asignar la descripción del requisito
			requisito.setDescripcion(item.getDescripcion());
			requisito.setEliminado(false);

			// Guardar el requisito en la base de datos
			requisito = requisitoService.create(requisito);

			// Asignar su ID al ítem
			item.setRequisitoIdRequisito(requisito.getIdRequisito());

			// Setear valores por defecto y crear el ítem
			item.setDesvioAcumulado(item.getDuracionEstandar());
			item.setContCambios(1);
			item.setEliminado(false);
			ItemEntity createdItem = itemService.create(item);

			// Devuelve el ítem creado
			return ResponseEntity.ok(createdItem);
		} catch (Exception e) {
			// Si ocurre algún error, deshace cualquier cambio realizado (por ejemplo, el
			// requisito creado)
			// y maneja la excepción adecuadamente
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al crear el ítem: " + e.getMessage());
		}
	}

	// Actualizo un item
	@PutMapping("/update")
	@Transactional
	public ResponseEntity<?> update(@RequestBody ItemEntity item) {

		try {

			RequisitoEntity requisito = requisitoService.getById(item.getRequisitoIdRequisito());
			if (!requisito.getDescripcion().equals(item.getDescripcion())) {
				requisito.setDescripcion(item.getDescripcion());
				requisitoService.update(requisito);
			}

			ItemEntity upDateItem = itemService.getById(item.getIdItem());
			upDateItem.setTipoServicioIdTipoServicio(item.getTipoServicioIdTipoServicio());
			upDateItem.setDependenciaIdDependencia(item.getDependenciaIdDependencia());
			upDateItem.setRubroIdRubro(item.getRubroIdRubro());
			upDateItem.setTipoItemIdTipoItem(item.getTipoItemIdTipoItem());

			itemService.update(upDateItem);
			return ResponseEntity.ok(upDateItem);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al crear el ítem: " + e.getMessage());
		}
	}

	// Elimino un item de manera lógica
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		itemService.delete(id);
	}
}
