package gnome;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ReviewRepositoryOffline implements ReviewRepository {
	@Inject
	private InitialData initialData;
	@Override
	public void persistReview(Review a) {
		initialData.addReview(a);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Review> findReview() {
		return initialData.getReviews();
	}

	@Override
	public void updateReview(Review c) {
		
		
	}

}
