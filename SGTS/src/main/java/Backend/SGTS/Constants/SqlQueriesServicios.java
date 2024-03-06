package Backend.SGTS.Constants;

public class SqlQueriesServicios {

	/* Tomar los Servicios */
	private String serviceNotDeleted = "WITH UltimoEstado AS ("
            + "    SELECT"
            + "        hse.Servicio_id_Servicio,"
            + "        hse.Estado_id_Estado,"
            + "        hse.fecha,"
            + "        ROW_NUMBER() OVER (PARTITION BY hse.Servicio_id_Servicio ORDER BY hse.Fecha DESC) as rn"
            + "    FROM"
            + "        historico_estado hse)"
            + "SELECT"
            + "    sv.id_Servicio as 'idServicio',"
            + "    tsv.id_Tipo_Servicio as 'idTipoServicio',"
            + "    se.Alta as 'fecha_alta',"
            + "    tsv.tipo_servicio as 'tipo',"
            + "    em.id_Empresa as 'idCliente',"
            + "    em.Razon_Social as 'cliente',"
            + "    est.id_Estado as 'idEstado',"
            + "    est.Tipo_Estado as 'estado',"
            + "    sv.Recurrencia as 'recurrencia',"
            + "    sv.Referencia_Id_Servicio as 'referencia',"
            + "    sv.Fecha_Hora_Alerta_Venc as 'fecha_notificacion',"
            + "    ru.id_Rubro as 'idRubro',"
            + "    ru.Rubro as 'rubro',"
            + "    se.id_Servicio_Empresa as 'idServicioEmpresa',"
            + "    se.Costo_Servicio as 'total_presupuestado',"
            + "    sv.Comentario as 'comentario'"
            + "FROM"
            + "    sgts_db.servicio_empresa se"
            + "    LEFT JOIN empresa em ON em.id_Empresa = se.Empresa_id_Empresa"
            + "    LEFT JOIN rubro ru ON ru.id_Rubro = em.Rubro_id_Rubro"
            + "    LEFT JOIN riesgo ri ON ri.id_Riesgo = em.Riesgo_id_Riesgo"
            + "    LEFT JOIN recurso_gg rgg ON rgg.id_Recurso_GG = se.Recurso_GG_id_Recurso_GG"
            + "    LEFT JOIN rol on rol.id_Rol = rgg.Rol_id_Rol"
            + "    LEFT JOIN persona per on per.id_Persona = rgg.Persona_id_Persona"
            + "    LEFT JOIN servicio sv ON sv.id_Servicio = se.Servicio_id_Servicio"
            + "    LEFT JOIN tipo_servicio tsv ON tsv.id_Tipo_Servicio = sv.Tipo_Servicio_id_Tipo_Servicio"
            + "    LEFT JOIN (SELECT * FROM UltimoEstado WHERE rn = 1) hse ON sv.id_Servicio = hse.Servicio_id_Servicio"
            + "    LEFT JOIN estado est ON est.id_Estado = hse.Estado_id_Estado"
    		+ "    WHERE se.Eliminado = 0";
	
	public SqlQueriesServicios() {
		super();
	}
	
	public String getServices(Integer limit) {
	    try {
	        return (limit <= 0) ? serviceNotDeleted : serviceNotDeleted + "    LIMIT " + limit;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error al obtener servicios";
	    }
	}
}
