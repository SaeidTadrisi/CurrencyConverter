import java.math.BigDecimal;
import static java.math.BigDecimal.*;

public class CurrencyConverterImp implements CurrencyConverter {
    @Override
    public String calculate(String rate, String amount) {
        if (amount.isEmpty()){
            throw new EmptyAmountException("You Should Enter A Number");
        }else {
            BigDecimal result = valueOf(Double.parseDouble(amount)).multiply(valueOf(Double.parseDouble(rate)));
            return String.valueOf(result);
        }
    }

}
