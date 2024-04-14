package Backend.SGTS.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "requisito", schema = "sgts_db", catalog = "")
public class RequisitoEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Requisito", nullable = false)
    private Integer idRequisito;
    @Basic
    @Column(name = "Descripcion", nullable = false, length = 60)
    private String descripcion;
    
    public RequisitoEntity() {}
    
	public Integer getIdRequisito() {
		return idRequisito;
	}
	public void setIdRequisito(Integer idRequisito) {
		this.idRequisito = idRequisito;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
