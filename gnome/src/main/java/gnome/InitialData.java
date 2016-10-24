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
		s1.setCompany("LawnFlamingosWholesale");
		s1.setId(001);
		s1.setName("Augustine Loris Poutine III");
		s1.setPhone("01645839242");
		s1.setEmail("mynameisaugustineandmyparentslovepoutine@lawnflamingoswholesale.lol");
		suppliers.add(s1);
		
		Supplier s2 = new Supplier();
		s2.setCompany("JacuzziBabies");
		s2.setId(002);
		s2.setName("Howard Schultz");
		s2.setPhone("07483627292");
		s2.setEmail("hottubsareawesome@jacuzzibabies.com");
		suppliers.add(s2);
		
		Supplier s3 = new Supplier();
		s3.setCompany("SensiblerMiddleAgedHomeOwners");
		s3.setId(003);
		s3.setName("Maurice 'the madman' Mortimer");
		s3.setPhone("026492672555");
		s3.setEmail("iwillsellyouverysensiblelawnornamentsatareasonableprice@madmansales.com");
		suppliers.add(s3);
		
		PurchaseOrder po1 = new PurchaseOrder();
		po1.setId(001);
		po1.setDate(new Date(2016,05,01));
		po1.setStatus("Archived");
		po1.setSupplier(s1);
		purchaseOrders.add(po1);
		
		PurchaseOrder po2 = new PurchaseOrder();
		po2.setId(002);
		po2.setDate(new Date(2016,11,22));
		po2.setStatus("Waiting Payment");
		purchaseOrders.add(po2);
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
