package apireq.server;

import java.io.IOException;
import apireq.api.GetApi;

public class ReqApi {
	
	public static void ThreadApi() {
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
		run.start();;
	}
}
