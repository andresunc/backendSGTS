package Backend.SGTS.Repository.Rpt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Constans.Rpt.QueryServiciosEnCurso;
import Backend.SGTS.Entity.Rpt.ServicioEnCursoRpt;

@Repository
public class RptServicioEnCurso {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	QueryServiciosEnCurso query = new QueryServiciosEnCurso();
	
	public List<ServicioEnCursoRpt> getServicioEnCursoRpt() {
		
		String sql = query.getServiciosEnCurso();
		return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
			ServicioEnCursoRpt servicioEnCursoRpt = new ServicioEnCursoRpt();
			servicioEnCursoRpt.setIdServicio(resultSet.getInt("idServicio"));
			servicioEnCursoRpt.setEmpresa(resultSet.getString("empresa"));
			servicioEnCursoRpt.setRubro(resultSet.getString("rubro"));
			servicioEnCursoRpt.setTipoServicio(resultSet.getString("tipoServicio"));
			servicioEnCursoRpt.setDependenciaInvolucrada(resultSet.getString("dependenciaInvolucrada"));
			servicioEnCursoRpt.setEstado(resultSet.getString("estado"));
			servicioEnCursoRpt.setPorcentajeAvance(resultSet.getDouble("porcentajeAvance"));
			return servicioEnCursoRpt;
		});
	}

}
