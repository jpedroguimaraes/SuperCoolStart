import java.awt.EventQueue;

public class Main
{
	public static StartUpItemManager startManager;
	public static Menu menuGUI;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startManager = new StartUpItemManager();
					menuGUI = new Menu(); //might be better to set a callback
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//startManager.startItems(); to be triggered by buttons
		menuGUI.setVisible(true);
		//put returns in int form with enum to represent motive of error
	}
}