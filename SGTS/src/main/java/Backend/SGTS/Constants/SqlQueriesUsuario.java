package Backend.SGTS.Constants;

public class SqlQueriesUsuario {

    private String usuarioDto = "SELECT " +
            "u.id_usuario as 'idUsuario'," +
            "u.username as 'username'," +
            "u.password as 'password'," +
            "r.id_rol as 'idRol'," +
            "r.rol as 'rol'," +
            "p.id_Persona as 'idPersona'," +
            "p.Nombre as 'nombre'," +
            "p.Apellido as 'apellido'," +
            "p.Dni as 'dni'," +
            "p.Telefono as 'telefono'," +
            "p.Email as 'email'," +
            "u.is_enabled as 'isEnabled' " +
            "FROM sgts_db.usuario u " +
            "LEFT JOIN usuario_rol ur ON u.id_usuario = ur.id_usuario " +
            "LEFT JOIN rol r ON r.id_rol = ur.id_rol " +
            "LEFT JOIN recurso_gg rgg ON rgg.id_Recurso_GG = u.recurso_gg_id_Recurso_GG AND rgg.Eliminado = 0 " +
            "INNER JOIN persona p ON p.id_Persona = rgg.Persona_id_Persona AND p.id_Persona IS NOT NULL";

    public SqlQueriesUsuario() {}

    public String getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(String usuarioDto) {
        this.usuarioDto = usuarioDto;
    }
}