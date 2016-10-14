package gnome;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Address;
@Default
@Stateless
public class AddressRepositoryOffline implements AddressRepository{
	
	@Inject
	private InitialData initialData;

	//Create
	@Override
	public void persistAddress(Address a){
		initialData.addAddress(a);
	}
	
	//Read method called from Customer
	//Update or delete methods are not necessary
}
