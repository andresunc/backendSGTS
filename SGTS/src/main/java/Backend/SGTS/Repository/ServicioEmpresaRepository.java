package Backend.SGTS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.ServicioEmpresaEntity;

@Repository
public interface ServicioEmpresaRepository extends JpaRepository<ServicioEmpresaEntity, Integer>{

	// Método para buscar por servicioIdServicio
    ServicioEmpresaEntity findByServicioIdServicio(Integer servicioIdServicio);
}
