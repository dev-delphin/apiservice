package apireq.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.sun.net.httpserver.HttpServer;

public class SrvWork {
	
	public static void http() throws IOException {
		HttpServer server = HttpServer.create (new InetSocketAddress(apireq.Main.HOSTNAME, apireq.Main.PORT), apireq.Main.BACKLOG);
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(apireq.Main.THREAD_POOL);
		//server.createContext("/test", new  MyHttpHandler());
		server.setExecutor(threadPoolExecutor);
		System.out.println(" Server started on port " + apireq.Main.PORT);
		server.start();
		
		Thread run = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						apireq.api.GetApi.api(apireq.Main.CONNECTION_TIMEOUT);
						Thread.sleep(apireq.Main.WAITING_TIME*1000);
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
