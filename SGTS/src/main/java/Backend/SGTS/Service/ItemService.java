package Backend.SGTS.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.ItemEntity;
import Backend.SGTS.Repository.ItemRepository;

@Service
public class ItemService {

	// Inyecto repositorio
	@Autowired
	ItemRepository itemRepository;

	// Obtengo todos los items
	public List<ItemEntity> getAll() {
		return itemRepository.findAll();
	}

	// Obtengo un item por id
	public ItemEntity getById(Integer id) {
		return itemRepository.findById(id).orElse(null);
	}

	// Creo un item
	public ItemEntity create(ItemEntity item) {
		return itemRepository.save(item);
	}

	// Actualizo un item
	public ItemEntity update(ItemEntity item) {
		return itemRepository.save(item);
	}

	// Elimino un item
	public void delete(Integer id) {
		itemRepository.deleteById(id);
	}

	// Establecer Desviación estándar
	public void setDeviation(Timestamp finA, Timestamp finB, Integer idItem) {
		ItemEntity upDateItem = this.getById(idItem);

		// Calcular la diferencia en horas entre las dos fechas
		long difInMillis = finA.getTime() - finB.getTime();
		double difInHours = difInMillis / (1000.0 * 3600);

		// Obtener el tiempo almacenado en la clase
		BigDecimal duracionEstandarBigDecimal = new BigDecimal(upDateItem.getDuracionEstandar());
		BigDecimal difInHoursBigDecimal = new BigDecimal(difInHours);

		BigDecimal mediaBigDecimal = duracionEstandarBigDecimal.add(difInHoursBigDecimal).divide(new BigDecimal(2));

		double mediaRedondeada = mediaBigDecimal.setScale(2, RoundingMode.HALF_UP).doubleValue();

		upDateItem.setDuracionEstandar(mediaRedondeada);
		itemRepository.save(upDateItem);
	}
}
