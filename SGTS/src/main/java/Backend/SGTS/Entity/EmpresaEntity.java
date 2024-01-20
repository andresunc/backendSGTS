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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaEntity that = (EmpresaEntity) o;
        return idEmpresa == that.idEmpresa && rubroIdRubro == that.rubroIdRubro && Objects.equals(cuit, that.cuit) && Objects.equals(direccion, that.direccion) && Objects.equals(riesgoIdRiesgo, that.riesgoIdRiesgo) && Objects.equals(razonSocial, that.razonSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpresa, cuit, direccion, rubroIdRubro, riesgoIdRiesgo, razonSocial);
    }
}
