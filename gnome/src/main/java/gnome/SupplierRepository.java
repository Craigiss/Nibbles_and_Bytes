package gnome;

import com.nb.gnome.entities.Supplier;

/**
 * Interface for SupplierManager classes
 * SupplierManagers will have these methods
 * @author Nibbles and Bytes
 */

public interface SupplierRepository {

	//Create
	public void persistSupplier(Supplier s);
	
	//Read
	public Supplier findSupplier(Supplier s);
	
}
