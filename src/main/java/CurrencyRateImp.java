import org.json.JSONObject;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class CurrencyRateImp implements CurrencyRate {
    private static JSONObject currencyRates;

    @Override
    public String getRate(String firstCurrency, String secondCurrency) {

        Currency currency = new Currency();
        String firstKey = currency.getKey(firstCurrency);
        String secondKey = currency.getKey(secondCurrency);

        String serverAddress;
        try (InputStream configFile = new FileInputStream("server-config.properties")) {
            Properties properties = new Properties();
            properties.load(configFile);
            serverAddress = properties.get("address").toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            URL url = new URL(serverAddress);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JSONObject jsonResponse = new JSONObject(response.toString());

                currencyRates = jsonResponse.getJSONObject("rates");

            } else {
                System.out.println("Error: " + responseCode);
            }

            connection.disconnect();
        } catch (EmptyAmountException | IOException e) {
            e.printStackTrace();
        }

        BigDecimal firstRate = currencyRates.getBigDecimal(firstKey);
        BigDecimal secondRate = currencyRates.getBigDecimal(secondKey);
        BigDecimal rate = secondRate.divide(firstRate, 4, RoundingMode.HALF_UP);
        return rate.toString();
    }
}

