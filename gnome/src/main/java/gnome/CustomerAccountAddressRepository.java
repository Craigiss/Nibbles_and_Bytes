package gnome;

import java.util.List;

import com.nb.gnome.entities.Address;

/**
 * Interface for CustomerAccountAddress classes AddressManagers will have these methods
 * 
 * @author Nibbles and Bytes
 */
public interface CustomerAccountAddressRepository {

	// Create
	public void persistCustomerAddress(Address a);



}
