package parcial.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parcial.isil.model.City;

public interface CityRepository extends JpaRepository<City,Integer> {
}
