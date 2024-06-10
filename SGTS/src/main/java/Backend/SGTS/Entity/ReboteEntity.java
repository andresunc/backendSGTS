package Backend.SGTS.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "porcentaje_rebote", schema = "sgts_db", catalog = "")
public class ReboteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_rebote;
	
	@Column(name = "fecha", nullable = false)
	private Timestamp fecha;
	
	@Column(name = "rebote_ambiente", precision = 5, scale = 2)
    private BigDecimal reboteAmbiente;

    @Column(name = "rebote_hys", precision = 5, scale = 2)
    private BigDecimal reboteHys;

    @Column(name = "rebote_habilitaciones", precision = 5, scale = 2)
    private BigDecimal reboteHabilitaciones;

	public ReboteEntity() {
		super();
	}
	
}
