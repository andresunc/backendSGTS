package Backend.SGTS.Repository.Dto;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Dto.ServicioDto;

@Repository
public class DtoRepositoryServicio {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	DtoRepositoryItemChecklist dtoRepositoryItemChecklist;

	public List<ServicioDto> obtenerServiciosDto() {
        String sql = "WITH UltimoEstado AS ("
                + "    SELECT"
                + "        hse.Servicio_id_Servicio,"
                + "        hse.Estado_id_Estado,"
                + "        hse.fecha,"
                + "        ROW_NUMBER() OVER (PARTITION BY hse.Servicio_id_Servicio ORDER BY hse.Fecha DESC) as rn"
                + "    FROM"
                + "        historico_estado hse)"
                + "SELECT"
                + "    sv.id_Servicio as 'id',"
                + "    tsv.tipo_servicio as 'tipo',"
                + "    em.Razon_Social as 'cliente',"
                + "    est.id_Estado as 'idEstado',"
                + "    est.Tipo_Estado as 'estado',"
                + "    sv.Recurrencia as 'recurrencia',"
                + "    sv.Referencia_Id_Servicio as 'referencia',"
                + "    sv.Fecha_Hora_Alerta_Venc as 'fecha_notificacion',"
                + "    ru.Rubro as 'rubro',"
                + "    se.Costo_Servicio as 'total_presupuestado',"
                + "    sv.Comentario as 'comentario'"
                + "FROM"
                + "    sgts_db.servicio_empresa se"
                + "    LEFT JOIN empresa em ON em.id_Empresa = se.Empresa_id_Empresa"
                + "    LEFT JOIN rubro ru ON ru.id_Rubro = em.Rubro_id_Rubro"
                + "    LEFT JOIN riesgo ri ON ri.id_Riesgo = em.Riesgo_id_Riesgo"
                + "    LEFT JOIN recurso_gg rgg ON rgg.id_Recurso_GG = se.Recurso_GG_id_Recurso_GG"
                + "    LEFT JOIN rol on rol.id_Rol = rgg.Rol_id_Rol"
                + "    LEFT JOIN persona per on per.id_Persona = rgg.Persona_id_Persona"
                + "    LEFT JOIN servicio sv ON sv.id_Servicio = se.Servicio_id_Servicio"
                + "    LEFT JOIN tipo_servicio tsv ON tsv.id_Tipo_Servicio = sv.Tipo_Servicio_id_Tipo_Servicio"
                + "    LEFT JOIN (SELECT * FROM UltimoEstado WHERE rn = 1) hse ON sv.id_Servicio = hse.Servicio_id_Servicio"
                + "    LEFT JOIN estado est ON est.id_Estado = hse.Estado_id_Estado";

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            ServicioDto servicioDto = new ServicioDto();
            servicioDto.setId(resultSet.getInt("id"));
            servicioDto.setTipo(resultSet.getString("tipo"));
            servicioDto.setCliente(resultSet.getString("cliente"));
            servicioDto.setIdEstado(resultSet.getInt("idEstado"));
            servicioDto.setEstado(resultSet.getString("estado"));
            servicioDto.setRecurrencia(resultSet.getInt("recurrencia"));
            servicioDto.setReferencia(resultSet.getInt("referencia"));
            servicioDto.setFecha_notificacion(resultSet.getObject("fecha_notificacion", LocalDateTime.class));
            servicioDto.setRubro(resultSet.getString("rubro"));
            servicioDto.setTotal_presupuestado(resultSet.getDouble("total_presupuestado"));
            servicioDto.setComentario(resultSet.getString("comentario"));
            servicioDto.setItemChecklistDto(dtoRepositoryItemChecklist.obtenerItemChecklistDto(servicioDto.getId()));
            return servicioDto;
        });
    }
	
}
