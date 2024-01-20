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

    public Integer getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(Integer idRubro) {
        this.idRubro = idRubro;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RubroEntity that = (RubroEntity) o;
        return idRubro == that.idRubro && Objects.equals(rubro, that.rubro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRubro, rubro);
    }
}
