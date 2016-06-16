import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class TravelingCrane extends RealtimeThread {

	private Sensors sensor;
	private Controller controller;

	TravelingCrane(PeriodicParameters pp) {
		super(null, pp);
		sensor = Sensors.getInstance();
		controller = Controller.getInstance();
	}

	public void run() {
		while(true) {
			if(controller.pickMetalAndMoveToFeed()) {
				controller.idle();

				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				print("The " + getDeviceName() + " has picked up the metal!");
				sensor.setMetalBelowCrane(false);
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				print("The " + getDeviceName() + " is moving to Feed Belt!");

				try {
					Thread.sleep(2000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setCraneOnDeposit(false);
				sensor.setCraneOnFeed(true);
			} else if(controller.dropMetalAndMoveToDeposit()) {
				controller.idle();

				print("The " + getDeviceName() + " dropped the metal on Feed Belt!");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setCraneOnFeed(false);

				print("The " + getDeviceName() + " is returning to Deposit Belt!");

				try {
					Thread.sleep(4000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setCraneOnDeposit(true);
			}

			waitForNextPeriod();
		}
	}

	private String getDeviceName() {
		return "Traveling Crane";
	}

	private void print(String arg) {
		System.out.println("**********************");
		System.out.println("Plant:");
		System.out.println(arg);
		System.out.println("**********************");
	}
}