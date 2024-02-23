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
    @Basic
    @Column(name = "Descripcion", length = 45)
    private String descripcion;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, idPermiso, permiso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermisoEntity other = (PermisoEntity) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(idPermiso, other.idPermiso)
				&& permiso == other.permiso;
	}

}
