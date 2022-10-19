package apireq;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

public class Json{
	
	public static void json(StringBuilder content) throws FileNotFoundException, IOException, ParseException {
		JSONArray jsonArray = (JSONArray) new JSONParser().parse(content.toString());

		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = (JSONObject)jsonArray.get(i);
			System.out.println("id = " + i);
			System.out.println("symbol = "+(String) jsonObject.get("symbol"));
			System.out.println("price_24h = "+(String) jsonObject.get("price_24h").toString());
			System.out.println("volume_24h"+(String) jsonObject.get("volume_24h").toString());
			System.out.println("last_trade_price = "+(String) jsonObject.get("last_trade_price").toString());
		}
	}
}
