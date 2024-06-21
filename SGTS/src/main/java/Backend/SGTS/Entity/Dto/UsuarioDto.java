package Backend.SGTS.Entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioDto {

	private Integer idUsuario;
	private String username;
	private String password;
	private Integer idRol;
	private String rol;
	private Integer idPersona;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String email;
	private Boolean isEnabled;
}
