import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class FeedBelt extends RealtimeThread {

	private Sensors sensor;
	private Controller controller;

	FeedBelt(PeriodicParameters pp) {
		super(null, pp);
		sensor = Sensors.getInstance();
		controller = Controller.getInstance();
	}

	public void run() {
		while(true) {
			if(controller.startFeedBelt()) {
				controller.idle();
				
				print("The metal is on " + getDeviceName() + "!");
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				print("The metal reached the end of " + getDeviceName() + "!");

				sensor.setMetalOnTable(true);
			}

			waitForNextPeriod();
		}
	}

	private String getDeviceName() {
		return "Feed Belt";
	}

	private void print(String arg) {
		System.out.println("**********************");
		System.out.println("Plant:");
		System.out.println(arg);
		System.out.println("**********************");
	}
}