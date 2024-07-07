package Backend.SGTS.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.ServicioEntity;

@Repository
public interface ServicioRepository extends JpaRepository<ServicioEntity, Integer>{

	@Procedure(name = "renovarServicio")
    Integer renovarServicio(@Param("p_id_Servicio") Integer id_Servicio, 
                            @Param("p_Costo_Servicio") Double costo_Servicio, 
                            @Param("p_Recurso_GG_id_Recurso_GG") Integer recurso_GG_id_Recurso_GG, 
                            @Param("p_Estado_id_Estado") Integer estado_id_Estado);
	
	@Procedure(name = "CheckServicioRenovado")
    Boolean checkServicioRenovado(@Param("p_id_Servicio") Integer id_Servicio);
}