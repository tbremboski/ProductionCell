

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
	private boolean pressOpened;
	private boolean pressClosed;
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
		pressOpened = true;
		pressClosed = false;
		metalBelowCrane = false;
	}

	public static synchronized Sensors getInstance() {
		if(singleton == null) {
			singleton = new Sensors();
		}

		return singleton;
	}

	public boolean getCraneOnFeed() {
		return craneOnFeed;
	}

	public boolean getCraneOnDeposit() {
		return craneOnDeposit;
	}

	public boolean getMetalOnTable() {
		return metalOnTable;
	}

	public boolean getTableDown() {
		return tableDown;
	}

	public boolean getTableUp() {
		return tableUp;
	}

	public boolean getArm1OnTable() {
		return arm1OnTable;
	}

	public boolean getArm1OnPress() {
		return arm1OnPress;
	}

	public boolean getArm2OnPress() {
		return arm2OnPress;
	}

	public boolean getArm2OnDeposit() {
		return arm2OnDeposit;
	}

	public boolean getPressOpened() {
		return pressOpened;
	}

	public boolean getPressClosed() {
		return pressClosed;
	}

	public boolean getMetalBelowCrane() {
		return metalBelowCrane;
	}

	public void setCraneOnFeed(boolean b) {
		craneOnFeed = b;
	}

	public void setCraneOnDeposit(boolean b) {
		craneOnDeposit = b;
	}

	public void setMetalOnTable(boolean b) {
		metalOnTable = b;
	}

	public void setTableDown(boolean b) {
		tableDown = b;
	}

	public void setTableUp(boolean b) {
		tableUp = b;
	}

	public void setArm1OnTable(boolean b) {
		arm1OnTable = b;
	}

	public void setArm1OnPress(boolean b) {
		arm1OnPress = b;
	}

	public void setArm2OnPress(boolean b) {
		arm2OnPress = b;
	}

	public void setArm2OnDeposit(boolean b) {
		arm2OnDeposit = b;
	}

	public void setPressOpened(boolean b) {
		pressOpened = b;
	}

	public void setPressClosed(boolean b) {
		pressClosed = b;
	}

	public void setMetalBelowCrane(boolean b) {
		metalBelowCrane = b;
	}
}