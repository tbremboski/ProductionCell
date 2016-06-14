import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class Press extends RealtimeThread {

	private Sensors sensor;

	Press(PeriodicParameters pp) {
		super(null, pp);
		sensor = Sensors.getInstance();
	}

	public void run() {
		for(;;) {
			if(sensor.getPressClosed()) {
				System.out.println("The " + getDeviceName() + " is forging the metal!");
				
				try {
					Thread.sleep(4500);
				} catch (InterruptedException ie) {
					//  ignore
				}
				
				System.out.println("The metal has been forged!");

				sensor.setPressClosed(false);
				sensor.setPressOpened(true);
			}
		}
	}

	private String getDeviceName() {
		return "Press";
	}
}