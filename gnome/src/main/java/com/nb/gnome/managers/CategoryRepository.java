package com.nb.gnome.managers;

import com.nb.gnome.entities.*;

/**
 * Interface for CategoryRepository 
 * 
 * @author Nibbles and Bytes
 */
public interface CategoryRepository {
	//Create
	public void persistCategory(Category c);
	
	//Update
	public void updateCategory(Category c);

}
