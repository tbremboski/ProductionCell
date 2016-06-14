import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class Robot extends RealtimeThread {

	private Sensors sensor;

	Robot(PeriodicParameters pp) {
		super(null, pp);
		sensor = Sensors.getInstance();
	}

	public void run() {
		while(true) {
			if(sensor.getArm1OnTable() && sensor.getTableUp() && sensor.getPressOpened()) {
				System.out.println("The " + getDeviceName() + " is rotating counterclockwisely!");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setTableUp(false);
				sensor.setTableDown(true);

				System.out.println("The metal has been put on the Press!");
				sensor.setArm1OnTable(false);
				sensor.setArm1OnPress(true);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setPressOpened(false);
				sensor.setPressClosed(true);
			} else if(sensor.getArm1OnPress() && sensor.getPressOpened()) {
				System.out.println("The " + getDeviceName() + " is rotating clockwisely!");

				try {
					Thread.sleep(3500);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setArm1OnPress(false);
				sensor.setArm2OnPress(true);

				System.out.println("The metal got picked up by Arm2!");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				System.out.println("The " + getDeviceName() + " is rotating counterclockwisely!");

				try {
					Thread.sleep(2500);
				} catch (InterruptedException ie) {
					//  ignore
				}

				System.out.println("The metal has been put on the Deposit Belt!");

				sensor.setArm2OnPress(false);
				sensor.setArm2OnDeposit(true);
			}

			waitForNextPeriod();
		}
	}

	private String getDeviceName() {
		return "Robot";
	}
}