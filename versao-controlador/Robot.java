import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class Robot extends RealtimeThread {

	private Sensors sensor;
	private Controller controller;

	Robot(PeriodicParameters pp) {
		super(null, pp);
		sensor = Sensors.getInstance();
		controller = Controller.getInstance();
	}

	public void run() {
		while(true) {
			if(controller.arm1Task()) {
				controller.idle();

				print("The " + getDeviceName() + " is rotating counterclockwisely!");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				print("The metal has been put on the Press by Arm1!");
				sensor.setArm1OnTable(false);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setArm1OnPress(true);
			} else if(controller.arm2Task()) {
				controller.idle();

				print("The " + getDeviceName() + " is rotating clockwisely!");

				try {
					Thread.sleep(3500);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setArm1OnPress(false);
				sensor.setArm2OnPress(true);

				print("The metal got picked up by Arm2!");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				print("The " + getDeviceName() + " is rotating counterclockwisely!");

				try {
					Thread.sleep(2500);
				} catch (InterruptedException ie) {
					//  ignore
				}

				print("The arm2 dropped the metal on the Deposit Belt!");

				sensor.setArm2OnPress(false);
				sensor.setArm2OnDeposit(true);
			} else if(controller.arm1Back()) {
				controller.idle();

				print("The " + getDeviceName() + " is positioning Arm1 over the Table!");

				try {
					Thread.sleep(2000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setArm2OnDeposit(false);
				sensor.setArm1OnTable(true);
			}

			waitForNextPeriod();
		}
	}

	private String getDeviceName() {
		return "Robot";
	}

	private void print(String arg) {
		System.out.println("**********************");
		System.out.println("Plant:");
		System.out.println(arg);
		System.out.println("**********************");
	}
}