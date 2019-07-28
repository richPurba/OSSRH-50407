import com.google.gson.Gson;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RandomNumberGenerator {
    //1. set the connection
    //2. set the incoming data to a variable
    //3. produce the randomness to a certain range.
    Map<String,String> queryParameters = new HashMap<String, String>();
    private  final String USER_AGENT = "Mozilla/5.0";
    int status;
    JSONObject finalResult;

    public RandomNumber getRandomNumber() throws MalformedURLException , IOException{
        try {
            queryParameters.put("length","100");
            queryParameters.put("type","uint8");
            URL url = new URL("https://qrng.anu.edu.au/API/jsonI.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-type","application/json");
            connection.setRequestProperty("User-agent",USER_AGENT);
//            connection.setReadTimeout(5000);
//            connection.setConnectTimeout(5000);

            connection.connect();

            status = connection.getResponseCode();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sbuilder = new StringBuilder();// StringBuffer vs StringBuilder?
            String inputline;

            while((inputline = reader.readLine()) != null){
                sbuilder.append(inputline + "\n");
            }
            reader.close();
            connection.disconnect();
            return new Gson().fromJson(sbuilder.toString(),RandomNumber.class);

        } catch (MalformedURLException me){
            throw new MalformedURLException("URL exception was thrown while calling the API" + me);
        }
        catch (IOException ie){
            throw  new IOException("IO exception is thrown while calling the API" + ie);
        }
    }

}
