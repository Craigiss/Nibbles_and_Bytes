package gnome;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.*;
import com.nb.gnome.entities.*;

@Startup
@Singleton
public class InitialData {

	private List<Address> addresses = new ArrayList<Address>();
	private List<Category> categories = new ArrayList<Category>();
	private List<Customer> customers = new ArrayList<Customer>();
	private List<CustomerAccountAddress> customerAccountAddresses = new ArrayList<CustomerAccountAddress>();
	private List<ISAccount> iSAccounts = new ArrayList<ISAccount>();
	private List<Product> products = new ArrayList<Product>();
	private List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
	private List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
	private List<PurchaseOrderDetails> purchaseOrderDetails = new ArrayList<PurchaseOrderDetails>();
	private List<Returns> returns = new ArrayList<Returns>();
	private List<Review> reviews = new ArrayList<Review>();
	private List<SalesOrder> salesOrders = new ArrayList<SalesOrder>();
	private List<SalesOrderDetails> salesOrderDetails = new ArrayList<SalesOrderDetails>();
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	
	public InitialData(){
		Product p1 = new Product();
		p1.setProductName("Lawn Flamingo");
		p1.setProductID(1);
		p1.setDescription("A beautiful pink plastic flamingo to place in your tropical garden");
		p1.setPrice(15.99);
		p1.setStockLevel(115);
		p1.setImgPath("img/Flamingo.gif");
		products.add(p1);
		
		Product p2 = new Product();
		p2.setProductName("Godzilla gnome");
		p2.setProductID(002);
		p2.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p2.setPrice(24.99);
		p2.setStockLevel(115);
		p2.setImgPath("img/gnomezilla.png");
		products.add(p2);
		
		Product p3 = new Product();
		p3.setProductName("Timtim the timmy tim gnome");
		p3.setProductID(003);
		p3.setDescription("tim loves java and being in the garden");
		p3.setPrice(24.99);
		p3.setStockLevel(1015);
		products.add(p3);
		
		Supplier s1 = new Supplier();
		s1.setCompany("Lawn Flamingos Wholesale");
		s1.setId(001);
		s1.setName("Augustine Poutine");
		s1.setPhone("01645839242");
		s1.setEmail("augustine@lawnflamingoswholesale.lol");
		s1.setDescription("These guys sell lawn flamingos in bulk. Low prices but we tend to have their stock for a while."
				+ " Augustine is friendly enough, but don't talk to them about gnomes. They have incredible delivery time, "
				+ "as they are able to ship 1,000 flamingos for next day delivery. This is now a test to see how far down the"
				+ "text will go and if it will collide with the PO table that shows all the POs for this supplier.");
		suppliers.add(s1);
		
		Supplier s2 = new Supplier();
		s2.setCompany("Jacuzzi Babies");
		s2.setId(002);
		s2.setName("Howard Schultz");
		s2.setPhone("07483627292");
		s2.setEmail("hottubsareawesome@jacuzzibabies.com");
		s2.setDescription("This supplier sells great jacuzzis. They have always been reliable, and Howard is always very helpful. Require one week to deliver an order.");
		suppliers.add(s2);
		
		Supplier s3 = new Supplier();
		s3.setCompany("Sensibler Middle Aged Home Owners");
		s3.setId(003);
		s3.setName("Maurice 'the madman' Mortimer");
		s3.setPhone("026492672555");
		s3.setEmail("sensiblelawnornamentsatareasonableprice@madmansales.com");
		s3.setDescription("Good supplier but be careful of Maurice. He can be a bit temperamental at times, so don't haggle too much on the price. "
				+ "Delivery time depends on the size of the order, but should be safe for 3 business days if order quantity is less than 500. ");
		suppliers.add(s3);
		
		//Purchase Orders + Purchase Order Details
		PurchaseOrder po1 = new PurchaseOrder();
		po1.setId(2);
		po1.setDate(new Date(116,10,22));
		po1.setStatus("Archived");
		po1.setSupplier(s1);
		
		PurchaseOrderDetails pod1 = new PurchaseOrderDetails();
		pod1.setProduct(p1);
		pod1.setQuantity(2);
		pod1.setPurchaseOrder(po1);
		purchaseOrderDetails.add(pod1);
		
		PurchaseOrderDetails pod2 = new PurchaseOrderDetails();
		pod2.setProduct(p2);
		pod2.setQuantity(1);
		pod2.setPurchaseOrder(po1);
		purchaseOrderDetails.add(pod2);

		purchaseOrders.add(po1);
		
		PurchaseOrder po2 = new PurchaseOrder();
		po2.setId(6);
		po2.setDate(new Date(116,10,19));
		po2.setStatus("Waiting Payment");
		po2.setSupplier(s1);
		
		PurchaseOrderDetails pod3 = new PurchaseOrderDetails();
		pod3.setProduct(p3);
		pod3.setQuantity(1);
		pod3.setPurchaseOrder(po2);
		purchaseOrderDetails.add(pod3);
		
		PurchaseOrderDetails pod4 = new PurchaseOrderDetails();
		pod4.setProduct(p2);
		pod4.setQuantity(1);
		pod4.setPurchaseOrder(po2);
		purchaseOrderDetails.add(pod4);
		
		purchaseOrders.add(po2);
		
		PurchaseOrder po3 = new PurchaseOrder();
		po3.setId(1);
		po3.setDate(new Date(116,10,22));
		po3.setStatus("Archived");
		po3.setSupplier(s1);
		
		PurchaseOrderDetails pod5 = new PurchaseOrderDetails();
		pod5.setProduct(p1);
		pod5.setQuantity(2);
		pod5.setPurchaseOrder(po3);
		purchaseOrderDetails.add(pod5);
		
		PurchaseOrderDetails pod6 = new PurchaseOrderDetails();
		pod6.setProduct(p2);
		pod6.setQuantity(1);
		pod6.setPurchaseOrder(po3);
		purchaseOrderDetails.add(pod6);

		purchaseOrders.add(po3);
		
		//Inventory Staff Account details
		
		ISAccount isa1 = new ISAccount();
		isa1.setEmail("PaulVanDyke@TranceNation.com");
		isa1.setPassword("ilovetrance");
		isa1.setName("Paul Van Dyke");
		iSAccounts.add(isa1);
		
		ISAccount isa2 = new ISAccount();
		isa2.setEmail("CyrilSneer@GreenHavenCottage.com");
		isa2.setPassword("ihateraccoons");
		isa2.setName("Cyril Sneer");
		iSAccounts.add(isa2);
	}
	
	
	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses(){
		return addresses;
	}
	
