package Backend.SGTS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.EstadoEntity;
import Backend.SGTS.Entity.RubroEntity;

@Repository
public interface RubroRepository extends JpaRepository<RubroEntity, Integer> {

	// Obtener rubros donde eliminado es false
		List<RubroEntity> findByEliminadoFalse();

		// Obtener rubros donde eliminado es true
		List<RubroEntity> findByEliminadoTrue();
}
