package Backend.SGTS.Controller.Dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Repository.Dto.DtoRepositoryRecursoGG;

@RestController
@RequestMapping("/recursoDto")
public class RecursoDtoController {

	// Inyecto el repositorio de dto de recursos
	@Autowired
	DtoRepositoryRecursoGG dtoRepositoryRecursoGG;
	
	@RequestMapping("/getRecursos")
	public Object getAllRecursos() {
		return dtoRepositoryRecursoGG.obtenerRecursoGgDto();
	}
}