	/**
	 * Adds an address to the dummy data
	 * @param a Input is new address to be added
	 */
	public void addAddress(Address a){
		addresses.add(a);
	}
	
	/**
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return categories;
	}
	
	/**
	 * Adds a category to the dummy data
	 * @param c Input is new category to be added
	 */
	public void addCategory(Category c){
		categories.add(c);
	}

	/**
	 * @return the customerAccounts
	 */
	public List<Customer> getCustomerAccounts() {
		return customers;
	}
	
	/**
	 * Adds a customer account to the dummy data
	 * @param ca Input is new customer account to be added
	 */
	public void addCustomerAccount(Customer ca){
		customers.add(ca);
	}

	/**
	 * @return the customerAccountAddresses
	 */
	public List<CustomerAccountAddress> getCustomerAccountAddresses() {
		return customerAccountAddresses;
	}
	
	/**
	 * Adds a customer account address to the data set
	 * @param cad Input is new customer account address to be added
	 */
	public void addCustomerAccountAddress(CustomerAccountAddress cad){
		customerAccountAddresses.add(cad);
	}

	/**
	 * @return the inventoryStaffAccounts
	 */
	public List<ISAccount> getInventoryStaffAccounts() {
		return iSAccounts;
	}
	
	/**
	 * Adds an inventory staff account to the data set
	 * @param isa Input is new inventory staff account to be added
	 */
	public void addInventoryStaffAccount(ISAccount isa ){
		iSAccounts.add(isa);
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}
	
	/**
	 * Adds a product to the dummy data
	 * @param p Input is new product to be added
	 */
	public void addProduct(Product p){
		products.add(p);
	}

	/**
	 * @return the productCategories
	 */
	public List<ProductCategory> getProductCategories() {
		return productCategories;
	}
	
	/**
	 * Adds a product category to the dummy data
	 * @param pc Input is new product category to be added
	 */
	public void addProductCategory(ProductCategory pc){
		productCategories.add(pc);
	}

	/**
	 * @return the purchaseOrders
	 */
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}
	
	/**
	 * Adds a purchase order to the dummy data
	 * @param po Input is new purchase order to be added
	 */
	public void addPurchaseOrder(PurchaseOrder po){
		purchaseOrders.add(po);
	}

	/**
	 * @return the purchaseOrdersDetails
	 */
	public List<PurchaseOrderDetails> getPurchaseOrderDetails() {
		return purchaseOrderDetails;
	}
	
	/**
	 * Adds a purchase order line to the dummy data
	 * @param po Input is new purchase order to be added
	 */
	public void addPurchaseOrderDetails(PurchaseOrderDetails pol){
		purchaseOrderDetails.add(pol);
	}

	/**
	 * @return the returns
	 */
	public List<Returns> getReturns() {
		return returns;
	}
	
	/**
	 * Adds a return to the dummy data
	 * @param r Input is new return to be added
	 */
	public void addReturn(Returns r){
		returns.add(r);
	}

	/**
	 * @return the reviews
	 */
	public List<Review> getReviews() {
		return reviews;
	}
	
	/**
	 * Adds a review to the dummy data
	 * @param r Input is new review to be added
	 */
	public void addReview(Review r){
		reviews.add(r);
	}

	/**
	 * @return the salesOrders
	 */
	public List<SalesOrder> getSalesOrders() {
		return salesOrders;
	}
	
	/**
	 * Adds a sales order to the dummy data
	 * @param so Input is new sales order to be added
	 */
	public void addSalesOrder(SalesOrder so){
		salesOrders.add(so);
	}

	/**
	 * @return the salesOrderDetails
	 */
	public List<SalesOrderDetails> getSalesOrdersDetails() {
		return salesOrderDetails;
	}
	
	/**
	 * Adds a sales order details to the dummy data
	 * @param sod Input is new sales order details to be added
	 */
	public void addSalesOrderDetails(SalesOrderDetails sod){
		salesOrderDetails.add(sod);
	}

	/**
	 * @return the suppliers
	 */
	public List<Supplier> getSuppliers() {
		return suppliers;
	}
	
	/**
	 * Adds a supplier to the dummy data
	 * @param s Input is new supplier to be added
	 */
	public void addSupplier(Supplier s){
		suppliers.add(s);
	}

}
