package Backend.SGTS.Repository.Dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Constants.SqlQueriesRol;
import Backend.SGTS.Entity.Dto.RolDto;

import java.util.List;

@Repository
public class DtoRepositoryRol {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SqlQueriesRol sqlQueries = new SqlQueriesRol();
    
    @SuppressWarnings("deprecation")
    public List<RolDto> obtenerRolesPorUsuario(Integer idUsuario) {
        String sql = sqlQueries.getRolDto();

        return jdbcTemplate.query(sql, new Object[]{idUsuario}, (resultSet, rowNum) -> {
            RolDto rolDto = new RolDto();
            rolDto.setIdRol(resultSet.getInt("id_rol"));
            rolDto.setRol(resultSet.getString("rol"));
            
            return rolDto;
        });
    }
}
