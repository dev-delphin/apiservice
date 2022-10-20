package apireq;
import java.io.IOException;
import apireq.server.SrvWork;

public class Main {
	
	public static final int CONNECTION_TIMEOUT = 15000;
	public static final String URL = "https://api.blockchain.com/v3/exchange/tickers";
	public static final int WAITING_TIME = 30;
	public static final String HOSTNAME = "localhost";
	public static final int PORT = 8081;
	public static final int BACKLOG = 0;
	public static final int THREAD_POOL = 10;
	

	public static void main(String[] args) throws IOException {
		//GetApi.api(CONNECTION_TIMEOUT);
		SrvWork.http();
	}

}
