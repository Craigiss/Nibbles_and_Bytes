package gnome;

import java.util.List;

import com.nb.gnome.entities.*;

/**
 * Interface for CategoryRepository 
 * 
 * @author Nibbles and Bytes
 */
public interface CategoryRepository {
	//Create
	public void persistCategory(Category c);
	
	//Read
	public List<Address> findCategory(Category c);
	
	//Update
	public void updateCategory(Category c);// TODO

}
