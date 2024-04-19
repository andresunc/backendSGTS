package Backend.SGTS.Constants;

public class SqlQueriesRol {

	private String rolDto = "SELECT " +
		    "r.id_rol as 'id_rol'," +
		    "r.rol as 'rol'" +
		    "FROM usuario us " +
		    "LEFT JOIN usuario_rol usr ON usr.id_usuario = us.id_usuario " +
		    "LEFT JOIN rol r ON r.id_rol = usr.id_rol " +
		    "WHERE us.id_usuario = ?";
	
	public SqlQueriesRol() {}

	public String getRolDto() {
		return rolDto;
	}

	public void setRolDto(String rolDto) {
		this.rolDto = rolDto;
	}
	
}
