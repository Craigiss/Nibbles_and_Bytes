//Kieran Working On
package com.nb.gnome.controllers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Product;
import com.nb.gnome.helper.PaginationHelper;
import com.nb.gnome.managers.ProductRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("searchProducts")
@SessionScoped
public class SearchCatalogueController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5224338881449833591L;
	@Inject
	private ProductRepository productRepository;
	@Inject
	private SelectedProduct product;
	private PaginationHelper pagination;
	private DataModel<Product> dataModel = null;
	private List<Product> listData;
	private String term;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public void recreateModel() {
		dataModel = null;
		listData = null;
	}

	// method that will set

	public PaginationHelper getPagination() {
		if (pagination == null)
			pagination = new PaginationHelper(8) {
				@Override
				public int getItemsCount() {
					if (listData == null)
						return productRepository.findAll().size();
					else
						return listData.size();
				}

				@Override
				public DataModel<Product> createPageDataModel() {
					try {
						return new ListDataModel<Product>(
								listData.subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(listData.subList(getPageFirstItem(), getItemsCount()));
					}
				}

			};

		return pagination;
	}

	public DataModel<Product> getDataModel() {
		if (listData == null)
			listData = productRepository.getProductByKeyword(term);

		dataModel = getPagination().createPageDataModel();
		return dataModel;
	}

	public List<Product> getListData() {
		return listData;
	}

	public void setListData(List<Product> listData) {
		this.listData = listData;
	}

	public void setDataModel(ArrayList<Product> model) {
		dataModel.setWrappedData(model);
	}

	public String next() {
		getPagination().nextPage();
		
		return "browse";
	}

	public String previous() {
		getPagination().previousPage();
	
		return "browse";
	}

	public String view(int id) {
		product.setProduct(productRepository.getProductByID(id));

		return "Product";
	}

}
