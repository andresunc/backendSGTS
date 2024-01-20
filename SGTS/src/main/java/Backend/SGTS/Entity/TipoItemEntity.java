package Backend.SGTS.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tipo_item", schema = "sgts_db", catalog = "")
public class TipoItemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Tipo_Item", nullable = false)
    private Integer idTipoItem;
    @Basic
    @Column(name = "Tipo_Item", nullable = false, length = 45)
    private String tipoItem;

    public Integer getIdTipoItem() {
        return idTipoItem;
    }

    public void setIdTipoItem(Integer idTipoItem) {
        this.idTipoItem = idTipoItem;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoItemEntity that = (TipoItemEntity) o;
        return idTipoItem == that.idTipoItem && Objects.equals(tipoItem, that.tipoItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoItem, tipoItem);
    }
}
