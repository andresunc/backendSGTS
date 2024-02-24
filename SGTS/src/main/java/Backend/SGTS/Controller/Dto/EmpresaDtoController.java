package Backend.SGTS.Controller.Dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Repository.Dto.DtoRepositoryEmpresa;

@RestController
@RequestMapping("/empresaDto")
public class EmpresaDtoController {

	// Inyecto el repositorio de dto de empresas
	@Autowired
	DtoRepositoryEmpresa dtoRepositoryEmpresa;
	
	@RequestMapping("/getEmpresas")
	public Object getAllEmpresas() {
		return dtoRepositoryEmpresa.obtenerEmpresaDto();
	}
}
