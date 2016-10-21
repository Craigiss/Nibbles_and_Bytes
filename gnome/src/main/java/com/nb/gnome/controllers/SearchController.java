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
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.helper.PaginationHelper;
import com.nb.gnome.service.ProductService;
import com.nb.gnome.service.SearchService;
import com.nb.gnome.service.SupplierService;

@Named("search")
@RequestScoped
public class SearchController{
	
	private String term;
	
	@Inject private ProductService productServ;
	@Inject private SupplierService supplierServ;
	@Inject private SelectedProduct selectedProd;
//	@Inject private SelectedProductDataModel selectedProductDataModel;
	@Inject private ProductController prodController;
	private PaginationHelper pagination;
	private DataModel<Product> dataModel = null;
	private List<Product> productsFoundByKeyword = new ArrayList<Product>();
	
	public String searchProd(String service){
		String returnValue = "";
		Product p = productServ.findProductById(term);
		ArrayList<Product> pList = (ArrayList<Product>)productServ.findProductByKeyword(term);
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
				prodController.getDataModel();
				prodController.setData((ArrayList)productsFoundByKeyword);
				returnValue = "imsProducts";
			}
		}
		else{
			returnValue = "imsError";
		}
		return returnValue;		
	}
	
	public String searchSuppliers(String service){
		String returnValue = "";
		Supplier s = supplierServ.findSupplierById(term);
		ArrayList<Supplier> sList = (ArrayList<Supplier>)supplierServ.findSupplierByCompany(term);
//		if (s !=null && service.equals("cat")){
//			selectedProd.setProduct(s);	
//			returnValue = "Product";
//		}
//		else if (p !=null && service.equals("ims")){
//			System.out.println("i got to the right section");
//			selectedProd.setProduct(p);
//			returnValue = "imsProdDeets";
//		}
//		else if (pList.size() > 0){
//			for(Product prod : pList){
//				productsFoundByKeyword.add(prod);
//				prodController.getDataModel();
//				prodController.setData((ArrayList)productsFoundByKeyword);
//				returnValue = "imsProducts";
//			}
//		}
//		else{
//			returnValue = "imsError";
//		}
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
