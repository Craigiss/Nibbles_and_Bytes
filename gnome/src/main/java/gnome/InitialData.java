package gnome;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.*;

@Startup
@Singleton
public class InitialData {

	private List<Address> addresses = new ArrayList<Address>();
	private List<Category> categories = new ArrayList<Category>();
	private List<CustomerAccount> customerAccounts = new ArrayList<CustomerAccount>();
	private List<CustomerAccountAddress> customerAccountAddresses = new ArrayList<CustomerAccountAddress>();
	private List<InventoryStaffAccount> inventoryStaffAccounts = new ArrayList<InventoryStaffAccount>();
	private List<Product> products = new ArrayList<Product>();
	private List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
	private List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
	private List<PurchaseOrderDetails> purchaseOrdersDetails = new ArrayList<PurchaseOrderDetails>();
	private List<Returns> returns = new ArrayList<Returns>();
	private List<Review> reviews = new ArrayList<Review>();
	private List<SalesOrder> salesOrders = new ArrayList<SalesOrder>();
	private List<SalesOrderDetails> salesOrdersDetails = new ArrayList<SalesOrderDetails>();
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	
	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses(){
		return addresses;
	}
	
	/**
	 * Adds an address to the data set
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
	 * @return the customerAccounts
	 */
	public List<CustomerAccount> getCustomerAccounts() {
		return customerAccounts;
	}

	/**
	 * @return the customerAccountAddresses
	 */
	public List<CustomerAccountAddress> getCustomerAccountAddresses() {
		return customerAccountAddresses;
	}

	/**
	 * @return the inventoryStaffAccounts
	 */
	public List<InventoryStaffAccount> getInventoryStaffAccounts() {
		return inventoryStaffAccounts;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @return the productCategories
	 */
	public List<ProductCategory> getProductCategories() {
		return productCategories;
	}

	/**
	 * @return the purchaseOrders
	 */
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}

	/**
	 * @return the purchaseOrdersDetails
	 */
	public List<PurchaseOrderDetails> getPurchaseOrdersDetails() {
		return purchaseOrdersDetails;
	}

	/**
	 * @return the returns
	 */
	public List<Returns> getReturns() {
		return returns;
	}

	/**
	 * @return the reviews
	 */
	public List<Review> getReviews() {
		return reviews;
	}

	/**
	 * @return the salesOrders
	 */
	public List<SalesOrder> getSalesOrders() {
		return salesOrders;
	}

	/**
	 * @return the salesOrdersDetails
	 */
	public List<SalesOrderDetails> getSalesOrdersDetails() {
		return salesOrdersDetails;
	}

	/**
	 * @return the suppliers
	 */
	public List<Supplier> getSuppliers() {
		return suppliers;
	}
	
}
