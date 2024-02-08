package Backend.SGTS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.ContactoEmpresaEntity;
import Backend.SGTS.Repository.ContactoEmpresaRepository;

@Service
public class ContactoEmpresaService {

	// Inyecto repositorio
	@Autowired
	ContactoEmpresaRepository contactoEmpresaRepository;
	
	// Obtengo todos los contactos
	public List<ContactoEmpresaEntity> getAll() {
		return contactoEmpresaRepository.findAll();
	}
	
	// Obtengo un contacto por id
	public ContactoEmpresaEntity getById(Integer id) {
		return contactoEmpresaRepository.findById(id).orElse(null);
	}
	
	// Creo un contacto
	public ContactoEmpresaEntity create(ContactoEmpresaEntity contactoEmpresa) {
		return contactoEmpresaRepository.save(contactoEmpresa);
	}
	
	// Actualizo un contacto
	public ContactoEmpresaEntity update(ContactoEmpresaEntity contactoEmpresa) {
		return contactoEmpresaRepository.save(contactoEmpresa);
	}
	
	// Elimino un contacto
	public void delete(Integer id) {
		contactoEmpresaRepository.deleteById(id);
	}
	
	// Obtengo todos los contactos por idEmpresa
	public List<ContactoEmpresaEntity> getByIdEmpresa(Integer empresaIdEmpresa) {
		return contactoEmpresaRepository.findByEmpresaIdEmpresa(empresaIdEmpresa);
	}
}
