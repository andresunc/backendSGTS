package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "historico_notificaciones", schema = "sgts_db", catalog = "")
public class HistoricoNotificacionesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Historico_Notificaciones", nullable = false)
    private Integer idHistoricoNotificaciones;
    @Basic
    @Column(name = "Fecha", nullable = false)
    private Timestamp fecha;
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

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
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

}
