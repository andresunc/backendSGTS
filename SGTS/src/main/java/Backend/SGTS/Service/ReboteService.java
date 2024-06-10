package Backend.SGTS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.ReboteEntity;
import Backend.SGTS.Repository.ReboteRepository;

@Service
public class ReboteService {

	@Autowired
	ReboteRepository reboteRepository;

	// Obtengo todos los usuarios
	public List<ReboteEntity> getAll() {
		return reboteRepository.findAll();
	}
	
	// Obtengo los últimos 60 registros
    public List<ReboteEntity> getLast60Records() {
        return reboteRepository.findTop60ByOrderByFechaDesc();
    }
}
