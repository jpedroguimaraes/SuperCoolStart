import java.util.Vector;

public class StartUpItemManager {

	Vector<StartUpItem> itemList;

	public StartUpItem getItem(int index) {
		return itemList.get(index); //deprecated?
	}

	public void clearItemList() {
		itemList.clear(); //doesn't work? maybe new version needed
	}

	public void addItemToList(String newItem) {
		itemList.add(new StartUpItem(newItem)); //also doesn't work? wtf? might be better to switch to arrays
	}

	public void removeItemFromList() {
		//waiting on id decision on StartUpItem
	}

	public int getItemListSize() {
		return 2;//return itemList.size(); also doesnt work????
	}

	public Vector<StartUpItem> getItemList() {
		return itemList;
	}

	public void saveItems() {
		
	}

	public void loadItems() {
		
	}

	public StartUpItemManager() {
		//clearItemList();
		loadItems();
	}
}