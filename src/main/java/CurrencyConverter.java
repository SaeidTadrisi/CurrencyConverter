public class CurrencyConverter {

    public String dollarToEuro (String amount){
        double result = Double.parseDouble(amount) * 0.92;
        return String.valueOf(result);
    }

    public String dollarToPound (String amount){
        double result = Double.parseDouble(amount) * 0.8;
        return String.valueOf(result);
    }

    public String euroToDollar (String amount){
        double result = Double.parseDouble(amount) * 1.09;
        return String.valueOf(result);
    }

    public String euroToPound (String amount){
        double result = Double.parseDouble(amount) * 0.87;
        return String.valueOf(result);
    }

    public String poundToDollar (String amount){
        double result = Double.parseDouble(amount) * 1.8;
        return String.valueOf(result);
    }

    public String poundToEuro (String amount){
        double result = Double.parseDouble(amount) * 1.87;
        return String.valueOf(result);
    }

}
