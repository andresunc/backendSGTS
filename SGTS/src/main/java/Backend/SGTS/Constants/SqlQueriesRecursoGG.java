package Backend.SGTS.Constants;

public class SqlQueriesRecursoGG {

	private String recursoGGDto = "SELECT "
            + "rgg.id_Recurso_GG as 'idRecurso',"
            + "per.id_Persona as 'idPersona',"
            + "per.Nombre as 'nombre',"
            + "per.Apellido as 'apellido',"
            + "per.Dni as 'dni',"
            + "rol.id_Rol as 'idRol',"
            + "rol.Rol as 'rol'"
            + "FROM recurso_gg rgg "
            + "LEFT JOIN persona per ON per.id_Persona = rgg.Persona_id_Persona "
            + "LEFT JOIN rol ON rol.id_Rol = rgg.Rol_id_Rol "
            + "WHERE rgg.eliminado = 0";

    public SqlQueriesRecursoGG() {
        super();
    }

    public String getRecursoGGDto() {
        return recursoGGDto;
    }
}
