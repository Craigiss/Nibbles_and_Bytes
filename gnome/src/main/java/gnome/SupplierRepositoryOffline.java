package gnome;

import java.util.List;

import javax.inject.Inject;

import com.nb.gnome.entities.Supplier;

public class SupplierRepositoryOffline {

	@Inject
	private InitialData initialData;

	//Create
	public void persistSupplier(Supplier s){
		initialData.addSupplier(s);
	}

	//Read
	public Supplier findSupplierByName(String s) {
		do{
			
		}while(Supplier.getName()!=s);
		return null;
	}
	
	//Update
	public void updateSupplier(Supplier s) {
		
	}
	
}
