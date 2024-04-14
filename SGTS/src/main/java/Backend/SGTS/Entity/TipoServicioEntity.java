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
    private Byte eliminado;
    
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

    public Byte getEliminado() {
		return eliminado;
	}

	public void setEliminado(Byte eliminado) {
		this.eliminado = eliminado;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoServicioEntity that = (TipoServicioEntity) o;
        return idTipoServicio == that.idTipoServicio && Objects.equals(tipoServicio, that.tipoServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoServicio, tipoServicio);
    }
}
