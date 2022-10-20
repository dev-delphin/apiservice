package apireq.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.sun.net.httpserver.HttpServer;

public class SrvWork {
	
	public static void http() throws IOException {
		HttpServer server = HttpServer.create (new InetSocketAddress("localhost", 8001), 0);
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
		//server.createContext("/test", new  MyHttpHandler());
		server.setExecutor(threadPoolExecutor);
		System.out.println(" Server started on port 8001");
		server.start();
		
		Thread run = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						apireq.api.GetApi.api(apireq.Main.CONNECTION_TIMEOUT);
						Thread.sleep(30*1000);
					} catch (IOException ex) {} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		run.start();;
	}

}
