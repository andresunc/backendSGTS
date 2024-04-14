package Backend.SGTS.Controller.Dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Repository.Dto.DtoRepositorySelectItem;

@RestController
@RequestMapping("/selectItemDto")
public class SelectItemDtoController {
	
	// Inyecto el repositorio de dto de SelectItemDto
	@Autowired
	DtoRepositorySelectItem dtoRepositorySelectItem;
	
	@RequestMapping("/getItems")
	public Object getSelectitemsDto() {
		return dtoRepositorySelectItem.obtenerItemDto();
	}

}
