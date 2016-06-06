import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class ElevatingRotaryTable extends RealtimeThread {
	ElevatingRotaryTable(PeriodicParameters pp){
		super(null, pp);
	}
	public void run(){
		for (int i = 0; i < 30; ++i) {
			System.out.println(this.getPriority() + " ERT");
			waitForNextPeriod();
		}
	}

	private String getName() {
		return "Elevating Rotary Table";
	}
}