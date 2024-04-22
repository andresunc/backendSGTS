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
	public ItemChecklistEntity update(@PathVariable("id") Integer id, @RequestBody ItemChecklistEntity itemChecklist) {

		ItemChecklistEntity upDateItemChecklist = itemChecklistService.getById(id);
		if (itemChecklist != null) {
			
			// Se comentan los atributos que no se deberían editar
			//upDateItemChecklist.setInicioEstandar(itemChecklist.getInicioEstandar());
			//upDateItemChecklist.setFinEstandar(itemChecklist.getFinEstandar());
			//upDateItemChecklist.setInicioConDesvio(itemChecklist.getInicioConDesvio());
			upDateItemChecklist.setFinConDesvio(itemChecklist.getFinConDesvio());
			upDateItemChecklist.setNotificado(itemChecklist.getNotificado());
			upDateItemChecklist.setTasaValor(itemChecklist.getTasaValor());
			upDateItemChecklist.setTasaCantidadHojas(itemChecklist.getTasaCantidadHojas());
			upDateItemChecklist.setUrlComprobanteTasa(itemChecklist.getUrlComprobanteTasa());
			//upDateItemChecklist.setServicioIdServicio(itemChecklist.getServicioIdServicio());
			//upDateItemChecklist.setRecursoGgIdRecursoGg(itemChecklist.getRecursoGgIdRecursoGg());
			upDateItemChecklist.setItemIdItem(itemChecklist.getItemIdItem());
			upDateItemChecklist.setCompleto(itemChecklist.getCompleto());

			itemChecklistService.update(upDateItemChecklist);
		}
		return upDateItemChecklist;
	}
	/* Función deshabilitada, no borramos un ítem del checklist
	 * 
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		itemChecklistService.delete(id);
	}
	*/
}
