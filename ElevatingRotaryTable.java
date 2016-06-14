import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class ElevatingRotaryTable extends RealtimeThread {

	private Sensors sensor;

	ElevatingRotaryTable(PeriodicParameters pp) {
		super(null, pp);
		sensor = Sensors.getInstance();
	}

	public void run() {
		for(;;) {
			if(sensor.getMetalOnTable() && sensor.getTableDown() && sensor.getArm1OnTable()) {
				System.out.println("The metal in on " + getDeviceName() + "!");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ie) {
					//  ignore
				}
				
				System.out.println("The metal got picked up by Arm1!");

				sensor.setMetalOnTable(false);
				sensor.setTableDown(false);
				sensor.setTableUp(true);

				// Thread.sleep(5000);
				// sensor.setTableUp(false);
				// sensor.setTableDown(true);
			}
		}
	}

	// public void run() {
	// 	for (int i = 0; i < 2; ++i) {
	// 		System.out.println(this.getPriority() + " ERT");

		// 	System.out.println("Rotating clockwise " + getDeviceName() + "...");
		// 	try {
		// 		Thread.sleep(4500);
		// 	} catch (InterruptedException ie) {
		// 		//  ignore
		// 	}
		// 	System.out.println("The " + getDeviceName() + " reached " + MAX_DEGREE + " degrees.");

		// 	System.out.println("Elevating " + getDeviceName() + "...");
		// 	try {
		// 		Thread.sleep(3000);
		// 	} catch (InterruptedException ie) {
		// 		//  ignore
		// 	}
		// 	System.out.println("The " + getDeviceName() + " reached " + MAX_HEIGHT + " centimeters.");

		// 	try {
		// 		Thread.sleep(1000);
		// 	} catch (InterruptedException ie) {
		// 		//  ignore
		// 	}

		// 	System.out.println("Lowering " + getDeviceName() + "...");
		// 	try {
		// 		Thread.sleep(3000);
		// 	} catch (InterruptedException ie) {
		// 		//  ignore
		// 	}
		// 	System.out.println("The " + getDeviceName() + " reached " + MIN_HEIGHT + " centimeters.");

		// 	System.out.println("Rotating counterclockwise " + getDeviceName() + "...");
		// 	try {
		// 		Thread.sleep(4500);
		// 	} catch (InterruptedException ie) {
		// 		//  ignore
		// 	}
		// 	System.out.println("The " + getDeviceName() + " reached " + MIN_DEGREE + " degrees.");

		// 	System.out.println("DONEEEEEEEE");

		// 	waitForNextPeriod();
		// }
	// }

	private String getDeviceName() {
		return "Elevating Rotary Table";
	}
}