package Backend.SGTS.Constants;

public class SqlQueriesEmpresa {

	private String empresaDto = "SELECT "
			+ "em.id_Empresa as 'idEmpresa',"
            + "ru.id_Rubro as 'idRubro',"
            + "ru.rubro as 'rubro',"
            + "ri.id_Riesgo as 'idRiesgo',"
            + "ri.Riesgo as 'riesgo',"
            + "em.Razon_Social as 'cliente',"
            + "em.Cuit as 'cuit',"
            + "em.Direccion as 'direccion' "
            + "FROM empresa em "
            + "LEFT JOIN rubro ru ON ru.id_Rubro = em.Rubro_id_Rubro "
            + "LEFT JOIN riesgo ri ON ri.id_Riesgo = em.Riesgo_id_Riesgo AND ri.eliminado = 0 "
            + "WHERE em.Eliminado = 0";

    public SqlQueriesEmpresa() {
        super();
    }

    public String getEmpresaDto() {
        return empresaDto;
    }
}
