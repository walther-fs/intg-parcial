package parcial.isil.model;

import lombok.Data;

import java.util.List;

@Data
public class Country {
    private Integer countryId;
    private List<City> cities;
}
