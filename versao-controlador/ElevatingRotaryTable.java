import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class ElevatingRotaryTable extends RealtimeThread {

	private Sensors sensor;
	private Controller controller;

	ElevatingRotaryTable(PeriodicParameters pp) {
		super(null, pp);
		sensor = Sensors.getInstance();
		controller = Controller.getInstance();
	}

	public void run() {
		while(true) {
			if(controller.elevateTable()) {
				controller.idle();

				print("The " + getDeviceName() + " is elevating!");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setMetalOnTable(false);
				sensor.setTableDown(false);
				sensor.setTableUp(true);
			} else if(controller.lowerTable()) {
				controller.idle();
				
				print("The " + getDeviceName() + " is lowering!");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setTableUp(false);
				sensor.setTableDown(true);
			}

			waitForNextPeriod();
		}
	}

	private String getDeviceName() {
		return "Elevating Rotary Table";
	}

	private void print(String arg) {
		System.out.println("**********************");
		System.out.println("Plant:");
		System.out.println(arg);
		System.out.println("**********************");
	}
}