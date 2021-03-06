package com.nb.gnome.mangers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Customer;
import com.nb.gnome.entities.ISAccount;
import com.nb.gnome.managers.ISAccountRepository;

import gnome.InitialData;
@Default
@Stateless
public class ISAccountRepositoryOffline implements ISAccountRepository{
	
	@Inject
	private InitialData initialData;

	@Override
	public void persistISAccount(ISAccount isa) {
		initialData.addInventoryStaffAccount(isa);		
	}

	@Override
	public ISAccount findISAccountByEmail(String email) {
		ISAccount is = new ISAccount();
		for (ISAccount isa : initialData.getInventoryStaffAccounts()){
			if (isa.getEmail().equals(email))
			{
				is = isa;
			}
		}
		return is;
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
