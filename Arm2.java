import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class Arm2 extends RealtimeThread {
	Arm2(PeriodicParameters pp){
		super(null, pp);
	}
	public void run(){
		for (int i = 0; i < 30; ++i) {
			System.out.println(this.getPriority() + " A2");
			waitForNextPeriod();
		}
	}

	private String getName() {
		return "Arm2";
	}
}