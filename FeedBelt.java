import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class FeedBelt extends RealtimeThread {

	private Sensors sensor;

	FeedBelt(PeriodicParameters pp) {
		super(null, pp);
		sensor = Sensors.getInstance();
	}

	public void run() {
		while(true) {
			if(sensor.getCraneOnFeed() && sensor.getTableDown()) {
				System.out.println("The metal is on " + getDeviceName() + "!");
				
				sensor.setCraneOnFeed(false);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				System.out.println("The metal has left " + getDeviceName() + "!");

				sensor.setCraneOnDeposit(true);
				sensor.setMetalOnTable(true);
			}

			waitForNextPeriod();
		}
	}

	private String getDeviceName() {
		return "Feed Belt";
	}
}