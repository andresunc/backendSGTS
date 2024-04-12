package Backend.SGTS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.EmpresaEntity;
import Backend.SGTS.Repository.EmpresaRepository;
import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

	// Inyecto repositorio de empresa
	@Autowired
	EmpresaRepository empresaRepository;
	
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
	
	// Creo una empresa
	public EmpresaEntity create(EmpresaEntity empresa) {
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
        if (empresa != null && empresa.getEliminado() == 0) {
            empresa.setEliminado(Byte.valueOf((byte) 1));
            empresaRepository.save(empresa);
            contactoEmpresaService.deleteByEmpresaIdEmpresa(idEmpresa);
        }
    }
}
