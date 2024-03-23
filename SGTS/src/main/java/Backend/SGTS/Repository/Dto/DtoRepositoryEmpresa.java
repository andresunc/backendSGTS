package Backend.SGTS.Repository.Dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Constants.SqlQueriesEmpresa;
import Backend.SGTS.Entity.Dto.EmpresaDto;

@Repository
public class DtoRepositoryEmpresa {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SqlQueriesEmpresa sqlQueries = new SqlQueriesEmpresa();
	
	public List<EmpresaDto> obtenerEmpresaDto() {

		// Obtener empresas.
		String sql = sqlQueries.getEmpresaDto();

		return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
			EmpresaDto empresaDto = new EmpresaDto();
			empresaDto.setIdEmpresa(resultSet.getInt("idEmpresa"));
			empresaDto.setIdRubro(resultSet.getInt("idRubro"));
			empresaDto.setRubro(resultSet.getString("rubro"));
			empresaDto.setIdRiesgo(resultSet.getInt("idRiesgo"));
			empresaDto.setRiesgo(resultSet.getString("riesgo"));
			empresaDto.setCliente(resultSet.getString("cliente"));
			empresaDto.setCuit(resultSet.getString("cuit"));
			empresaDto.setDireccion(resultSet.getString("direccion"));
			
			return empresaDto;
		});
	}
}
