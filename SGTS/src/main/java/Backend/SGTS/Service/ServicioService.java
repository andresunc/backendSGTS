package Backend.SGTS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.ServicioEntity;
import Backend.SGTS.Repository.ServicioRepository;

@Service
public class ServicioService {

	// Inyecto Repositorio de Servicio
	@Autowired
	ServicioRepository servicioRepository;
	
	// Obtengo todos los servicios
	public List<ServicioEntity> getAll() {
		return servicioRepository.findAll();
	}
	
	// Obtengo un servicio por id
	public ServicioEntity getById(Integer id) {
		return servicioRepository.findById(id).orElse(null);
	}
	
	// Creo un servicio
	public ServicioEntity create(ServicioEntity servicio) {
		return servicioRepository.save(servicio);
	}
	
	// Actualizo un servicio
	public ServicioEntity update(ServicioEntity servicio) {
		return servicioRepository.save(servicio);
	}
	
	// Elimino un servicio
	public void delete(Integer id) {
		// Método para eliminar un servicio
	}
	
	// Renovar un servicio
	public Integer renovarServicio(Integer id_Servicio, Double costo_Servicio, Integer recurso_GG_id_Recurso_GG, Integer estado_id_Estado) {
        return servicioRepository.renovarServicio(id_Servicio, costo_Servicio, recurso_GG_id_Recurso_GG, estado_id_Estado);
    }
	
	// Checkear si un servicio fue renovado
	public Boolean isServicioRenovado(Integer idServicio) {
        return servicioRepository.checkServicioRenovado(idServicio);
    }
}
