import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class Press extends RealtimeThread {

	private Sensors sensor;
	private Controller controller;

	Press(PeriodicParameters pp) {
		super(null, pp);
		sensor = Sensors.getInstance();
		controller = Controller.getInstance();
	}

	public void run() {
		while(true) {
			if(controller.closePress()) {
				controller.idle();

				print("The " + getDeviceName() + " is forging the metal!");

				sensor.setPressOpened1(false);
				
				try {
					Thread.sleep(4500);
				} catch (InterruptedException ie) {
					//  ignore
				}

				print("The metal has been forged!");

				sensor.setPressOpened2(true);
			} else if(controller.openPress()) {
				controller.idle();
				
				print("The " + getDeviceName() + " is opening for Arm1!");

				sensor.setPressOpened2(false);
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setPressOpened1(true);
			}

			waitForNextPeriod();
		}
	}

	private String getDeviceName() {
		return "Press";
	}

	private void print(String arg) {
		System.out.println("**********************");
		System.out.println("Plant:");
		System.out.println(arg);
		System.out.println("**********************");
	}
}