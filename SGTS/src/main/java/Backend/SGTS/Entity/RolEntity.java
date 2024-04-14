package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "rol", schema = "sgts_db", catalog = "")
public class RolEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Rol", nullable = false)
    private Integer idRol;
    @Basic
    @Column(name = "Rol", nullable = false, length = 45)
    private String rol;
    
    public RolEntity() {}

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolEntity rolEntity = (RolEntity) o;
        return idRol == rolEntity.idRol && Objects.equals(rol, rolEntity.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRol, rol);
    }
}
