package Backend.SGTS.Dto;

import java.util.List;

import Backend.SGTS.Entity.HistoricoEstadoEntity;
import Backend.SGTS.Entity.ItemChecklistEntity;
import Backend.SGTS.Entity.ServicioEmpresaEntity;
import Backend.SGTS.Entity.ServicioEntity;

public class NuevoServicioDTO {

	private ServicioEntity servicio;
	private HistoricoEstadoEntity historicoEstado;
	private ServicioEmpresaEntity servicioEmpresa;
	private List<ItemChecklistEntity> itemChecklist;
	
	public NuevoServicioDTO() {}

	public ServicioEntity getServicio() {
		return servicio;
	}

	public void setServicio(ServicioEntity servicio) {
		this.servicio = servicio;
	}

	public HistoricoEstadoEntity getHistoricoEstado() {
		return historicoEstado;
	}

	public void setHistoricoEstado(HistoricoEstadoEntity historicoEstado) {
		this.historicoEstado = historicoEstado;
	}

	public ServicioEmpresaEntity getServicioEmpresa() {
		return servicioEmpresa;
	}

	public void setServicioEmpresa(ServicioEmpresaEntity servicioEmpresa) {
		this.servicioEmpresa = servicioEmpresa;
	}

	public List<ItemChecklistEntity> getItemChecklist() {
		return itemChecklist;
	}

	public void setItemChecklist(List<ItemChecklistEntity> itemChecklist) {
		this.itemChecklist = itemChecklist;
	}
	
}
