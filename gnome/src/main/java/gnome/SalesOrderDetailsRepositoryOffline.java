package gnome;

import javax.inject.Inject;

import com.nb.gnome.entities.SalesOrderDetails;

public class SalesOrderDetailsRepositoryOffline {

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
	
}
