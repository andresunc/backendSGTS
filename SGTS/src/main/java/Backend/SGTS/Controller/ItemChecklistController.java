package Backend.SGTS.Controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
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

import Backend.SGTS.Entity.ItemChecklistEntity;
import Backend.SGTS.Entity.Dto.ItemChecklistDto;
import Backend.SGTS.Service.ItemChecklistService;
import Backend.SGTS.Service.ItemService;
import jakarta.transaction.Transactional;

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
	public ResponseEntity<List<ItemChecklistEntity>> updateAll(
			@RequestBody List<ItemChecklistEntity> itemChecklistList) {

		List<ItemChecklistEntity> updatedItems = new ArrayList<>();

		for (ItemChecklistEntity itemChecklist : itemChecklistList) {

			try {
				// obtener el ID del elemento actual y buscarlo en la bd
				Integer id = itemChecklist.getIdItemChecklist();
				ItemChecklistEntity existingItem = itemChecklistService.getById(id);

				// Sí se completó desde el cliente y en la bd esta incompleto: calcular desvío
				if (itemChecklist.getCompleto() && !existingItem.getCompleto()) {
					existingItem.setFinConDesvio(Timestamp.from(Instant.now()));
					existingItem.setCompleto(itemChecklist.getCompleto());

					// Calcular el desvío cuando se finaliza el ítem
					double horasDesvio = itemService.setDeviation(existingItem.getFinEstandar(),
							existingItem.getFinConDesvio(), existingItem.getItemIdItem());
					existingItem.setHorasDesvio(horasDesvio);
				}

				/**
				 * Si se desmarca la opción completo revertir duracion estandar calculada cuando
				 * se tildo como completa inicialmente
				 */
				if (!itemChecklist.getCompleto() && existingItem.getCompleto()) {
					itemService.unSetDeviation(existingItem.getHorasDesvio(), existingItem.getItemIdItem());
					existingItem.setCompleto(itemChecklist.getCompleto());
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
				// Manejar la excepción adecuadamente, por ejemplo, registrándola o devolviendo
				// una respuesta de error
				e.printStackTrace(); // Registro de la excepción
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Devolver una respuesta de
																						// error
			}
		}

		return ResponseEntity.ok(updatedItems);
	}

	/*
	 * Esta función elimina un listado de items del checklist revirtiendo el calculo
	 * del desvío
	 */
	@DeleteMapping("/delete")
	@Transactional
	public ResponseEntity<Integer> delete(@RequestBody ItemChecklistDto itemChecklistListDto) {

		try {
			Integer id = itemChecklistListDto.getIdItemChecklist();
			ItemChecklistEntity existingItemChecklist = itemChecklistService.getById(id);

			// Revertir el calculo del desvío solo si presenta horas de desvio
			if (existingItemChecklist.getHorasDesvio() > 0) {
				itemService.unSetDeviation(existingItemChecklist.getHorasDesvio(),
						existingItemChecklist.getItemIdItem());
			}

			itemChecklistService.delete(id);
			return ResponseEntity.ok(id); // Retorna 200 OK
		} catch (Exception e) {
			// Si ocurre una excepción, se hace rollback de la transacción
			// Esto asegura que todas las operaciones realizadas dentro del método se
			// deshagan
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
