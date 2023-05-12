import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrencyConverterTest {

    @Test
    void Should_Convert_Dollar_To_Euro() {

        CurrencyConverter currencyConverter = new CurrencyConverter();
        String result = currencyConverter.dollarToEuro("7");

        Assertions.assertThat(result).isEqualTo("6.44");
    }

    @Test
    void Should_Convert_Dollar_To_Pound() {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        String result = currencyConverter.dollarToPound("8");

        Assertions.assertThat(result).isEqualTo("6.4");
    }

    @Test
    void Should_Convert_Euro_To_Dollar() {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        String result = currencyConverter.euroToDollar("8");

        Assertions.assertThat(result).isEqualTo("8.72");
    }

    @Test
    void Should_Convert_Euro_To_Pound() {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        String result = currencyConverter.euroToPound("8");

        Assertions.assertThat(result).isEqualTo("6.96");
    }

    @Test
    void Should_Convert_Pound_To_Dollar() {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        String result = currencyConverter.poundToDollar("16");

        Assertions.assertThat(result).isEqualTo("28.8");
    }

    @Test
    void Should_Convert_Pound_To_Euro() {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        String result = currencyConverter.poundToEuro("14");

        Assertions.assertThat(result).isEqualTo("26.18");
    }
}
