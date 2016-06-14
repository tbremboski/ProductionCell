import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class DepositBelt extends RealtimeThread {

	private Sensors sensor;

	DepositBelt(PeriodicParameters pp) {
		super(null, pp);
		sensor = Sensors.getInstance();
	}

	public void run() {
		for(;;) {
			if(sensor.getArm2OnDeposit() && sensor.getCraneOnDeposit()) {
				System.out.println("The metal in on " + getDeviceName() + "!");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ie) {
					//  ignore
				}

				sensor.setArm2OnDeposit(false);
				sensor.setArm1OnTable(true);

				try {
					Thread.sleep(2000);
				} catch (InterruptedException ie) {
					//  ignore
				}
				
				System.out.println("The metal reached the end of " + getDeviceName() + "!");

				sensor.setMetalBelowCrane(true);
			}
		}
	}

	private String getDeviceName() {
		return "Deposit Belt";
	}
}