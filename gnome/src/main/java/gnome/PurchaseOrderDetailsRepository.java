package gnome;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.PurchaseOrderDetails;

public interface PurchaseOrderDetailsRepository {
	
	//Create
	public void persistPOD(PurchaseOrderDetails pod);
	
	//Read
	public Product getPODProduct(PurchaseOrderDetails pod);
	public int getPODQuantity(PurchaseOrderDetails pod);

}
