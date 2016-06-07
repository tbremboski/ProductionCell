import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class Arm1 extends RealtimeThread {

	private static final int MIN_DISTANCE = 0;
	private static final int MAX_DISTANCE = 10;


	Arm1(PriorityParameters pri, PeriodicParameters pp){
		super(pri, pp);
	}

	public void run(){
		for (int i = 0; i < 2; ++i) {
			System.out.println(this.getPriority() + " ARM1");

		// 	System.out.println("Stretching " + getDeviceName() + "...");
		// 	try {
		// 		Thread.sleep(1000);
		// 	} catch (InterruptedException ie) {
		// 		//  ignore
		// 	}

		// 	System.out.println("The " + getDeviceName() + " reached " + MAX_DISTANCE + " centimeters.");

		// 	System.out.println("Shrinking " + getDeviceName() + "...");
		// 	try {
		// 		Thread.sleep(1000);
		// 	} catch (InterruptedException ie) {
		// 		//  ignore
		// 	}

		// 	System.out.println("The " + getDeviceName() + " reached " + MIN_DISTANCE + " centimeters.");

			waitForNextPeriod();
		}
	}

	private String getDeviceName() {
		return "Arm1";
	}
}