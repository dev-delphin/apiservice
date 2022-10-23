package apireq.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import apireq.Main;
import apireq.api.GetApi;

public class SrvWork{
	
	public static void http(Main core) throws IOException {
		Thread run = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						GetApi.api(core.GetConnectionTimeout(), core.GetURL());
						Thread.sleep(core.GetWaiteTime()*1000);
					} catch (IOException ex) {} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		run.start();
		
		ServerSocket ss = new ServerSocket(core.GetPort());
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
