package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "riesgo", schema = "sgts_db", catalog = "")
public class RiesgoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Riesgo", nullable = false)
    private Integer idRiesgo;
    @Basic
    @Column(name = "riesgo", nullable = false, length = 45)
    private String riesgo;
    @Basic
    @Column(name = "eliminado", nullable = false, length = 45)
    private Boolean eliminado;
    
    public RiesgoEntity() {}

    public Integer getIdRiesgo() {
        return idRiesgo;
    }

    public void setIdRiesgo(Integer idRiesgo) {
        this.idRiesgo = idRiesgo;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

	public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}
    
}
