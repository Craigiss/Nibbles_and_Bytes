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
	
	/**
	 * Converts attributes into a list of PurchaseOrderDetails
	 * @return
	 */
	public List<PurchaseOrderDetails> convert(){
		List<PurchaseOrderDetails> list = new ArrayList<PurchaseOrderDetails>();
		if(product1 != null && quantity1 > 0) list.add(new PurchaseOrderDetails(product1, quantity1));
		if(product2 != null && quantity2 > 0) list.add(new PurchaseOrderDetails(product2, quantity2));
		if(product3 != null && quantity3 > 0) list.add(new PurchaseOrderDetails(product3, quantity3));
		if(product4 != null && quantity4 > 0) list.add(new PurchaseOrderDetails(product4, quantity4));
		if(product5 != null && quantity5 > 0) list.add(new PurchaseOrderDetails(product5, quantity5));
		if(product6 != null && quantity6 > 0) list.add(new PurchaseOrderDetails(product6, quantity6));
		if(product7 != null && quantity7 > 0) list.add(new PurchaseOrderDetails(product7, quantity7));
		if(product8 != null && quantity8 > 0) list.add(new PurchaseOrderDetails(product8, quantity8));
		if(product9 != null && quantity9 > 0) list.add(new PurchaseOrderDetails(product9, quantity9));
		if(product10 != null && quantity10 > 0) list.add(new PurchaseOrderDetails(product10, quantity10));

		return list;
	}
	
	public void clean(){
		System.out.println("Cleaning the 'Add new PO' form");
		product1 = null;
		product2 = null;
		product3 = null;
		product4 = null;
		product5 = null;
		product6 = null;
		product7 = null;
		product8 = null;
		product9 = null;
		product10 = null;
		
		quantity1 = 0;
		quantity2 = 0;
		quantity3 = 0;
		quantity4 = 0;
		quantity5 = 0;
		quantity6 = 0;
		quantity7 = 0;
		quantity8 = 0;
		quantity9 = 0;
		quantity10 = 0;	
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
	
}
