package com.nb.gnome.controllers;


import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.service.ProductService;
import com.nb.gnome.service.PurchaseOrderService;
import com.nb.gnome.service.SupplierService;

import gnome.InitialData;

@Named("search")
@RequestScoped
public class SearchController{
	
	private String term;
	private String searchType;
	private boolean optionChecked;
	
	@Inject private ProductService productServ;
	@Inject private SupplierService supplierServ;
	@Inject private PurchaseOrderService poServ;
	
	@Inject private SelectedProduct selectedProd;
	@Inject private SelectedSupplier selectedSup;	
	@Inject private SelectedPo selectedPo;
	
	@Inject private ProductController prodController;
	@Inject private SupplierController supController;
	@Inject private PurchaseOrderController poController;
	
	
	/**
	 * @return the searchType
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * @param searchType the searchType to set
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
		if (searchType != null){
		optionChecked =true;
		}
	}
	
	/**
	 * @return the optionChecked
	 */
	public boolean isOptionChecked() {
		return optionChecked;
	}

	/**
	 * @param optionChecked the optionChecked to set
	 */
	public void setOptionChecked(boolean optionChecked) {
		this.optionChecked = optionChecked;
	}
	
	public String search(){
		String returnValue = "";
		if (optionChecked == false){
			returnValue = "imsIndex";
		}
		else if (searchType.equals("Products")){
			returnValue = searchProd();
		}
		else if (searchType.equals("Suppliers")){
			returnValue = searchSuppliers();
		}
		else if (searchType.equals("PO")){
			returnValue = searchPo();
		}
		else{
			returnValue = "imsError";
		}
		
		return returnValue;
	}
	

	public String searchProd(){
		String returnValue = "";
		Product p = productServ.findProductById(term);
		ArrayList<Product> pList = (ArrayList<Product>)productServ.findProductByKeyword(term);
		if (p !=null){
			selectedProd.setProduct(p);
			returnValue = "imsProdDeets";
		}
		else if (pList.size() > 0){
			
				prodController.getDataModel();
				prodController.setData(pList);
				returnValue = "imsProducts";
			
		}
		else{
			returnValue = "imsError";
		}
		return returnValue;		
	}
	
	public String searchSuppliers(){
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
			supController.getDataModel();
			supController.setData(companyList);
			returnValue = "imsSuppliers";
		}
		else{
			returnValue = "imsError";
		}
		return returnValue;		
	}
	
	public String searchPo(){
		String returnValue = "";
		PurchaseOrder p = poServ.findPoById(term);
		ArrayList<Supplier> companyList = (ArrayList<Supplier>)supplierServ.findSupplierByCompany(term);	
		ArrayList<PurchaseOrder> pList = new ArrayList<PurchaseOrder>();
		for (Supplier s : companyList){
			pList = (ArrayList<PurchaseOrder>)poServ.findPurchaseOrderBySupplier(s);
		}
		if (p !=null){
			selectedPo.setPurchaseOrder(p);
			returnValue = "imsPoDeets";
		}
		else if (pList.size() > 0){
			for(PurchaseOrder po : pList){
				poController.getDataModel();
				poController.setData(pList);
				returnValue = "imsPo";
			}
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
