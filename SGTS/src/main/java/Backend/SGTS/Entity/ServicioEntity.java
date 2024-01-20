package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "servicio", schema = "sgts_db", catalog = "")
public class ServicioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Servicio", nullable = false)
    private Integer idServicio;
    @Basic
    @Column(name = "Fecha_Venc_Expediente", nullable = true)
    private Date fechaVencExpediente;
    @Basic
    @Column(name = "Fecha_Hora_Alerta_Venc", nullable = true)
    private Timestamp fechaHoraAlertaVenc;
    @Basic
    @Column(name = "Recurrencia", nullable = true)
    private Integer recurrencia;
    @Basic
    @Column(name = "Referencia_Id_Servicio", nullable = true)
    private Integer referenciaIdServicio;
    @Basic
    @Column(name = "Tipo_Servicio_id_Tipo_Servicio", nullable = false)
    private int tipoServicioIdTipoServicio;
    @Basic
    @Column(name = "Comentario", nullable = true, length = 500)
    private String comentario;
    @Basic
    @Column(name = "Expediente", nullable = true, length = 45)
    private String expediente;

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Date getFechaVencExpediente() {
        return fechaVencExpediente;
    }

    public void setFechaVencExpediente(Date fechaVencExpediente) {
        this.fechaVencExpediente = fechaVencExpediente;
    }

    public Timestamp getFechaHoraAlertaVenc() {
        return fechaHoraAlertaVenc;
    }

    public void setFechaHoraAlertaVenc(Timestamp fechaHoraAlertaVenc) {
        this.fechaHoraAlertaVenc = fechaHoraAlertaVenc;
    }

    public Integer getRecurrencia() {
        return recurrencia;
    }

    public void setRecurrencia(Integer recurrencia) {
        this.recurrencia = recurrencia;
    }

    public Integer getReferenciaIdServicio() {
        return referenciaIdServicio;
    }

    public void setReferenciaIdServicio(Integer referenciaIdServicio) {
        this.referenciaIdServicio = referenciaIdServicio;
    }

    public int getTipoServicioIdTipoServicio() {
        return tipoServicioIdTipoServicio;
    }

    public void setTipoServicioIdTipoServicio(int tipoServicioIdTipoServicio) {
        this.tipoServicioIdTipoServicio = tipoServicioIdTipoServicio;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicioEntity that = (ServicioEntity) o;
        return idServicio == that.idServicio && tipoServicioIdTipoServicio == that.tipoServicioIdTipoServicio && Objects.equals(fechaVencExpediente, that.fechaVencExpediente) && Objects.equals(fechaHoraAlertaVenc, that.fechaHoraAlertaVenc) && Objects.equals(recurrencia, that.recurrencia) && Objects.equals(referenciaIdServicio, that.referenciaIdServicio) && Objects.equals(comentario, that.comentario) && Objects.equals(expediente, that.expediente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicio, fechaVencExpediente, fechaHoraAlertaVenc, recurrencia, referenciaIdServicio, tipoServicioIdTipoServicio, comentario, expediente);
    }
}
