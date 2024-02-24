package Backend.SGTS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.RecursoGgEntity;

@Repository
public interface RecursoRepository extends JpaRepository<RecursoGgEntity, Integer> {
	
	// Obtener estados donde eliminado es false
	List<RecursoGgEntity> findByEliminadoFalse();
	
	// Obtener estados donde eliminado es true
	List<RecursoGgEntity> findByEliminadoTrue();

}
