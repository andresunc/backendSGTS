package Backend.SGTS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.ItemEntity;
import Backend.SGTS.Entity.RequisitoEntity;
import Backend.SGTS.Repository.RequisitoRepository;

@Service
public class RequisitoService {

	// Inyecto repositorio
	@Autowired
	RequisitoRepository requisitoRepository;

	// Obtengo todos los requisitos
	public List<RequisitoEntity> getAll() {
		return requisitoRepository.findAll();
	}

	// Obtengo todos los requisitos no eliminados
	public List<RequisitoEntity> getAllNotDeleted() {
		return requisitoRepository.findByEliminadoFalse();
	}

	// Obtengo todos los requisitos eliminados
	public List<RequisitoEntity> getAllDeleted() {
		return requisitoRepository.findByEliminadoTrue();
	}

	// Obtengo un requisito por id
	public RequisitoEntity getById(Integer id) {
		return requisitoRepository.findById(id).orElse(null);
	}

	// Creo un requisito
	public RequisitoEntity create(RequisitoEntity requisito) {
		return requisitoRepository.save(requisito);
	}

	// Actualizo un requisito
	public RequisitoEntity update(RequisitoEntity requisito) {
		return requisitoRepository.save(requisito);
	}

	// Elimino un requisito
	public void delete(Integer id) {
		requisitoRepository.deleteById(id);
	}
}
