package gnome;

import java.util.List;

import javax.inject.Inject;

import com.nb.gnome.entities.ISAccount;

public class ISAccountRepositoryOffline implements ISAccountRepository{
	
	@Inject
	private InitialData initialData;

	@Override
	public void persistISAccount(ISAccount isa) {
		initialData.addInventoryStaffAccount(isa);		
	}

	@Override
	public List<ISAccount> findISAccount(ISAccount isa) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void updateISAccountName(ISAccount isa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateISAccountEmail(ISAccount isa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateISAccountPassword(ISAccount isa) {
		// TODO Auto-generated method stub
		
	}

}
