package Backend.SGTS.Entity.Dto;

import java.time.LocalDateTime;

public class ItemChecklistDto {

	private Integer idItemChecklist;
	private String nombreItem;
	private LocalDateTime inicioEstimado;
	private LocalDateTime finEstimado;
	private LocalDateTime ejecucionReal;
	private LocalDateTime finReal;
	private boolean notificado;
	private double valorTasa;
	private Integer hojas;
	private String responsable;
	private String urlComprobante;
	private boolean completo;

	public ItemChecklistDto() {
	}

	public Integer getIdItemChecklist() {
		return idItemChecklist;
	}

	public void setIdItemChecklist(Integer idItemChecklist) {
		this.idItemChecklist = idItemChecklist;
	}

	public String getNombreItem() {
		return nombreItem;
	}

	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}

	public LocalDateTime getInicioEstimado() {
		return inicioEstimado;
	}

	public void setInicioEstimado(LocalDateTime inicioEstimado) {
		this.inicioEstimado = inicioEstimado;
	}

	public LocalDateTime getFinEstimado() {
		return finEstimado;
	}

	public void setFinEstimado(LocalDateTime finEstimado) {
		this.finEstimado = finEstimado;
	}

	public LocalDateTime getEjecucionReal() {
		return ejecucionReal;
	}

	public void setEjecucionReal(LocalDateTime ejecucionReal) {
		this.ejecucionReal = ejecucionReal;
	}

	public LocalDateTime getFinReal() {
		return finReal;
	}

	public void setFinReal(LocalDateTime finReal) {
		this.finReal = finReal;
	}

	public boolean isNotificado() {
		return notificado;
	}

	public void setNotificado(boolean notificado) {
		this.notificado = notificado;
	}

	public double getValorTasa() {
		return valorTasa;
	}

	public void setValorTasa(double valorTasa) {
		this.valorTasa = valorTasa;
	}

	public Integer getHojas() {
		return hojas;
	}

	public void setHojas(Integer hojas) {
		this.hojas = hojas;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getUrlComprobante() {
		return urlComprobante;
	}

	public void setUrlComprobante(String urlComprobante) {
		this.urlComprobante = urlComprobante;
	}

	public boolean getCompleto() {
		return completo;
	}

	public void setCompleto(boolean completo) {
		this.completo = completo;
	}
	
}
