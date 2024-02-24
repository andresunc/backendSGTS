package Backend.SGTS.Entity.Dto;

public class EmpresaDto {

	private Integer idRubro;
    private String rubro;
    private Integer idRiesgo;
    private String riesgo;
    private String cliente;
    private String cuit;
    private String direccion;
    
    public EmpresaDto() {}

	public Integer getIdRubro() {
		return idRubro;
	}

	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public Integer getIdRiesgo() {
		return idRiesgo;
	}

	public void setIdRiesgo(Integer idRiesgo) {
		this.idRiesgo = idRiesgo;
	}

	public String getRiesgo() {
		return riesgo;
	}

	public void setRiesgo(String riesgo) {
		this.riesgo = riesgo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
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
    
    
}
