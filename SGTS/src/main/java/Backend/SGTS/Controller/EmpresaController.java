package Backend.SGTS.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Controller.Dto.EmpresaContactosDTO;
import Backend.SGTS.Entity.ContactoEmpresaEntity;
import Backend.SGTS.Entity.EmpresaEntity;
import Backend.SGTS.Service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	// Inyecto Servicio de Empresa
	@Autowired
	EmpresaService empresaService;

	// Obtengo todas las empresas
	@GetMapping("/getAll")
	public List<EmpresaEntity> getAll() {
		return empresaService.getAll();
	}

	// Obtengo una empresa por id
	@GetMapping("/{id}")
	public EmpresaEntity getById(@PathVariable Integer id) {
		return empresaService.getById(id);
	}

	// Creo una empresa
	@PostMapping("/create")
	public EmpresaEntity create(@RequestBody EmpresaEntity empresa) {
		return empresaService.create(empresa);
	}

	// Actualizo una empresa
	@PutMapping("/update/{id}")
	public EmpresaEntity update(@PathVariable("id") Integer id, @RequestBody EmpresaEntity empresa) {

		EmpresaEntity upDateEmpresa = empresaService.getById(id);
		upDateEmpresa.setRubroIdRubro(empresa.getRubroIdRubro());
		upDateEmpresa.setRiesgoIdRiesgo(empresa.getRiesgoIdRiesgo());
		upDateEmpresa.setRazonSocial(empresa.getRazonSocial());
		upDateEmpresa.setCuit(empresa.getCuit());
		upDateEmpresa.setDireccion(empresa.getDireccion());
		empresaService.update(upDateEmpresa);

		return upDateEmpresa;
	}

	/* Elimino una empresa de manera lógica incluye eliminar contactos de manera
	permaente */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteLogicoEmpresa(@PathVariable Integer id) {
	    empresaService.deleteEmpresaAndContacts(id);
	    return ResponseEntity.noContent().build();
	}
	
	// Crear una empresa con una lista de contactos asociados
    @PostMapping("/create-empresa-with-contacts")
    public EmpresaContactosDTO createEmpresaWithContacts(@RequestBody EmpresaContactosDTO dto) {
        
    	if (dto.getContactos() == null) {
            // Si la lista de contactos es nula, solo crear la empresa
            empresaService.create(dto.getEmpresa());
            return new EmpresaContactosDTO(dto.getEmpresa(), new ArrayList<>());
        } else {
            // Si la lista de contactos no es nula, crear la empresa con los contactos asociados
            List<ContactoEmpresaEntity> contactosCreados = empresaService.createEmpresaWithContacts(dto.getEmpresa(), dto.getContactos());
            return new EmpresaContactosDTO(dto.getEmpresa(), contactosCreados);
        }
    }
}
