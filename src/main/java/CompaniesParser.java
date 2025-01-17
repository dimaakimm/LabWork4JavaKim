import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CompaniesParser {
    public static void parse() {
        try {
            URL url = new URL("https://fake-json-api.mock.beeceptor.com/companies");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream responseStream = connection.getInputStream();
            JsonReader jsonReader = Json.createReader(responseStream);
            JsonArray jsonArray = jsonReader.readArray();
            jsonReader.close();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.getJsonObject(i);
                int id = jsonObject.getInt("id", -1);
                String name = jsonObject.getString("name", "none");
                String address = jsonObject.getString("address", "none");
                String zip = jsonObject.getString("zip", "none");
                String country = jsonObject.getString("country", "none");
                String employeeCount = jsonObject.getString("employeeCount", "none");
                String industry = jsonObject.getString("industry", "none");
                String marketCap = jsonObject.getString("marketCap", "none");
                String domain = jsonObject.getString("domain", "none");
                String logo = jsonObject.getString("logo", "none");
                String ceoName = jsonObject.getString("ceoName", "none");

                System.out.println("Id: " + (id != -1 ? id : "none"));
                System.out.println("Name: " + name);
                System.out.println("Address: " + address);
                System.out.println("Zip: " + zip);
                System.out.println("Country: " + country);
                System.out.println("EmployeeCount: " + employeeCount);
                System.out.println("Industry: " + industry);
                System.out.println("MarketCap: " + marketCap);
                System.out.println("Domain: " + domain);
                System.out.println("Logo: " + logo);
                System.out.println("CeoName: " + ceoName);
                System.out.println();
            }
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOError: " + e.getMessage());
        }
        System.out.println("\n");
    }
}
