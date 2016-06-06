import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class FeedBelt extends RealtimeThread {
	public void run(){
		System.out.println(getDeviceName() + " started!");
	}

	private String getDeviceName() {
		return "Feed Belt";
	}
}