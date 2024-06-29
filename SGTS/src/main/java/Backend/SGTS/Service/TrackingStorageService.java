package Backend.SGTS.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.TrackingStorageEntity;
import Backend.SGTS.Repository.TrackingStorageRepository;

@Service
public class TrackingStorageService {

	// Inyecto repositorio
	@Autowired
	TrackingStorageRepository trackingStorageRepository;

	// Creo una tracking storage
	public TrackingStorageEntity create(TrackingStorageEntity trackingStorage) {
		trackingStorage.setTimestamp(Timestamp.from(Instant.now()));
        return trackingStorageRepository.save(trackingStorage);
	}

	// Crear múltiples tracking storages
	public List<TrackingStorageEntity> createMultiple(List<TrackingStorageEntity> trackingStorages) {
        for (TrackingStorageEntity entity : trackingStorages) {
            entity.setTimestamp(Timestamp.from(Instant.now()));
        }
        return trackingStorageRepository.saveAll(trackingStorages);
	}

	// Buscar por id_servicio
	public List<TrackingStorageEntity> findByIdServicio(Integer idServicio) {
		return trackingStorageRepository.findByIdServicio(idServicio);
	}
}
