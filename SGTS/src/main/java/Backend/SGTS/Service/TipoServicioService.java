package Backend.SGTS.Service;

import java.util.List;

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
		return tipoServicioRepository.save(tipoServicio);
	}
	
	// Actualizo un tipo de servicio
	public TipoServicioEntity update(TipoServicioEntity tipoServicio) {
		return tipoServicioRepository.save(tipoServicio);
	}
	
	// Elimino un tipo de servicio
	public void delete(Integer id) {
		tipoServicioRepository.deleteById(id);
	}
}