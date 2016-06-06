import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class TravelingCrane extends RealtimeThread {
	TravelingCrane(PeriodicParameters pp){
		super(null, pp);
	}
	public void run(){
		for (int i = 0; i < 30; ++i) {
			System.out.println(this.getPriority() + " TC");
			waitForNextPeriod();
		}
	}

	private String getName() {
		return "Traveling Crane";
	}
}