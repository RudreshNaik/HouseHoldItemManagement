package savePackage;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Wrapper class for Inventory class.
@Path("/InventorryAccess")
public class InventorryAccess {
	static Inventory inventory = new Inventory();
	
	@GET
	@Path("/getAllItems")
	@Produces(MediaType.APPLICATION_JSON)
	public static List<Item> callGetAllItems(){
		List<Item> getList = inventory.getAllItems();
		return getList;
	}
	
	@POST
	@Path("/addItem")
	@Produces(MediaType.APPLICATION_JSON)
	public static Response callAddItem(Item item){
		System.out.println(item.getName()+" "+item.getOriginalQty()+" "+item.getRemainingQty()+" "+item.getPurchaseDate()+" "+item.getExpectedFinishDate()+" "+item.getUnitOfItem()+" "+item.getStatusOfItem());
		inventory.addItem(item);
		return Utility.addCrossOriginHeader(null);

	}
	
	@POST
	@Path("/testUrl")
	@Produces(MediaType.APPLICATION_JSON)
	public static Response testMethod(){
		//return Response.status(200).entity(new Item()).header("Access-Control-Allow-Origin", "*").build();
		return Utility.addCrossOriginHeader(null);
		
	}
	
}
