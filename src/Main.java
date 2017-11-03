import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		StartUpItemManager temp = new StartUpItemManager();
		temp.addItemToList("lol1");
		temp.addItemToList("lol2");
		temp.addItemToList("lol3");
		temp.addItemToList("lol4");
		System.out.println("Size: " + temp.getItemListSize());
		for(int i = 0; i < temp.getItemListSize(); i++) {
			System.out.println("Item: " + i + " : " + temp.getItem(i).getCommand());
		}
	}
}