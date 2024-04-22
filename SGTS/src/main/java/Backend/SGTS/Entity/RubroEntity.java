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
    private Boolean eliminado;
    
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

	public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}

	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}

}
