import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class ElevatingRotaryTable extends RealtimeThread {

	private static final int MIN_DEGREE = 0;
	private static final int MAX_DEGREE = 45;

	private static final int MIN_HEIGHT = 0;
	private static final int MAX_HEIGHT = 30;

	ElevatingRotaryTable(PriorityParameters pri, PeriodicParameters pp){
		super(pri, pp);
	}

	public void run(){
		for (int i = 0; i < 2; ++i) {
			System.out.println(this.getPriority() + " ERT");

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

			waitForNextPeriod();
		}
	}

	private String getDeviceName() {
		return "Elevating Rotary Table";
	}
}