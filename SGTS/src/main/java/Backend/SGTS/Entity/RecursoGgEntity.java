package Backend.SGTS.Entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Entity
@Table(name = "recurso_gg", schema = "sgts_db", catalog = "")
public class RecursoGgEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Recurso_GG", nullable = false)
    private Integer idRecursoGg;
    @Basic
    @Column(name = "Persona_id_Persona", nullable = false)
    private int personaIdPersona;
    @Basic
    @Column(name = "Eliminado", nullable = true)
    private Byte eliminado;
    
    public RecursoGgEntity() {}

    public Integer getIdRecursoGg() {
        return idRecursoGg;
    }

    public void setIdRecursoGg(Integer idRecursoGg) {
        this.idRecursoGg = idRecursoGg;
    }

    public int getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(int personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }

    public Byte getEliminado() {
		return eliminado;
	}

	public void setEliminado(Byte eliminado) {
		this.eliminado = eliminado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eliminado, idRecursoGg, personaIdPersona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecursoGgEntity other = (RecursoGgEntity) obj;
		return Objects.equals(eliminado, other.eliminado) && Objects.equals(idRecursoGg, other.idRecursoGg)
				&& personaIdPersona == other.personaIdPersona;
	}

}
