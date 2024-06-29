package Backend.SGTS.Entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tracking_storage")
public class TrackingStorageEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtracking;

    @Column(name = "id_servicio")
    private Integer idServicio;

    @Column(name = "event_log")
    private String eventLog;

    @Column(name = "data")
    private String data;

    @Column(name = "id_recurso")
    private Integer idRecurso;

    @Column(name = "data_responsable")
    private String dataResponsable;

    @Column(name = "rol")
    private String rol;

    @Column(name = "timestamp")
    private Timestamp timestamp;
    
    @Column(name = "action")
    private String action;
}
