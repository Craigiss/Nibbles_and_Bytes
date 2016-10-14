package gnome;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.SalesOrderDetails;
@Default
@Stateless
public class SalesOrderDetailsRepositoryOffline implements SalesOrderDetailsRepository {

	@Inject
	private InitialData initialData;

	//Create
	public void persistSalesOrderDetails(SalesOrderDetails s){
		initialData.addSalesOrderDetails(s);
	}

	//Read
	public SalesOrderDetails findSalesOrderDetailsById(int s) {
		SalesOrderDetails newOne = new SalesOrderDetails();
		for(SalesOrderDetails deets : initialData.getSalesOrdersDetails()){
			if (deets.getId() == s){
				newOne = deets;
				break;
			}
		}
		return newOne;
	}

	@Override
	public SalesOrderDetails findSalesOrderDetails(SalesOrderDetails s) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

