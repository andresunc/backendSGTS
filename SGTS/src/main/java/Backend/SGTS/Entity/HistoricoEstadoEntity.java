package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "historico_estado", schema = "sgts_db", catalog = "")
public class HistoricoEstadoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Historico_Estado", nullable = false)
    private Integer idHistoricoEstado;
    @Basic
    @Column(name = "Fecha", nullable = false)
    private Timestamp fecha;
    @Basic
    @Column(name = "Servicio_id_Servicio", nullable = false)
    private int servicioIdServicio;
    @Basic
    @Column(name = "Estado_id_Estado", nullable = false)
    private int estadoIdEstado;

    public Integer getIdHistoricoEstado() {
        return idHistoricoEstado;
    }

    public void setIdHistoricoEstado(Integer idHistoricoEstado) {
        this.idHistoricoEstado = idHistoricoEstado;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getServicioIdServicio() {
        return servicioIdServicio;
    }

    public void setServicioIdServicio(int servicioIdServicio) {
        this.servicioIdServicio = servicioIdServicio;
    }

    public int getEstadoIdEstado() {
        return estadoIdEstado;
    }

    public void setEstadoIdEstado(int estadoIdEstado) {
        this.estadoIdEstado = estadoIdEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoEstadoEntity that = (HistoricoEstadoEntity) o;
        return idHistoricoEstado == that.idHistoricoEstado && servicioIdServicio == that.servicioIdServicio && estadoIdEstado == that.estadoIdEstado && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHistoricoEstado, fecha, servicioIdServicio, estadoIdEstado);
    }
}
