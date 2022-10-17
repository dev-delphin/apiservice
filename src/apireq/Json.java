package apireq;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json{
	
	public static void json() throws FileNotFoundException, IOException, ParseException {
		// Считываем json
		JSONObject obj = (JSONObject) new JSONParser().parse(new FileReader(Main.jsonfile));
		// Кастим obj в JSONObject
		// Достаём firstName and lastName
		String symbol = (String) obj.get("symbol"); 
		/*String price_24h = (String) jo.get("price_24h");
		String volume_24h = (String) jo.get("volume_24h");
		String last_trade_price = (String) jo.get("last_trade_price");*/
		System.out.println("symbol: " + symbol + "\n");/* + 
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
}
