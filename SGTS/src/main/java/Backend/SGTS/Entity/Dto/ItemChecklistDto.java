package Backend.SGTS.Entity.Dto;

import java.time.LocalDateTime;

public class ItemChecklistDto {

	private Integer idItemChecklist;
	private String nombreItem;
	private LocalDateTime inicioEstimado;
	private LocalDateTime finEstimado;
	private double horasDesvio;
	private LocalDateTime finReal;
	private boolean notificado;
	private double tasaValor;
	private Integer tasaCantidadHojas;
	private Integer idRecurso;
	private String responsable;
	private String urlComprobanteTasa;
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

	public double getHorasDesvio() {
		return horasDesvio;
	}

	public void setHorasDesvio(double horasDesvio) {
		this.horasDesvio = horasDesvio;
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

	public double getTasaValor() {
		return tasaValor;
	}

	public void setTasaValor(double tasaValor) {
		this.tasaValor = tasaValor;
	}

	public Integer getTasaCantidadHojas() {
		return tasaCantidadHojas;
	}

	public void setTasaCantidadHojas(Integer tasaCantidadHojas) {
		this.tasaCantidadHojas = tasaCantidadHojas;
	}

	public Integer getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(Integer idRecurso) {
		this.idRecurso = idRecurso;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getUrlComprobanteTasa() {
		return urlComprobanteTasa;
	}

	public void setUrlComprobanteTasa(String urlComprobanteTasa) {
		this.urlComprobanteTasa = urlComprobanteTasa;
	}

	public boolean isCompleto() {
		return completo;
	}

	public void setCompleto(boolean completo) {
		this.completo = completo;
	}
	
}
