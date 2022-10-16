import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Main {
	static int CONNECTION_TIMEOUT = 15000;
	static String contents = "";
	
	public static void main(String[] args) throws IOException {
		api(CONNECTION_TIMEOUT);
	}
	
	public static void Json() throws FileNotFoundException, IOException, ParseException {
		// Считываем json
		Object obj = new JSONParser().parse(new FileReader("./tmp.json"));
		// Кастим obj в JSONObject
		JSONObject jo = (JSONObject) obj;
		// Достаём firstName and lastName
		String symbol = (String) jo.get("symbol"); 
		String price_24h = (String) jo.get("price_24h");
		String volume_24h = (String) jo.get("volume_24h");
		String last_trade_price = (String) jo.get("last_trade_price");
		System.out.println("symbol: " + symbol + "\n" + 
				"price_24h: " + price_24h + "\n" +
				"volume_24h: " + volume_24h + "\n" + 
				"last_trade_price" + last_trade_price);
		// Достаем массив номеров
		//JSONArray phoneNumbersArr = (JSONArray) jo.get("phoneNumbers");
		//Iterator phonesItr = phoneNumbersArr.iterator();
		//System.out.println("phoneNumbers:");
		// Выводим в цикле данные массива
		/*while (phonesItr.hasNext()) {
		    JSONObject test = (JSONObject) phonesItr.next();
		    System.out.println("- type: " + test.get("type") + ", phone: " + test.get("number"));
		}*/
	}

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
            try(FileWriter writer = new FileWriter("./tmp.json", false))
            {
                writer.write(content.toString());
            }
            catch(IOException ex){
                 
                System.out.println(ex.getMessage());
            } 
            
            contents = content.toString();
            System.out.println(content);
            Json();
            return content.toString();
        } catch (final Exception ex) {
            ex.printStackTrace();
            return "";
        }
	}
	
		
	

}
