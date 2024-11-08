package Backend.SGTS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.EstadoEntity;
import Backend.SGTS.Repository.EstadoRepository;
import jakarta.transaction.Transactional;

@Service
public class EstadoService {

	// Inyecto repositorio
	@Autowired
	EstadoRepository estadoRepository;

	// Obtengo todos los estados
	public List<EstadoEntity> getAll() {
		return estadoRepository.findAll();
	}

	// Obtengo un estado por id
	public EstadoEntity getById(Integer id) {
		return estadoRepository.findById(id).orElse(null);
	}

	// Creo un estado
	public EstadoEntity create(EstadoEntity estado) {
		estado.setEliminado(false);
		return estadoRepository.save(estado);
	}

	// Actualizo un estado
	public EstadoEntity update(EstadoEntity estado) {
		return estadoRepository.save(estado);
	}

	// Actualizo el orden de los estados
	@Transactional
	public List<EstadoEntity> actualizarOrden(List<EstadoEntity> estados) {
		return  estadoRepository.saveAll(estados);
	}

	// Elimino un estado de manera lógica
	@Transactional
	public void delete(Integer id) {
		EstadoEntity estado = estadoRepository.findById(id).orElse(null);
		if (estado != null && estado.getEliminado() == false) {
			estado.setEliminado(true);
			estadoRepository.save(estado);
		}
	}

	// Obtengo todos los estados no eliminados de manera ordenada
	public List<EstadoEntity> getAllNotDeleted() {
		return estadoRepository.findByEliminadoFalseOrderByOrdenAsc();
	}

	// Obtengo todos los estados no eliminados
	public List<EstadoEntity> getAllDeleted() {
		return estadoRepository.findByEliminadoTrue();
	}

}
