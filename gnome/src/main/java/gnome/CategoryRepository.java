package gnome;

import com.nb.gnome.entities.Category;

/**
 * Interface for CategoryRepository 
 * 
 * @author Nibbles and Bytes
 */
public interface CategoryRepository {
	//Create
	public void persistCategory(Category c);
	
	//Read
	public Category findCategory(Category c);
	
	//Update
	public void updateCategory(Category c);// TODO

}
