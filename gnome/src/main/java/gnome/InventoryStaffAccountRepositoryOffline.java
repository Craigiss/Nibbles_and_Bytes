package gnome;

import java.util.List;

import javax.inject.Inject;

import com.nb.gnome.entities.InventoryStaffAccount;

public class InventoryStaffAccountRepositoryOffline implements InventoryStaffAccountRepository{
	
	@Inject
	private InitialData initialData;

	@Override
	public void persistInventoryStaffAccount(InventoryStaffAccount isa) {
		initialData.addInventoryStaffAccount(isa);		
	}

	@Override
	public List<InventoryStaffAccount> findInventoryStaffAccount(InventoryStaffAccount isa) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void updateInventoryStaffAccountName(InventoryStaffAccount isa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInventoryStaffAccountEmail(InventoryStaffAccount isa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInventoryStaffAccountPassword(InventoryStaffAccount isa) {
		// TODO Auto-generated method stub
		
	}

	public void persistInventoryStaffAccount(InventoryStaffAccount isa) {
		// TODO Auto-generated method stub
		
	}

	public List<InventoryStaffAccount> findInventoryStaffAccount(InventoryStaffAccount isa) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateInventoryStaffAccountName(InventoryStaffAccount isa) {
		// TODO Auto-generated method stub
		
	}

	public void updateInventoryStaffAccountEmail(InventoryStaffAccount isa) {
		// TODO Auto-generated method stub
		
	}

	public void updateInventoryStaffAccountPassword(InventoryStaffAccount isa) {
		// TODO Auto-generated method stub
		
	}

}
