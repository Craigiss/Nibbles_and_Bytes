package gnome;

import java.util.List;

/**
 * Interface for PurchaseOrderManager classes
 * PurchaseOrderManagers will have these methods
 * @author Nibbles and Bytes
 */

public interface PurchaseOrderRepository {
		//Create
		public void persistPurchaseOrder(PurchaseOrder a);
		//Read
		public List<PurchaseOrder> findPurchaseOrder();
}
