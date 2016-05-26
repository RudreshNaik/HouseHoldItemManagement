package savePackage;

import java.util.List;


public class InventorryAccess {
	static Inventory inventory = new Inventory();
	
	public static List<Item> call_getAllItems(){
		return inventory.getAllItems();
	}
	public static void call_addItem(Item item){
		inventory.addItem(item);
	}
}
