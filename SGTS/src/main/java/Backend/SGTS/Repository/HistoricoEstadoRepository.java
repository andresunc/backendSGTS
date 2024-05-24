package Backend.SGTS.Repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.HistoricoEstadoEntity;

@Repository
public interface HistoricoEstadoRepository extends JpaRepository<HistoricoEstadoEntity, Integer> {

	@Procedure("delete_old_hs_estado")
    void revertirEstado(Timestamp fecha_param, Integer servicio_id_param, Integer estado_id_param);
}