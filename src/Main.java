
import apireq.Api;
import java.io.File;
import java.io.IOException;

public class Main {
	
	public static int CONNECTION_TIMEOUT = 15000;
	
	public static void main(String[] args) throws IOException {
		Api.api(CONNECTION_TIMEOUT);
	}

}
