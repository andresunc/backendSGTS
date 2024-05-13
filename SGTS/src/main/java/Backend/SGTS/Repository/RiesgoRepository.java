package Backend.SGTS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.ItemEntity;
import Backend.SGTS.Entity.RiesgoEntity;

@Repository
public interface RiesgoRepository extends JpaRepository<RiesgoEntity, Integer> {

	// Obtener ItemEntity donde eliminado es false
	List<RiesgoEntity> findByEliminadoFalse();

	// Obtener ItemEntity donde eliminado es true
	List<RiesgoEntity> findByEliminadoTrue();
}
