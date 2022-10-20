package apireq.api;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import apireq.database.DBpost;

public class GetApi{

	public static void api (int CONNECTION_TIMEOUT) throws IOException {
		System.out.println("started");
        final HttpURLConnection con = (HttpURLConnection) new URL(apireq.Main.URL).openConnection();
        
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
            DBpost.json(content);
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
	}
}
