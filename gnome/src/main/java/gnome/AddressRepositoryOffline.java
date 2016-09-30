package gnome;

import javax.inject.Inject;

public class AddressRepositoryOffline implements AddressRepository{
	
	@Inject
	private InitialData initialData;

	//Create
	public void persistAddress(Address a){
		initialData.addAddress(a);
	}
	
}
