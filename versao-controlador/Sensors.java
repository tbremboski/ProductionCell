

class Sensors {
	private static Sensors singleton;

	private boolean craneOnFeed;
	private boolean craneOnDeposit;
	private boolean metalOnTable;
	private boolean tableDown;
	private boolean tableUp;
	private boolean arm1OnTable;
	private boolean arm1OnPress;
	private boolean arm2OnPress;
	private boolean arm2OnDeposit;
	private boolean pressOpened1;
	private boolean pressOpened2;
	private boolean metalBelowCrane;

	private Sensors() {
		craneOnFeed = true;
		craneOnDeposit = false;
		metalOnTable = false;
		tableDown = true;
		tableUp = false;
		arm1OnTable = true;
		arm1OnPress = false;
		arm2OnPress = false;
		arm2OnDeposit = false;
		pressOpened1 = true;
		pressOpened2 = false;
		metalBelowCrane = false;
	}

	public static synchronized Sensors getInstance() {
		if(singleton == null) {
			singleton = new Sensors();
		}

		return singleton;
	}

	public synchronized boolean getCraneOnFeed() {
		return craneOnFeed;
	}

	public synchronized boolean getCraneOnDeposit() {
		return craneOnDeposit;
	}

	public synchronized boolean getMetalOnTable() {
		return metalOnTable;
	}

	public synchronized boolean getTableDown() {
		return tableDown;
	}

	public synchronized boolean getTableUp() {
		return tableUp;
	}

	public synchronized boolean getArm1OnTable() {
		return arm1OnTable;
	}

	public synchronized boolean getArm1OnPress() {
		return arm1OnPress;
	}

	public synchronized boolean getArm2OnPress() {
		return arm2OnPress;
	}

	public synchronized boolean getArm2OnDeposit() {
		return arm2OnDeposit;
	}

	public synchronized boolean getPressOpened1() {
		return pressOpened1;
	}

	public synchronized boolean getPressOpened2() {
		return pressOpened2;
	}

	public synchronized boolean getMetalBelowCrane() {
		return metalBelowCrane;
	}

	public synchronized void setCraneOnFeed(boolean b) {
		craneOnFeed = b;
	}

	public synchronized void setCraneOnDeposit(boolean b) {
		craneOnDeposit = b;
	}

	public synchronized void setMetalOnTable(boolean b) {
		metalOnTable = b;
	}

	public synchronized void setTableDown(boolean b) {
		tableDown = b;
	}

	public synchronized void setTableUp(boolean b) {
		tableUp = b;
	}

	public synchronized void setArm1OnTable(boolean b) {
		arm1OnTable = b;
	}

	public synchronized void setArm1OnPress(boolean b) {
		arm1OnPress = b;
	}

	public synchronized void setArm2OnPress(boolean b) {
		arm2OnPress = b;
	}

	public synchronized void setArm2OnDeposit(boolean b) {
		arm2OnDeposit = b;
	}

	public synchronized void setPressOpened1(boolean b) {
		pressOpened1 = b;
	}

	public synchronized void setPressOpened2(boolean b) {
		pressOpened2 = b;
	}

	public synchronized void setMetalBelowCrane(boolean b) {
		metalBelowCrane = b;
	}
}