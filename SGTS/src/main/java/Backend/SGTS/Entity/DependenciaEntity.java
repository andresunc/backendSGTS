package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "dependencia", schema = "sgts_db", catalog = "")
public class DependenciaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Dependencia", nullable = false)
    private Integer idDependencia;
    @Basic
    @Column(name = "Dependencia", nullable = false, length = 45)
    private String dependencia;

    public Integer getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(Integer idDependencia) {
        this.idDependencia = idDependencia;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DependenciaEntity that = (DependenciaEntity) o;
        return idDependencia == that.idDependencia && Objects.equals(dependencia, that.dependencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDependencia, dependencia);
    }
}
