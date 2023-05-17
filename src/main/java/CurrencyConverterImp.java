import java.math.BigDecimal;

import static java.math.BigDecimal.*;

public class CurrencyConverterImp implements CurrencyConverter {

    public static final double dolToEu = 0.92;
    public static final double dolToPou = 0.80;
    public static final double eurToDol = 1.09;
    public static final double eurToPou = 0.87;
    public static final double pouToDol = 1.80;
    public static final double pouToEur = 1.87;

    public String execute(String firstCurrency, String secondCurrency, String amount){

        String result = "";

        if (firstCurrency.equals(secondCurrency)){
            BigDecimal bigDecimal = valueOf(Double.parseDouble(amount));
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

        return getString(amount, dolToEu);
    }

    public String dollarToPound (String amount){
        return getString(amount, dolToPou);
    }

    public String euroToDollar (String amount){
        return getString(amount, eurToDol);
    }

    public String euroToPound (String amount){
        return getString(amount, eurToPou);
    }

    public String poundToDollar (String amount){
        return getString(amount, pouToDol);
    }

    public String poundToEuro (String amount){
        return getString(amount, pouToEur);
    }

    private static String getString(String amount, double rate) {
        BigDecimal result = valueOf(Double.parseDouble(amount));
        return String.valueOf(result.multiply(valueOf(rate)));
    }

}
