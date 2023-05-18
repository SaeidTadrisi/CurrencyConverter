import java.math.BigDecimal;
import static java.math.BigDecimal.*;

public class CurrencyConverterImp implements CurrencyConverter {
    @Override
    public String calculate(String rate, String amount) {
        BigDecimal result = valueOf(Double.parseDouble(amount)).multiply(valueOf(Double.parseDouble(rate)));
        return String.valueOf(result);
    }

}
