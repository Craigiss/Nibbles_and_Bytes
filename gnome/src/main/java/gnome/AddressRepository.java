package gnome;

import java.util.List;

/**
 * Interface for AddressManager classes
 * AddressManagers will have these methods
 * @author Nibbles and Bytes
 */

public interface AddressRepository {

	//Create
	public void persistAddress(Address a);
	
	//Read
	public List<Address> findCustomerAddresses(CustomerAccount c);

}
