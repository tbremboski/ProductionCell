import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.RelativeTime;
import java.lang.Thread;
public class Main {

	public static void main(String [] args) {

		RelativeTime r2000 = new RelativeTime(2000, 0);
		RelativeTime r2500 = new RelativeTime(2500, 0);
		RelativeTime r3000 = new RelativeTime(3000, 0);
		RelativeTime r4500 = new RelativeTime(4500, 0);
		RelativeTime r10000 = new RelativeTime(10000, 0);
		RelativeTime r16000 = new RelativeTime(16000, 0);
		RelativeTime r17000 = new RelativeTime(17000, 0);
		// RelativeTime r2500 = new RelativeTime(2500, 0);
		// RelativeTime r2500 = new RelativeTime(2500, 0);

		// PeriodicParameters ertParam = new PeriodicParameters(
		// 	r2500, r17000, r2000, r17000, null, null);
		PeriodicParameters rParam = new PeriodicParameters(new RelativeTime(5000, 0));
		PriorityParameters maxPP = new PriorityParameters(Thread.MAX_PRIORITY);
		PriorityParameters minPP = new PriorityParameters(Thread.MIN_PRIORITY);
		PriorityParameters normPP = new PriorityParameters(Thread.NORM_PRIORITY);
		// PeriodicParameters arm1Param = new PeriodicParameters(
		// 	r10000, r17000, r2000, r17000, null, null);
		// PeriodicParameters arm2Param = new PeriodicParameters(new RelativeTime(500, 0));
		PeriodicParameters pParam = new PeriodicParameters(new RelativeTime(8000, 0));
		// PeriodicParameters tcParam = new PeriodicParameters(new RelativeTime(500, 0));
		// FeedBelt fb = new FeedBelt();
		ElevatingRotaryTable ert = new ElevatingRotaryTable(maxPP, pParam);
		Robot r = new Robot(normPP, rParam);
		Arm1 arm1 = new Arm1(minPP, pParam);
		Arm2 arm2 = new Arm2(minPP, pParam);
		Press p = new Press(normPP, pParam);
		// DepositBelt db = new DepositBelt();
		// TravelingCrane tc = new TravelingCrane(tcParam);

		// fb.start();
		ert.start();
		r.start();
		arm1.start();
		arm2.start();
		p.start();
		// db.start();
		// tc.start();

		try {
			// fb.join();
			ert.join();
			r.join();
			arm1.join();
			arm2.join();
			p.join();
			// db.join();
			// tc.join();
		} catch (InterruptedException ie) {
			//  ignore
		}
	}
}