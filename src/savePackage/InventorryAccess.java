package savePackage;

import java.util.List;


public class InventorryAccess {
	static Inventory inventory = new Inventory();
	
	protected static List<Item> callGetAllItems(){
		return inventory.getAllItems();
	}
	protected static void callAddItem(Item item){
		inventory.addItem(item);
	}
}
