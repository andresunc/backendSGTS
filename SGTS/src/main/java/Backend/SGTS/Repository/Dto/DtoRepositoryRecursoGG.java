package Backend.SGTS.Repository.Dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Constants.SqlQueriesRecursoGG;
import Backend.SGTS.Entity.Dto.RecursoGgDto;

@Repository
public class DtoRepositoryRecursoGG {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	private SqlQueriesRecursoGG sqlQueries = new SqlQueriesRecursoGG();
	
	public List<RecursoGgDto> obtenerRecursoGgDto() {

		// Obtener recursos gg.
		String sql = sqlQueries.getRecursoGGDto();

		return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
			RecursoGgDto recursoGgDto = new RecursoGgDto();
			recursoGgDto.setIdRecurso(resultSet.getInt("idRecurso"));
            recursoGgDto.setIdPersona(resultSet.getInt("idPersona"));
            recursoGgDto.setNombre(resultSet.getString("nombre"));
            recursoGgDto.setApellido(resultSet.getString("apellido"));
			recursoGgDto.setDni(resultSet.getString("dni"));

			return recursoGgDto;
		});
	}
	
}
