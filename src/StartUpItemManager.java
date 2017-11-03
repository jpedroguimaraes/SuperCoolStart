import java.util.Vector;

public class StartUpItemManager {

	Vector<StartUpItem> itemList;
	
	public void clearItemList() {
		itemList.clear();
	}
	
	public void addItemToList(StartUpItem newItem) {
		itemList.add(getItemListSize(), newItem);
	}
	
	public void removeItemFromList() {
		itemList.clear();
	}
	
	public int getItemListSize() {
		return itemList.size();
	}

	public StartUpItemManager() {
		clearItemList();
	}
}