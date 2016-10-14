package gnome;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Supplier;

@Default
public class SupplierRepositoryOffline {

	@Inject
	private InitialData initialData;

	//Create
	public void persistSupplier(Supplier s){
		initialData.addSupplier(s);
	}

	//Read
	public Supplier findSupplierByCompany(String s) {
		Supplier newOne = new Supplier();
		for(Supplier company : initialData.getSuppliers()){
			if (company.getCompany() == s){
				newOne = company;
				break;
			}
		}
		return newOne;
	}
	
}
