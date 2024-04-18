package Backend.SGTS.Constants;

public class SqlQueriesRecursoGG {

	private String recursoGGDto = "SELECT "
            + "rgg.id_Recurso_GG as 'idRecurso',"
            + "per.id_Persona as 'idPersona',"
            + "per.Nombre as 'nombre',"
            + "per.Apellido as 'apellido',"
            + "per.Dni as 'dni',"
            + "r.id_Rol as 'idRol',"
            + "r.Rol as 'rol'"
            + "FROM recurso_gg rgg "
            + "LEFT JOIN persona per on per.id_Persona = rgg.Persona_id_Persona "
            + "LEFT JOIN usuario us ON rgg.id_recurso_gg = us.Recurso_GG_id_Recurso_GG "
            + "LEFT JOIN usuario_rol ur ON us.id_usuario = ur.id_usuario "
            + "LEFT JOIN rol r ON ur.id_rol = r.id_rol "
            + "WHERE rgg.eliminado = 0";

    public SqlQueriesRecursoGG() {
        super();
    }

    public String getRecursoGGDto() {
        return recursoGGDto;
    }
}
