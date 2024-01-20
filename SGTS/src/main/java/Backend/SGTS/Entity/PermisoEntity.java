package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "permiso", schema = "sgts_db", catalog = "")
public class PermisoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_permiso", nullable = false)
    private Integer idPermiso;
    @Basic
    @Column(name = "Permiso", nullable = false)
    private int permiso;

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public int getPermiso() {
        return permiso;
    }

    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermisoEntity that = (PermisoEntity) o;
        return idPermiso == that.idPermiso && permiso == that.permiso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPermiso, permiso);
    }
}
