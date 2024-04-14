package Backend.SGTS.Repository.Dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Constants.SqlSelectItemDto;
import Backend.SGTS.Entity.DependenciaEntity;
import Backend.SGTS.Entity.RequisitoEntity;
import Backend.SGTS.Entity.RubroEntity;
import Backend.SGTS.Entity.TipoItemEntity;
import Backend.SGTS.Entity.TipoServicioEntity;
import Backend.SGTS.Entity.Dto.SelectItemDto;

@Repository
public class DtoRepositorySelectItem {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SqlSelectItemDto sqlQueries = new SqlSelectItemDto();
	
	public List<SelectItemDto> obtenerItemDto() {
		
		// Obtener ítems mediante una consulta sql
		String sql = sqlQueries.getSelectItemDto();
		
		return jdbcTemplate.query(sql, (resultSet, rowNum) -> {

			SelectItemDto selectItemDto = new SelectItemDto();
			
			selectItemDto.setIdItem(resultSet.getInt("idItem"));
			selectItemDto.setIdTipoServicio(resultSet.getInt("idTipoServicio"));
			selectItemDto.setTipoServicio(resultSet.getString("tipoServicio"));
			selectItemDto.setIdDependencia(resultSet.getInt("idDependencia"));
			selectItemDto.setDependencia(resultSet.getString("dependencia"));
			selectItemDto.setIdRubro(resultSet.getInt("idRubro"));
			selectItemDto.setRubro(resultSet.getString("rubro"));
			selectItemDto.setIdTipoItem(resultSet.getInt("idTipoItem"));
			selectItemDto.setTipoItem(resultSet.getString("tipoItem"));
			selectItemDto.setIdRequisito(resultSet.getInt("idRequisito"));
			selectItemDto.setDescripcion(resultSet.getString("descripcion"));
			selectItemDto.setFechaHoraRealizacionRecomendada(resultSet.getTimestamp("fechaHoraRealizacionRecomendada"));
			
			return selectItemDto;
			
		});
	}
}
