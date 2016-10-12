package gnome;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
import com.nb.gnome.entities.Supplier;

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
	@Override
	public PurchaseOrder getPurchaseOrderById(PurchaseOrder a) {
		for(PurchaseOrder p : initialData.getPurchaseOrders()){
			if(p.getId() == a.getId()){
				list.add(a);
			}
		
	}
		
}
}
