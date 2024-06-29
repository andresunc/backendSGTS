package Backend.SGTS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Entity.TrackingStorageEntity;
import Backend.SGTS.Service.TrackingStorageService;

@RestController
@RequestMapping("/tracking_storage")
public class TrackingStorageController {

	@Autowired
	TrackingStorageService trackingStorageService;
	
	@GetMapping("/by_servicio/{idServicio}")
    public List<TrackingStorageEntity> getTrackingStorageByServicio(@PathVariable Integer idServicio) {
        return trackingStorageService.findByIdServicio(idServicio);
    }
	
	@PostMapping("/new")
    public TrackingStorageEntity createTrackingStorage(@RequestBody TrackingStorageEntity trackingStorageEntity) {
        return trackingStorageService.create(trackingStorageEntity);
    }

    // Endpoint para crear múltiples tracking storages
    @PostMapping("multiple")
    public List<TrackingStorageEntity> createMultipleTrackingStorages(@RequestBody List<TrackingStorageEntity> trackingStorageEntities) {
        return trackingStorageService.createMultiple(trackingStorageEntities);
    }
}
