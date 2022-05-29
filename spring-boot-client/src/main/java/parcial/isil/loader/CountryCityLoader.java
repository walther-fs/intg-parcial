package parcial.isil.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import parcial.isil.service.CityService;
import parcial.isil.service.CountryService;


@Configuration
public class CountryCityLoader implements CommandLineRunner {

    private final CountryService countryService;
    private final CityService cityService;

    public CountryCityLoader(CountryService countryService, CityService cityService) {
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @Override
    public void run(String... args) throws Exception {
        countryService.getAll()
                .ifPresent(System.out::println)
        ;
        cityService.getAll()
                .ifPresent(System.out::println);
    }
}
