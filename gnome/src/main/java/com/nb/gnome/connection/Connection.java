//package com.nb.gnome.connection;
//
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
//import javax.annotation.PostConstruct;
//import javax.ejb.*;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//
//import com.nb.gnome.entities.Address;
//import com.nb.gnome.entities.Product;
//import com.nb.gnome.entities.PurchaseOrder;
//import com.nb.gnome.entities.PurchaseOrderDetails;
//import com.nb.gnome.entities.Supplier;
//
//@Startup
//@Singleton
//public class Connection {
//	
//	private SessionFactory sessionFactory;
//	private Session session;
//	private Transaction tx;
//	
//	private void createSession(){
//		Properties properties = new Properties();
//		properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
//		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/ims");
//		
//			
//		properties.setProperty("hibernate.connection.username", "root");
//		properties.setProperty("hibernate.connection.password", "password");
//		
//		
//		properties.setProperty("hibernate.show_sql", "true");
//		//properties.setProperty("hibernate.hbm2ddl.auto", "update");
//		properties.setProperty("hibernate.hbm2ddl.auto", "create");
//					
//		Configuration cfg = new Configuration().addProperties(properties).addAnnotatedClass(Product.class).addAnnotatedClass(Supplier.class).addAnnotatedClass(Address.class).addAnnotatedClass(PurchaseOrder.class).addAnnotatedClass(PurchaseOrderDetails.class);
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
//		
//		
//		sessionFactory = cfg.buildSessionFactory(serviceRegistry);	
//		session = sessionFactory.openSession();
//	}
//	
//	public void persistData(Object...objects){
//		createSession();
//		tx = session.beginTransaction();
//		for (Object b : objects){
//			session.save(b);
//		}
//		tx.commit();
//		session.close();
//		sessionFactory.close();		
//	}
//	
//	public List<Object> returnData(String databaseToQuery){
//		createSession();
//		Query query = session.createQuery("from " + databaseToQuery);
//		List<Object> returnObjects = query.list();
//		session.close();
//		sessionFactory.close();
//		return returnObjects;
//	}
//	
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
//		Product p1 = new Product();
//		p1.setProductName("Lawn Flamingo");
//		p1.setDescription("A beautiful pink plastic flamingo to place in your tropical garden");
//		p1.setPrice(15.99);
//		p1.setImgPath("img/Flamingo.gif");
//		p1.setStockLevel(5);
//		p1.setPorousStockLevel(15);
//		p1.setSupplier(s1);
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
//		pod1.setProduct(p1);
//		pod1.setQuantity(40);
//		listOfPOD.add(pod1);
//		pod1.setPo(po1);
//		
//		persistData(p1,a1,s1,po1,pod1);
//	}
//	
//
//}
//
//
//
////Product p2 = new Product();
////p2.setProductName("Godzilla gnome");
////p2.setProductID(002);
////p2.setDescription("A giant lizard beast perfect for keeping pesky cats out of your garden");
////p2.setPrice(24.99);
////p2.setStockLevel(115);
////p2.setPorousStockLevel(6);
////p2.setImgPath("img/gnomezilla.png");
////
////
////Product p3 = new Product();
////p3.setProductName("Timtim the timmy tim gnome");
////p3.setProductID(003);
////p3.setDescription("tim loves java and being in the garden");
////p3.setPrice(24.99);
////p3.setStockLevel(1015);
////p3.setPorousStockLevel(20);
////
////
////Product p4 = new Product();
////p4.setProductName("Gnome Of Gnomes - Ned Gnome");
////p4.setProductID(004);
////p4.setDescription("Dont lose your head!");
////p4.setPrice(14.99);
////p4.setStockLevel(1);
////p4.setPorousStockLevel(8);
////
////Product p5 = new Product();
////p5.setProductName("Gnome Trek - Kirk & Spok");
////p5.setProductID(005);
////p5.setDescription("Travelling where no gnome has gone before!");
////p5.setPrice(20.99);
////p5.setStockLevel(6);
////p5.setPorousStockLevel(3);
////
////
////Product p6 = new Product();
////p6.setProductName("Benny - Gnomeo&Juliet");
////p6.setProductID(006);
////p6.setDescription("Tragic Gnomes");
////p6.setPrice(12.99);
////p6.setStockLevel(7);
////p6.setPorousStockLevel(1);
