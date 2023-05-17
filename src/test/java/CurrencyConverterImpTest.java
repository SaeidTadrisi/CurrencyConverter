import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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

        Assertions.assertThat(dToD).isEqualTo("5.0");
        Assertions.assertThat(dToE).isEqualTo("6.440");
        Assertions.assertThat(dToP).isEqualTo("6.40");
        Assertions.assertThat(eToD).isEqualTo("5.450");
        Assertions.assertThat(eToP).isEqualTo("7.830");
        Assertions.assertThat(pToD).isEqualTo("7.20");
        Assertions.assertThat(pToE).isEqualTo("16.830");
    }
}