package Backend.SGTS.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class RenovarServicioEntity {

	private Integer id_Servicio;
    private Double costo_Servicio;
    private Integer recurso_GG_id_Recurso_GG;
    private Integer estado_id_Estado;
}
