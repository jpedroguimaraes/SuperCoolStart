import java.io.Serializable;

public class StartUpItem implements Serializable
{
	private static final long serialVersionUID = 1L;
	static int id = 0;
	int itemId;
	boolean active;
	String cmd;

	public int getId()
	{
		return itemId;
	}

	public void toggleStatus()
	{
		active = !active;
	}

	public boolean getStatus()
	{
		return active;
	}

	public void setCommand(String newCmd)
	{
		cmd = newCmd;
	}

	public String getCommand()
	{
		return cmd;
	}

	public StartUpItem(String newCmd)
	{
		itemId = id;
		id++;
		active = true;
		cmd = newCmd;
	}
}