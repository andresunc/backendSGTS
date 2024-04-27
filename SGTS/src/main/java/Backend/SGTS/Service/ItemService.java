package Backend.SGTS.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.ItemEntity;
import Backend.SGTS.Entity.RubroEntity;
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

	// Obtengo todos los items no eliminados
	public List<ItemEntity> getAllNotDeleted() {
		return itemRepository.findByEliminadoFalse();
	}

	// Obtengo todos los items eliminados
	public List<ItemEntity> getAllDeleted() {
		return itemRepository.findByEliminadoTrue();
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
	public double setDeviation(Timestamp finA, Timestamp finB, Integer idItem) {
		ItemEntity upDateItem = this.getById(idItem);

		/**
		 * Calcular la diferencia en horas entre las dos fechas 
		 * Los números negativos indican menos desvío (-45)
		 * Los números positivos indican más desvíos (63)
		 */
		double desvioHoras = (finB.getTime() - finA.getTime()) / (1000.0 * 3600);
		
		/**
		 * Obtener el desvío acumulado almacenado en la base de datos y las veces que se solicitó cambiar
		 * Sumar el desvío horas del item checklist al desvío-acumulado
		 * Dividir por los cambios realizados.
		 */
		Integer countCambios = upDateItem.getContCambios()+1;
		double nuevoDesvioAcumulado = upDateItem.getDesvioAcumulado() + desvioHoras;
		double nuevaDuracionEstandar = nuevoDesvioAcumulado / countCambios;

		nuevaDuracionEstandar = redondearADosDecimales(nuevaDuracionEstandar);
		nuevoDesvioAcumulado = redondearADosDecimales(nuevoDesvioAcumulado);

		upDateItem.setDuracionEstandar(nuevaDuracionEstandar);
		upDateItem.setDesvioAcumulado(nuevoDesvioAcumulado);
		upDateItem.setContCambios(countCambios);
		itemRepository.save(upDateItem);
		
		// retorno el desvío expresado en horas.
		return redondearADosDecimales(desvioHoras);
	}
	
	// Establecer Desviación estándar
		public double unSetDeviation(double desvioHoras, Integer idItem) {
			ItemEntity upDateItem = this.getById(idItem);
			
			/**
			 * Restar 1 al conteo de cambios -1
			 * restar las horas desvio del item del checklist al desvío acumulado
			 * reestablecer duracion estandar
			 */
			Integer countCambios = upDateItem.getContCambios()-1;
			double desvioAcumulado = upDateItem.getDesvioAcumulado() - desvioHoras;
			double nuevaDuracionEstandar = desvioAcumulado / countCambios;

			nuevaDuracionEstandar = redondearADosDecimales(nuevaDuracionEstandar);
			desvioAcumulado = redondearADosDecimales(desvioAcumulado);

			upDateItem.setDuracionEstandar(nuevaDuracionEstandar);
			upDateItem.setDesvioAcumulado(desvioAcumulado);
			upDateItem.setContCambios(countCambios);
			itemRepository.save(upDateItem);
			
			// retorno el desvío expresado en horas.
			return redondearADosDecimales(desvioHoras);
		}
	
	public double redondearADosDecimales(double valor) {
        BigDecimal decimal = new BigDecimal(valor);
        decimal = decimal.setScale(2, RoundingMode.HALF_UP);
        return decimal.doubleValue();
    }
}
