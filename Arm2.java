import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class Arm2 extends RealtimeThread {
	Arm2(PriorityParameters pri, PeriodicParameters pp){
		super(pri, pp);
	}
	public void run(){
		for (int i = 0; i < 2; ++i) {
			System.out.println(this.getPriority() + " A2");
			waitForNextPeriod();
		}
	}

	private String getDeviceName() {
		return "Arm2";
	}
}