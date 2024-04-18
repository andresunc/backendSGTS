package Backend.SGTS.Controller.Dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Entity.ContactoEmpresaEntity;
import Backend.SGTS.Entity.Dto.EmpresaContactosDTO;
import Backend.SGTS.Repository.Dto.DtoRepositoryEmpresa;
import Backend.SGTS.Service.EmpresaService;

@RestController
@RequestMapping("/empresaDto")
public class EmpresaDtoController {

	// Inyecto el repositorio de dto de empresas
	@Autowired
	DtoRepositoryEmpresa dtoRepositoryEmpresa;
	// Inyecto Servicio de Empresa
	@Autowired
	EmpresaService empresaService;

	@RequestMapping("/getEmpresas")
	public Object getAllEmpresas() {
		return dtoRepositoryEmpresa.obtenerEmpresaDto();
	}

	// Crear una empresa con una lista de contactos asociados
	@PostMapping("/create-empresa-with-contacts")
	public EmpresaContactosDTO createEmpresaWithContacts(@RequestBody EmpresaContactosDTO dto) {

		if (dto.getContactos() == null) {
			// Si la lista de contactos es nula, solo crear la empresa
			empresaService.create(dto.getEmpresa());
			return new EmpresaContactosDTO(dto.getEmpresa(), new ArrayList<>());
		} else {
			// Si la lista de contactos no es nula, crear la empresa con los contactos
			// asociados
			List<ContactoEmpresaEntity> contactosCreados = empresaService.createEmpresaWithContacts(dto.getEmpresa(),
					dto.getContactos());
			return new EmpresaContactosDTO(dto.getEmpresa(), contactosCreados);
		}
	}
	
	// Actualizar una empresa con sus contactos
    @PutMapping("/update-empresa-with-contacts")
    public ResponseEntity<?> updateEmpresaWithContacts(@RequestBody EmpresaContactosDTO dto) {
        EmpresaContactosDTO updatedEmpresa = empresaService.updateEmpresaWithContacts(dto);
        if (updatedEmpresa != null) {
            return ResponseEntity.ok(updatedEmpresa);
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
}
