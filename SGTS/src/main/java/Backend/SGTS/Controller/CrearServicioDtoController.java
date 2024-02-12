package Backend.SGTS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Dto.NuevoServicioDTO;
import Backend.SGTS.Service.NuevoServicioDtoService;

@RestController
@RequestMapping("/nuevo")
public class CrearServicioDtoController {
	
	@Autowired
	NuevoServicioDtoService nuevoServicioDtoService;
	
	@PostMapping("/crearServicio")
	public ResponseEntity<NuevoServicioDTO> crearServicio(@RequestBody NuevoServicioDTO nuevoServicioDTO) {
		
		try {
	        nuevoServicioDtoService.crearServicio(nuevoServicioDTO);
	        return ResponseEntity.ok(nuevoServicioDTO);
	    } catch (Exception e) {
	    	System.out.println("Error al crear el servicio: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}

}
