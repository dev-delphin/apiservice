package apireq;
import java.io.IOException;
import java.util.Map;
// import apireq.server.SrvWork;
import apireq.storage.storage;
import apireq.storage.postgres.postgres;
import apireq.storage.test_store.test_store;

public class Main {
	
	// TODO: move change config to ENV or config file.
	private int CONNECTION_TIMEOUT; // = 15000;
	private String URL; // = "https://api.blockchain.com/v3/exchange/tickers";
	private int WAITING_TIME; // = 30;
	private String HOSTNAME; // = "localhost";
	private int PORT; // = 8081;
	private int BACKLOG; // = 0; 
	private int THREAD_POOL; // = 10;
	private String TEST;

	public Main() {
		CONNECTION_TIMEOUT = 15000;
		URL = "https://api.blockchain.com/v3/exchange/tickers";
		WAITING_TIME = 30;
		HOSTNAME = "localhost";
		PORT = 8080;
		BACKLOG = 0; 
		THREAD_POOL = 10;
		TEST = "no";
	}

	public boolean Test() {
		System.out.format("Test state is - %s %b\n",  this.TEST, this.TEST.equals("yes"));
		return this.TEST.equals("yes");
	}

	public int GetPort() {
		return this.PORT;
	}

	public int GetConnectionTimeout() {
		return this.CONNECTION_TIMEOUT;
	}

	public int GetWaiteTime() {
		return this.WAITING_TIME;
	}

	public String GetURL() {
		return this.URL;
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
		TEST = env.get("APP_TEST").trim();

		System.out.println("Service configs:");
		System.out.format("\tPort server - %d\n", PORT);
		System.out.format("\tTime out - %d\n", CONNECTION_TIMEOUT);
		System.out.format("\tURL - %s\n", URL);
		System.out.format("\tTimint update - %d\n", WAITING_TIME);
		System.out.format("\tTrace level - %d\n", BACKLOG);
		System.out.format("\tThreads pool units - %d\n", THREAD_POOL);
		System.out.format("\tAddress server - %s\n", HOSTNAME);
		System.out.format("\tTest - %s\n", TEST);
	}
	
	public static void main(String[] args) throws IOException {
		Main myObj = new Main();
		myObj.SetConfig(System.getenv());

		postgres db = new postgres();
		test_store t = new test_store();

		storage store;

		if (myObj.Test()) {
			// injection test
			store = new storage(t);
		} else {
			// injection Postgres
			store = new storage(db);
		}

		store.SaveUserName("Petr");


		// SrvWork.http();
	}

}