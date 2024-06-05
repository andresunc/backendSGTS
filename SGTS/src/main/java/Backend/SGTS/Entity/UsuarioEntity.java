package Backend.SGTS.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "usuario", schema = "sgts_db", catalog = "")
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Usuario", nullable = false)
    private Integer idUsuario;
    @Basic
    @Column(name = "Username", nullable = false, length = 45)
    private String username;
    @Basic
    @Column(name = "Password", nullable = false)
    private String password;
    @Basic
    @Column(name = "Recurso_GG_id_Recurso_GG", nullable = false)
    private Integer recursoGgIdRecursoGg;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "account_No_Expired")
    private boolean accountNoExpired;

    @Column(name = "account_No_Locked")
    private boolean accountNoLocked;

    @Column(name = "credential_No_Expired")
    private boolean credentialNoExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_Usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<RolEntity> roles = new HashSet<>();
    
    public UsuarioEntity() {}

    // Método builder manual ***
    public static UsuarioEntityBuilder builder() {
        return new UsuarioEntityBuilder();
    }

    public static class UsuarioEntityBuilder {
        private Integer idUsuario;
        private String username;
        private String password;
        private Integer recursoGgIdRecursoGg;
        private boolean isEnabled;
        private boolean accountNoExpired;
        private boolean accountNoLocked;
        private boolean credentialNoExpired;
        private Set<RolEntity> roles;

        public UsuarioEntityBuilder idUsuario(Integer idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        public UsuarioEntityBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UsuarioEntityBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UsuarioEntityBuilder recursoGgIdRecursoGg(Integer recursoGgIdRecursoGg) {
            this.recursoGgIdRecursoGg = recursoGgIdRecursoGg;
            return this;
        }

        public UsuarioEntityBuilder isEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        public UsuarioEntityBuilder accountNoExpired(boolean accountNoExpired) {
            this.accountNoExpired = accountNoExpired;
            return this;
        }

        public UsuarioEntityBuilder accountNoLocked(boolean accountNoLocked) {
            this.accountNoLocked = accountNoLocked;
            return this;
        }

        public UsuarioEntityBuilder credentialNoExpired(boolean credentialNoExpired) {
            this.credentialNoExpired = credentialNoExpired;
            return this;
        }

        public UsuarioEntityBuilder roles(Set<RolEntity> roles) {
            this.roles = roles;
            return this;
        }

        public UsuarioEntity build() {
            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setIdUsuario(this.idUsuario);
            usuario.setUsername(this.username);
            usuario.setPassword(this.password);
            usuario.setRecursoGgIdRecursoGg(this.recursoGgIdRecursoGg);
            usuario.setEnabled(this.isEnabled);
            usuario.setAccountNoExpired(this.accountNoExpired);
            usuario.setAccountNoLocked(this.accountNoLocked);
            usuario.setCredentialNoExpired(this.credentialNoExpired);
            usuario.setRoles(this.roles);
            return usuario;
        }
    }
    // *** Fin Método builder manual ***

    public Integer getRecursoGgIdRecursoGg() {
        return recursoGgIdRecursoGg;
    }

    public void setRecursoGgIdRecursoGg(Integer recursoGgIdRecursoGg) {
        this.recursoGgIdRecursoGg = recursoGgIdRecursoGg;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isAccountNoExpired() {
        return accountNoExpired;
    }

    public void setAccountNoExpired(boolean accountNoExpired) {
        this.accountNoExpired = accountNoExpired;
    }

    public boolean isAccountNoLocked() {
        return accountNoLocked;
    }

    public void setAccountNoLocked(boolean accountNoLocked) {
        this.accountNoLocked = accountNoLocked;
    }

    public boolean isCredentialNoExpired() {
        return credentialNoExpired;
    }

    public void setCredentialNoExpired(boolean credentialNoExpired) {
        this.credentialNoExpired = credentialNoExpired;
    }

    public Set<RolEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolEntity> roles) {
        this.roles = roles;
    }
}
