package Backend.SGTS.Entity.Rpt;

public class ServicioEnCursoRpt {

	private int idServicio;
    private String empresa;
    private String rubro;
    private String tipoServicio;
    private String dependenciaInvolucrada;
    private String estado;
    private double porcentajeAvance;
    
    public ServicioEnCursoRpt() {}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getDependenciaInvolucrada() {
		return dependenciaInvolucrada;
	}

	public void setDependenciaInvolucrada(String dependenciaInvolucrada) {
		this.dependenciaInvolucrada = dependenciaInvolucrada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getPorcentajeAvance() {
		return porcentajeAvance;
	}

	public void setPorcentajeAvance(double porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}
    
    
}
