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

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoEntity that = (EstadoEntity) o;
        return idEstado == that.idEstado && Objects.equals(tipoEstado, that.tipoEstado) && Objects.equals(eliminado, that.eliminado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstado, tipoEstado, eliminado);
    }
}
