package com.nb.gnome.managers.hib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.nb.gnome.entities.Address;
import com.nb.gnome.entities.Category;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.ProductCategory;
import com.nb.gnome.entities.PurchaseOrder;
import com.nb.gnome.entities.PurchaseOrderDetails;
import com.nb.gnome.entities.Supplier;

@Stateless
public class ObjectConverter implements Serializable {

	public List<Supplier> convertToSuppliers(List<Object> objectList) {
		List<Supplier> supplierList = new ArrayList<Supplier>();

		for (Object o : objectList) {
			supplierList.add((Supplier) o);
		}
		return supplierList;
	}

	public List<Product> convertToProducts(List<Object> objectList) {
		List<Product> productList = new ArrayList<Product>();

		for (Object o : objectList) {
			productList.add((Product) o);
		}
		return productList;
	}
	public List<Address> convertToAddress(List<Object> objectList) {
		List<Address> productList = new ArrayList<Address>();

		for (Object o : objectList) {
			productList.add((Address) o);
		}
		return productList;
	}
	public List<Category> ConvertToCategory(List<Object> objectList){
		List<Category> categoryList = new ArrayList<Category>();
		
		for (Object o: objectList){
			categoryList.add((Category)o);
		}
		
		return categoryList;
		
	}
	
	public List<ProductCategory> ConvertToProductCategory(List<Object> objectList){
		List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
		
		for (Object o: objectList){
			productCategoryList.add((ProductCategory)o);
		}
		
		return productCategoryList;
		
	}
	
	public List<PurchaseOrderDetails> ConvertToPurchaseOrderDetails(List<Object> objectList){
		List<PurchaseOrderDetails> purchaseOrderDetailsList = new ArrayList<PurchaseOrderDetails>();
		
		for (Object o: objectList){
			purchaseOrderDetailsList.add((PurchaseOrderDetails)o);
		}
		
		return purchaseOrderDetailsList;
		
	}
	
	public List<PurchaseOrder> ConvertToPurchaseOrder(List<Object> objectList){
		List<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();
		
		for (Object o: objectList){
			purchaseOrderList.add((PurchaseOrder)o);
		}
		
		return purchaseOrderList;
		
	}
	
	
	
}