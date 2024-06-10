package Backend.SGTS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.SGTS.Entity.ReboteEntity;
import Backend.SGTS.Service.ReboteService;

@RestController
@RequestMapping("/rebote")
public class ReboteController {

	@Autowired
    private ReboteService reboteService;

    @GetMapping("/last60")
    public List<ReboteEntity> getLast60Records() {
        return reboteService.getLast60Records();
    }
}
