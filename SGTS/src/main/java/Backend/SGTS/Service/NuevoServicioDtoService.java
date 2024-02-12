package Backend.SGTS.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Dto.NuevoServicioDTO;
import Backend.SGTS.Entity.ItemChecklistEntity;
import Backend.SGTS.Entity.ServicioEntity;
import Backend.SGTS.Repository.HistoricoEstadoRepository;
import Backend.SGTS.Repository.ItemChecklistRepository;
import Backend.SGTS.Repository.ServicioEmpresaRepository;
import Backend.SGTS.Repository.ServicioRepository;
import jakarta.transaction.Transactional;

@Service
public class NuevoServicioDtoService {

	@Autowired
	ServicioRepository servicioRepository;
	@Autowired
	HistoricoEstadoRepository historicoEstadoRepository;
	@Autowired
	ServicioEmpresaRepository servicioEmpresaRepository;
	@Autowired
    ItemChecklistRepository itemChecklistRepository;

	@Transactional
	public NuevoServicioDTO crearServicio(NuevoServicioDTO nuevoServicioDTO) {

		// Paso 1: Guardar el servicio y obtener su ID
		ServicioEntity servicio = servicioRepository.save(nuevoServicioDTO.getServicio());
		Integer idServicio = servicio.getIdServicio();

		// Paso 2: Guardar el histórico de estado con el id del servicio;
		nuevoServicioDTO.getHistoricoEstado().setFecha(new Timestamp(System.currentTimeMillis()));
		nuevoServicioDTO.getHistoricoEstado().setServicioIdServicio(idServicio);
        historicoEstadoRepository.save(nuevoServicioDTO.getHistoricoEstado());

		// Paso 3: Guardar el servicio de la empresa;
        nuevoServicioDTO.getServicioEmpresa().setAlta(new Date(System.currentTimeMillis()));
        nuevoServicioDTO.getServicioEmpresa().setServicioIdServicio(idServicio);
        nuevoServicioDTO.getServicioEmpresa().setEliminado((byte) 0);
        servicioEmpresaRepository.save(nuevoServicioDTO.getServicioEmpresa());
        
        // Paso 4: Guardar la lista de ItemChecklistEntity si existe
        List<ItemChecklistEntity> itemChecklistEntities = nuevoServicioDTO.getItemChecklist();
        if (itemChecklistEntities != null && !itemChecklistEntities.isEmpty()) {
            for (ItemChecklistEntity itemChecklistEntity : itemChecklistEntities) {
                itemChecklistEntity.setServicioIdServicio(idServicio);
                itemChecklistRepository.save(itemChecklistEntity);
            }
        }

		return nuevoServicioDTO;
	}
}
