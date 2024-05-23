package Backend.SGTS.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estado", schema = "sgts_db", catalog = "")
public class EstadoEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_Estado", nullable = false)
	private Integer idEstado;
	@Basic
	@Column(name = "Tipo_Estado", nullable = false, length = 45)
	private String tipoEstado;
	@Basic
	@Column(name = "Categoria_estado_id_Categoria", nullable = false)
	private Integer idCategoria;
	@Basic
	@Column(name = "orden", nullable = true)
	private Integer orden;
	@Basic
	@Column(name = "eliminado", nullable = true)
	private Boolean eliminado;

	public EstadoEntity() {
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(String tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	
}
