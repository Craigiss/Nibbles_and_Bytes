package gnome;

import java.util.List;

import com.nb.gnome.entities.SalesOrder;

public interface SalesOrderRepository {
	//Create
	public void persistSalesOrder(SalesOrder a);
	//Read
	public List<SalesOrder> findSalesOrder();
	
	public SalesOrder findSalesOrderById(long id);
	
	public List<SalesOrder> findAll();
}
