package connection;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Category;
import com.nb.gnome.entities.Customer;
import com.nb.gnome.entities.ISAccount;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.ProductCategory;

import com.nb.gnome.entities.Review;
import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.entities.SalesOrderDetails;



@Startup
@Singleton
public class Connection {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction tx;

	private void createSession() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/cat");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "broly1");
		
		properties.setProperty("hibernate.show_sql", "true");
		// properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");

		Configuration cfg = new Configuration().addProperties(properties).addAnnotatedClass(Product.class).addAnnotatedClass(ProductCategory.class)
				.addAnnotatedClass(Address.class).addAnnotatedClass(Category.class).addAnnotatedClass(Customer.class).addAnnotatedClass(ISAccount.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(SalesOrder.class).addAnnotatedClass(SalesOrderDetails.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
	}

	public void persistData(Object... objects) {
		createSession();
		tx = session.beginTransaction();
		for (Object b : objects) {
			session.save(b);
		}
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void persistUpdate(Object obj){
		createSession();
		session.update(obj);
		System.out.println("things have happened?");
		tx = session.beginTransaction();
		tx.commit();
		session.close();
		sessionFactory.close();
		}

	public List<Object> returnData(String databaseToQuery) {
		createSession();
		Query query = session.createQuery("from " + databaseToQuery);
		List<Object> returnObjects = query.list();
		session.close();
		sessionFactory.close();
		return returnObjects;
	}

	@PostConstruct
	public void init() {
		
		
		Address aa = new Address();
		aa.setLine1("95 Crowborough Lane");
		aa.setLine2("Kents Hill");
		aa.setTown("Milton Keynes");
		aa.setCounty("Bucks");
		aa.setPostcode("mk76jn");
		
		Address aa1 = new Address();
		aa1.setLine1("First Line2");
		aa1.setLine2("Second Line2");
		aa1.setTown("Town2");
		aa1.setCounty("County2");
		aa1.setPostcode("Postcode");
			
																						// Customers
		Customer cu = new Customer();
		cu.setTitle("Mr");
		cu.setEmail("Email");
		cu.setFirstName("firstName");
		cu.setSurname("surname");
		cu.setPassword("password");
		//cu.setId(1);
		cu.setSalt("ks93t1dq74tec1jpua15effjh3");
		cu.setPhoneNumber("0123456789");
		cu.setStatus("Active");
		List<Address> cuad = new ArrayList<Address>();
		cuad.add(aa1);
		cu.setAddresses(cuad);
		
		Customer cu2 = new Customer();
		cu2.setTitle("Mr");
		cu2.setEmail("cameron@smart.com");
		cu2.setFirstName("Cameron");
		cu2.setSurname("Smart");
		cu2.setPassword("goaway");
		//cu2.setId(2);
		cu2.setSalt("ks93t1dq74tec1jpua15effjh3");
		cu2.setPhoneNumber("0123456789");
		cu2.setStatus("Active");
		List<Address> cu1ad = new ArrayList<Address>();
		cu1ad.add(aa);
		cu.setAddresses(cu1ad);
																			// Customer <-> Address
//		List<Address> cuAddr = new ArrayList<Address>();
//		cuAddr.add(aa);
//		cuAddr.add(aa1);
//		cu.setAddresses(cuAddr);
		
																						// Sales orders
		SalesOrder sO1 = new SalesOrder();
		sO1.setDate("11/12/2016");
		sO1.setCustomer(cu);
		sO1.setStatus("Delivered");

		SalesOrder sO2 = new SalesOrder();
		sO2.setDate("12/12/2016");
		sO2.setStatus("Processing");
		sO2.setCustomer(cu);

		Product p1 = new Product();
		p1.setProductName("King of the 7 Gnomedoms");
		p1.setImgPath("img/GameofGnomes.jpg");
		p1.setDescription("Every now and again a piece of wordplay comes along that's so sumptuous, so irresistible that it would be a travesty to not bring it to life (Robocup anyone?). We present to you... Game of Gnomes. ");
		//p1.setDescription("tersdt");
		p1.setPrice(17.99);
		p1.setStockLevel(115);
		p1.setRating(4);

		Product p2 = new Product();
		p2.setProductName("The Laundry Line");
		p2.setImgPath("img/Laundry.gif");
		p2.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p2.setPrice(2.99);
		p2.setStockLevel(115);
		p2.setRating(0);
		// Reviews
		Review r1 = new Review();
		r1.setProductID(1);
		r1.setDate("11/12/2016");
		r1.setRating(4);
		r1.setReviewText(" Perfect for my garden 1");
		r1.setCustomerid(cu);
		r1.setName("Connor");
		r1.setProduct_id(p1);
		
		Review r2 = new Review();
		r2.setProductID(1);
		r2.setDate("11/12/2016");
		r2.setRating(4);
		r2.setReviewText(" Perfect for my garden 2");
		r2.setName("Craig");
		r2.setCustomerid(cu);
		r2.setProduct_id(p1);
		
		Review r3 = new Review();
		r3.setProductID(1);
		r3.setDate("11/12/2016");
		r3.setRating(4);
		r3.setReviewText(" Perfect for my garden 3");
		r3.setName("Tim");
		r3.setCustomerid(cu);
		r3.setProduct_id(p1);
		
		
		Category c1 = new Category();													// Categories
		c1.setName("Gnomes");
		
		Category c2 = new Category();
		c2.setName("PoolsAndHotTubs");
		
		Category c3 = new Category();
		c3.setName("GnomeAccessories");
		
		Category c4 = new Category();
		c4.setName("GardenOrnaments");
		
		Category c5 = new Category();
		c5.setName("GnomeCare");
		
	
		
		Product p3 = new Product();
		p3.setProductName("Gnome Trek Set");
		p3.setImgPath("img/GnomeTrek.gif");
		p3.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p3.setPrice(4.99);
		p3.setStockLevel(115);
		p3.setRating(0);
		
		Product p4 = new Product();
		p4.setProductName("Minimushrooms");
		p4.setImgPath("img/mushrooms.gif");
		p4.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p4.setPrice(24.99);
		p4.setStockLevel(115);
		p4.setRating(0);
		
		Product p5 = new Product();
		p5.setProductName("Mr and Mrs");
		p5.setImgPath("img/MrandMrs.gif");
		p5.setDescription("when these gnomes are rockin', don't come-a-knockin'!!!");
		p5.setPrice(7.99);
		p5.setStockLevel(8008135);
		p5.setRating(0);
		
		Product p6 = new Product();
		p6.setProductName("Christmas Boots");
		p6.setImgPath("img/Boots.gif");
		p6.setDescription("a snazzy pair of sneaks for the Christmas gimp");
		p6.setPrice(4.99);
		p6.setStockLevel(8008135);
		p6.setRating(0);
		
		Product p7 = new Product();
		p7.setProductName("Lawn Flamingo");
		p7.setImgPath("img/Flamingo.gif");
		p7.setDescription("a dainty pair of Tim's favourite lawn ornaments");
		p7.setPrice(14.99);
		p7.setStockLevel(8008135);
		p7.setRating(0);
		
		Product p8 = new Product();
		p8.setProductName("Benny");
		p8.setImgPath("img/Benny.gif");
		p8.setDescription("the worst gnome in existence; the dumpy little guy from gnomeo and juliet");
		p8.setPrice(8.99);
		p8.setStockLevel(8008135);
		p8.setRating(0);
		
		Product p11 = new Product();
		p11.setProductName("King of the 7 Gnomedoms");
		p11.setImgPath("img/GameofGnomes.jpg");
		p11.setDescription("Every now and again a piece of wordplay comes along that's so sumptuous, so irresistible that it would be a travesty to not bring it to life (Robocup anyone?). We present to you... Game of Gnomes.");
		p11.setPrice(17.99);
		p11.setStockLevel(115);
		p11.setRating(0);
		
		Product p12 = new Product();
		p12.setProductName("The Laundry Line");
		p12.setImgPath("img/Laundry.gif");
		p12.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p12.setPrice(2.99);
		p12.setStockLevel(115);
		p12.setRating(0);
		
		Product p13 = new Product();
		p13.setProductName("Gnome Trek Set");
		p13.setImgPath("img/GnomeTrek.gif");
		p13.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p13.setPrice(4.99);
		p13.setStockLevel(115);
		p13.setRating(0);
		
		Product p14 = new Product();
		p14.setProductName("Minimushrooms");
		p14.setImgPath("img/mushrooms.gif");
		p14.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
		p14.setPrice(24.99);
		p14.setStockLevel(115);
		p14.setRating(0);
		
		Product p15 = new Product();
		p15.setProductName("Mr and Mrs");
		p15.setImgPath("img/MrandMrs.gif");
		p15.setDescription("when these gnomes are rockin', don't come-a-knockin'!!!");
		p15.setPrice(7.99);
		p15.setStockLevel(8008135);
		p15.setRating(0);
		
		Product p16 = new Product();
		p16.setProductName("Christmas Boots");
		p16.setImgPath("img/Boots.gif");
		p16.setDescription("a snazzy pair of sneaks for the Christmas gimp");
		p16.setPrice(4.99);
		p16.setStockLevel(8008135);
		p16.setRating(0);
		
		Product p17 = new Product();
		p17.setProductName("Lawn Flamingo");
		p17.setImgPath("img/Flamingo.gif");
		p17.setDescription("a dainty pair of Tim's favourite lawn ornaments");
		p17.setPrice(14.99);
		p17.setStockLevel(8008135);
		p17.setRating(0);
		
		Product p18 = new Product();
		p18.setProductName("Benny");
		p18.setImgPath("img/Benny.gif");
		p18.setDescription("the worst gnome in existence; the dumpy little guy from gnomeo and juliet");
		p18.setPrice(8.99);
		p18.setStockLevel(8008135);
		p18.setRating(0);

		
		Product p19 = new Product();
		p19.setProductName("Westbury Pool Table");
		p19.setImgPath("img/westburyPoolTable019.jpg");
		p19.setDescription("Dive into the pool table of pure magnificence.");
		p19.setPrice(209.99);
		p19.setStockLevel(8008135);
		p19.setRating(0);

		
																						// Product Categories
		ProductCategory pc1 = new ProductCategory();
		pc1.setCategoryID(001);
		
		ProductCategory pc2 = new ProductCategory();
		pc2.setCategoryID(001);
		
		ProductCategory pc3 = new ProductCategory();
		pc3.setCategoryID(001);
		
		ProductCategory pc4 = new ProductCategory();
		pc4.setCategoryID(001);
		
		ProductCategory pc5 = new ProductCategory();
		pc5.setCategoryID(001);
		
		ProductCategory pc6 = new ProductCategory();
		pc6.setCategoryID(001);
		
		ProductCategory pc7 = new ProductCategory();
		pc7.setCategoryID(001);
		
		ProductCategory pc8 = new ProductCategory();
		pc8.setCategoryID(002);
		
		ProductCategory pc9 = new ProductCategory();
		pc9.setCategoryID(001);
																								// Product Categories
			
		
		
		persistData(aa,aa1, cu,cu2,sO1,sO2,p1,p2,p3,p4,p5,p6,p7,p8,p11,p12,p13,p14,p15,p16,p17,p18,p19,pc1,pc2,pc3,
				pc4,pc5,pc6,pc7,pc8,pc9,r1,r2,r3);
		
		
		
		
	}

}

