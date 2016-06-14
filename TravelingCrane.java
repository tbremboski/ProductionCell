import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class TravelingCrane extends RealtimeThread {

	private Sensors sensor;

	TravelingCrane(PeriodicParameters pp) {
		super(null, pp);
		sensor = Sensors.getInstance();
	}

	public void run() {
		while(true) {
			if(sensor.getMetalBelowCrane() && sensor.getCraneOnDeposit()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				System.out.println("The " + getDeviceName() + " has picked up the metal!");
				
				try {
					Thread.sleep(4000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setMetalBelowCrane(false);
				sensor.setCraneOnDeposit(false);

				System.out.println("The " + getDeviceName() + " released the metal on Feed Belt!");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setCraneOnFeed(true);
			}

			waitForNextPeriod();
		}
	}

	private String getDeviceName() {
		return "Traveling Crane";
	}
}