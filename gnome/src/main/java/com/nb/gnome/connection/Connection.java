package com.nb.gnome.connection;

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
import com.nb.gnome.entities.ISAccount;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
import com.nb.gnome.entities.Supplier;

@Startup
@Singleton
public class Connection {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction tx;
	
	private void createSession(){
		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/ims?autoReconnect=true&useSSL=false");
		
			
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "password");
		
		
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		//properties.setProperty("hibernate.hbm2ddl.auto", "create");
					
		Configuration cfg = new Configuration().addProperties(properties).addAnnotatedClass(Product.class).addAnnotatedClass(Supplier.class).addAnnotatedClass(Address.class).addAnnotatedClass(PurchaseOrder.class).addAnnotatedClass(PurchaseOrderDetails.class).addAnnotatedClass(ISAccount.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);	
		session = sessionFactory.openSession();
	}
	
	public void persistData(Object...objects){
		createSession();
		tx = session.beginTransaction();
		for (Object b : objects){
			session.save(b);
		}
		tx.commit();
		session.close();
		sessionFactory.close();		
	}
	
	public List<Object> returnData(String databaseToQuery){
		createSession();
		Query query = session.createQuery("from " + databaseToQuery);
		List<Object> returnObjects = query.list();
		session.close();
		sessionFactory.close();
		return returnObjects;
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
	
//	@PostConstruct
//	public void init(){
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..PRODUCT DONE");
//		Address a1 = new Address("25 Barncombe Close", "", "Benfleet" , "Essex", "SS74AQ");
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..ADDRESS DONE");
//		
//		Supplier s1 = new Supplier();
//		s1.setCompany("Lawn Flamingos Wholesale");
//		s1.setName("Augustine Poutine");
//		s1.setPhone("01645839242");
//		s1.setEmail("augustine@lawnflamingoswholesale.lol");
//		s1.setDescription("These guys sell lawn flamingos in bulk. Low prices but we tend to have their stock for a while."
//				+ " Augustine is friendly enough, but don't talk to them about gnomes. They have incredible delivery time, "
//				+ "as they are able to ship 1,000 flamingos for next day delivery. This is now a test to see how far down the"
//				+ "text will go and if it will collide with the PO table that shows all the POs for this supplier.");
//		s1.setAddress(a1);
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..SUPPLIER DONE");
//		
//		Product p2 = new Product();
//		p2.setProductName("Lawn Flamingo");
//		p2.setDescription("A beautiful pink plastic flamingo to place in your tropical garden");
//		p2.setPrice(15.99);
//		p2.setImgPath("img/Flamingo.gif");
//		p2.setStockLevel(5);
//		p2.setPorousStockLevel(15);
//		p2.setSupplier(s1);
//			
//		List<PurchaseOrderDetails> listOfPOD = new ArrayList<PurchaseOrderDetails>();
//		
//		PurchaseOrder po1 = new PurchaseOrder();
//		po1.setDate(new Date(116,10,22));
//		po1.setStatus("Open");
//		po1.setSupplier(s1);
//		po1.setLines(listOfPOD);
//		
//		PurchaseOrderDetails pod1 = new PurchaseOrderDetails();
//		pod1.setProduct(p2);
//		pod1.setQuantity(40);
//		listOfPOD.add(pod1);
//		pod1.setPo(po1);
//		
//		ISAccount isa1 = new ISAccount();
//		isa1.setEmail("PaulVanDyke@TranceNation.com");
//		isa1.setPassword("24871d06dc1dcb6614c7a0dc0f678d53390de44796500c1ca000624471b03c39");
//		isa1.setName("Paul Van Dyke");
//		isa1.setAdmin(false);
//		isa1.setSalt("Y83naas£$Bklaf");
//		isa1.setRole("user");
//		
//		ISAccount isa2 = new ISAccount();
//		isa2.setEmail("CyrilSneer@GreenHavenCottage.com");
//		isa2.setPassword("d7d18c04d2eab7deeb363b8c89fb68618e2be0ea34686e085313c627ea4c513a");
//		isa2.setName("Cyril Sneer");
//		isa2.setAdmin(false);
//		isa2.setSalt("IU(979qh097asith");
//		isa2.setRole("user");
//
//		ISAccount isa3 = new ISAccount();
//		isa3.setEmail("admin");
//		isa3.setPassword("6bcf7af8f331e857e69c4a7a748742e549cb1d3af9f4bf920a75a23fbd006ae8");
//		isa3.setName("admin");
//		isa3.setAdmin(true);
//		isa3.setSalt("42");
//		isa3.setRole("admin");
//
//		
//		persistData(p2,a1,s1,po1,pod1,isa1,isa2,isa3);
//	}
	

}