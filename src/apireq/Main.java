package apireq;

import java.io.File;
import java.io.IOException;


public class Main {
	
	public static int CONNECTION_TIMEOUT = 15000;
	public static String contents = "";
	public static File file = new File("./tmp.txt");
	public static File jsonfile = new File("./tmp.json");
	
	public static void main(String[] args) throws IOException {
		Api.api(CONNECTION_TIMEOUT);
	}

}
