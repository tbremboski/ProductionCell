import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RelativeTime;
import java.lang.Thread;
public class Main {

	public static void main(String [] args) {

		// RelativeTime r2000 = new RelativeTime(2000, 0);
		// RelativeTime r2500 = new RelativeTime(2500, 0);
		RelativeTime r3000 = new RelativeTime(3000, 0);
		RelativeTime r4500 = new RelativeTime(4500, 0);
		RelativeTime r5000 = new RelativeTime(6000, 0);
		RelativeTime r6000 = new RelativeTime(6000, 0);
		RelativeTime r7000 = new RelativeTime(7000, 0);
		// RelativeTime r10000 = new RelativeTime(10000, 0);
		// RelativeTime r15000 = new RelativeTime(15000, 0);
		// RelativeTime r16000 = new RelativeTime(16000, 0);
		// RelativeTime r2500 = new RelativeTime(2500, 0);
		// RelativeTime r2500 = new RelativeTime(2500, 0);

		PeriodicParameters fbParam = new PeriodicParameters(r3000);
		PeriodicParameters ertParam = new PeriodicParameters(r5000);
		PeriodicParameters rParam = new PeriodicParameters(r7000);
		// PeriodicParameters arm1Param = new PeriodicParameters();
		// PeriodicParameters arm2Param = new PeriodicParameters();
		PeriodicParameters pParam = new PeriodicParameters(r4500);
		PeriodicParameters dbParam = new PeriodicParameters(r7000);
		PeriodicParameters tcParam = new PeriodicParameters(r6000);
		FeedBelt fb = new FeedBelt(fbParam);
		ElevatingRotaryTable ert = new ElevatingRotaryTable(ertParam);
		Robot r = new Robot(rParam);
		// Arm1 arm1 = new Arm1(pParam);
		// Arm2 arm2 = new Arm2(pParam);
		Press p = new Press(pParam);
		DepositBelt db = new DepositBelt(dbParam);
		TravelingCrane tc = new TravelingCrane(tcParam);

		fb.start();
		ert.start();
		r.start();
		// arm1.start();
		// arm2.start();
		p.start();
		db.start();
		tc.start();

		try {
			fb.join();
			ert.join();
			r.join();
			// arm1.join();
			// arm2.join();
			p.join();
			db.join();
			tc.join();
		} catch (InterruptedException ie) {
			//  ignore
		}
	}
}