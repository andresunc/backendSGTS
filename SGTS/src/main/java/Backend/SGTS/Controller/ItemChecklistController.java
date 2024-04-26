package Backend.SGTS.Controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Entity.ItemChecklistEntity;
import Backend.SGTS.Service.ItemChecklistService;
import Backend.SGTS.Service.ItemService;

@RestController
@RequestMapping("/itemChecklist")
public class ItemChecklistController {

	// Inyecto Servicio de ItemChecklist
	@Autowired
	ItemChecklistService itemChecklistService;
	@Autowired
	ItemService itemService;

	// Obtengo todos los items de checklist
	@GetMapping("/getAll")
	public List<ItemChecklistEntity> getAll() {
		return itemChecklistService.getAll();
	}

	// Obtengo un item de checklist por id
	@GetMapping("/{id}")
	public ItemChecklistEntity getById(@PathVariable Integer id) {
		return itemChecklistService.getById(id);
	}

	// Creo un item de checklist
	@PostMapping("/create")
	public ItemChecklistEntity create(@RequestBody ItemChecklistEntity itemChecklist) {
		return itemChecklistService.create(itemChecklist);
	}

	// Actualizo un item de checklist
	@PutMapping("/update")
	public ResponseEntity<List<ItemChecklistEntity>> updateAll(@RequestBody List<ItemChecklistEntity> itemChecklistList) {

	    List<ItemChecklistEntity> updatedItems = new ArrayList<>();

	    for (ItemChecklistEntity itemChecklist : itemChecklistList) {
	        
	    	try {
	            Integer id = itemChecklist.getIdItemChecklist(); // Obtener el ID del elemento actual

	            ItemChecklistEntity existingItem = itemChecklistService.getById(id); // Buscar el itemChecklist en la bd

	            // Agregar validación para detener el método si el ítem está completo
	            if (existingItem == null) {
	                return ResponseEntity.notFound().build(); // Retorna una respuesta de error si el item no existe
	            }

	            // Actualizar lógica *
	            if (!existingItem.getCompleto()) {
	                existingItem.setFinConDesvio(Timestamp.from(Instant.now()));
	                existingItem.setCompleto(itemChecklist.getCompleto());

	                // Calcular el desvío cuando se finaliza el ítem
	                itemService.setDeviation(
	                        existingItem.getFinEstandar(),
	                        existingItem.getFinConDesvio(),
	                        existingItem.getItemIdItem());
	            }

	            if (itemChecklist.getNotificado() != null) {
	                existingItem.setNotificado(itemChecklist.getNotificado());
	            }
	            if (itemChecklist.getTasaValor() != null) {
	                existingItem.setTasaValor(itemChecklist.getTasaValor());
	            }
	            if (itemChecklist.getTasaCantidadHojas() != null) {
	                existingItem.setTasaCantidadHojas(itemChecklist.getTasaCantidadHojas());
	            }
	            if (itemChecklist.getUrlComprobanteTasa() != null) {
	                existingItem.setUrlComprobanteTasa(itemChecklist.getUrlComprobanteTasa());
	            }

	            itemChecklistService.update(existingItem);
	            updatedItems.add(existingItem);
	        } catch (Exception e) {
	            // Manejar la excepción adecuadamente, por ejemplo, registrándola o devolviendo una respuesta de error
	            e.printStackTrace(); // Registro de la excepción
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Devolver una respuesta de error
	        }
	    }

	    return ResponseEntity.ok(updatedItems);
	}

	/*
	 * Función deshabilitada, no borramos un ítem del checklist
	 * 
	 * @DeleteMapping("/delete/{id}") public void delete(@PathVariable Integer id) {
	 * itemChecklistService.delete(id); }
	 */
}
