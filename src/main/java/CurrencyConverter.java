import java.math.BigDecimal;

public class CurrencyConverter {

    public String dollarToEuro (String amount){

        BigDecimal result = BigDecimal.valueOf(Double.parseDouble(amount));
        return String.valueOf(result.multiply(BigDecimal.valueOf(0.92)));
    }

    public String dollarToPound (String amount){
        BigDecimal result = BigDecimal.valueOf(Double.parseDouble(amount));
        return String.valueOf(result.multiply(BigDecimal.valueOf(0.80)));
    }

    public String euroToDollar (String amount){
        BigDecimal result = BigDecimal.valueOf(Double.parseDouble(amount));
        return String.valueOf(result.multiply(BigDecimal.valueOf(1.09)));
    }

    public String euroToPound (String amount){
        BigDecimal result = BigDecimal.valueOf(Double.parseDouble(amount));
        return String.valueOf(result.multiply(BigDecimal.valueOf(0.87)));
    }

    public String poundToDollar (String amount){
        BigDecimal result = BigDecimal.valueOf(Double.parseDouble(amount));
        return String.valueOf(result.multiply(BigDecimal.valueOf(1.80)));
    }

    public String poundToEuro (String amount){
        BigDecimal result = BigDecimal.valueOf(Double.parseDouble(amount));
        return String.valueOf(result.multiply(BigDecimal.valueOf(1.87)));
    }

}
