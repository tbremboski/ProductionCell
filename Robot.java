import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class Robot extends RealtimeThread {
	Robot(PeriodicParameters pp){
		super(null, pp);
	}
	public void run(){
		for (int i = 0; i < 30; ++i) {
			System.out.println(this.getPriority() + " R");
			waitForNextPeriod();
		}
	}

	private String getName() {
		return "Robot";
	}
}