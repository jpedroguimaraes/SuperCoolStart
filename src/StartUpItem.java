public class StartUpItem {

	boolean active;
	String cmd;

	public void setStatus(boolean newStatus) {
		active = newStatus;
	}

	public boolean getStatus() {
		return active;
	}

	public void setCommand(String newCmd) {
		cmd = newCmd;
	}

	public String getCommand() {
		return cmd;
	}

	public StartUpItem(String newCmd) {
		active = true;
		cmd = newCmd;
	}

}