package gnome;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import com.nb.gnome.entities.Returns;
@Default
@Stateless
public class ReturnsRepositoryOffline implements ReturnsRepository{

	@Override
	public void persistReturns() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Returns> findReturns(Returns r) {
		// TODO Auto-generated method stub
		return null;
	}

}
