import javax.swing.*;
public class CurrencyConverterUI {
    private static String firstAmount;
    private static String firstCurrency;
    private static String secondCurrency;

    public static void main (String ... args){

        JFrame currencyConverterFrame = new JFrame("Currency Converter");

        Currency currencies = new Currency();

        JTextField firstCurrencyField = new JTextField();
        firstCurrencyField.setBounds(10,10,190,30);
        firstCurrencyField.setEditable(true);

        JTextField secondCurrencyField = new JTextField();
        secondCurrencyField.setBounds(240,10,190,30);
        secondCurrencyField.setEditable(false);

        JComboBox<String> firstCurrencyList = new JComboBox<>(currencies.names);
        firstCurrencyList.setBounds(10,50,190,30);
        firstCurrencyList.addActionListener(e -> {
            firstCurrency = (String) firstCurrencyList.getSelectedItem();
        });

        JComboBox<String> secondCurrencyList = new JComboBox<>(currencies.names);
        secondCurrencyList.setBounds(240,50,190,30);
        secondCurrencyList.addActionListener(e -> {
            secondCurrency = (String) secondCurrencyList.getSelectedItem();
        });

        JButton calculate = new JButton("Calculate");
        calculate.setBounds(170,90,100,30);
        calculate.addActionListener(e -> {
            firstAmount = firstCurrencyField.getText();
            if (firstAmount == null || firstAmount.isEmpty()){
                JOptionPane.showInternalMessageDialog(null, "Please Enter a Number");
            }else {
                CurrencyConverter currencyConverter = new CurrencyConverterImp();
                CurrencyRate currencyRate = new CurrencyRateImp();
                String rate = currencyRate.getRate(firstCurrency, secondCurrency);
                String result = currencyConverter.calculate(rate, firstAmount);
                secondCurrencyField.setText(result);
            }
            });

        firstCurrencyList.setSelectedIndex(0);
        secondCurrencyList.setSelectedIndex(0);
        currencyConverterFrame.add(firstCurrencyList);
        currencyConverterFrame.add(secondCurrencyList);
        currencyConverterFrame.add(firstCurrencyField);
        currencyConverterFrame.add(secondCurrencyField);
        currencyConverterFrame.add(calculate);
        currencyConverterFrame.setLayout(null);
        currencyConverterFrame.setSize(455,170);
        currencyConverterFrame.setVisible(true);
    }
}
