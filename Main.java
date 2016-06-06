import javax.realtime.PeriodicParameters;
import javax.realtime.RelativeTime;
public class Main {

	public static void main(String [] args) {

		RelativeTime r2000 = new RelativeTime(2000, 0);
		RelativeTime r2500 = new RelativeTime(2500, 0);
		RelativeTime r4500 = new RelativeTime(4500, 0);
		RelativeTime r2500 = new RelativeTime(2500, 0);
		RelativeTime r2500 = new RelativeTime(2500, 0);
		RelativeTime r2500 = new RelativeTime(2500, 0);

		PeriodicParameters ertParam = new PeriodicParameters(new RelativeTime(2000, 0));
		PeriodicParameters rParam = new PeriodicParameters(new RelativeTime(500, 0));
		PeriodicParameters arm1Param = new PeriodicParameters(new RelativeTime(500, 0));
		PeriodicParameters arm2Param = new PeriodicParameters(new RelativeTime(500, 0));
		PeriodicParameters pParam = new PeriodicParameters(new RelativeTime(500, 0));
		PeriodicParameters tcParam = new PeriodicParameters(new RelativeTime(500, 0));
		FeedBelt fb = new FeedBelt();
		ElevatingRotaryTable ert = new ElevatingRotaryTable();
		Robot r = new Robot();
		Arm1 arm1 = new Arm1();
		Arm2 arm2 = new Arm2();
		Press p = new Press();
		DepositBelt db = new DepositBelt();
		TravelingCrane tc = new TravelingCrane();

		fb.start();
		ert.start();
		r.start();
		arm1.start();
		arm2.start();
		p.start();
		db.start();
		tc.start();

		try {
			fb.join();
			ert.join();
			r.join();
			arm1.join();
			arm2.join();
			p.join();
			db.join();
			tc.join();
		} catch (InterruptedException ie) {
			//  ignore
		}
	}
}