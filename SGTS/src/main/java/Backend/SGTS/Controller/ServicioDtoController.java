package Backend.SGTS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Repository.Dto.DtoRepositoryServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/servicioDto")
public class ServicioDtoController {

	// Inyecto el repositorio de dto de servicios
	@Autowired
	DtoRepositoryServicio dtoRepositoryServicio;

	/* @RequestParam para obtener los parámetros de la solicitud HTTP y trabajar con ellos en el método.
	 * Puede contener un valor entero
	 * Si el valor es 0 traerá todos los servicios.
	 * */
	@RequestMapping("/getTopServices")
	public Object getAllServicios(@RequestParam(value = "limit", required = false)Integer limit) {
		return dtoRepositoryServicio.obtenerServiciosDto(limit);
	}
}