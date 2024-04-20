package Backend.SGTS.Constants;

public class SqlQueriesRecursoGG {

	private String recursoGGDto = "SELECT "
            + "rgg.id_Recurso_GG as 'idRecurso',"
            + "per.id_Persona as 'idPersona',"
            + "per.Nombre as 'nombre',"
            + "per.Apellido as 'apellido',"
            + "per.Dni as 'dni'"
            + "FROM recurso_gg rgg "
            + "LEFT JOIN persona per on per.id_Persona = rgg.Persona_id_Persona "
            + "LEFT JOIN usuario us ON rgg.id_recurso_gg = us.Recurso_GG_id_Recurso_GG "
            + "WHERE rgg.eliminado = 0";

    public SqlQueriesRecursoGG() {
        super();
    }

    public String getRecursoGGDto() {
        return recursoGGDto;
    }
}
