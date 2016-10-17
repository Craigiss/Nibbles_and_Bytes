package com.nb.gnome.mangers.offline;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Category;
import com.nb.gnome.managers.CategoryRepository;

import gnome.InitialData;
@Default
@Stateless
public class CategoryRepositoryOffline implements CategoryRepository {
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistCategory(Category c) {
		initialData.addCategory(c);
	}

	@Override
	public Category findCategory(Category c) {
		for(Category cat : initialData.getCategories())
		{
			if( cat.getId() == c.getId())
			{
				return cat;
			}
		}
		return null;
	}
	
	@Override
	public void updateCategory(Category c) {
		for(Category cat : initialData.getCategories())
		{
			if( cat.getId() == c.getId())
			{
				cat.setId(c.getId());
				cat.setName(c.getName());
			}
		}
	}

}
