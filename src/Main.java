import java.awt.EventQueue;

public class Main
{
	public static Menu menuGUI;
	
	public static void main(final String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartUpItemManager itemManager = new StartUpItemManager();
					if(args.length == 0)
						itemManager.startItems();
					else if(args.length == 1 && args[0].equals("-gui"))
						menuGUI = new Menu(itemManager);
					else
						System.out.println("Program initialization error!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}