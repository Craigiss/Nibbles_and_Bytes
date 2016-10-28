package MyHibernateApp.com.nb.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import com.nb.models.Address;
import com.nb.models.Customer;




public class MyHibernateApplication {

	public static void main(String[] args) {
		
		//Create properties class object and set hibernate properties
		
		Properties props = new Properties();

		int i, j, k; 
		i = j = k = 9;
		System.out.println(i);
		
		props.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		props.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/jacob");
		props.setProperty("hibernate.connection.username", "root");
		props.setProperty("hibernate.connection.password", "password");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "create");
		
		//step 2 
		
		//create configuration class object 
		
		Configuration cfg = new Configuration().addProperties(props)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Address.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			
	
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction(); 
		List<Address> addressList = new ArrayList<Address>(); 
		
		Address adr1 = new Address();
		adr1.setStreet("The street");
		adr1.setCity("The city");
		adr1.setPostcode("THE POS");
		addressList.add(adr1);
		Address adr2 = new Address();
		adr2.setStreet("The street12");
		adr2.setCity("The city12");
		adr2.setPostcode("THE POS12");
        addressList.add(adr2);
		
		Customer c1 = new Customer();

		c1.setCustomername("Jacob");
		
		c1.setAddresses(addressList);
	    Customer c2 = new Customer();
		c2.setCustomername("Cam");
		Customer c3 = new Customer();
		c3.setCustomername("Craig");
		
        Query query = session.createQuery("from Customer");
		
		List<Customer> customerList = query.list();
		
		for(Customer c: customerList){
		System.out.println(c);
		}

	    session.save(c1);
	    session.save(adr1);
	    session.save(adr2);
	    session.save(c2);
	    session.save(c3);
		tx.commit();
		
		session.close();
		
		sessionFactory.close();
	
	}

}