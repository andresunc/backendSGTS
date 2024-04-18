package Backend.SGTS.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.ContactoEmpresaEntity;
import Backend.SGTS.Entity.EmpresaEntity;
import Backend.SGTS.Entity.Dto.EmpresaContactosDTO;
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
	
	// Método para actualizar una empresa con contactos
	@Transactional
	public EmpresaContactosDTO updateEmpresaWithContacts(EmpresaContactosDTO dto) {
	    EmpresaEntity empresa = empresaRepository.findById(dto.getEmpresa().getIdEmpresa()).orElse(null);
	    
	    if (empresa != null) {
	        // Actualizar los datos de la empresa
	    	empresa.setCuit(dto.getEmpresa().getCuit());
	    	empresa.setDireccion(dto.getEmpresa().getDireccion());
	    	empresa.setRubroIdRubro(dto.getEmpresa().getRubroIdRubro());
	    	empresa.setRiesgoIdRiesgo(dto.getEmpresa().getRiesgoIdRiesgo());
	        empresa.setRazonSocial(dto.getEmpresa().getRazonSocial());
	        
	        // Otros campos que puedan ser actualizados
	        
	        empresa = this.update(empresa); // Guardar los cambios en la empresa

	        // Eliminar los contactos actuales de la empresa
	        contactoEmpresaService.deleteByEmpresaIdEmpresa(empresa.getIdEmpresa());

	        // Crear nuevos contactos si la lista no está vacía
	        if (dto.getContactos() != null && !dto.getContactos().isEmpty()) {
	            // Guardar los nuevos contactos asociados a la empresa
	            List<ContactoEmpresaEntity> contactosCreados = contactoEmpresaRepository.saveAll(dto.getContactos());
	            return new EmpresaContactosDTO(empresa, contactosCreados);
	        } else {
	            // Si la lista de contactos está vacía, retornar solo la empresa actualizada
	            return new EmpresaContactosDTO(empresa, new ArrayList<>());
	        }
	    } else {
	        // Si la empresa no existe, retornar null o lanzar una excepción según la lógica de tu aplicación
	        return null;
	    }
	}
}
