package Backend.SGTS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Repository.Dto.DtoRepositoryServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/servicioDto")
public class ServicioDtoController {

	// Inyecto el repositorio de dto de servicios
	@Autowired
	DtoRepositoryServicio dtoRepositoryServicio;

	// Obtener los dto de servicios
	@RequestMapping("/getAll")
	public Object getAllServicios() {
		return dtoRepositoryServicio.obtenerServiciosDto();
	}
}