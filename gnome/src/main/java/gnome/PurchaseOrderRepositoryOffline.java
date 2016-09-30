package gnome;

import java.util.List;

import javax.inject.Inject;

import com.nb.gnome.entities.PurchaseOrder;

public class PurchaseOrderRepositoryOffline implements PurchaseOrderRepository {
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistPurchaseOrder(PurchaseOrder a) {
		initialData.addPurchaseOrder(a);
	}
	@Override
	public List<PurchaseOrder> findPurchaseOrder() {
		
		return initialData.getPurchaseOrders();
	}
		
}
