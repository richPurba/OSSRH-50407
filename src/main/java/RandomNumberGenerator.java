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

    Map<String,String> queryParameters = new HashMap<String, String>();
    public int status;

    public RandomNumber getRandomNumber() throws MalformedURLException , IOException{
        try {
            queryParameters.put("length","100");
            queryParameters.put("type","uint8");
            URL url = new URL("https://qrng.anu.edu.au/API/jsonI.php?"+QueryParameterStringBuilder.getParamString(queryParameters));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-type","application/json");
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
