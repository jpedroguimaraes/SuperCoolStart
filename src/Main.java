import java.awt.EventQueue;

public class Main
{
	public static Menu menuGUI;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuGUI = new Menu(new StartUpItemManager());
					menuGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}