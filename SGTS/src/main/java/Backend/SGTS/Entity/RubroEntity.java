package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "rubro", schema = "sgts_db", catalog = "")
public class RubroEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Rubro", nullable = false)
    private Integer idRubro;
    @Basic
    @Column(name = "Rubro", nullable = false, length = 45)
    private String rubro;
    @Basic
    @Column(name = "Eliminado", nullable = true)
    private Byte eliminado;
    
    public RubroEntity() {}

    public Integer getIdRubro() {
        return idRubro;
    }

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public Byte getEliminado() {
		return eliminado;
	}

	public void setEliminado(Byte eliminado) {
		this.eliminado = eliminado;
	}

	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eliminado, idRubro, rubro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RubroEntity other = (RubroEntity) obj;
		return Objects.equals(eliminado, other.eliminado) && Objects.equals(idRubro, other.idRubro)
				&& Objects.equals(rubro, other.rubro);
	}

}
