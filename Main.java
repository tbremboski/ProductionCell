import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RelativeTime;
import java.lang.Thread;
public class Main {

	public static void main(String [] args) {

		Sensors s = Sensors.getInstance();

		RelativeTime r3000 = new RelativeTime(3000, 0);
		RelativeTime r4500 = new RelativeTime(4500, 0);
		RelativeTime r5000 = new RelativeTime(6000, 0);
		RelativeTime r6000 = new RelativeTime(6000, 0);
		RelativeTime r7000 = new RelativeTime(7000, 0);

		PeriodicParameters fbParam = new PeriodicParameters(r3000);
		PeriodicParameters ertParam = new PeriodicParameters(r5000);
		PeriodicParameters rParam = new PeriodicParameters(r7000);
		PeriodicParameters pParam = new PeriodicParameters(r4500);
		PeriodicParameters dbParam = new PeriodicParameters(r7000);
		PeriodicParameters tcParam = new PeriodicParameters(r6000);

		FeedBelt fb = new FeedBelt(fbParam);
		ElevatingRotaryTable ert = new ElevatingRotaryTable(ertParam);
		Robot r = new Robot(rParam);
		Press p = new Press(pParam);
		DepositBelt db = new DepositBelt(dbParam);
		TravelingCrane tc = new TravelingCrane(tcParam);

		System.out.println("");

		fb.start();
		ert.start();
		r.start();
		p.start();
		db.start();
		tc.start();

		try {
			fb.join();
			ert.join();
			r.join();
			p.join();
			db.join();
			tc.join();
		} catch (InterruptedException ie) {
			//  ignore
		}
	}
}