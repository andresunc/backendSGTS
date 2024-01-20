package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "item_checklist", schema = "sgts_db", catalog = "")
public class ItemChecklistEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Item_Checklist", nullable = false)
    private Integer idItemChecklist;
    @Basic
    @Column(name = "Inicio_Estandar", nullable = true)
    private Date inicioEstandar;
    @Basic
    @Column(name = "Fin_Estandar", nullable = true)
    private Date finEstandar;
    @Basic
    @Column(name = "Inicio_Con_Desvio", nullable = true)
    private Date inicioConDesvio;
    @Basic
    @Column(name = "Fin_Con_Desvio", nullable = true)
    private Date finConDesvio;
    @Basic
    @Column(name = "Notificado", nullable = true)
    private Byte notificado;
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
    private int servicioIdServicio;
    @Basic
    @Column(name = "Recurso_GG_id_Recurso_GG", nullable = false)
    private int recursoGgIdRecursoGg;
    @Basic
    @Column(name = "Item_id_Item", nullable = false)
    private int itemIdItem;
    @Basic
    @Column(name = "Completo", nullable = true)
    private Byte completo;

    public Integer getIdItemChecklist() {
        return idItemChecklist;
    }

    public void setIdItemChecklist(Integer idItemChecklist) {
        this.idItemChecklist = idItemChecklist;
    }

    public Date getInicioEstandar() {
        return inicioEstandar;
    }

    public void setInicioEstandar(Date inicioEstandar) {
        this.inicioEstandar = inicioEstandar;
    }

    public Date getFinEstandar() {
        return finEstandar;
    }

    public void setFinEstandar(Date finEstandar) {
        this.finEstandar = finEstandar;
    }

    public Date getInicioConDesvio() {
        return inicioConDesvio;
    }

    public void setInicioConDesvio(Date inicioConDesvio) {
        this.inicioConDesvio = inicioConDesvio;
    }

    public Date getFinConDesvio() {
        return finConDesvio;
    }

    public void setFinConDesvio(Date finConDesvio) {
        this.finConDesvio = finConDesvio;
    }

    public Byte getNotificado() {
        return notificado;
    }

    public void setNotificado(Byte notificado) {
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

    public int getServicioIdServicio() {
        return servicioIdServicio;
    }

    public void setServicioIdServicio(int servicioIdServicio) {
        this.servicioIdServicio = servicioIdServicio;
    }

    public int getRecursoGgIdRecursoGg() {
        return recursoGgIdRecursoGg;
    }

    public void setRecursoGgIdRecursoGg(int recursoGgIdRecursoGg) {
        this.recursoGgIdRecursoGg = recursoGgIdRecursoGg;
    }

    public int getItemIdItem() {
        return itemIdItem;
    }

    public void setItemIdItem(int itemIdItem) {
        this.itemIdItem = itemIdItem;
    }

    public Byte getCompleto() {
        return completo;
    }

    public void setCompleto(Byte completo) {
        this.completo = completo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemChecklistEntity that = (ItemChecklistEntity) o;
        return idItemChecklist == that.idItemChecklist && servicioIdServicio == that.servicioIdServicio && recursoGgIdRecursoGg == that.recursoGgIdRecursoGg && itemIdItem == that.itemIdItem && Objects.equals(inicioEstandar, that.inicioEstandar) && Objects.equals(finEstandar, that.finEstandar) && Objects.equals(inicioConDesvio, that.inicioConDesvio) && Objects.equals(finConDesvio, that.finConDesvio) && Objects.equals(notificado, that.notificado) && Objects.equals(tasaValor, that.tasaValor) && Objects.equals(tasaCantidadHojas, that.tasaCantidadHojas) && Objects.equals(urlComprobanteTasa, that.urlComprobanteTasa) && Objects.equals(completo, that.completo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItemChecklist, inicioEstandar, finEstandar, inicioConDesvio, finConDesvio, notificado, tasaValor, tasaCantidadHojas, urlComprobanteTasa, servicioIdServicio, recursoGgIdRecursoGg, itemIdItem, completo);
    }
}
