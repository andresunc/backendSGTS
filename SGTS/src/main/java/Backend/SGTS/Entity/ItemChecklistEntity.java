package Backend.SGTS.Entity;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "item_checklist", schema = "sgts_db", catalog = "")
public class ItemChecklistEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Item_Checklist", nullable = false)
    private Integer idItemChecklist;
    @Basic
    @Column(name = "Inicio_Estandar", nullable = true)
    private Timestamp inicioEstandar;
    @Basic
    @Column(name = "Fin_Estandar", nullable = true)
    private Timestamp finEstandar;
    @Basic
    @Column(name = "horas_desvio", nullable = false)
    private double horasDesvio;
    @Basic
    @Column(name = "Fin_Con_Desvio", nullable = true)
    private Timestamp finConDesvio;
    @Basic
    @Column(name = "Notificado", nullable = true)
    private Boolean notificado;
    @Basic
    @Column(name = "Tasa_Valor", nullable = true, precision = 0)
    private Double tasaValor;
    @Basic
    @Column(name = "Tasa_Cantidad_Hojas", nullable = true)
    private Integer tasaCantidadHojas;
    @Basic
    @Column(name = "Url_comprobante_tasa", nullable = true, length = 500)
    private String urlComprobanteTasa;
    @Basic
    @Column(name = "Servicio_id_Servicio", nullable = false)
    private Integer servicioIdServicio;
    @Basic
    @Column(name = "Recurso_GG_id_Recurso_GG", nullable = false)
    private Integer recursoGgIdRecursoGg;
    @Basic
    @Column(name = "Item_id_Item", nullable = false)
    private Integer itemIdItem;
    @Basic
    @Column(name = "Completo", nullable = true)
    private Boolean completo;
    
    public ItemChecklistEntity() {}

	public Integer getIdItemChecklist() {
		return idItemChecklist;
	}

	public void setIdItemChecklist(Integer idItemChecklist) {
		this.idItemChecklist = idItemChecklist;
	}

	public Timestamp getInicioEstandar() {
		return inicioEstandar;
	}

	public void setInicioEstandar(Timestamp inicioEstandar) {
		this.inicioEstandar = inicioEstandar;
	}

	public Timestamp getFinEstandar() {
		return finEstandar;
	}

	public void setFinEstandar(Timestamp finEstandar) {
		this.finEstandar = finEstandar;
	}

	public double getHorasDesvio() {
		return horasDesvio;
	}

	public void setHorasDesvio(double horasDesvio) {
		this.horasDesvio = horasDesvio;
	}

	public Timestamp getFinConDesvio() {
		return finConDesvio;
	}

	public void setFinConDesvio(Timestamp finConDesvio) {
		this.finConDesvio = finConDesvio;
	}

	public Boolean getNotificado() {
		return notificado;
	}

	public void setNotificado(Boolean notificado) {
		this.notificado = notificado;
	}

	public Double getTasaValor() {
		return tasaValor;
	}

	public void setTasaValor(Double tasaValor) {
		this.tasaValor = tasaValor;
	}

	public Integer getTasaCantidadHojas() {
		return tasaCantidadHojas;
	}

	public void setTasaCantidadHojas(Integer tasaCantidadHojas) {
		this.tasaCantidadHojas = tasaCantidadHojas;
	}

	public String getUrlComprobanteTasa() {
		return urlComprobanteTasa;
	}

	public void setUrlComprobanteTasa(String urlComprobanteTasa) {
		this.urlComprobanteTasa = urlComprobanteTasa;
	}

	public Integer getServicioIdServicio() {
		return servicioIdServicio;
	}

	public void setServicioIdServicio(Integer servicioIdServicio) {
		this.servicioIdServicio = servicioIdServicio;
	}

	public Integer getRecursoGgIdRecursoGg() {
		return recursoGgIdRecursoGg;
	}

	public void setRecursoGgIdRecursoGg(Integer recursoGgIdRecursoGg) {
		this.recursoGgIdRecursoGg = recursoGgIdRecursoGg;
	}

	public Integer getItemIdItem() {
		return itemIdItem;
	}

	public void setItemIdItem(Integer itemIdItem) {
		this.itemIdItem = itemIdItem;
	}

	public Boolean getCompleto() {
		return completo;
	}

	public void setCompleto(Boolean completo) {
		this.completo = completo;
	}

}
