package Backend.SGTS.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.ItemChecklistEntity;
import Backend.SGTS.Repository.ItemChecklistRepository;
import jakarta.transaction.Transactional;

@Service
public class ItemChecklistService {

	// Inyecto Repositorio de ItemChecklist
	@Autowired
	ItemChecklistRepository itemChecklistRepository;

	// Obtengo todos los items de checklist
	public List<ItemChecklistEntity> getAll() {
		return itemChecklistRepository.findAll();
	}

	// Obtengo un item de checklist por id
	public ItemChecklistEntity getById(Integer id) {
		return itemChecklistRepository.findById(id).orElse(null);
	}

	// Creo un item de checklist
	public ItemChecklistEntity create(ItemChecklistEntity itemChecklist) {

		// Si notificado es null, establecerlo en 0 (falso) por defecto
		if (itemChecklist.getNotificado() == null) {
			itemChecklist.setNotificado(false);
		}
		
		// Si completo es null, establecerlo en 0 (falso) por defecto
		if (itemChecklist.getCompleto() == null) {
			itemChecklist.setCompleto(false);
		}
		
		// Establecer inicioEstandar e inicioConDesvio como la fecha actual
		Timestamp fechaActual = Timestamp.from(Instant.now());
		itemChecklist.setInicioEstandar(fechaActual);
		
		return itemChecklistRepository.save(itemChecklist);
	}

	// Actualizo un item de checklist
	@Transactional
	public ItemChecklistEntity update(ItemChecklistEntity itemChecklist) {
		return itemChecklistRepository.save(itemChecklist);
	}

	// Elimino un item de checklist
	public void delete(Integer id) {
		itemChecklistRepository.deleteById(id);
	}
	
	@Transactional 
    public void reasignarResponsables(String servicios, String items, Integer responsableActual, Integer nuevoResponsable) {
        itemChecklistRepository.reasignarResponsables(servicios, items, responsableActual, nuevoResponsable);
    }
	
	@Transactional
	public List<ItemChecklistEntity> getItemsByRecursoGgId(Integer recursoGgId) {
        return itemChecklistRepository.getItemsByRecursoGgId(recursoGgId);
    }
}
