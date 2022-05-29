package parcial.isil.model;

import lombok.Data;

@Data
public class City {
    private  Integer cityId;
    private  Integer countryId;
    private Country country;

}
