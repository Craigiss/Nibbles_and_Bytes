package gnome;

import java.util.List;

import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;

/**
 * Interface for PurchaseOrderDetails entity managers
 * @author Nibbles and Bytes
 */

public interface PurchaseOrderDetailsRepository {
	
	//Create
	public void persistPOD(PurchaseOrderDetails pod);
	
	//Read
	public List<PurchaseOrderDetails> getPurchaseOrderDetails(PurchaseOrder po);

}
