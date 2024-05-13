package Backend.SGTS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.ItemEntity;
import Backend.SGTS.Entity.RiesgoEntity;
import Backend.SGTS.Repository.RiesgoRepository;
import jakarta.transaction.Transactional;

@Service
public class RiesgoService {

	// Inyecto repositorio
	@Autowired
	RiesgoRepository riesgoRepository;

	// Obtengo todos los riesgos
	public List<RiesgoEntity> getAll() {
		return riesgoRepository.findAll();
	}

	// Obtengo todos los riesgos no eliminados
	public List<RiesgoEntity> getAllNotDeleted() {
		return riesgoRepository.findByEliminadoFalse();
	}

	// Obtengo todos los riesgos eliminados
	public List<RiesgoEntity> getAllDeleted() {
		return riesgoRepository.findByEliminadoTrue();
	}

	// Obtengo un riesgo por id
	public RiesgoEntity getById(Integer id) {
		return riesgoRepository.findById(id).orElse(null);
	}

	// Creo un riesgo
	public RiesgoEntity create(RiesgoEntity riesgo) {
		return riesgoRepository.save(riesgo);
	}

	// Actualizo un riesgo
	public RiesgoEntity update(RiesgoEntity riesgo) {
		return riesgoRepository.save(riesgo);
	}

	// Elimino un riesgo de manera lógica
	@Transactional
	public void delete(Integer id) {

		RiesgoEntity riegoToDelete = this.getById(id);
		if (riegoToDelete != null && riegoToDelete.getEliminado() == false) {
			riegoToDelete.setEliminado(true);
			this.update(riegoToDelete);
		}
	}
}