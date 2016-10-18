//Kieran Working On
package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.Product;
import com.nb.gnome.helper.PaginationHelper;
import com.nb.gnome.service.SearchService;

@Named("search")
@RequestScoped
public class SearchController{
	
	private String term;
	
	@Inject private SearchService searchServ;
	@Inject private SelectedProduct selectedProd;
	@Inject private SelectedDataModel selectedDataModel;
	private PaginationHelper pagination;
	private DataModel<Product> dataModel = null;
	private List<Product> productsFoundByKeyword = new ArrayList<Product>();
	
	public String searchProd(String service){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + service + " TERM " + term);
		String returnValue = "";
		Product p = searchServ.findProductById(term);
		ArrayList<Product> pList = (ArrayList<Product>)searchServ.findProductByKeyword(term);
		if (p !=null && service.equals("cat")){
			selectedProd.setProduct(p);	
			returnValue = "Product";
		}
		else if (p !=null && service.equals("ims")){
			System.out.println("i got to the right section");
			selectedProd.setProduct(p);
			returnValue = "imsProdDeets";
		}
		else if (pList.size() > 0){
			for(Product prod : pList){
				productsFoundByKeyword.add(prod);
				getPagination().createPageDataModel();
				selectedDataModel.setProductDataModel(dataModel);
				returnValue = "imsProducts";
			}
		}
		else{
			returnValue = "imsError";
		}
		return returnValue;		
	}
	

	private void recreateModel() {
		dataModel = null;
	}

	public PaginationHelper getPagination() {
		if (pagination == null)
			pagination = new PaginationHelper(2) {
				@Override
				public int getItemsCount() {
					return productsFoundByKeyword.size();
				}

				@Override
				public DataModel<Product>createPageDataModel() {
					try {
						return new ListDataModel<Product>(
								productsFoundByKeyword.subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(
								productsFoundByKeyword.subList(getPageFirstItem(), getItemsCount()));
					}
				}

			};

		return pagination;
	}

	public DataModel<Product> getDataModel() {
		if (dataModel == null)
			dataModel = getPagination().createPageDataModel();
		return dataModel;
	}
	
	
	public String next(){
		getPagination().nextPage();
		recreateModel();
		return "browse";
	}
	
	public String previous(){
		getPagination().previousPage();
		recreateModel();
		return "browse";
	}
	
	
	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	

}
