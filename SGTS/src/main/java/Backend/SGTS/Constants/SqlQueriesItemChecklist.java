package Backend.SGTS.Constants;

public class SqlQueriesItemChecklist {

	private String itemChecklistDto = "SELECT "
			+ "itch.id_Item_Checklist as 'idItemChecklist',"
            + "req.descripcion as 'nombre_item',"
            + "itch.Inicio_Estandar as 'inicio_estimado',"
            + "itch.Fin_Estandar as 'fin_estimado',"
            + "itch.horas_desvio as 'horasDesvio',"
            + "itch.Fin_Con_Desvio as 'fin_real',"
            + "itch.Notificado as 'notificado',"
            + "itch.Tasa_Valor as 'valor_tasa',"
            + "itch.Tasa_Cantidad_Hojas as 'hojas',"
            + "rgg.id_recurso_gg as 'idRecurso',"
            + "concat(per.Nombre, ' ' , per.Apellido) as 'responsable',"
            + "itch.Url_comprobante_tasa as 'url_comprobante',"
            + "itch.completo as 'completo'"
            + "FROM item_checklist itch "
            + "LEFT JOIN servicio sv ON sv.id_Servicio = itch.Servicio_id_Servicio "
            + "LEFT JOIN item it ON it.id_Item = itch.Item_id_Item "
            + "LEFT JOIN requisito req ON req.id_requisito = it.requisito_id_requisito "
            + "LEFT JOIN recurso_gg rgg ON rgg.id_Recurso_GG = itch.Recurso_GG_id_Recurso_GG "
            + "LEFT JOIN persona per on per.id_Persona = rgg.Persona_id_Persona "
            + "LEFT JOIN usuario us ON rgg.id_recurso_gg = us.Recurso_GG_id_Recurso_GG "
            + "LEFT JOIN usuario_rol ur ON us.id_usuario = ur.id_usuario "
            + "LEFT JOIN rol r ON ur.id_rol = r.id_rol "
            + "WHERE sv.id_Servicio = ?";
	
	public SqlQueriesItemChecklist() {
		super();
	}
	
	public String getItemChecklistDto() {
		return itemChecklistDto;
	}
}
