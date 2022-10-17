package apireq;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api {

	public static String api (int CONNECTION_TIMEOUT) throws IOException {

		final URL url = new URL("https://api.blockchain.com/v3/exchange/tickers");
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
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
            try(FileWriter writer = new FileWriter(Main.file , false))
            {
                writer.write(content.toString());
            }
            catch(IOException ex){
                 
                System.out.println(ex.getMessage());
            } 
            
            Main.contents = content.toString();
            System.out.println(content);
            File.files();
            return content.toString();
        } catch (final Exception ex) {
            ex.printStackTrace();
            return "";
        }
	}
}
