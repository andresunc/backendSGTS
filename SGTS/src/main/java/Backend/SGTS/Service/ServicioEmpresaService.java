package Backend.SGTS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.ServicioEmpresaEntity;
import Backend.SGTS.Repository.ServicioEmpresaRepository;

@Service
public class ServicioEmpresaService {

	// Inyecto Repositorio de ServicioEmpresa
	@Autowired
	ServicioEmpresaRepository servicioEmpresaRepository;

	// Obtengo todos los servicioEmpresa
	public List<ServicioEmpresaEntity> getAll() {
		return servicioEmpresaRepository.findAll();
	}

	// Obtengo un servicioEmpresa por id
	public ServicioEmpresaEntity getById(Integer id) {
		return servicioEmpresaRepository.findById(id).orElse(null);
	}

	// Obtengo un servicioEmpresa por ServicioIdServicio
	public ServicioEmpresaEntity getByServicioIdServicio(Integer id) {
		return servicioEmpresaRepository.findByServicioIdServicio(id);
	}

	// Creo un servicioEmpresa
	public ServicioEmpresaEntity create(ServicioEmpresaEntity servicioEmpresa) {
		return servicioEmpresaRepository.save(servicioEmpresa);
	}

	// Actualizo un servicioEmpresa
	public ServicioEmpresaEntity update(ServicioEmpresaEntity servicioEmpresa) {
		return servicioEmpresaRepository.save(servicioEmpresa);
	}

	// Elimino un servicioEmpresa
	public void delete(Integer id) {
		servicioEmpresaRepository.deleteById(id);
	}

}
