import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StartUpItemManager
{
	List<StartUpItem> itemList = new ArrayList<StartUpItem>();

	public boolean itemWithThisIdExists(int itemId)
	{
		int i = 0;
		do
		{
			if(itemId == itemList.get(i).getId())
				return true;
			i++;
		} while(i < getItemListSize());
		return false;
	}
	
	public boolean toggleItemStatus(int itemId)
	{
		if(itemWithThisIdExists(itemId))
		{
			boolean changeCompleted = false;
			for(StartUpItem item: getItemList())
			{
				if(itemId == item.getId())
				{
					item.toggleStatus();
					saveItems();
					changeCompleted = true;
					break;
				}
			}
			if(itemWithThisIdExists(itemId) && changeCompleted)
				return true;
			else
				return false;
		}
		return false;
	}

	public void clearItemList()
	{
		itemList.clear();
	}

	public void addItemToList(String newItem)
	{
		itemList.add(new StartUpItem(newItem));
		startItems();
		saveItems();
	}

	public boolean removeItemFromList(int itemId)
	{
		if(itemWithThisIdExists(itemId))
		{
			boolean changeCompleted = false;
			for(StartUpItem item: getItemList())
			{
				if(itemId == item.getId())
				{
					itemList.remove(item);
					saveItems();
					changeCompleted = true;
					break;
				}
			}
			if(itemWithThisIdExists(itemId) && changeCompleted)
				return false;
			else
				return true;
		}
		return false;
	}

	public int getItemListSize()
	{
		return itemList.size();
	}

	public List<StartUpItem> getItemList()
	{
		return itemList;
	}

	public boolean saveItems()
	{
		try
		{
		    FileOutputStream fos = new FileOutputStream("items.dat");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(itemList);
		    oos.close();
		    return true;
		}
		catch (FileNotFoundException e)
		{
		    e.printStackTrace();
		    return false;
		}
		catch (IOException e)
		{
		    e.printStackTrace();
		    return false;
		}
	}

	@SuppressWarnings("unchecked")
	public boolean loadItems()
	{
		try
		{
			File f = new File("items.dat");
			if(!f.exists())
				return false;
		    FileInputStream fis = new FileInputStream("items.dat");
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    Object obj = ois.readObject();
		    ois.close();
		    if (obj instanceof ArrayList)
		    {
		    	itemList = (ArrayList<StartUpItem>) obj;
		    	StartUpItem.id = getItemListSize();
		    }
		    else 
		    {
		    	clearItemList();
		    	return false;
		    }
		    return true;
		}
		catch (FileNotFoundException e)
		{
		    e.printStackTrace();
		    return false;
		}
		catch (IOException e)
		{
		    e.printStackTrace();
		    return false;
		}
		catch (ClassNotFoundException e)
		{
		    e.printStackTrace();
		    return false;
		}
	}

	public void startItems()
	{
		for(StartUpItem item: itemList)
		{
			//executar sequencialmente os que estao activos
			System.out.println("Item: " + item.getId() + " : " + item.getCommand() + " (" + item.getStatus() + ")");
			/*String[] args = new String[] {"/bin/bash", "-c", "gnome-terminal --working-directory=/home/jpguimaraes/project/accounting_provisory & disown"};
			try {
				Process proc = new ProcessBuilder(args).start();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		}
	}

	public StartUpItemManager()
	{
		clearItemList();
		loadItems();
	}
}