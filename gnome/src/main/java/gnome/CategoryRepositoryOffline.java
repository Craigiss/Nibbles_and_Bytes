package gnome;

import java.util.List;

import javax.inject.Inject;

import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Category;

public class CategoryRepositoryOffline implements CategoryRepository {
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistCategory(Category c) {
		// TODO Auto-generated method stub
		initialData.addCategory(c);
	}

	@Override
	public List<Address> findCategory(Category c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCategory(Category c) {
		// TODO
		
	}

}
