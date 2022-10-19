package apireq;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetApi {

	public static void api (int CONNECTION_TIMEOUT) throws IOException {
        final HttpURLConnection con = (HttpURLConnection) new URL(Main.URL).openConnection();
        
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(CONNECTION_TIMEOUT);
        con.setReadTimeout(CONNECTION_TIMEOUT );
        
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            DBquery.json(content);
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
	}
}
