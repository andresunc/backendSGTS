package Backend.SGTS.Constans.Rpt;

public class QueryServiciosEnCurso {

    /* Tomar los Servicios */
    private String serviciosEnCurso = "WITH UltimoEstado AS ("
            + "    SELECT"
            + "        hse.Servicio_id_Servicio,"
            + "        hse.Estado_id_Estado,"
            + "        hse.fecha,"
            + "        ROW_NUMBER() OVER (PARTITION BY hse.Servicio_id_Servicio ORDER BY hse.Fecha DESC) as rn"
            + "    FROM"
            + "        historico_estado hse"
            + ")"
            + "SELECT"
            + "    sv.id_Servicio AS 'idServicio',"
            + "    em.Razon_Social AS 'empresa',"
            + "    ru.Rubro AS 'rubro',"
            + "    tsv.tipo_servicio AS 'tipoServicio',"
            + "    COALESCE(dep.Dependencia, 'N/A') AS 'dependenciaInvolucrada',"
            + "    est.Tipo_Estado AS 'estado',"
            + "    COALESCE("
            + "        ROUND("
            + "            (SUM(CASE WHEN itch.completo = 1 THEN 1 ELSE 0 END) / NULLIF(COUNT(itch.Item_id_Item), 0)) * 100,"
            + "            0"
            + "        ),"
            + "        0"
            + "    ) AS 'porcentajeAvance'"
            + "FROM"
            + "    sgts_db.servicio_empresa se"
            + "    LEFT JOIN empresa em ON em.id_Empresa = se.Empresa_id_Empresa"
            + "    LEFT JOIN rubro ru ON ru.id_Rubro = em.Rubro_id_Rubro"
            + "    LEFT JOIN riesgo ri ON ri.id_Riesgo = em.Riesgo_id_Riesgo"
            + "    LEFT JOIN servicio sv ON sv.id_Servicio = se.Servicio_id_Servicio"
            + "    LEFT JOIN tipo_servicio tsv ON tsv.id_Tipo_Servicio = sv.Tipo_Servicio_id_Tipo_Servicio"
            + "    LEFT JOIN ("
            + "        SELECT * FROM UltimoEstado WHERE rn = 1"
            + "    ) hse ON sv.id_Servicio = hse.Servicio_id_Servicio"
            + "    LEFT JOIN estado est ON est.id_Estado = hse.Estado_id_Estado"
            + "    LEFT JOIN categoria_estado cae ON cae.id_Categoria = est.categoria_estado_id_Categoria"
            + "    LEFT JOIN item_checklist itch ON sv.id_Servicio = itch.Servicio_id_Servicio"
            + "    LEFT JOIN item item ON item.id_Item = itch.Item_id_Item"
            + "    LEFT JOIN dependencia dep ON dep.id_Dependencia = item.Dependencia_id_Dependencia"
            + "    WHERE se.Eliminado = 0 and est.categoria_estado_id_Categoria = 2"
            + "    GROUP BY 1, 2, 3, 4, 5, 6";

    public QueryServiciosEnCurso() {
        super();
    }

    public String getServiciosEnCurso() {
            return serviciosEnCurso;
    }
}
