import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CatFacts {

  private static final String API_URL = "https://meowfacts.herokuapp.com/";

  public static void main(String[] args) {
    try {
      System.out.println("Starting the program..."); // Debug print
      String jsonResponse = getApiResponse(API_URL);
      System.out.println("API response received: " + jsonResponse); // Debug print
      String catFact = parseCatFact(jsonResponse);
      System.out.println("Random Cat Fact: " + catFact);
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private static String getApiResponse(String apiUrl) throws Exception {
    System.out.println("Sending API request to: " + apiUrl); // Debug print
    URL url = new URL(apiUrl);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.connect();

    int responseCode = connection.getResponseCode();
    System.out.println("Response code: " + responseCode); // Debug print
    if (responseCode != 200) {
      throw new RuntimeException("HttpResponseCode: " + responseCode);
    } else {
      BufferedReader in = new BufferedReader(
        new InputStreamReader(connection.getInputStream())
      );
      String inputLine;
      StringBuilder content = new StringBuilder();
      while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
      }
      in.close();
      connection.disconnect();
      return content.toString();
    }
  }

  private static String parseCatFact(String jsonResponse) {
    System.out.println("Parsing JSON response..."); // Debug print
    JSONObject jsonObject = new JSONObject(jsonResponse);
    return jsonObject.getJSONArray("data").getString(0);
  }
}
