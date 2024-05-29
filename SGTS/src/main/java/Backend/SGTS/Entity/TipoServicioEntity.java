package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tipo_servicio", schema = "sgts_db", catalog = "")
public class TipoServicioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Tipo_Servicio", nullable = false)
    private Integer idTipoServicio;
    @Basic
    @Column(name = "Tipo_Servicio", nullable = false, length = 45)
    private String tipoServicio;
    @Basic
    @Column(name = "Eliminado", nullable = true)
    private Boolean eliminado;
    
    public TipoServicioEntity() {}

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

    public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}


}
