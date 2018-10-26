package pl.sda.springtraining.spring;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Countries {
    POLAND("PL", "Polska"),
    GERMANY("DE", "Niemcy"),
    USA("US", "Stany Zjednoczone Ameryki"),
    JAPAN("JP100%", "Japonia"),
    UK("UK", "Wielka Brytania");

    private final String symbol;
    private final String polishName;

    Countries(String symbol, String polishName) {
        //todo fixme tu jest pytanie/ciekawostka!!!
        this.symbol = symbol;
        this.polishName = polishName;
    }

    public static Countries findCountryBySymbol(String symbol) {
       return Arrays.stream(Countries.values())
                .filter(c -> c.getSymbol().equals(symbol))
                .findFirst()
                .orElse(null);
    }
}
