package Backend.SGTS.Entity.Dto;

import java.sql.Timestamp;

import Backend.SGTS.Entity.DependenciaEntity;
import Backend.SGTS.Entity.RequisitoEntity;
import Backend.SGTS.Entity.RubroEntity;
import Backend.SGTS.Entity.TipoItemEntity;
import Backend.SGTS.Entity.TipoServicioEntity;

public class SelectItemDto {

	private Integer idItem;
	private Integer idTipoServicio;
	private String tipoServicio;
	private Integer idDependencia;
	private String dependencia;
	private Integer idRubro;
	private String rubro;
	private Integer idTipoItem;
	private String tipoItem;
	private Integer idRequisito;
	private String descripcion;
	private Timestamp fechaHoraRealizacionRecomendada;
	
	public SelectItemDto() {}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public Integer getIdTipoServicio() {
		return idTipoServicio;
	}

	public void setIdTipoServicio(Integer idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public Integer getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(Integer idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public Integer getIdRubro() {
		return idRubro;
	}

	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public Integer getIdTipoItem() {
		return idTipoItem;
	}

	public void setIdTipoItem(Integer idTipoItem) {
		this.idTipoItem = idTipoItem;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public Integer getIdRequisito() {
		return idRequisito;
	}

	public void setIdRequisito(Integer idRequisito) {
		this.idRequisito = idRequisito;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFechaHoraRealizacionRecomendada() {
		return fechaHoraRealizacionRecomendada;
	}

	public void setFechaHoraRealizacionRecomendada(Timestamp fechaHoraRealizacionRecomendada) {
		this.fechaHoraRealizacionRecomendada = fechaHoraRealizacionRecomendada;
	}
	
}