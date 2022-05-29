package parcial.isil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import parcial.isil.model.City;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CityService {

    private static final String URL = "http://localhost:9000/api/cities";
    private final RestTemplate restTemplate;

    public CityService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Optional<List<City>> getAll(){

        ResponseEntity<City[]> responseEntity = restTemplate.getForEntity(URL, City[].class);

        if (responseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT) ||
                responseEntity.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)){
            log.info("status code: {}", responseEntity.getStatusCode());
            return Optional.empty();
        }

        City[] cities = responseEntity.getBody();
        return Optional.ofNullable(List.of(cities));
    }
}
