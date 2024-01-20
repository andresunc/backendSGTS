package Backend.SGTS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.TipoServicioEntity;

@Repository
public interface TipoServicioRepository extends JpaRepository<TipoServicioEntity, Integer> {

	// Obtener tipo de servicio donde eliminado es false
	List<TipoServicioEntity> findByEliminadoFalse();
	
	// Obtener tipo de servicio donde eliminado es true
	List<TipoServicioEntity> findByEliminadoTrue();
}
