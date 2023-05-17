import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyConverterImpTest {
    @Test
    void Should_Convert_Currencies() {

        CurrencyConverter currencyConverter = new CurrencyConverterImp();

        String dToD = currencyConverter.execute("US Dollar", "US Dollar", "5");
        String dToE = currencyConverter.execute("US Dollar", "Euro", "7");
        String dToP = currencyConverter.execute("US Dollar", "British Pound", "8");
        String eToD = currencyConverter.execute("Euro", "US Dollar", "5");
        String eToP = currencyConverter.execute("Euro", "British Pound", "9");
        String pToD = currencyConverter.execute("British Pound", "US Dollar", "4");
        String pToE = currencyConverter.execute("British Pound", "Euro", "9");

        assertThat(dToD).isEqualTo("5.0");
        assertThat(dToE).isEqualTo("6.440");
        assertThat(dToP).isEqualTo("6.40");
        assertThat(eToD).isEqualTo("5.450");
        assertThat(eToP).isEqualTo("7.830");
        assertThat(pToD).isEqualTo("7.20");
        assertThat(pToE).isEqualTo("16.830");
    }
}