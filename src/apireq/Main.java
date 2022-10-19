package apireq;
import java.io.IOException;
import apireq.Api;

public class Main {
	
	public final static int CONNECTION_TIMEOUT = 15000;

	public static void main(String[] args) throws IOException {
		Api.api(CONNECTION_TIMEOUT);
	}

}
