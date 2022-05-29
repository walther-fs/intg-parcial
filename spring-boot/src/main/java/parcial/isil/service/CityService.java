package parcial.isil.service;

import org.springframework.stereotype.Service;
import parcial.isil.model.City;
import parcial.isil.repository.CityRepository;

import java.util.List;

@Service
public class CityService implements BaseService<City,Integer> {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City update(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void delete(Integer id) {
        cityRepository.deleteById(id);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Integer id) {
        return cityRepository.findById(id).orElse(null);
    }
}
