package parcial.isil.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial.isil.model.City;
import parcial.isil.service.CityService;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CityResource implements BaseResource<City,Integer> {

    private final CityService cityService;

    public CityResource(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    @GetMapping("/cities/{id}")
    public ResponseEntity<City> get(@PathVariable Integer id) {
        City city = cityService.findById(id);
        if (city == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @Override
    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAll() {
        List<City> cities = cityService.findAll();
        if (cities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @Override
    @PostMapping("/cities")
    public ResponseEntity<City> post(@RequestBody City city) {
        cityService.save(city);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/cities/{id}")
    public ResponseEntity<City> put(@RequestBody City city,
                                    @PathVariable Integer id) {
        City currentCity = cityService.findById(id);
        if (currentCity == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentCity.setName(city.getName());
        cityService.update(currentCity);
        return new ResponseEntity<>(currentCity, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/cities/{id}")
    public ResponseEntity<?> delete(@PathVariable  Integer id) {
        City currentCity = cityService.findById(id);
        if (currentCity == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.delete(currentCity.getCityId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
