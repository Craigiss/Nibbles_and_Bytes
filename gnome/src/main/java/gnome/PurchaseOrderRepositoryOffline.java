package gnome;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;


import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
import com.nb.gnome.entities.Supplier;
@Stateless
@Default
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
	public PurchaseOrder findPurchaseOrderById(long id) {
		for(PurchaseOrder p : initialData.getPurchaseOrders()){
			if(p.getId() == id){
				//list.add(a);
				return p;
			}
		}
		return null;
		
		
}
	@Override
	public List<PurchaseOrder> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
