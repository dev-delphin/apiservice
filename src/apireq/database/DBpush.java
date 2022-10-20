package apireq.database;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

public class DBpush{
	
	public static void json(StringBuilder content) throws FileNotFoundException, IOException, ParseException, SQLException {
		JSONArray jsonArray = (JSONArray) new JSONParser().parse(content.toString());
		Connection conn = DBconnect.connect();
		
		for (int i = 0; i < jsonArray.size(); i++) {
			
			
			String SQL = "SELECT id FROM req WHERE id=" + i + ";";
			int id = -1;
			ResultSet rs = conn.prepareStatement(SQL).executeQuery();
			while (rs.next()) {
	            id = rs.getInt("id");
			}
			if (id != i) {
				SQL = "INSERT INTO req (symbol, price_24h, volume_24h, last_trade_price, id) VALUES (?,?,?,?,?);";
			} else {
				SQL = "UPDATE req SET symbol = ?, price_24h = ?, volume_24h = ?, last_trade_price = ? WHERE id = ?;";
			}
			PreparedStatement PS = conn.prepareStatement(SQL);
			
			
			JSONObject jsonObject = (JSONObject)jsonArray.get(i);
	        try {
	        	PS.setString(1, (String) jsonObject.get("symbol"));
	        	PS.setString(2, (String) jsonObject.get("price_24h").toString());
				PS.setString(3, (String) jsonObject.get("volume_24h").toString());
				PS.setString(4, (String) jsonObject.get("last_trade_price").toString());
	        	PS.setInt(5, i);
	        	PS.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		}
		conn.close();
		
	}
}
