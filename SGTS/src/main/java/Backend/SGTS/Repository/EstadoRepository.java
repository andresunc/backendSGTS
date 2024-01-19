package Backend.SGTS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.EstadoEntity;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoEntity, Integer> {

	// Obtener estados donde eliminado es false
	 List<EstadoEntity> findByEliminadoFalse();
	 
	// Obtener estados donde eliminado es true
	    List<EstadoEntity> findByEliminadoTrue();
}
