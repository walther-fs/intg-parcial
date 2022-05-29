package parcial.isil.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial.isil.model.Country;
import parcial.isil.service.CountryService;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CountryResource implements BaseResource<Country,Integer> {

    private final CountryService countryService;

    public CountryResource(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> get(@PathVariable Integer id) {
        Country country = countryService.findById(id);
        if (country == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @Override
    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getAll() {
        List<Country> countries = countryService.findAll();
        if (countries.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @Override
    @PostMapping("/countries")
    public ResponseEntity<Country> post(@RequestBody Country country) {
        countryService.save(country);
        return new ResponseEntity<>(country, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/countries/{id}")
    public ResponseEntity<Country> put(@RequestBody Country country,
                                       @PathVariable Integer id) {
        Country currentCountry = countryService.findById(id);
        if (currentCountry == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            currentCountry.setName(country.getName());
            countryService.update(currentCountry);
            return new ResponseEntity<>(currentCountry, HttpStatus.OK);
        }

    @Override
    @DeleteMapping("/countries/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Country currentCountry = countryService.findById(id);
        if (currentCountry == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        countryService.delete(currentCountry.getCountryId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
