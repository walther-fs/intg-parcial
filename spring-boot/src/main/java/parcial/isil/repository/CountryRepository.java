package parcial.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parcial.isil.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
