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
import Backend.SGTS.Entity.RubroEntity;
import Backend.SGTS.Service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	// Inyecto Servicio de Item
	@Autowired
	ItemService itemService;

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
	public ItemEntity create(@RequestBody ItemEntity item) {
		/**
		 * El atributo desvio acumulado inicialmente se setea con el valor de la duración estandar inicial 
		 * "configurada al momento de la creación del item 
		 */
		item.setDesvioAcumulado(item.getDuracionEstandar());
		return itemService.create(item);
	}

	// Actualizo un item
	@PutMapping("/update/{id}")
	public ItemEntity update(@PathVariable("id") Integer id, @RequestBody ItemEntity item) {

		ItemEntity upDateItem = itemService.getById(id);
		upDateItem.setTipoServicioIdTipoServicio(item.getTipoServicioIdTipoServicio());
		upDateItem.setDependenciaIdDependencia(item.getDependenciaIdDependencia());
		upDateItem.setRubroIdRubro(item.getRubroIdRubro());
		upDateItem.setTipoItemIdTipoItem(item.getTipoItemIdTipoItem());
		upDateItem.setRequisitoIdRequisito(item.getRequisitoIdRequisito());

		itemService.update(upDateItem);
		return upDateItem;
	}

	// Elimino un item
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		itemService.delete(id);
	}
}
