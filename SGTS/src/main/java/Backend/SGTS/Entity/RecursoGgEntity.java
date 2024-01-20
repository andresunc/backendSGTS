package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "recurso_gg", schema = "sgts_db", catalog = "")
public class RecursoGgEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Recurso_GG", nullable = false)
    private Integer idRecursoGg;
    @Basic
    @Column(name = "Rol_id_Rol", nullable = false)
    private int rolIdRol;
    @Basic
    @Column(name = "Persona_id_Persona", nullable = false)
    private int personaIdPersona;

    public Integer getIdRecursoGg() {
        return idRecursoGg;
    }

    public void setIdRecursoGg(Integer idRecursoGg) {
        this.idRecursoGg = idRecursoGg;
    }

    public int getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(int rolIdRol) {
        this.rolIdRol = rolIdRol;
    }

    public int getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(int personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursoGgEntity that = (RecursoGgEntity) o;
        return idRecursoGg == that.idRecursoGg && rolIdRol == that.rolIdRol && personaIdPersona == that.personaIdPersona;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecursoGg, rolIdRol, personaIdPersona);
    }
}
