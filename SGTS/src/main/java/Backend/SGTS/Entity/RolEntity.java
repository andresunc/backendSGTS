package Backend.SGTS.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rol")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    @Column(name = "rol")
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "rol_permiso", joinColumns = @JoinColumn(name = "id_role"), inverseJoinColumns = @JoinColumn(name = "id_permiso"))
    private Set<PermisoEntity> permisoList = new HashSet<>();


    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public RoleEnum getRoleEmun() {
        return roleEnum;
    }

    public void setRoleEmun(RoleEnum roleEmun) {
        this.roleEnum = roleEmun;
    }

    public Set<PermisoEntity> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(Set<PermisoEntity> permisoList) {
        this.permisoList = permisoList;
    }
}
