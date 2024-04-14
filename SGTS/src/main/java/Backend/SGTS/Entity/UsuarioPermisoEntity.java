package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "usuario_permiso", schema = "sgts_db", catalog = "")
public class UsuarioPermisoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Usuario_Permiso", nullable = false)
    private Integer idUsuarioPermiso;
    @Basic
    @Column(name = "Usuario_id_Usuario", nullable = false)
    private int usuarioIdUsuario;
    @Basic
    @Column(name = "permiso_id_permiso", nullable = false)
    private int permisoIdPermiso;
    
    public UsuarioPermisoEntity() {}

    public Integer getIdUsuarioPermiso() {
        return idUsuarioPermiso;
    }

    public void setIdUsuarioPermiso(Integer idUsuarioPermiso) {
        this.idUsuarioPermiso = idUsuarioPermiso;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public int getPermisoIdPermiso() {
        return permisoIdPermiso;
    }

    public void setPermisoIdPermiso(int permisoIdPermiso) {
        this.permisoIdPermiso = permisoIdPermiso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioPermisoEntity that = (UsuarioPermisoEntity) o;
        return idUsuarioPermiso == that.idUsuarioPermiso && usuarioIdUsuario == that.usuarioIdUsuario && permisoIdPermiso == that.permisoIdPermiso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuarioPermiso, usuarioIdUsuario, permisoIdPermiso);
    }
}
