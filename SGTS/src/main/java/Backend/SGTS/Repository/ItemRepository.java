package Backend.SGTS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

			// Obtener ItemEntity donde eliminado es false
			List<ItemEntity> findByEliminadoFalse();

			// Obtener ItemEntity donde eliminado es true
			List<ItemEntity> findByEliminadoTrue();
}
