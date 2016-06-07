import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class Robot extends RealtimeThread {
	Robot(PriorityParameters pri, PeriodicParameters pp){
		super(pri, pp);
	}
	public void run(){
		for (int i = 0; i < 2; ++i) {
			System.out.println(this.getPriority() + " R");
			waitForNextPeriod();
		}
	}

	private String getDeviceName() {
		return "Robot";
	}
}