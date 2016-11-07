package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.PurchaseOrderDetails;

@Named (value="pods")
@SessionScoped
public class PurchaseOrderDetailsController implements Serializable{
	private Product product1;
	private Product product2;
	private Product product3;
	private Product product4;
	private Product product5;
	private Product product6;
	private Product product7;
	private Product product8;
	private Product product9;
	private Product product10;
	private List<Product> listProducts;
	private int quantity1;
	private int quantity2;
	private int quantity3;
	private int quantity4;
	private int quantity5;
	private int quantity6;
	private int quantity7;
	private int quantity8;
	private int quantity9;
	private int quantity10;
	private List<Integer> listQuantities;
	
	/**
	 * No-args constructor
	 */
	public PurchaseOrderDetailsController(){
		product1 = new Product();
		product2 = new Product();
		product3 = new Product();
		product4 = new Product();
		product5 = new Product();
		product6 = new Product();
		product7 = new Product();
		product8 = new Product();
		product9 = new Product();
		product10 = new Product();
		
		listProducts = new ArrayList<Product>();
		
		listProducts.add(product1);
		listProducts.add(product2);
		listProducts.add(product3);
		listProducts.add(product4);
		listProducts.add(product5);
		listProducts.add(product6);
		listProducts.add(product7);
		listProducts.add(product8);
		listProducts.add(product9);
		listProducts.add(product10);
		
		quantity1 = 1;
		quantity2 = 2;
		quantity3 = 3;
		quantity4 = 4;
		quantity5 = 5;
		quantity6 = 6;
		quantity7 = 7;
		quantity8 = 8;
		quantity9 = 9;
		quantity10 = 10;
		
		listQuantities = new ArrayList<Integer>();
		
		listQuantities.add(quantity1);
		listQuantities.add(quantity2);
		listQuantities.add(quantity3);
		listQuantities.add(quantity4);
		listQuantities.add(quantity5);
		listQuantities.add(quantity6);
		listQuantities.add(quantity7);
		listQuantities.add(quantity8);
		listQuantities.add(quantity9);
		listQuantities.add(quantity10);
	}
	
	/**
	 * Converts attributes into a list of PurchaseOrderDetails
	 * @return
	 */
	public List<PurchaseOrderDetails> convert(){
		List<PurchaseOrderDetails> list = new ArrayList<PurchaseOrderDetails>();
		for(int i = 0; i<10; i++){
			if(listProducts.get(i) != null){
				PurchaseOrderDetails pod = new PurchaseOrderDetails();
				pod.setProduct(listProducts.get(i));
				pod.setQuantity(listQuantities.get(i));
				list.add(pod);
			}
		}
		return list;
	}
	
