package apireq.database;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBget {
	public static void getJson() throws SQLException, IOException, Exception {
		
		int ids = 0;
		int id = 0;
		
		Connection conn = DBconnect.connect();			
		FileWriter writer = new FileWriter("./tmp.json", false);
		
		String count = "SELECT COUNT ( * ) FROM req;";
		String SQL = "SELECT * FROM req ORDER BY id ASC;";
		
		ResultSet res = conn.prepareStatement(count).executeQuery();
		ResultSet rs = conn.prepareStatement(SQL).executeQuery();
		
		while (res.next()) {
			ids = res.getInt("count");
		}

		try(writer)
        {
			writer.write("{");
			while (rs.next()) {
				id = rs.getInt("id");
				if (id == ids - 1) {
					writer.write("\n\t\""+rs.getString("symbol")+"\": {\n"+
					        "\t\t\"price\": "+rs.getString("price_24h")+","+
					        "\n\t\t\"volume\": "+rs.getString("volume_24h")+","+
					        "\n\t\t\"last_trade\": "+rs.getString("last_trade_price")+
					        "\n\t}");
				} else {
					writer.write("\n\t\""+rs.getString("symbol")+"\": {\n"+
				        "\t\t\"price\": "+rs.getString("price_24h")+","+
				        "\n\t\t\"volume\": "+rs.getString("volume_24h")+","+
				        "\n\t\t\"last_trade\": "+rs.getString("last_trade_price")+
				        "\n\t},");
				}
			}
			writer.write("}");
        }
	    catch(IOException ex){
	        System.out.println(ex.getMessage());
	    } 
		writer.close();
        conn.close();
	}
}
