package connection;

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


import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.ProductCategory;


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
		properties.setProperty("hibernate.connection.password", "password");
		
		properties.setProperty("hibernate.show_sql", "true");
		// properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");

		Configuration cfg = new Configuration().addProperties(properties).addAnnotatedClass(Product.class).addAnnotatedClass(ProductCategory.class);
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
		System.out.println("SDSHGDRYDJUKFDYJKFXERUDYET");
		Product p1 = new Product();
		p1.setProductName("King of the 7 Gnomedoms");
		p1.setImgPath("img/GameofGnomes.jpg");
		p1.setDescription("test");
		p1.setPrice(17.99);
		p1.setStockLevel(115);
		System.out.println("SDSHGDRYDJUKFDYJKFXERUDYET");
		persistData(p1);
	}

}

