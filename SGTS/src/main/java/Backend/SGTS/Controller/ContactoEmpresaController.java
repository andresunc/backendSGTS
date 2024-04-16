package Backend.SGTS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Entity.ContactoEmpresaEntity;
import Backend.SGTS.Service.ContactoEmpresaService;

@RestController
@RequestMapping("/contactoEmpresa")
public class ContactoEmpresaController {

	// Inyecto Servicio de ContactoEmpresa
	@Autowired
	ContactoEmpresaService contactoEmpresaService;
	
	// Obtengo todos los contactos
	@GetMapping("/getAll")
	public List<ContactoEmpresaEntity> getAll() {
		return contactoEmpresaService.getAll();
	}
	
	// Obtengo un contacto por id
	@GetMapping("/{id}")
	public ContactoEmpresaEntity getById(@PathVariable Integer id) {
		return contactoEmpresaService.getById(id);
	}
	
	// Creo un contacto
	@PostMapping("/create")
	public ContactoEmpresaEntity create(@RequestBody ContactoEmpresaEntity contactoEmpresa) {
		return contactoEmpresaService.create(contactoEmpresa);
	}
	
	// Actualizo un contacto
	@PutMapping("/update/{id}")
	public ContactoEmpresaEntity update(@PathVariable("id") Integer id,
			@RequestBody ContactoEmpresaEntity contactoEmpresa) {

		ContactoEmpresaEntity upDateContactoEmpresa = contactoEmpresaService.getById(id);
		upDateContactoEmpresa.setNombre(contactoEmpresa.getNombre());
		upDateContactoEmpresa.setApellido(contactoEmpresa.getApellido());
		upDateContactoEmpresa.setTelefono(contactoEmpresa.getTelefono());
		upDateContactoEmpresa.setEmail(contactoEmpresa.getEmail());
		contactoEmpresaService.update(upDateContactoEmpresa);

		return upDateContactoEmpresa;
	}
	
	// Elimino un contacto
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		contactoEmpresaService.delete(id);
	}
	
	// Obtengo todos los contactos por idEmpresa
	@GetMapping("/getByIdEmpresa/{empresaIdEmpresa}")
	public List<ContactoEmpresaEntity> getByIdEmpresa(@PathVariable Integer empresaIdEmpresa) {
		return contactoEmpresaService.getByIdEmpresa(empresaIdEmpresa);
	}
	
	// Elimino todos los contactos por empresaIdEmpresa
    @DeleteMapping("/deleteByEmpresaIdEmpresa/{empresaIdEmpresa}")
    public void deleteByEmpresaIdEmpresa(@PathVariable Integer empresaIdEmpresa) {
        contactoEmpresaService.deleteByEmpresaIdEmpresa(empresaIdEmpresa);
    }
}
