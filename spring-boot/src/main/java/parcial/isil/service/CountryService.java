package parcial.isil.service;

import org.springframework.stereotype.Service;
import parcial.isil.model.Country;
import parcial.isil.repository.CountryRepository;

import java.util.List;

@Service
public class CountryService implements BaseService<Country,Integer>{

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country update(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void delete(Integer integer) {
        countryRepository.deleteById(integer);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Integer id) {
        return countryRepository.findById(id).orElse(null);
    }
}
