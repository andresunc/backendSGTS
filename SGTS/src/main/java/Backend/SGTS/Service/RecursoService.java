package Backend.SGTS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.EstadoEntity;
import Backend.SGTS.Entity.RecursoGgEntity;
import Backend.SGTS.Repository.RecursoRepository;

@Service
public class RecursoService {

	// Inyecto repositorio
	@Autowired
	RecursoRepository recursoGgRepository;

	// Obtengo todos los recursos
	public List<RecursoGgEntity> getAll() {
		return recursoGgRepository.findAll();
	}

	// Obtengo un recurso por id
	public RecursoGgEntity getById(Integer id) {
		return recursoGgRepository.findById(id).orElse(null);
	}

	// Creo un recurso
	public RecursoGgEntity create(RecursoGgEntity recursoGg) {
		return recursoGgRepository.save(recursoGg);
	}

	// Actualizo un recurso
	public RecursoGgEntity update(RecursoGgEntity recursoGg) {
		return recursoGgRepository.save(recursoGg);
	}

	// Elimino un recurso
	public void delete(Integer id) {
		recursoGgRepository.deleteById(id);
	}

	// Obtengo todos los estados no eliminados
	public List<RecursoGgEntity> getAllNotDeleted() {
		return recursoGgRepository.findByEliminadoFalse();
	}

	// Obtengo todos los estados no eliminados
	public List<RecursoGgEntity> getAllDeleted() {
		return recursoGgRepository.findByEliminadoTrue();
	}
}
