package gnome;

import java.util.List;

import com.nb.gnome.entities.Review;

/**
 * Interface for PurchaseOrderManager classes
 * PurchaseOrderManagers will have these methods
 * @author Nibbles and Bytes
 */

public interface ReviewRepository {
	//Create
	public void persistReview(Review a);
	//Read
	public List<Review> findReview();
	//Update 
	public void updateReview(Review c); 
	

}
