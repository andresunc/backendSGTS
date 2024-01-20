package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

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
    @Column(name = "Eliminado", nullable = true)
    private Byte eliminado;

    public Byte getEliminado() {
		return eliminado;
	}

	public void setEliminado(Byte eliminado) {
		this.eliminado = eliminado;
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

	@Override
	public int hashCode() {
		return Objects.hash(eliminado, idEstado, tipoEstado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoEntity other = (EstadoEntity) obj;
		return Objects.equals(eliminado, other.eliminado) && Objects.equals(idEstado, other.idEstado)
				&& Objects.equals(tipoEstado, other.tipoEstado);
	}

    
}
