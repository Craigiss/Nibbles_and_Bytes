package com.nb.gnome.controllers;


import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.service.ProductService;
import com.nb.gnome.service.SupplierService;

@Named("search")
@RequestScoped
public class SearchController{
	
	private String term;
	
	@Inject private ProductService productServ;
	@Inject private SupplierService supplierServ;
	
	@Inject private SelectedProduct selectedProd;
	@Inject private SelectedSupplier selectedSup;	
	
	@Inject private ProductController prodController;
	@Inject private SupplierController supController;
	
	
	public String searchProd(){
		String returnValue = "";
		Product p = productServ.findProductById(term);
		ArrayList<Product> pList = (ArrayList<Product>)productServ.findProductByKeyword(term);
		if (p !=null){
			selectedProd.setProduct(p);
			returnValue = "imsProdDeets";
		}
		else if (pList.size() > 0){
			for(Product prod : pList){
				prodController.setData(pList);
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
		Supplier idSupp = supplierServ.findSupplierById(term);
		Supplier contactSupp = supplierServ.findSupplierByContact(term);
		ArrayList<Supplier> companyList = (ArrayList<Supplier>)supplierServ.findSupplierByCompany(term);
		
		if (idSupp !=null){
			selectedSup.setSupplier(idSupp);
			returnValue = "imsSupplierDeets";
		}
		else if (contactSupp != null){
			selectedSup.setSupplier(contactSupp);
			returnValue = "imsSupplierDeets";
		}
		else if (companyList.size() > 0){
			supController.setData(companyList);
			returnValue = "imsSuppliers";
		}
		else{
			returnValue = "imsError";
		}
		return returnValue;		
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
