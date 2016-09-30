package gnome;

public interface PurchaseOrderDetailsRepository {
	
	//Create
	public void persistPOD(PurchaseOrderDetails pod);
	
	//Read
	public Product getPODProduct(PurchaseOrderDetails pod);
	public int getPODQuantity(PurchaseOrderDetails pod);

}
