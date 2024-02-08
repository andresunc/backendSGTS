package Backend.SGTS.Constants;

public class SqlQueriesItemChecklist {

	private String itemChecklistDto = "SELECT "
			+ "itch.id_Item_Checklist as 'idItemChecklist',"
            + "req.descripcion as 'nombre_item',"
            + "itch.Inicio_Estandar as 'inicio_estimado',"
            + "itch.Fin_Estandar as 'fin_estimado',"
            + "itch.Inicio_Con_Desvio as 'ejecucion_real',"
            + "itch.Fin_Con_Desvio as 'fin_real',"
            + "itch.Notificado as 'notificado',"
            + "itch.Tasa_Valor as 'valor_tasa',"
            + "itch.Tasa_Cantidad_Hojas as 'hojas',"
            + "per.Nombre + ' ' + per.Apellido as 'responsable',"
            + "itch.Url_comprobante_tasa as 'url_comprobante',"
            + "itch.completo as 'completo'"
            + "FROM item_checklist itch "
            + "LEFT JOIN servicio sv ON sv.id_Servicio = itch.Servicio_id_Servicio "
            + "LEFT JOIN item it ON it.id_Item = itch.Item_id_Item "
            + "LEFT JOIN requisito req ON req.id_requisito = it.requisito_id_requisito "
            + "LEFT JOIN recurso_gg rgg ON rgg.id_Recurso_GG = itch.Recurso_GG_id_Recurso_GG "
            + "LEFT JOIN persona per ON per.id_Persona = rgg.Persona_id_Persona "
            + "LEFT JOIN rol ON rol.id_Rol = rgg.Rol_id_Rol "
            + "WHERE sv.id_Servicio = ?";
	
	public SqlQueriesItemChecklist() {
		super();
	}
	
	public String getItemChecklistDto() {
		return itemChecklistDto;
	}
}
