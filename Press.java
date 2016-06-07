import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class Press extends RealtimeThread {
	Press(PriorityParameters pri, PeriodicParameters pp){
		super(pri, pp);
	}
	public void run(){
		for (int i = 0; i < 2; ++i) {
			System.out.println(this.getPriority() + " P");
			waitForNextPeriod();
		}
	}

	private String getDeviceName() {
		return "Press";
	}
}