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
    @Column(name = "Riesgo", nullable = false, length = 45)
    private String riesgo;
    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiesgoEntity that = (RiesgoEntity) o;
        return idRiesgo == that.idRiesgo && Objects.equals(riesgo, that.riesgo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRiesgo, riesgo);
    }
}
