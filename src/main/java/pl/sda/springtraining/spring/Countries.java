package pl.sda.springtraining.spring;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Countries {
    POLAND("PL", "Polska"),
    GERMANY("DE", "Niemcy"),
    USA("US", "Stany Zjednoczone"),
    JAPAN("JP", "Japonia");

    private String countryCode;
    private String countryName;

    Countries(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public static Countries findCountryByCountryCode(String countryCode) {
        return Arrays.stream(Countries.values())
                .filter(country -> country.getCountryCode().equals(countryCode))
                .findFirst()
                .orElse(null);
    }
}
