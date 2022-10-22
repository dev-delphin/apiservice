package apireq.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import apireq.api.GetApi;

public class SrvWork{
	
	public static void http() throws IOException {
		Thread run = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						GetApi.api(apireq.Main.CONNECTION_TIMEOUT);
						Thread.sleep(apireq.Main.WAITING_TIME*1000);
					} catch (IOException ex) {} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		run.start();
		
		ServerSocket ss = new ServerSocket(apireq.Main.PORT);
        while (true) {
            Socket s = ss.accept();
            System.err.println("Client accepted");
            try {
				new Thread(new SocketProcessor(s)).start();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
}
