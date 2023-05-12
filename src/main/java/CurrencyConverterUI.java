import javax.swing.*;

public class CurrencyConverterUI {
    private static String firstAmount;
    private static String firstCurrency;
    private static String secondCurrency;

    public static void main (String ... args){

        JFrame currencyConverter = new JFrame("Currency Converter");

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

            if (firstCurrency.equals(secondCurrency)) {
                        secondCurrencyField.setText(firstAmount);
                    }
                    if (firstCurrency.equals("US Dollar") && secondCurrency.equals("Euro")) {
                        double result = Double.parseDouble(firstAmount) * 0.92;
                        secondCurrencyField.setText(Double.toString(result));
                    }
                    if (firstCurrency.equals("US Dollar") && secondCurrency.equals("British Pound")) {
                        double result = Double.parseDouble(firstAmount) * 0.80;
                        secondCurrencyField.setText(Double.toString(result));
                    }
                    if (firstCurrency.equals("Euro") && secondCurrency.equals("US Dollar")) {
                        double result = Double.parseDouble(firstAmount) * 1.09;
                        secondCurrencyField.setText(Double.toString(result));
                    }
                    if (firstCurrency.equals("Euro") && secondCurrency.equals("British Pound")) {
                        double result = Double.parseDouble(firstAmount) * 0.87;
                        secondCurrencyField.setText(Double.toString(result));
                    }
                    if (firstCurrency.equals("British Pound") && secondCurrency.equals("US Dollar")) {
                        double result = Double.parseDouble(firstAmount) * 1.80;
                        secondCurrencyField.setText(Double.toString(result));
                    }else if (firstCurrency.equals("British Pound") && secondCurrency.equals("Euro")) {
                        double result = Double.parseDouble(firstAmount) * 1.87;
                        secondCurrencyField.setText(Double.toString(result));
                    }
                });

        currencyConverter.add(firstCurrencyList);
        currencyConverter.add(secondCurrencyList);
        currencyConverter.add(firstCurrencyField);
        currencyConverter.add(secondCurrencyField);
        currencyConverter.add(calculate);
        currencyConverter.setLayout(null);
        currencyConverter.setSize(315,220);
        currencyConverter.setVisible(true);
    }
}
