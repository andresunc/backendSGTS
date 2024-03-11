package Backend.SGTS.Controller.Rpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Repository.Rpt.RptServicioEnCurso;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reporte")
public class ServicioEnCursoRpt {

	// Inyecto repositorio de ServicioEnCurso
	@Autowired
	RptServicioEnCurso rptServicioEnCurso;
	
	@RequestMapping("/getServiciosEnCurso")
	public Object getServiciosEnCurso() {
		return rptServicioEnCurso.getServicioEnCursoRpt();
	}
}
