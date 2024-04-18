package Backend.SGTS.Entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "servicio_empresa", schema = "sgts_db", catalog = "")
public class ServicioEmpresaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Servicio_Empresa", nullable = false)
    private Integer idServicioEmpresa;
    @Basic
    @Column(name = "Costo_Servicio", nullable = true, precision = 0)
    private double costoServicio;
    @Basic
    @Column(name = "Alta", nullable = false)
    private Timestamp alta;
    @Basic
    @Column(name = "Servicio_id_Servicio", nullable = false)
    private int servicioIdServicio;
    @Basic
    @Column(name = "Empresa_id_Empresa", nullable = false)
    private int empresaIdEmpresa;
    @Basic
    @Column(name = "Recurso_GG_id_Recurso_GG", nullable = false)
    private int recursoGgIdRecursoGg;
    @Basic
    @Column(name = "Eliminado", nullable = true)
    private Boolean eliminado;
    
	public ServicioEmpresaEntity() {}

    public Integer getIdServicioEmpresa() {
        return idServicioEmpresa;
    }

    public void setIdServicioEmpresa(Integer idServicioEmpresa) {
		this.idServicioEmpresa = idServicioEmpresa;
	}

	public Timestamp getAlta() {
		return alta;
	}

	public void setAlta(Timestamp alta) {
		this.alta = alta;
	}

	public void setIdServicioEmpresa(int idServicioEmpresa) {
        this.idServicioEmpresa = idServicioEmpresa;
    }

    public double getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(double costoServicio) {
        this.costoServicio = costoServicio;
    }

    public int getServicioIdServicio() {
        return servicioIdServicio;
    }

    public void setServicioIdServicio(int servicioIdServicio) {
        this.servicioIdServicio = servicioIdServicio;
    }

    public int getEmpresaIdEmpresa() {
        return empresaIdEmpresa;
    }

    public void setEmpresaIdEmpresa(int empresaIdEmpresa) {
        this.empresaIdEmpresa = empresaIdEmpresa;
    }

    public int getRecursoGgIdRecursoGg() {
        return recursoGgIdRecursoGg;
    }

    public void setRecursoGgIdRecursoGg(int recursoGgIdRecursoGg) {
        this.recursoGgIdRecursoGg = recursoGgIdRecursoGg;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

}
