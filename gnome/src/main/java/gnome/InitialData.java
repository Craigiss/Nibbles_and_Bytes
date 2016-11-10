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
	private List<ISAccount> iSAccounts = new ArrayList<ISAccount>();
	private List<Product> products = new ArrayList<Product>();
	private List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
	private List<PurchaseOrderDetails> purchaseOrderDetails = new ArrayList<PurchaseOrderDetails>();
	private List<Supplier> suppliers = new ArrayList<Supplier>();

	public InitialData(){
	/*
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
		s1.setAddress(new Address("1 Test Road", "second line", "Test Town", "Test County", "Test Postcode"));
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
		s3.setEmail("sensiblelawnornaments@madmansales.com");
		s3.setDescription("Good supplier but be careful of Maurice. He can be a bit temperamental at times, so don't haggle too much on the price. "
				+ "Delivery time depends on the size of the order, but should be safe for 3 business days if order quantity is less than 500. ");
		suppliers.add(s3);
		
		Product p1 = new Product();
		p1.setProductName("Lawn Flamingo");
		p1.setProductID(1);
		p1.setDescription("A beautiful pink plastic flamingo to place in your tropical garden A beautiful pink plastic flamingo to place in your tropical garden A beautiful pink plastic flamingo to place in your tropical garden A beautiful pink plastic flamingo to place in your tropical garden A beautiful pink plastic flamingo to place in your tropical garden A beautiful pink plastic flamingo to place in your tropical garden A beautiful pink plastic flamingo to place in your tropical garden ");
		p1.setPrice(15.99);
		p1.setStockLevel(5);
		p1.setPorousStockLevel(15);
		p1.setImgPath("../img/Flamingo.gif");
		p1.setSupplier(s1);
		products.add(p1);
		s1.getProducts().add(p1);
		
		Product p2 = new Product();
		p2.setProductName("Godzilla gnome");
		p2.setProductID(002);
		p2.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden A giant lizard beast perfect for keeping pesky cats out of your garden A giant lizard beast perfect for keeping pesky cats out of your garden A giant lizard beast perfect for keeping pesky cats out of your garden A giant lizard beast perfect for keeping pesky cats out of your garden A giant lizard beast perfect for keeping pesky cats out of your garden A giant lizard beast perfect for keeping pesky cats out of your garden A giant lizard beast perfect for keeping pesky cats out of your garden A giant lizard beast perfect for keeping pesky cats out of your garden ");
		p2.setPrice(24.99);
		p2.setStockLevel(115);
		p2.setPorousStockLevel(6);
		p2.setImgPath("../img/gnomezilla.png");
		p2.setSupplier(s1);
		products.add(p2);
		s1.getProducts().add(p2);
		
		Product p3 = new Product();
		p3.setProductName("Mr and Mrs Gnome");
		p3.setProductID(003);
		p3.setDescription("When these gnomes are rockin', don't come-a-knockin'!!");
		p3.setPrice(14.99);
		p3.setStockLevel(10);
		p3.setPorousStockLevel(8);
		p3.setImgPath("../img/MrandMrs.gif");
		products.add(p3);
		
		Product p4 = new Product();
		p4.setProductName("Gnome Of Gnomes - Ned Gnome");
		p4.setProductID(004);
		p4.setDescription("Dont lose your head!");
		p4.setPrice(14.99);
		p4.setStockLevel(1);
		p4.setPorousStockLevel(8);
		p4.setImgPath("../img/GameofGnomes.jpg");
		p4.setSupplier(s3);
		products.add(p4);
		s3.getProducts().add(p4);
		
		Product p5 = new Product();
		p5.setProductName("Gnome Trek - Kirk & Spok");
		p5.setProductID(005);
		p5.setDescription("Travelling where no gnome has gone before!");
		p5.setPrice(20.99);
		p5.setStockLevel(6);
		p5.setPorousStockLevel(3);
		p5.setSupplier(s3);
		p5.setImgPath("../img/gnome_trek_set.png");
		products.add(p5);
		s3.getProducts().add(p5);
		
		Product p6 = new Product();
		p6.setProductName("Benny - Gnomeo&Juliet");
		p6.setProductID(006);
		p6.setDescription("Tragic Gnomes");
		p6.setPrice(12.99);
		p6.setStockLevel(7);
		p6.setPorousStockLevel(1);
		p6.setSupplier(s3);
		p6.setImgPath("../img/benny.png");
		products.add(p6);
		s3.getProducts().add(p6);
		
		//Purchase Orders + Purchase Order Details
		List<PurchaseOrderDetails> listOfPOD = new ArrayList<PurchaseOrderDetails>();
		
		PurchaseOrder po1 = new PurchaseOrder();
		po1.setId(2);
		po1.setDate(new Date(116,10,22));
		po1.setStatus("Archived");
		po1.setSupplier(s1);
		
		PurchaseOrderDetails pod1 = new PurchaseOrderDetails();
		pod1.setProduct(p1);
		pod1.setQuantity(40);
		listOfPOD.add(pod1);
		purchaseOrderDetails.add(pod1);
		
		PurchaseOrderDetails pod2 = new PurchaseOrderDetails();
		pod2.setProduct(p2);
		pod2.setQuantity(20);
		listOfPOD.add(pod2);
		purchaseOrderDetails.add(pod2);

		po1.setLines(listOfPOD);
		purchaseOrders.add(po1);
		
		PurchaseOrder po2 = new PurchaseOrder();
		po2.setId(6);
		po2.setDate(new Date(116,10,19));
		po2.setStatus("Waiting Payment");
		po2.setSupplier(s1);
		
		PurchaseOrderDetails pod3 = new PurchaseOrderDetails();
		pod3.setProduct(p3);
		pod3.setQuantity(30);
		listOfPOD.add(pod3);
		purchaseOrderDetails.add(pod3);
		
		PurchaseOrderDetails pod4 = new PurchaseOrderDetails();
		pod4.setProduct(p4);
		pod4.setQuantity(35);
		listOfPOD.add(pod4);
		purchaseOrderDetails.add(pod4);
		
		po2.setLines(listOfPOD);
		purchaseOrders.add(po2);
		
		PurchaseOrder po3 = new PurchaseOrder();
		po3.setId(1);
		po3.setDate(new Date(116,10,22));
		po3.setStatus("Archived");
		po3.setSupplier(s1);
		
		PurchaseOrderDetails pod5 = new PurchaseOrderDetails();
		pod5.setProduct(p5);
		pod5.setQuantity(25);
		listOfPOD.add(pod5);
		purchaseOrderDetails.add(pod5);

		po3.setLines(listOfPOD);
		purchaseOrders.add(po3);
		
		PurchaseOrder po4 = new PurchaseOrder();
		po4.setId(9);
		po4.setDate(new Date(116,11,4));
		po4.setStatus("Archived");
		po4.setSupplier(s3);
		
		PurchaseOrderDetails pod7 = new PurchaseOrderDetails();
		pod7.setProduct(p6);
		pod7.setQuantity(15);
		listOfPOD.add(pod7);
		purchaseOrderDetails.add(pod7);
		
		po4.setLines(listOfPOD);
		purchaseOrders.add(po4);
		
		//Inventory Staff Account details
		
		ISAccount isa1 = new ISAccount();
		isa1.setEmail("PaulVanDyke@TranceNation.com");
		isa1.setPassword("24871d06dc1dcb6614c7a0dc0f678d53390de44796500c1ca000624471b03c39");
		isa1.setName("Paul Van Dyke");
		isa1.setAdmin(false);
		isa1.setSalt("Y83naas£$Bklaf");
		isa1.setRole("user");
		iSAccounts.add(isa1);
		
		ISAccount isa2 = new ISAccount();
		isa2.setEmail("CyrilSneer@GreenHavenCottage.com");
		isa2.setPassword("d7d18c04d2eab7deeb363b8c89fb68618e2be0ea34686e085313c627ea4c513a");
		isa2.setName("Cyril Sneer");
		isa2.setAdmin(false);
		isa2.setSalt("IU(979qh097asith");
		isa2.setRole("user");
		iSAccounts.add(isa2);
		
		ISAccount isa3 = new ISAccount();
		isa3.setEmail("admin");
		isa3.setPassword("6bcf7af8f331e857e69c4a7a748742e549cb1d3af9f4bf920a75a23fbd006ae8");
		isa3.setName("admin");
		isa3.setAdmin(true);
		isa3.setSalt("42");
		isa3.setRole("admin");
		iSAccounts.add(isa3);*/
	}

	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * Adds an address to the dummy data
	 * 
	 * @param a
	 *            Input is new address to be added
	 */
	public void addAddress(Address a) {
		addresses.add(a);
	}

	/**
	 * @return the inventoryStaffAccounts
	 */
	public List<ISAccount> getISAccounts() {
		return iSAccounts;
	}

	/**
	 * Adds an inventory staff account to the data set
	 * 
	 * @param isa
	 *            Input is new inventory staff account to be added
	 */
	public void addISAccount(ISAccount isa) {
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
	 * 
	 * @param p
	 *            Input is new product to be added
	 */
	public void addProduct(Product p) {
		products.add(p);
	}

	/**
	 * @return the purchaseOrders
	 */
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}

	/**
	 * Adds a purchase order to the dummy data
	 * 
	 * @param po
	 *            Input is new purchase order to be added
	 */
	public void addPurchaseOrder(PurchaseOrder po) {
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
	 * 
	 * @param po
	 *            Input is new purchase order to be added
	 */
	public void addPurchaseOrderDetails(PurchaseOrderDetails pol) {
		purchaseOrderDetails.add(pol);
	}

	/**
	 * @return the suppliers
	 */
	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	/**
	 * Adds a supplier to the dummy data
	 * 
	 * @param s
	 *            Input is new supplier to be added
	 */
	public void addSupplier(Supplier s) {
		suppliers.add(s);
	}

}
