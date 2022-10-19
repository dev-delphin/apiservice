package apireq;
import java.io.IOException;

public class Main {
	
	public final static int CONNECTION_TIMEOUT = 15000;
	public final static String URL = "https://api.blockchain.com/v3/exchange/tickers";

	public static void main(String[] args) throws IOException {
		GetApi.api(CONNECTION_TIMEOUT);
	}

}