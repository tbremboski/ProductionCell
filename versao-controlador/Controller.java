import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
public class Controller extends RealtimeThread {

	private static Controller singleton;

	private Sensors sensor;

	private boolean startFeedBelt;
	// private boolean stopFeedBelt;
	private boolean elevateTable;
	private boolean lowerTable;
	private boolean arm1Task;
	private boolean arm2Task;
	private boolean arm1Back;
	private boolean openPress;
	private boolean closePress;
	private boolean startDepositBelt;
	// private boolean stopDepositBelt;
	private boolean pickMetalAndMoveToFeed;
	private boolean dropMetalAndMoveToDeposit;

	private Controller(PeriodicParameters pp) {
		super(null, pp);
		sensor = Sensors.getInstance();

		idle();
	}

	public static synchronized Controller getInstance() {
		if(singleton == null) {
			RelativeTime r2000 = new RelativeTime(2000, 0);
			PeriodicParameters pp = new PeriodicParameters(r2000);
			singleton = new Controller(pp);
		}

		return singleton;
	}

	public void run() {
		while(true) {
			if(sensor.getCraneOnFeed() && sensor.getTableDown()) {
				controlCraneB();
				controlFeedBelt();
			} else if (sensor.getMetalOnTable() && sensor.getTableDown() && sensor.getArm1OnTable()) {
				controlTable();
			} else if (sensor.getArm1OnTable() && sensor.getTableUp() && sensor.getPressOpened1()) {
				controlTableB();
				controlArm1();
			} else if (sensor.getArm1OnPress() && sensor.getPressOpened1()) {
				controlPress();
			} else if (sensor.getArm1OnPress() && sensor.getPressOpened2()) {
				controlArm2();
				controlPressB();
			} else if (sensor.getArm2OnDeposit() && sensor.getCraneOnDeposit() && sensor.getPressOpened1()) {
				controlArm1B();
				controlDepositBelt();
			} else if (sensor.getMetalBelowCrane() && sensor.getCraneOnDeposit()) {
				controlCrane();
			}

			waitForNextPeriod();
		}
	}

	private void controlCraneB() {
		print("Start Traveling Crane.");

		dropMetalAndMoveToDeposit = true;

		while(!sensor.getCraneOnDeposit()) {
			waitOneSecond();
		}

		print("Stop Traveling Crane.");
		waitOneSecond();
	}

	private void controlFeedBelt() {
		this.print("Start Feed Belt.");

		startFeedBelt = true;

		while(!sensor.getMetalOnTable()) {
			waitOneSecond();
		}

		print("Stop Feed Belt.");
		waitOneSecond();
	}

	private void controlTable() {
		print("Start Elevating Rotary Table.");

		elevateTable = true;

		while(!sensor.getTableUp()) {
			waitOneSecond();
		}

		print("Stop Elevating Rotary Table.");
		waitOneSecond();
	}

	private void controlTableB() {
		print("Start Elevating Rotary Table.");

		lowerTable = true;

		while(!sensor.getTableDown()) {
			waitOneSecond();
		}

		print("Stop Elevating Rotary Table.");
		waitOneSecond();
	}

	private void controlArm1() {
		print("Start Robot.");

		arm1Task = true;

		while(!sensor.getArm1OnPress()) {
			waitOneSecond();
		}

		print("Stop Robot.");
		waitOneSecond();
	}

	private void controlPress() {
		print("Start Press.");

		closePress = true;

		while(!sensor.getPressOpened2()) {
			waitOneSecond();
		}

		print("Stop Press.");
		waitOneSecond();
	}

	private void controlArm2() {
		print("Start Robot.");

		arm2Task = true;

		while(!sensor.getArm2OnDeposit()) {
			waitOneSecond();
		}

		print("Stop Robot.");
		waitOneSecond();
	}

	private void controlPressB() {
		print("Start Press.");

		openPress = true;

		while(!sensor.getPressOpened1()) {
			waitOneSecond();
		}

		print("Stop Press.");
		waitOneSecond();
	}

	private void controlArm1B() {
		print("Start Robot.");

		arm1Back = true;

		while(!sensor.getArm1OnTable()) {
			waitOneSecond();
		}

		print("Stop Robot.");
		waitOneSecond();
	}

	private void controlDepositBelt() {
		print("Start Deposit Belt.");

		startDepositBelt = true;

		while(!sensor.getMetalBelowCrane()) {
			waitOneSecond();
		}

		print("Stop Deposit Belt.");
		waitOneSecond();
	}

	private void controlCrane() {
		print("Start Traveling Crane.");

		pickMetalAndMoveToFeed = true;

		while(!sensor.getCraneOnFeed()) {
			waitOneSecond();
		}

		print("Stop Traveling Crane.");
		waitOneSecond();
	}

	private String getDeviceName() {
		return "Controller";
	}

	private void print(String arg) {
		System.out.println("\t\t\t======================");
		System.out.println("\t\t\tController:");
		System.out.println("\t\t\t" + arg);
		System.out.println("\t\t\t======================");
	}

	public boolean startFeedBelt() {
		return startFeedBelt;
	}

	// public boolean stopFeedBelt() {
	// 	return stopFeedBelt;
	// }

	public boolean elevateTable() {
		return elevateTable;
	}

	public boolean lowerTable() {
		return lowerTable;
	}

	public boolean arm1Task() {
		return arm1Task;
	}

	public boolean arm2Task() {
		return arm2Task;
	}

	public boolean arm1Back() {
		return arm1Back;
	}

	public boolean openPress() {
		return openPress;
	}

	public boolean closePress() {
		return closePress;
	}

	public boolean startDepositBelt() {
		return startDepositBelt;
	}

	// public boolean stopDepositBelt() {
	// 	return stopDepositBelt;
	// }

	public boolean pickMetalAndMoveToFeed() {
		return pickMetalAndMoveToFeed;
	}

	public boolean dropMetalAndMoveToDeposit() {
		return dropMetalAndMoveToDeposit;
	}

	public void idle() {
		startFeedBelt = false;
		// stopFeedBelt = false;
		elevateTable = false;
		lowerTable = false;
		arm1Task = false;
		arm2Task = false;
		arm1Back= false;
		openPress = false;
		closePress = false;
		startDepositBelt = false;
		// stopDepositBelt = false;
		pickMetalAndMoveToFeed = false;
		dropMetalAndMoveToDeposit = false;
	}

	private void waitOneSecond() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			//  ignore
		}
	}
}