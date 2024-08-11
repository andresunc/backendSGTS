package Backend.SGTS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Backend.SGTS.Entity.ItemChecklistEntity;

@Repository
public interface ItemChecklistRepository extends JpaRepository<ItemChecklistEntity, Integer> {

	@Transactional
    @Modifying
    @Procedure(name = "ReasignarResponsables") 
    void reasignarResponsables(
            @Param("p_Servicios") String servicios, 
            @Param("p_Items") String items, 
            @Param("p_RecursoGG_Actual") Integer responsableActual, 
            @Param("p_RecursoGG_Nuevo") Integer nuevoResponsable);
	
	@Procedure(name = "GetItemsByRecursoGgId")
    List<ItemChecklistEntity> getItemsByRecursoGgId(
            @Param("p_RecursoGgId") Integer recursoGgId);
}
