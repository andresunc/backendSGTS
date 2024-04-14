package Backend.SGTS.Constants;

public class SqlSelectItemDto {

	private String selectItemDto = "SELECT "
            + "it.id_Item as 'idItem',"
            + "tsv.id_Tipo_Servicio as 'idTipoServicio',"
            + "tsv.Tipo_Servicio as 'tipoServicio',"
            + "dep.id_Dependencia as 'idDependencia',"
            + "dep.Dependencia as 'dependencia',"
            + "ru.id_Rubro as 'idRubro',"
            + "ru.Rubro as 'rubro',"
            + "ti.id_Tipo_Item as 'idTipoItem',"
            + "ti.Tipo_Item as 'tipoItem',"
            + "req.id_requisito as 'idRequisito',"
            + "req.Descripcion as 'descripcion',"
            + "DATE_ADD(NOW(), INTERVAL it.Duracion_estandar HOUR) as 'fechaHoraRealizacionRecomendada' "
            + "FROM item it "
            + "LEFT JOIN tipo_servicio tsv ON tsv.id_Tipo_Servicio = it.Tipo_Servicio_id_Tipo_Servicio "
            + "LEFT JOIN dependencia dep ON dep.id_Dependencia = it.Dependencia_id_Dependencia "
            + "LEFT JOIN rubro ru ON ru.id_Rubro = it.Rubro_id_Rubro AND ru.Eliminado = 0 "
            + "LEFT JOIN tipo_item ti ON ti.id_Tipo_Item = it.Tipo_Item_id_Tipo_Item "
            + "LEFT JOIN requisito req ON req.id_requisito = it.requisito_id_requisito";

    public SqlSelectItemDto() {
        super();
    }

    public String getSelectItemDto() {
        return selectItemDto;
    }
}
