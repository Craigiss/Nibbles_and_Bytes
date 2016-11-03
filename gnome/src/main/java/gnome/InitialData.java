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
	private List<Address> addresses2 = new ArrayList<Address>();
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
																						// Addresses
		Address aa = new Address();
		aa.setLine1("95 Crowborough Lane");
		aa.setLine2("Kents Hill");
		aa.setTown("Milton Keynes");
		aa.setCounty("Bucks");
		aa.setPostcode("mk76jn");
		aa.setId(1);
		addresses.add(aa);
		
		Address aa1 = new Address();
		aa1.setLine1("First Line2");
		aa1.setLine2("Second Line2");
		aa1.setTown("Town2");
		aa1.setCounty("County2");
		aa1.setPostcode("Post code2");
		aa1.setId(2);
		addresses.add(aa1);		
		
		/*Address aa2 = new Address();
		aa2.setLine1("First Line3");
		aa2.setLine2("Second Line3");
		aa2.setTown("Town3");
		aa2.setCounty("County3");
		aa2.setPostcode("Post code3");
		aa2.setId(3);
		addresses.add(aa2);
		
		Address aa3 = new Address();
		aa3.setLine1("26 Chadwick Road");
		aa3.setLine2("Eccles");
		aa3.setTown("Manchester");
		aa3.setCounty("Manchester");
		aa3.setPostcode("M30 0NZ");
		aa3.setId(4);
		addresses.add(aa3);
		
		addresses2.add(aa3);*/
		
																						// Customers
		Customer cu = new Customer();
		cu.setEmail("Email");
		cu.setFirstName("firstName");
		cu.setSurname("surname");
		cu.setAddresses(addresses);
		cu.setPassword("password");
		cu.setId(1);
		customers.add(cu);
		
		Customer cu2 = new Customer();
		cu2.setEmail("cameron@smart.com");
		cu2.setFirstName("Cameron");
		cu2.setSurname("Smart");
		cu2.setAddresses(addresses2);
		cu2.setPassword("goaway");
		cu2.setId(2);
		customers.add(cu2);
		
		
																						// Customer <-> Address
		
		CustomerAccountAddress caa1 = new CustomerAccountAddress();
		caa1.setUsername(cu);
		List<Address> cuAddr = new ArrayList<Address>();
		cuAddr.add(aa);
		cuAddr.add(aa1);
		caa1.setAddress(cuAddr);				// Cameron | Not sure which one to use yet to link customer to addresses?
		cu.setAddresses(cuAddr);
		
																						// Sales orders
		SalesOrder sO1 = new SalesOrder();
		sO1.setId(1);
		sO1.setDate("11/12/2016");
		sO1.setCustomer(cu);
		sO1.setStatus("Delivered");
		salesOrders.add(sO1);
		SalesOrder sO2 = new SalesOrder();
		sO2.setId(2);
		sO2.setDate("12/12/2016");
		sO2.setStatus("Processing");
		sO2.setCustomer(cu);
		salesOrders.add(sO2);
																						// Reviews
		Review r1 = new Review();
		r1.setProductID(1);
		r1.setDate("11/12/2016");
		r1.setRating(4);
		r1.setReviewText(" Perfect for my garden 1");
		reviews.add(r1);
		Review r2 = new Review();
		r2.setProductID(1);
		r2.setDate("11/12/2016");
		r2.setRating(4);
		r2.setReviewText(" Perfect for my garden 2");
		reviews.add(r2);
		Review r3 = new Review();
		r3.setProductID(1);
		r3.setDate("11/12/2016");
		r3.setRating(4);
		r3.setReviewText(" Perfect for my garden 3");
		reviews.add(r3);
		
		Category c1 = new Category();													// Categories
		c1.setId(001);
		c1.setName("Gnomes");
		
		Category c2 = new Category();
		c2.setId(002);
		c2.setName("PoolsAndHotTubs");
		
		Category c3 = new Category();
		c3.setId(003);
		c3.setName("GnomeAccessories");
		
		Category c4 = new Category();
		c4.setId(004);
		c4.setName("GardenOrnaments");
		
		Category c5 = new Category();
		c5.setId(005);
		c5.setName("GnomeCare");
		
		categories.add(c1);
		categories.add(c2);
		categories.add(c3);
		categories.add(c4);
		categories.add(c5);
																						// Products
		Product p1 = new Product();
		p1.setProductName("King of the 7 Gnomedoms");
		p1.setProductID(1);
		p1.setImgPath("img/GameofGnomes.jpg");
		p1.setDescription("Every now and again a piece of wordplay comes along that's so sumptuous, so irresistible that it would be a travesty to not bring it to life (Robocup anyone?). We present to you... Game of Gnomes. The original may have been forged from a thousand swords in the fiery exhalation of a dragon named 'Balerion the Black Dread', but this slightly diminutive version is appropriately made up of an assortment of rusty gardening tools.");
		p1.setPrice(17.99);
		p1.setStockLevel(115);
		products.add(p1);
		
		
		Product p2 = new Product();
		p2.setProductName("The Laundry Line");
		p2.setProductID(2);
		p2.setImgPath("img/Laundry.gif");
		p2.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p2.setPrice(2.99);
		p2.setStockLevel(115);
		products.add(p2);
		
		Product p3 = new Product();
		p3.setProductName("Gnome Trek Set");
		p3.setProductID(3);
		p3.setImgPath("img/GnomeTrek.gif");
		p3.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p3.setPrice(4.99);
		p3.setStockLevel(115);
		products.add(p3);
		
		Product p4 = new Product();
		p4.setProductName("Minimushrooms");
		p4.setProductID(4);
		p4.setImgPath("img/mushrooms.gif");
		p4.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p4.setPrice(24.99);
		p4.setStockLevel(115);
		products.add(p4);
		
		Product p5 = new Product();
		p5.setProductName("Mr and Mrs");
		p5.setProductID(5);
		p5.setImgPath("img/MrandMrs.gif");
		p5.setDescription("when these gnomes are rockin', don't come-a-knockin'!!!");
		p5.setPrice(7.99);
		p5.setStockLevel(8008135);
		products.add(p5);
		
		Product p6 = new Product();
		p6.setProductName("Christmas Boots");
		p6.setProductID(6);
		p6.setImgPath("img/Boots.gif");
		p6.setDescription("a snazzy pair of sneaks for the Christmas gimp");
		p6.setPrice(4.99);
		p6.setStockLevel(8008135);
		products.add(p6);
		
		Product p7 = new Product();
		p7.setProductName("Lawn Flamingo");
		p7.setProductID(7);
		p7.setImgPath("img/Flamingo.gif");
		p7.setDescription("a dainty pair of Tim's favourite lawn ornaments");
		p7.setPrice(14.99);
		p7.setStockLevel(8008135);
		products.add(p7);
		
		Product p8 = new Product();
		p8.setProductName("Benny");
		p8.setProductID(8);
		p8.setImgPath("img/Benny.gif");
		p8.setDescription("the worst gnome in existence; the dumpy little guy from gnomeo and juliet");
		p8.setPrice(8.99);
		p8.setStockLevel(8008135);
		products.add(p8);
		
		Product p11 = new Product();
		p11.setProductName("King of the 7 Gnomedoms");
		p11.setProductID(11);
		p11.setImgPath("img/GameofGnomes.jpg");
		p11.setDescription("Every now and again a piece of wordplay comes along that's so sumptuous, so irresistible that it would be a travesty to not bring it to life (Robocup anyone?). We present to you... Game of Gnomes. The original may have been forged from a thousand swords in the fiery exhalation of a dragon named 'Balerion the Black Dread', but this slightly diminutive version is appropriately made up of an assortment of rusty gardening tools.");
		p11.setPrice(17.99);
		p11.setStockLevel(115);
		products.add(p11);
		
		Product p12 = new Product();
		p12.setProductName("The Laundry Line");
		p12.setProductID(12);
		p12.setImgPath("img/Laundry.gif");
		p12.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p12.setPrice(2.99);
		p12.setStockLevel(115);
		products.add(p12);
		
		Product p13 = new Product();
		p13.setProductName("Gnome Trek Set");
		p13.setProductID(13);
		p13.setImgPath("img/GnomeTrek.gif");
		p13.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p13.setPrice(4.99);
		p13.setStockLevel(115);
		
		products.add(p13);
		
		Product p14 = new Product();
		p14.setProductName("Minimushrooms");
		p14.setProductID(14);
		p14.setImgPath("img/mushrooms.gif");
		p14.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p14.setPrice(24.99);
		p14.setStockLevel(115);
		products.add(p14);
		
		Product p15 = new Product();
		p15.setProductName("Mr and Mrs");
		p15.setProductID(15);
		p15.setImgPath("img/MrandMrs.gif");
		p15.setDescription("when these gnomes are rockin', don't come-a-knockin'!!!");
		p15.setPrice(7.99);
		p15.setStockLevel(8008135);
		products.add(p15);
		
		Product p16 = new Product();
		p16.setProductName("Christmas Boots");
		p16.setProductID(16);
		p16.setImgPath("img/Boots.gif");
		p16.setDescription("a snazzy pair of sneaks for the Christmas gimp");
		p16.setPrice(4.99);
		p16.setStockLevel(8008135);
		products.add(p16);
		
		Product p17 = new Product();
		p17.setProductName("Lawn Flamingo");
		p17.setProductID(17);
		p17.setImgPath("img/Flamingo.gif");
		p17.setDescription("a dainty pair of Tim's favourite lawn ornaments");
		p17.setPrice(14.99);
		p17.setStockLevel(8008135);
		products.add(p17);
		
		Product p18 = new Product();
		p18.setProductName("Benny");
		p18.setProductID(18);
		p18.setImgPath("img/Benny.gif");
		p18.setDescription("the worst gnome in existence; the dumpy little guy from gnomeo and juliet");
		p18.setPrice(8.99);
		p18.setStockLevel(8008135);
		products.add(p18);
		
		Product p19 = new Product();
		p19.setProductName("Westbury Pool Table");
		p19.setProductID(19);
		p19.setImgPath("img/westburyPoolTable019.jpg");
		p19.setDescription("Dive into the pool table of pure magnificence.");
		p19.setPrice(209.99);
		p19.setStockLevel(8008135);
		products.add(p19);
		
																							// Product Categories
		ProductCategory pc1 = new ProductCategory();
		pc1.setCategoryID(001);
		pc1.setProductID(1);
		
		ProductCategory pc2 = new ProductCategory();
		pc2.setCategoryID(001);
		pc2.setProductID(2);
		
		ProductCategory pc3 = new ProductCategory();
		pc3.setCategoryID(001);
		pc3.setProductID(3);
		
		ProductCategory pc4 = new ProductCategory();
		pc4.setCategoryID(001);
		pc4.setProductID(4);
		
		ProductCategory pc5 = new ProductCategory();
		pc5.setCategoryID(001);
		pc5.setProductID(5);
		
		ProductCategory pc6 = new ProductCategory();
		pc6.setCategoryID(001);
		pc6.setProductID(6);
		
		ProductCategory pc7 = new ProductCategory();
		pc7.setCategoryID(001);
		pc7.setProductID(7);
		
		ProductCategory pc8 = new ProductCategory();
		pc8.setCategoryID(002);
		pc8.setProductID(19);
		
		ProductCategory pc9 = new ProductCategory();
		pc9.setCategoryID(001);
		pc9.setProductID(1);
																								// Product Categories
		productCategories.add(pc1);
		productCategories.add(pc2);
		productCategories.add(pc3);
		productCategories.add(pc4);
		productCategories.add(pc5);
		productCategories.add(pc6);
		productCategories.add(pc7);
		productCategories.add(pc8);
		productCategories.add(pc9);
		
		Supplier s1 = new Supplier();
		s1.setCompany("LawnFlamingosWholesale");
		s1.setId(001);
		s1.setName("Augustine Loris Poutine III");
		s1.setPhone("01645839242");
		s1.setEmail("mynameisaugustineandmyparentslovepoutine@lawnflamingoswholesale.lol");
		suppliers.add(s1);
		
		Supplier s2 = new Supplier();
		s2.setCompany("LawnFlamingosWholesale");
		s2.setId(002);
		s2.setName("Augustine Loris Poutine III");
		s2.setPhone("01645839242");
		s2.setEmail("mynameisaugustineandmyparentslovepoutine@lawnflamingoswholesale.lol");
		suppliers.add(s2);
		
		Supplier s3 = new Supplier();
		s3.setCompany("LawnFlamingosWholesale");
		s3.setId(003);
		s3.setName("Augustine Loris Poutine III");
		s3.setPhone("01645839242");
		s3.setEmail("mynameisaugustineandmyparentslovepoutine@lawnflamingoswholesale.lol");
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
