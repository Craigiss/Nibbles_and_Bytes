package gnome;

import java.util.List;
import com.nb.gnome.entities.*;
/**
 * Interface for Product classes
 * ProductManager will have these methods
 * @author Nibbles and Bytes
 */

public interface ProductCategoryRepository {
	//Create
	public void persistProduct(Product p);
	
	//Read
	public List<Product> getProductByKeyword(String keyword);
	public List<Product> getProductByName(String name);
	public Product getProductByID(int id);
	public int getStockLevel(int id);
	
	//Update
	public void incrementStock(int id, int quantity);
	public void decrementStock(int id, int quantity); 
	
}
