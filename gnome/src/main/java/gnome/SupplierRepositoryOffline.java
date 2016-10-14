package gnome;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Supplier;

@Stateless
@Default
public class SupplierRepositoryOffline implements SupplierRepository{

	@Inject
	private InitialData initialData;

	//Create
	public void persistSupplier(Supplier s){
		initialData.addSupplier(s);
	}

//	//Read
//	public Supplier findSupplierByCompany(String s) {
//		Supplier newOne = new Supplier();
//		for(Supplier company : initialData.getSuppliers()){
//			if (company.getCompany() == s){
//				newOne = company;
//				break;
//			}
//		}
//		return newOne;
//	}
	
	public Supplier findSupplierById(long id){
		return new Supplier();
	}
	
	public List<Supplier> findAll(){
		return new ArrayList<Supplier>();
		
	}

	@Override
	public Supplier findSupplier(Supplier s) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
