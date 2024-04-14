package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "sgts_db", catalog = "")
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Usuario", nullable = false)
    private Integer idUsuario;
    @Basic
    @Column(name = "Usuario", nullable = false, length = 45)
    private String usuario;
    @Basic
    @Column(name = "Password", nullable = false, length = 45)
    private String password;
    @Basic
    @Column(name = "Activo", nullable = false)
    private byte activo;
    @Basic
    @Column(name = "Recurso_GG_id_Recurso_GG", nullable = false)
    private int recursoGgIdRecursoGg;
    
    public UsuarioEntity() {}

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getActivo() {
        return activo;
    }

    public void setActivo(byte activo) {
        this.activo = activo;
    }

    public int getRecursoGgIdRecursoGg() {
        return recursoGgIdRecursoGg;
    }

    public void setRecursoGgIdRecursoGg(int recursoGgIdRecursoGg) {
        this.recursoGgIdRecursoGg = recursoGgIdRecursoGg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return idUsuario == that.idUsuario && activo == that.activo && recursoGgIdRecursoGg == that.recursoGgIdRecursoGg && Objects.equals(usuario, that.usuario) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, usuario, password, activo, recursoGgIdRecursoGg);
    }
}
