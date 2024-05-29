package Backend.SGTS.Service;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.TipoServicioEntity;
import Backend.SGTS.Repository.TipoServicioRepository;

@Service
public class TipoServicioService {

	// Inyecto repositorio
	@Autowired
	TipoServicioRepository tipoServicioRepository;
	
	// Obtengo todos los tipos de servicio
	public List<TipoServicioEntity> getAll() {
		return tipoServicioRepository.findAll();
	}
	
	// Obtengo un tipo de servicio por id
	public TipoServicioEntity getById(Integer id) {
		return tipoServicioRepository.findById(id).orElse(null);
	}
	
	// Creo un tipo de servicio
	public TipoServicioEntity create(TipoServicioEntity tipoServicio) {
		tipoServicio.setEliminado(false);
		return tipoServicioRepository.save(tipoServicio);

	}
	
	// Actualizo un tipo de servicio
	public TipoServicioEntity update(TipoServicioEntity tipoServicio) {
		return tipoServicioRepository.save(tipoServicio);
	}

	// Elimino un tipo de servicio
	@Transactional
	public void delete(Integer id) {
		TipoServicioEntity tipoServicio = tipoServicioRepository.findById(id).orElse(null);
		if (tipoServicio != null && tipoServicio.getEliminado() == false) {
			tipoServicio.setEliminado(true);
			tipoServicioRepository.save(tipoServicio);
		}

	}
	
	// Obtengo todos los tipos de servicio no eliminados
	public List<TipoServicioEntity> getAllNotDeleted() {
		return tipoServicioRepository.findByEliminadoFalse();
	}
	
	// Obtengo todos los tipos de servicio eliminados
	public List<TipoServicioEntity> getAllDeleted() {
		return tipoServicioRepository.findByEliminadoTrue();
	}
}
