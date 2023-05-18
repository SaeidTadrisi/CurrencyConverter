import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyConverterImpTest {
    @Test
    void Should_Convert_Currencies() {


        CurrencyConverter currencyConverter = new CurrencyConverterImp();
        CurrencyRate currencyRate = new CurrencyRateImp();

        String rate = currencyRate.getRate("USD", "EUR");
        String result = currencyConverter.calculate(rate, "66");

        Assertions.assertThat(result).isEqualTo("71.12160");

    }
}