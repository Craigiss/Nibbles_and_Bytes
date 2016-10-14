/**
 * 
 */
package gnome;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Category;
import com.nb.gnome.entities.Product;


/**
 * Offline Class for Product

 * @author Nibbles and Bytes
 */
@Default
@Stateless
public class ProductRepositoryOffline implements ProductRepository {
	@Inject
	private InitialData initialData;
	
	//Create
	public void persistProduct(Product p){
		initialData.addProduct(p);
	}
	
	//Read
	public List<Product> getProductByKeyword(String keyword){
		List<Product> p = initialData.getProducts();
		
		
		return(p);
	}
	
	public List<Product> getProductByName(String name){
		ArrayList<Product> p = new ArrayList<Product>();
		
		return(p);
	}
	
	public List<Category> getProductCategories(){
		ArrayList<Category> c = new ArrayList<Category>();
		
		return(c);
	}
	
	public Product getProductByID(int id){
		Product p = new Product();
		return (p);
	}
	
	public int getStockLevel(int id){
		int stockLevel = 0;
		
		return(stockLevel);
	}
	
	//Update
	public void incrementStock(int id, int quantity){
		
	}
	
	public void decrementStock(int id, int quantity){
		
	}
	
    public List<Product> findAll(){
    	List<Product> p = initialData.getProducts();
    	return p;
    	
    }
	
	

	
}
