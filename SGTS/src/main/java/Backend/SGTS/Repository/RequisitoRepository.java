package Backend.SGTS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.RequisitoEntity;

@Repository
public interface RequisitoRepository extends JpaRepository<RequisitoEntity, Integer> {

	// Obtener Requisito donde eliminado es false
	List<RequisitoEntity> findByEliminadoFalse();

	// Obtener Requisito donde eliminado es true
	List<RequisitoEntity> findByEliminadoTrue();
}
