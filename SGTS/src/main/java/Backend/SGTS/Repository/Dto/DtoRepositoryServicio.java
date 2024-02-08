package Backend.SGTS.Repository.Dto;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Constants.SqlQueriesServicios;
import Backend.SGTS.Dto.ServicioDto;

@Repository
public class DtoRepositoryServicio {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	DtoRepositoryItemChecklist dtoRepositoryItemChecklist;
	SqlQueriesServicios sqlQueries = new SqlQueriesServicios();

	public List<ServicioDto> obtenerServiciosDto(Integer limit) {
		
		// Obtener servicios con limite variable.
        String sql = sqlQueries.getServices(limit);

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            ServicioDto servicioDto = new ServicioDto();
            servicioDto.setIdServicio(resultSet.getInt("idServicio"));
            servicioDto.setIdTipoServicio(resultSet.getInt("idTipoServicio"));
            servicioDto.setTipo(resultSet.getString("tipo"));
            servicioDto.setIdCliente(resultSet.getInt("idCliente"));
            servicioDto.setCliente(resultSet.getString("cliente"));
            servicioDto.setIdEstado(resultSet.getInt("idEstado"));
            servicioDto.setEstado(resultSet.getString("estado"));
            servicioDto.setRecurrencia(resultSet.getInt("recurrencia"));
            servicioDto.setReferencia(resultSet.getInt("referencia"));
            servicioDto.setFecha_notificacion(resultSet.getObject("fecha_notificacion", LocalDateTime.class));
            servicioDto.setIdRubro(resultSet.getInt("idRubro"));
            servicioDto.setRubro(resultSet.getString("rubro"));
            servicioDto.setIdServicioEmpresa(resultSet.getInt("idServicioEmpresa"));
            servicioDto.setTotal_presupuestado(resultSet.getDouble("total_presupuestado"));
            servicioDto.setComentario(resultSet.getString("comentario"));
            servicioDto.setItemChecklistDto(dtoRepositoryItemChecklist.obtenerItemChecklistDto(servicioDto.getIdServicio()));
            return servicioDto;
        });
    }
	
}