	/**
	 * @return the product1
	 */
	public Product getProduct1() {
		return product1;
	}
	/**
	 * @param product1 the product1 to set
	 */
	public void setProduct1(Product product1) {
		this.product1 = product1;
	}
	/**
	 * @return the product2
	 */
	public Product getProduct2() {
		return product2;
	}
	/**
	 * @param product2 the product2 to set
	 */
	public void setProduct2(Product product2) {
		this.product2 = product2;
	}
	/**
	 * @return the product3
	 */
	public Product getProduct3() {
		return product3;
	}
	/**
	 * @param product3 the product3 to set
	 */
	public void setProduct3(Product product3) {
		this.product3 = product3;
	}
	/**
	 * @return the product4
	 */
	public Product getProduct4() {
		return product4;
	}
	/**
	 * @param product4 the product4 to set
	 */
	public void setProduct4(Product product4) {
		this.product4 = product4;
	}
	/**
	 * @return the product5
	 */
	public Product getProduct5() {
		return product5;
	}
	/**
	 * @param product5 the product5 to set
	 */
	public void setProduct5(Product product5) {
		this.product5 = product5;
	}
	/**
	 * @return the product6
	 */
	public Product getProduct6() {
		return product6;
	}
	/**
	 * @param product6 the product6 to set
	 */
	public void setProduct6(Product product6) {
		this.product6 = product6;
	}
	/**
	 * @return the product7
	 */
	public Product getProduct7() {
		return product7;
	}
	/**
	 * @param product7 the product7 to set
	 */
	public void setProduct7(Product product7) {
		this.product7 = product7;
	}
	/**
	 * @return the product8
	 */
	public Product getProduct8() {
		return product8;
	}
	/**
	 * @param product8 the product8 to set
	 */
	public void setProduct8(Product product8) {
		this.product8 = product8;
	}
	/**
	 * @return the product9
	 */
	public Product getProduct9() {
		return product9;
	}
	/**
	 * @param product9 the product9 to set
	 */
	public void setProduct9(Product product9) {
		this.product9 = product9;
	}
	/**
	 * @return the product10
	 */
	public Product getProduct10() {
		return product10;
	}
	/**
	 * @param product10 the product10 to set
	 */
	public void setProduct10(Product product10) {
		this.product10 = product10;
	}
	/**
	 * @return the quantity1
	 */
	public int getQuantity1() {
		return quantity1;
	}
	/**
	 * @param quantity1 the quantity1 to set
	 */
	public void setQuantity1(int quantity1) {
		this.quantity1 = quantity1;
	}
	/**
	 * @return the quantity2
	 */
	public int getQuantity2() {
		return quantity2;
	}
	/**
	 * @param quantity2 the quantity2 to set
	 */
	public void setQuantity2(int quantity2) {
		this.quantity2 = quantity2;
	}
	/**
	 * @return the quantity3
	 */
	public int getQuantity3() {
		return quantity3;
	}
	/**
	 * @param quantity3 the quantity3 to set
	 */
	public void setQuantity3(int quantity3) {
		this.quantity3 = quantity3;
	}
	/**
	 * @return the quantity4
	 */
	public int getQuantity4() {
		return quantity4;
	}
	/**
	 * @param quantity4 the quantity4 to set
	 */
	public void setQuantity4(int quantity4) {
		this.quantity4 = quantity4;
	}
	/**
	 * @return the quantity5
	 */
	public int getQuantity5() {
		return quantity5;
	}
	/**
	 * @param quantity5 the quantity5 to set
	 */
	public void setQuantity5(int quantity5) {
		this.quantity5 = quantity5;
	}
	/**
	 * @return the quantity6
	 */
	public int getQuantity6() {
		return quantity6;
	}
	/**
	 * @param quantity6 the quantity6 to set
	 */
	public void setQuantity6(int quantity6) {
		this.quantity6 = quantity6;
	}
	/**
	 * @return the quantity7
	 */
	public int getQuantity7() {
		return quantity7;
	}
	/**
	 * @param quantity7 the quantity7 to set
	 */
	public void setQuantity7(int quantity7) {
		this.quantity7 = quantity7;
	}
	/**
	 * @return the quantity8
	 */
	public int getQuantity8() {
		return quantity8;
	}
	/**
	 * @param quantity8 the quantity8 to set
	 */
	public void setQuantity8(int quantity8) {
		this.quantity8 = quantity8;
	}
	/**
	 * @return the quantity9
	 */
	public int getQuantity9() {
		return quantity9;
	}
	/**
	 * @param quantity9 the quantity9 to set
	 */
	public void setQuantity9(int quantity9) {
		this.quantity9 = quantity9;
	}
	/**
	 * @return the quantity10
	 */
	public int getQuantity10() {
		return quantity10;
	}
	/**
	 * @param quantity10 the quantity10 to set
	 */
	public void setQuantity10(int quantity10) {
		this.quantity10 = quantity10;
	}

	/**
	 * @return the listProducts
	 */
	public List<Product> getListProducts() {
		return listProducts;
	}

	/**
	 * @param listProducts the listProducts to set
	 */
	public void setListProducts(List<Product> listProducts) {
		this.listProducts = (ArrayList<Product>) listProducts;
	}

	/**
	 * @return the listQuantities
	 */
	public List<Integer> getListQuantities() {
		return listQuantities;
	}

	/**
	 * @param listQuantities the listQuantities to set
	 */
	public void setListQuantities(List<Integer> listQuantities) {
		this.listQuantities = listQuantities;
	}
	
	
}
