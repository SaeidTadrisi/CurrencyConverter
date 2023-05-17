import java.math.BigDecimal;

public class CurrencyConverterImp implements CurrencyConverter {

    public String execute(String firstCurrency, String secondCurrency, String amount){

        String result = "";

        if (firstCurrency.equals(secondCurrency)){
            BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(amount));
            result = String.valueOf(bigDecimal);
            }
        if (firstCurrency.equals("US Dollar") && secondCurrency.equals("Euro")){
            result = dollarToEuro(amount);
        }
        if (firstCurrency.equals("US Dollar") && secondCurrency.equals("British Pound")){
            result = dollarToPound(amount);
        }
        if (firstCurrency.equals("Euro") && secondCurrency.equals("US Dollar")){
            result = euroToDollar(amount);
        }
        if (firstCurrency.equals("Euro") && secondCurrency.equals("British Pound")){
            result = euroToPound(amount);
        }
        if (firstCurrency.equals("British Pound") && secondCurrency.equals("US Dollar")){
            result = poundToDollar(amount);
        }
        if (firstCurrency.equals("British Pound") && secondCurrency.equals("Euro")){
            result = poundToEuro(amount);
        }
        return result;
    }

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
