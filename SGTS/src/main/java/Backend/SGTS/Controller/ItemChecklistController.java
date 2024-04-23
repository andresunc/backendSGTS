package Backend.SGTS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/itemChecklist")
public class ItemChecklistController {

	// Inyecto Servicio de ItemChecklist
	@Autowired
	ItemChecklistService itemChecklistService;
	
	
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
	@PutMapping("/update/{id}")
	public ResponseEntity<ItemChecklistEntity> update(@PathVariable("id") Integer id, @RequestBody ItemChecklistEntity itemChecklist) {
	    
		if (id == null || itemChecklist == null) {
	        return ResponseEntity.badRequest().build(); // Retorna una respuesta de error si el ID o el item son nulos
	    }

	    ItemChecklistEntity existingItem = itemChecklistService.getById(id);
	    if (existingItem == null) {
	        return ResponseEntity.notFound().build(); // Retorna una respuesta de error si el item no existe
	    }

	    // Verifica cada campo para evitar la actualización con valores nulos
	    if (itemChecklist.getFinConDesvio() != null) {
	        existingItem.setFinConDesvio(itemChecklist.getFinConDesvio());
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
	    if (itemChecklist.getItemIdItem() != null) {
	        existingItem.setItemIdItem(itemChecklist.getItemIdItem());
	    }
	    if (itemChecklist.getCompleto() != null) {
	        existingItem.setCompleto(itemChecklist.getCompleto());
	    }

	    itemChecklistService.update(existingItem);
	    return ResponseEntity.ok(existingItem);
	}

	/* Función deshabilitada, no borramos un ítem del checklist
	 * 
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		itemChecklistService.delete(id);
	}
	*/
}
