package gnome;

import java.util.List;

import com.nb.gnome.entities.InventoryStaffAccount;

/**
 * Interface for InventoryStaffAccount Manager classes
 * InventoryStaffAccount Managers will have these methods
 * @author Nibbles and Bytes
 */

public interface InventoryStaffAccountRepository {
	
	//Create
	public void persistInventoryStaffAccount(InventoryStaffAccount isa);
	
	//Read
	public List<InventoryStaffAccount> findInventoryStaffAccount(InventoryStaffAccount isa);
	
	//Update
	public void updateInventoryStaffAccountName(InventoryStaffAccount isa);
	public void updateInventoryStaffAccountEmail(InventoryStaffAccount isa);
	public void updateInventoryStaffAccountPassword(InventoryStaffAccount isa);
}
