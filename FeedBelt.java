import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class FeedBelt extends RealtimeThread {
	public void run(){
		System.out.println(this.getPriority() + " FB");
	}

	private String getName() {
		return "Feed Belt";
	}
}