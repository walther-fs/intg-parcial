package parcial.isil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import parcial.isil.model.Country;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CountryService {

    private static final String URL = "http://localhost:9000/api/countries";
    private final RestTemplate restTemplate;

    public CountryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<List<Country>> getAll(){

        ResponseEntity<Country[]> responseEntity = restTemplate.getForEntity(URL, Country[].class);

        if (responseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT) ||
                responseEntity.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)){
            log.info("status code: {}", responseEntity.getStatusCode());
            return Optional.empty();
        }

        Country[] countries = responseEntity.getBody();
        return Optional.ofNullable(List.of(countries));
    }
}
