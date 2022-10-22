package apireq;
import java.io.IOException;
import java.util.Map;
// import apireq.server.SrvWork;

public class Main {
	
	// TODO: move change config to ENV or config file.
	public static final int CONNECTION_TIMEOUT = 15000;
	public static final String URL = "https://api.blockchain.com/v3/exchange/tickers";
	public static final int WAITING_TIME = 30;
	public static final String HOSTNAME = "localhost";
	public static final int PORT = 8081;
	public static final int BACKLOG = 0; 
	public static final int THREAD_POOL = 10;

	
	public static void main(String[] args) throws IOException {
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			System.out.format("%s=%s%n",envName,env.get(envName));
		}
		// SrvWork.http();
	}

}
