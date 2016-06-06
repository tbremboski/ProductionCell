import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class DepositBelt extends RealtimeThread {

	public void run(){
		System.out.println(this.getPriority() + " DB");
	}

	private String getName() {
		return "Deposit Belt";
	}
}