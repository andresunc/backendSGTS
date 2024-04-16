package Backend.SGTS.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.ContactoEmpresaEntity;
import Backend.SGTS.Entity.EmpresaEntity;
import Backend.SGTS.Repository.ContactoEmpresaRepository;
import Backend.SGTS.Repository.EmpresaRepository;
import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

	// Inyecto repositorio de empresa
	@Autowired
	EmpresaRepository empresaRepository;
	@Autowired
    ContactoEmpresaRepository contactoEmpresaRepository;
	
	// Inyecto Servicio de contactos
	@Autowired
    ContactoEmpresaService contactoEmpresaService;
	
	// Obtengo todos los riesgos
	public List<EmpresaEntity> getAll() {
		return empresaRepository.findAll();
	}
	
	// Obtengo una empresa por id
	public EmpresaEntity getById(Integer id) {
		return empresaRepository.findById(id).orElse(null);
	}
	
	// Crear una empresa
    public EmpresaEntity create(EmpresaEntity empresa) {
        empresa.setEliminado(false);
        return empresaRepository.save(empresa);
    }
	
	// Actualizo una empresa
	public EmpresaEntity update(EmpresaEntity empresa) {
		return empresaRepository.save(empresa);
	}
	
	// Elimino una empresa de manera lógica y los contactos de manera permanente
	@Transactional
    public void deleteEmpresaAndContacts(Integer idEmpresa) {
        EmpresaEntity empresa = empresaRepository.findById(idEmpresa).orElse(null);
        if (empresa != null && empresa.getEliminado() == false) {
            empresa.setEliminado(true);
            empresaRepository.save(empresa);
            contactoEmpresaService.deleteByEmpresaIdEmpresa(idEmpresa);
        }
    }
	
	// Crear una empresa con una lista de contactos
	@Transactional
    public List<ContactoEmpresaEntity> createEmpresaWithContacts(EmpresaEntity empresa, List<ContactoEmpresaEntity> contactos) {
        // Guardar la empresa primero para obtener su ID
        empresa = this.create(empresa);

        // Si hay contactos, asignar el ID de la empresa a cada uno
        if (!contactos.isEmpty()) {
            for (ContactoEmpresaEntity contacto : contactos) {
                contacto.setEmpresaIdEmpresa(empresa.getIdEmpresa());
            }

            // Guardar los contactos asociados a la empresa
            List<ContactoEmpresaEntity> contactosCreados = contactoEmpresaRepository.saveAll(contactos);
            return contactosCreados;
        } else {
            // Si no hay contactos, simplemente retornar una lista vacía
            return new ArrayList<>();
        }
    }
}
