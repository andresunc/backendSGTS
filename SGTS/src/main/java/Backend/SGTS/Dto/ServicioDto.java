package Backend.SGTS.Dto;

import java.time.LocalDateTime;
import java.util.List;

public class ServicioDto {

	private Integer idServicio;
	private Integer idTipoServicio;
	private String tipo;
	private Integer idCliente;
	private String cliente;
	private Integer idEstado;
	private String estado;
	private Integer recurrencia;
	private Integer referencia;
	private LocalDateTime fecha_notificacion;
	private Integer idRubro;
	private String rubro;
	private Integer idServicioEmpresa;
	private Double total_presupuestado;
	private String comentario;
	private List<ItemChecklistDto> itemChecklistDto;
	
	public ServicioDto() {}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public Integer getIdTipoServicio() {
		return idTipoServicio;
	}

	public void setIdTipoServicio(Integer idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getRecurrencia() {
		return recurrencia;
	}

	public void setRecurrencia(Integer recurrencia) {
		this.recurrencia = recurrencia;
	}

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public LocalDateTime getFecha_notificacion() {
		return fecha_notificacion;
	}

	public void setFecha_notificacion(LocalDateTime fecha_notificacion) {
		this.fecha_notificacion = fecha_notificacion;
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

	public Integer getIdServicioEmpresa() {
		return idServicioEmpresa;
	}

	public void setIdServicioEmpresa(Integer idServicioEmpresa) {
		this.idServicioEmpresa = idServicioEmpresa;
	}

	public Double getTotal_presupuestado() {
		return total_presupuestado;
	}

	public void setTotal_presupuestado(Double total_presupuestado) {
		this.total_presupuestado = total_presupuestado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public List<ItemChecklistDto> getItemChecklistDto() {
		return itemChecklistDto;
	}

	public void setItemChecklistDto(List<ItemChecklistDto> itemChecklistDto) {
		this.itemChecklistDto = itemChecklistDto;
	}
	
}
