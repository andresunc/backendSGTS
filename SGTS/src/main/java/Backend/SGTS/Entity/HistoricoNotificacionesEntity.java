package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "historico_notificaciones", schema = "sgts_db", catalog = "")
public class HistoricoNotificacionesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Historico_Notificaciones", nullable = false)
    private Integer idHistoricoNotificaciones;
    @Basic
    @Column(name = "Observacion", nullable = true, length = 100)
    private String observacion;
    @Basic
    @Column(name = "Fecha", nullable = false)
    private Date fecha;
    @Basic
    @Column(name = "Resuelto", nullable = true)
    private Byte resuelto;
    @Basic
    @Column(name = "Item_Checklist_id_Item_Checklist", nullable = false)
    private int itemChecklistIdItemChecklist;

    public Integer getIdHistoricoNotificaciones() {
        return idHistoricoNotificaciones;
    }

    public void setIdHistoricoNotificaciones(Integer idHistoricoNotificaciones) {
        this.idHistoricoNotificaciones = idHistoricoNotificaciones;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Byte getResuelto() {
        return resuelto;
    }

    public void setResuelto(Byte resuelto) {
        this.resuelto = resuelto;
    }

    public int getItemChecklistIdItemChecklist() {
        return itemChecklistIdItemChecklist;
    }

    public void setItemChecklistIdItemChecklist(int itemChecklistIdItemChecklist) {
        this.itemChecklistIdItemChecklist = itemChecklistIdItemChecklist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoNotificacionesEntity that = (HistoricoNotificacionesEntity) o;
        return idHistoricoNotificaciones == that.idHistoricoNotificaciones && itemChecklistIdItemChecklist == that.itemChecklistIdItemChecklist && Objects.equals(observacion, that.observacion) && Objects.equals(fecha, that.fecha) && Objects.equals(resuelto, that.resuelto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHistoricoNotificaciones, observacion, fecha, resuelto, itemChecklistIdItemChecklist);
    }
}
