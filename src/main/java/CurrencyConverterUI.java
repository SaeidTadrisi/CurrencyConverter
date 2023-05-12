import javax.swing.*;
import java.math.BigDecimal;

public class CurrencyConverterUI {
    private static String firstAmount;
    private static String firstCurrency;
    private static String secondCurrency;

    public static void main (String ... args){

        JFrame currencyConverterFrame = new JFrame("Currency Converter");

        String [] currencyType = {"US Dollar", "Euro", "British Pound"};

        JTextField firstCurrencyField = new JTextField();
        firstCurrencyField.setBounds(10,10,120,30);
        firstCurrencyField.setEditable(true);

        JTextField secondCurrencyField = new JTextField();
        secondCurrencyField.setBounds(170,10,120,30);
        secondCurrencyField.setEditable(false);

        JComboBox firstCurrencyList = new JComboBox(currencyType);
        firstCurrencyList.setBounds(10,50,120,30);
        firstCurrencyList.addActionListener(e -> {
            firstCurrency = (String) firstCurrencyList.getSelectedItem();
        });

        JComboBox secondCurrencyList = new JComboBox(currencyType);
        secondCurrencyList.setBounds(170,50,120,30);
        secondCurrencyList.addActionListener(e -> {
            secondCurrency = (String) secondCurrencyList.getSelectedItem();
        });

        JButton calculate = new JButton("Calculate");
        calculate.setBounds(100,90,100,30);
        calculate.addActionListener(e -> {
                    firstAmount = firstCurrencyField.getText();

            final CurrencyConverter currencyConverter = new CurrencyConverter();

            if (firstCurrency.equals(secondCurrency)) {
                        secondCurrencyField.setText(firstAmount);
                    }
                    if (firstCurrency.equals("US Dollar") && secondCurrency.equals("Euro")) {
                        String result = currencyConverter.dollarToEuro(firstAmount);
                        secondCurrencyField.setText(result);
                    }
                    if (firstCurrency.equals("US Dollar") && secondCurrency.equals("British Pound")) {
                        String result = currencyConverter.dollarToPound(firstAmount);
                        secondCurrencyField.setText(result);
                    }
                    if (firstCurrency.equals("Euro") && secondCurrency.equals("US Dollar")) {
                        String result = currencyConverter.euroToDollar(firstAmount);
                        secondCurrencyField.setText(result);
                    }
                    if (firstCurrency.equals("Euro") && secondCurrency.equals("British Pound")) {
                        String result = currencyConverter.euroToPound(firstAmount);
                        secondCurrencyField.setText(result);
                    }
                    if (firstCurrency.equals("British Pound") && secondCurrency.equals("US Dollar")) {
                        String result = currencyConverter.poundToDollar(firstAmount);
                        secondCurrencyField.setText(result);

                    }if (firstCurrency.equals("British Pound") && secondCurrency.equals("Euro")) {
                        String result = currencyConverter.poundToEuro(firstAmount);
                        secondCurrencyField.setText(result);
                    }
                });

        currencyConverterFrame.add(firstCurrencyList);
        currencyConverterFrame.add(secondCurrencyList);
        currencyConverterFrame.add(firstCurrencyField);
        currencyConverterFrame.add(secondCurrencyField);
        currencyConverterFrame.add(calculate);
        currencyConverterFrame.setLayout(null);
        currencyConverterFrame.setSize(315,220);
        currencyConverterFrame.setVisible(true);
    }
}
