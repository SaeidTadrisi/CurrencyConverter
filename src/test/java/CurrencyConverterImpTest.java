import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CurrencyConverterImpTest {

    public CurrencyConverter currencyConverter;
    public CurrencyRate currencyRate;
    @BeforeEach
    void setUp() {
        currencyConverter = new CurrencyConverterImp();
        currencyRate = new CurrencyRateImp();
    }

    @Test
    void Should_Convert_Currencies() {

        String rate = currencyRate.getRate("United States Dollar", "Euro");
        String result = currencyConverter.calculate(rate, "66");

        assertThat(result).isEqualTo("61.08960");
    }

    @Test
    void ShouldThrowEmptyAmountException() {

        String rate = currencyRate.getRate("United States Dollar", "Euro");

        assertThatExceptionOfType(EmptyAmountException.class)
                .isThrownBy(()-> currencyConverter.calculate(rate, ""));
    }
}