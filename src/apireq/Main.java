package apireq;
import java.io.IOException;
import java.util.Map;
import apireq.server.SrvWork;

public class Main {
	
	// TODO: move change config to ENV or config file.
	public static int CONNECTION_TIMEOUT; // = 15000;
	public static String URL; // = "https://api.blockchain.com/v3/exchange/tickers";
	public static int WAITING_TIME; // = 30;
	public static String HOSTNAME; // = "localhost";
	public static int PORT; // = 8081;
	public static int BACKLOG; // = 0; 
	public static int THREAD_POOL; // = 10;

	public Main() {
		CONNECTION_TIMEOUT = 15000;
		URL = "https://api.blockchain.com/v3/exchange/tickers";
		WAITING_TIME = 30;
		HOSTNAME = "localhost";
		PORT = 8080;
		BACKLOG = 0; 
		THREAD_POOL = 10;
	}

	public int PortValidator(int port) {
		if (port < 80) {
			return 80;
		}
		return port;
	}

	public void SetConfig(Map<String, String> env) {
		PORT =  PortValidator(Integer.parseInt(env.get("APP_PORT")));
		CONNECTION_TIMEOUT = Integer.parseInt(env.get("APP_CLI_TTL"));
		URL = env.get("APP_URL");
		WAITING_TIME = Integer.parseInt(env.get("APP_TIME_UPDATE"));
		BACKLOG = Integer.parseInt(env.get("APP_LOG_LEVEL"));
		THREAD_POOL = Integer.parseInt(env.get("APP_THREADS_POOL"));
		HOSTNAME = env.get("APP_ADDR");

		System.out.println("Service configs:");
		System.out.format("\tPort server - %d\n", PORT);
		System.out.format("\tTime out - %d\n", CONNECTION_TIMEOUT);
		System.out.format("\tURL - %s\n", URL);
		System.out.format("\tTimint update - %d\n", WAITING_TIME);
		System.out.format("\tTrace level - %d\n", BACKLOG);
		System.out.format("\tThreads pool units - %d\n", THREAD_POOL);
		System.out.format("\tAddress server - %s\n", HOSTNAME);
	}
	
	public static void main(String[] args) throws IOException {
		Main myObj = new Main();
		myObj.SetConfig(System.getenv());
		SrvWork.http();
	}

}
