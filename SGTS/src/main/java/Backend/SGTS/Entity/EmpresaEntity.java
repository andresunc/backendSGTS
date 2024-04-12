package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "empresa", schema = "sgts_db", catalog = "")
public class EmpresaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Empresa", nullable = false)
    private Integer idEmpresa;
    @Basic
    @Column(name = "Cuit", nullable = true, length = 13)
    private String cuit;
    @Basic
    @Column(name = "Direccion", nullable = true, length = 200)
    private String direccion;
    @Basic
    @Column(name = "Rubro_id_Rubro", nullable = false)
    private int rubroIdRubro;
    @Basic
    @Column(name = "Riesgo_id_Riesgo", nullable = true)
    private Integer riesgoIdRiesgo;
    @Basic
    @Column(name = "Razon_Social", nullable = false, length = 100)
    private String razonSocial;
    @Basic
    @Column(name = "Eliminado", nullable = true)
    private Byte eliminado;
    
	public EmpresaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getRubroIdRubro() {
		return rubroIdRubro;
	}

	public void setRubroIdRubro(int rubroIdRubro) {
		this.rubroIdRubro = rubroIdRubro;
	}

	public Integer getRiesgoIdRiesgo() {
		return riesgoIdRiesgo;
	}

	public void setRiesgoIdRiesgo(Integer riesgoIdRiesgo) {
		this.riesgoIdRiesgo = riesgoIdRiesgo;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Byte getEliminado() {
		return eliminado;
	}

	public void setEliminado(Byte eliminado) {
		this.eliminado = eliminado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuit, direccion, eliminado, idEmpresa, razonSocial, riesgoIdRiesgo, rubroIdRubro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpresaEntity other = (EmpresaEntity) obj;
		return Objects.equals(cuit, other.cuit) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(eliminado, other.eliminado) && Objects.equals(idEmpresa, other.idEmpresa)
				&& Objects.equals(razonSocial, other.razonSocial)
				&& Objects.equals(riesgoIdRiesgo, other.riesgoIdRiesgo) && rubroIdRubro == other.rubroIdRubro;
	}
    
}
