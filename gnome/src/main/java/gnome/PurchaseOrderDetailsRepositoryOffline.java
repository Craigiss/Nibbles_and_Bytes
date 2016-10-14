package gnome;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
@Default
@Stateless
public class PurchaseOrderDetailsRepositoryOffline implements PurchaseOrderDetailsRepository{

	@Inject
	private InitialData initialData;
	
	@Override
	public void persistPOD(PurchaseOrderDetails pod) {
		initialData.addPurchaseOrderDetails(pod);
	}

	@Override
	public List<PurchaseOrderDetails> getPurchaseOrderDetails(PurchaseOrder po) {
		ArrayList<PurchaseOrderDetails> list = new ArrayList<PurchaseOrderDetails>();
		
		for(PurchaseOrderDetails p : initialData.getPurchaseOrderDetails()){
			if(p.getPurchaseOrder().getId() == po.getId()){
				list.add(p);
			}
		}
		return list;
	}

}
