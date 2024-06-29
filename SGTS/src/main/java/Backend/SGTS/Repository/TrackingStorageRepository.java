package Backend.SGTS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Backend.SGTS.Entity.TrackingStorageEntity;

public interface TrackingStorageRepository extends JpaRepository<TrackingStorageEntity, Integer> {

	@Query("SELECT ts FROM TrackingStorageEntity ts WHERE ts.idServicio = :idServicio ORDER BY ts.timestamp ASC")
    List<TrackingStorageEntity> findByIdServicio(@Param("idServicio") Integer idServicio);
}