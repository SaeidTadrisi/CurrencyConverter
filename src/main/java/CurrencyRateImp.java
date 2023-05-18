import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
public class CurrencyRateImp implements CurrencyRate {
        private static final String API_KEY = "2a8413d556964a55ba7eb8679dc952fb";
        private static final String BASE_URL = "https://openexchangerates.org/api/latest.json?app_id=" + API_KEY;
        private static JSONObject currencyRates;

    @Override
    public String getRate(String firstCurrency, String secondCurrency) {

        try {
            URL url = new URL(BASE_URL);

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
        } catch (Exception e) {
            e.printStackTrace();
        }

        BigDecimal firstRate = currencyRates.getBigDecimal(firstCurrency);
        BigDecimal secondRate = currencyRates.getBigDecimal(secondCurrency);
        BigDecimal rate = firstRate.divide(secondRate, 4, BigDecimal.ROUND_HALF_UP);
        return rate.toString();
    }

}

