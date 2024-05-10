package Backend.SGTS.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item", schema = "sgts_db", catalog = "")
public class ItemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Item", nullable = false)
    private Integer idItem;
    @Basic
    @Column(name = "Tipo_Item_id_Tipo_Item", nullable = false)
    private int tipoItemIdTipoItem;
    @Basic
    @Column(name = "Rubro_id_Rubro", nullable = true)
    private Integer rubroIdRubro;
    @Basic
    @Column(name = "Dependencia_id_Dependencia", nullable = true)
    private Integer dependenciaIdDependencia;
    @Basic
    @Column(name = "Tipo_Servicio_id_Tipo_Servicio", nullable = false)
    private int tipoServicioIdTipoServicio;
    @Basic
    @Column(name = "Requisito_id_Requisito", nullable = false)
    private int requisitoIdRequisito;
    @Basic
    @Column(name = "duracion_estandar", nullable = false)
    private double duracionEstandar;
    @Basic
    @Column(name = "desvio_acumulado", nullable = false)
    private double desvioAcumulado;
    @Basic
    @Column(name = "cont_cambios", nullable = true)
    private Integer contCambios;
    @Basic
    @Column(name = "eliminado", nullable = true)
    private Boolean eliminado;
    
    private String descripcion;
    
    public ItemEntity() {}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public int getTipoItemIdTipoItem() {
		return tipoItemIdTipoItem;
	}

	public void setTipoItemIdTipoItem(int tipoItemIdTipoItem) {
		this.tipoItemIdTipoItem = tipoItemIdTipoItem;
	}

	public Integer getRubroIdRubro() {
		return rubroIdRubro;
	}

	public void setRubroIdRubro(Integer rubroIdRubro) {
		this.rubroIdRubro = rubroIdRubro;
	}

	public Integer getDependenciaIdDependencia() {
		return dependenciaIdDependencia;
	}

	public void setDependenciaIdDependencia(Integer dependenciaIdDependencia) {
		this.dependenciaIdDependencia = dependenciaIdDependencia;
	}

	public int getTipoServicioIdTipoServicio() {
		return tipoServicioIdTipoServicio;
	}

	public void setTipoServicioIdTipoServicio(int tipoServicioIdTipoServicio) {
		this.tipoServicioIdTipoServicio = tipoServicioIdTipoServicio;
	}

	public int getRequisitoIdRequisito() {
		return requisitoIdRequisito;
	}

	public void setRequisitoIdRequisito(int requisitoIdRequisito) {
		this.requisitoIdRequisito = requisitoIdRequisito;
	}

	public double getDuracionEstandar() {
		return duracionEstandar;
	}

	public void setDuracionEstandar(double duracionEstandar) {
		this.duracionEstandar = duracionEstandar;
	}

	public double getDesvioAcumulado() {
		return desvioAcumulado;
	}

	public void setDesvioAcumulado(double desvioAcumulado) {
		this.desvioAcumulado = desvioAcumulado;
	}

	public Integer getContCambios() {
		return contCambios;
	}

	public void setContCambios(Integer contCambios) {
		this.contCambios = contCambios;
	}

	public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}

}
