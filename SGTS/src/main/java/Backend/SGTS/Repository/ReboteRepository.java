package Backend.SGTS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.ReboteEntity;

@Repository
public interface ReboteRepository extends JpaRepository<ReboteEntity, Integer> {

	@Query("SELECT r FROM ReboteEntity r ORDER BY r.fecha DESC")
    List<ReboteEntity> findTop60ByOrderByFechaDesc();
}
