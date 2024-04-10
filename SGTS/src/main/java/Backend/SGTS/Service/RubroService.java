package Backend.SGTS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.EstadoEntity;
import Backend.SGTS.Entity.RubroEntity;
import Backend.SGTS.Repository.RubroRepository;

@Service
public class RubroService {

	// Inyecto repositorio
	@Autowired
	RubroRepository rubroRepository;
	
	// Obtengo todos los rubros
	public List<RubroEntity> getAll() {
		return rubroRepository.findAll();
	}
	
	// Obtengo un rubro por id
	public RubroEntity getById(Integer id) {
		return rubroRepository.findById(id).orElse(null);
	}
	
	// Creo un rubro
	public RubroEntity create(RubroEntity rubro) {
		return rubroRepository.save(rubro);
	}
	
	// Actualizo un rubro
	public RubroEntity update(RubroEntity rubro) {
		return rubroRepository.save(rubro);
	}
	
	// Elimino un rubro
	public void delete(Integer id) {
		rubroRepository.deleteById(id);
	}
	
	// Obtengo todos los rubros no eliminados
		public List<RubroEntity> getAllNotDeleted() {
			return rubroRepository.findByEliminadoFalse();
		}

		// Obtengo todos los rubros no eliminados
		public List<RubroEntity> getAllDeleted() {
			return rubroRepository.findByEliminadoTrue();
		}
	
}
