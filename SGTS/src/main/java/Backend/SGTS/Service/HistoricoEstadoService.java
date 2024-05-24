package Backend.SGTS.Service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.HistoricoEstadoEntity;
import Backend.SGTS.Repository.HistoricoEstadoRepository;
import jakarta.transaction.Transactional;

@Service
public class HistoricoEstadoService {

	// Inyecto repositorio
	@Autowired
	HistoricoEstadoRepository historicoEstadoRepository;
	
	@Transactional
    public void revertir(Timestamp fecha_param, Integer servicio_id_param, Integer estado_id_param) {
		historicoEstadoRepository.revertirEstado(fecha_param, servicio_id_param, estado_id_param);
    }
	
	// Obtengo todos los historicos de estados
	public List<HistoricoEstadoEntity> getAll() {
		return historicoEstadoRepository.findAll();
	}
	
	// Obtengo un historico de estado por id
	public HistoricoEstadoEntity getById(Integer id) {
		return historicoEstadoRepository.findById(id).orElse(null);
	}
	
	// Creo un historico de estado
	public HistoricoEstadoEntity create(HistoricoEstadoEntity historicoEstado) {
		return historicoEstadoRepository.save(historicoEstado);
	}
	
	// Actualizo un historico de estado
	public HistoricoEstadoEntity update(HistoricoEstadoEntity historicoEstado) {
		return historicoEstadoRepository.save(historicoEstado);
	}
	
	// Elimino un historico de estado
	public void delete(Integer id) {
		historicoEstadoRepository.deleteById(id);
	}
}
