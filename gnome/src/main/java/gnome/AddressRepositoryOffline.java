package gnome;

import java.util.List;

import javax.inject.Inject;

public class AddressRepositoryOffline implements AddressRepository{
	
	@Inject
	private InitialData initialData;

	//Create
	public void persistAddress(Address a){
		initialData.addAddress(a);
	}

	public List<Address> findCustomerAddresses(CustomerAccount c) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
