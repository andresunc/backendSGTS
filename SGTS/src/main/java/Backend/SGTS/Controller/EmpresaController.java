package Backend.SGTS.Controller;

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

import Backend.SGTS.Entity.EmpresaEntity;
import Backend.SGTS.Service.ContactoEmpresaService;
import Backend.SGTS.Service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	// Inyecto Servicio de Empresa
	@Autowired
	EmpresaService empresaService;

	// Inyecto Servicio de ContactoEmpresa
	@Autowired
	ContactoEmpresaService contactoEmpresaService;

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
}
