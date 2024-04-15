package Backend.SGTS.Repository.Dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Constants.SqlQueriesItemChecklist;
import Backend.SGTS.Entity.Dto.ItemChecklistDto;

@Repository
public class DtoRepositoryItemChecklist {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	private SqlQueriesItemChecklist sqlQueries = new SqlQueriesItemChecklist();
	
	@SuppressWarnings("deprecation")
	public List<ItemChecklistDto> obtenerItemChecklistDto(Integer idServicio) {
        String sql = sqlQueries.getItemChecklistDto();

        return jdbcTemplate.query(sql, new Object[]{idServicio}, (resultSet, rowNum) -> {
            ItemChecklistDto itemChecklistDto = new ItemChecklistDto();
            itemChecklistDto.setIdItemChecklist(resultSet.getInt("idItemChecklist"));
            itemChecklistDto.setNombreItem(resultSet.getString("nombre_item"));
            itemChecklistDto.setInicioEstimado(resultSet.getObject("inicio_estimado", LocalDateTime.class));
            itemChecklistDto.setFinEstimado(resultSet.getObject("fin_estimado", LocalDateTime.class));
            itemChecklistDto.setEjecucionReal(resultSet.getObject("ejecucion_real", LocalDateTime.class));
            itemChecklistDto.setFinReal(resultSet.getObject("fin_real", LocalDateTime.class));
            itemChecklistDto.setNotificado(resultSet.getBoolean("notificado"));
            itemChecklistDto.setValorTasa(resultSet.getDouble("valor_tasa"));
            itemChecklistDto.setHojas(resultSet.getInt("hojas"));
            itemChecklistDto.setResponsable(resultSet.getString("responsable"));
            itemChecklistDto.setUrlComprobante(resultSet.getString("url_comprobante"));
            itemChecklistDto.setCompleto(resultSet.getBoolean("completo"));
            
            return itemChecklistDto;
        });
    }
}
