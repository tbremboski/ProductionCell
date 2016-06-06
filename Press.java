import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class Press extends RealtimeThread {
	Press(PeriodicParameters pp){
		super(null, pp);
	}
	public void run(){
		for (int i = 0; i < 30; ++i) {
			System.out.println(this.getPriority() + " P");
			waitForNextPeriod();
		}
	}

	private String getName() {
		return "Press";
	}
}