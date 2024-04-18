package Backend.SGTS.Entity.Dto;

import java.util.List;

import Backend.SGTS.Entity.ContactoEmpresaEntity;
import Backend.SGTS.Entity.EmpresaEntity;

public class EmpresaContactosDTO {

	private EmpresaEntity empresa;
    private List<ContactoEmpresaEntity> contactos;
    
	public EmpresaContactosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpresaContactosDTO(EmpresaEntity empresa, List<ContactoEmpresaEntity> contactos) {
		super();
		this.empresa = empresa;
		this.contactos = contactos;
	}

	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

	public List<ContactoEmpresaEntity> getContactos() {
		return contactos;
	}

	public void setContactos(List<ContactoEmpresaEntity> contactos) {
		this.contactos = contactos;
	}
    
}
