package Backend.SGTS.Repository.Dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Constants.SqlQueriesUsuario;
import Backend.SGTS.Entity.Dto.UsuarioDto;

import java.util.List;

@Repository
public class DtoRepositoryUsuario {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SqlQueriesUsuario sqlQueries = new SqlQueriesUsuario();
    
    public List<UsuarioDto> obtenerUsuarios() {
        String sql = sqlQueries.getUsuarioDto();

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setIdUsuario(resultSet.getInt("idUsuario"));
            usuarioDto.setUsername(resultSet.getString("username"));
            usuarioDto.setPassword(resultSet.getString("password"));
            usuarioDto.setIdRol(resultSet.getInt("idRol"));
            usuarioDto.setRol(resultSet.getString("rol"));
            usuarioDto.setIdPersona(resultSet.getInt("idPersona"));
            usuarioDto.setNombre(resultSet.getString("nombre"));
            usuarioDto.setApellido(resultSet.getString("apellido"));
            usuarioDto.setDni(resultSet.getString("dni"));
            usuarioDto.setTelefono(resultSet.getString("telefono"));
            usuarioDto.setEmail(resultSet.getString("email"));
            usuarioDto.setIsEnabled(resultSet.getByte("isEnabled"));

            return usuarioDto;
        });
    }
}