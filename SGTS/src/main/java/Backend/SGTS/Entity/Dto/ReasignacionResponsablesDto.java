package Backend.SGTS.Entity.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReasignacionResponsablesDto {

	private List<Integer> servicios;
    private List<Integer> items;
    private Integer responsableActual;
    private Integer nuevoResponsable;
}
