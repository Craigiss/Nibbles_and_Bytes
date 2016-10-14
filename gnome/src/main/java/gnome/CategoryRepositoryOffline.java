package gnome;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Category;
@Default
public class CategoryRepositoryOffline implements CategoryRepository {
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistCategory(Category c) {
		// TODO Auto-generated method stub
		initialData.addCategory(c);
	}

	@Override
	public Category findCategory(Category c) {
		for(Category cat : initialData.getCategories())
		{
			if( cat.getId() == c.getId())
			{
				return cat;
			}
		}
		return null;
	}
	
	@Override
	public void updateCategory(Category c) {
		for(Category cat : initialData.getCategories())
		{
			if( cat.getId() == c.getId())
			{
				cat.setId(c.getId());
				cat.setName(c.getName());
			}
		}
	}

}
