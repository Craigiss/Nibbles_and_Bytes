package com.nb.gnome.mangers.online;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.ISAccount;
import com.nb.gnome.managers.ISAccountRepository;
import com.nb.gnome.managers.hib.ObjectConverter;

import connection.Connection;
@Default
@Stateless
public class ISAccountRepositoryOnline implements ISAccountRepository{
	
	@Inject
	private Connection connection;

	@Inject
	private ObjectConverter converter;
	@Override
	public void persistISAccount(ISAccount isa) {
		connection.persistData(isa);
	}

	@Override
	public ISAccount findISAccountByEmail(String email) {
		ISAccount is = new ISAccount();
		for (ISAccount isa : converter.convertToISA(connection.returnData("Staff"))){
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
