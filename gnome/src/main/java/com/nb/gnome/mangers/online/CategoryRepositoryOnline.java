package com.nb.gnome.mangers.online;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Category;
import com.nb.gnome.managers.CategoryRepository;
import com.nb.gnome.managers.hib.ObjectConverter;

import connection.Connection;
@Default
@Stateless
public class CategoryRepositoryOnline implements CategoryRepository {
	@Inject
	private Connection connection;

	@Inject
	private ObjectConverter converter;
	@Override
	public void persistCategory(Category c) {
		connection.persistData(c);
	}

	
	@Override
	public void updateCategory(Category c) {
		for(Category cat : converter.convertToCategory(connection.returnData("Category")))
		{
			if( cat.getId() == c.getId())
			{
				cat.setId(c.getId());
				cat.setName(c.getName());
			}
		}
	}

}
