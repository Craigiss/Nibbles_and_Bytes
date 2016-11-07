package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import com.nb.gnome.helper.*;
import com.nb.gnome.managers.ProductRepository;
import com.nb.gnome.service.ProductService;
import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Supplier;

@Named("products")
@SessionScoped
public class ProductController implements Serializable {

	@Inject
	private ProductService productService;

	@Inject
	IMSUserCredentials userCredentials;

	@Inject
	private SelectedProduct product;
	private PaginationHelper pagination;
	private DataModel<Product> dataModel = null;
	private int productID;
	private String name;
	private String description;
	private double price;
	private int stockLevel;
	private int porousStockLevel;
	private List<Product> listData;
	private Supplier supplier;

	private void recreateModel() {
		dataModel = null;
	}

	public String reset() {
		dataModel = null;
		listData = null;
		return "imsIndex?faces-redirect=true";
	}

	public String goToAddProductPage() {
		String returnPage = "addProduct";
		if ((userCredentials.getName() == null)) {
			returnPage = "imsLogin?faces-redirect=true";
		}
		return returnPage;
	}

	public PaginationHelper getPagination() {
		if (pagination == null)
			pagination = new PaginationHelper(10) {
				@Override
				public int getItemsCount() {
					if (listData == null) {
						return productService.findAll().size();
					} else {
						return listData.size();
					}
				}

				@Override
				public DataModel<Product> createPageDataModel() {
					// Return products to fill page
					try {
						return new ListDataModel<Product>(
								listData.subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					}
					// Or if there aren't enough, return the rest of them
					catch (Exception e) {
						return new ListDataModel<Product>(listData.subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};

		return pagination;
	}

	public DataModel<Product> getDataModel() {
		if (listData == null) {
			listData = productService.findAll();
		}
		dataModel = getPagination().createPageDataModel();
		return dataModel;
	}

	public void setData(ArrayList<Product> model) {
		listData = model;
	}

	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "imsProducts?faces-redirect=true";
	}

	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "imsProducts?faces-redirect=true";
	}

	public String view(Product p) {
		String returnPage = "imsProdDeets?faces-redirect=true";
		if (!(userCredentials.getName() == null)) {
			product.setProduct(p);
		} else {
			returnPage = "imsLogin?faces-redirect=true";
		}
		return returnPage;
	}

	public String persistProduct() {
		System.out.println("In controller >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		productService.persistProduct(name, description, price, stockLevel, porousStockLevel, supplier);
		recreateModel();
		name = "";
		description = "";
		price = 0;
		stockLevel = 0;
		porousStockLevel = 0;
		supplier=null;
		reset();
		return "imsProducts?faces-redirect=true";
	}

	public List<Product> findAll() {
		return productService.findAll();
	}

	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}

	/**
	 * @param productID
	 *            the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the stockLevel
	 */
	public int getStockLevel() {
		return stockLevel;
	}

	/**
	 * @param stockLevel
	 *            the stockLevel to set
	 */
	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}

	/**
	 * @return the porousStockLevel
	 */
	public int getPorousStockLevel() {
		return porousStockLevel;
	}

	/**
	 * @param porousStockLevel
	 *            the porousStockLevel to set
	 */
	public void setPorousStockLevel(int porousStockLevel) {
		this.porousStockLevel = porousStockLevel;
	}

	/**
	 * @return the product
	 */
	public SelectedProduct getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(SelectedProduct product) {
		this.product = product;
	}

	public String productToString() {
		return product.getProduct().getProductName() + " " + product.getProduct().getStockLevel();
	}

	/**
	 * @return the listData
	 */
	public List<Product> getListData() {
		return listData;
	}

	/**
	 * @param listData
	 *            the listData to set
	 */
	public void setListData(List<Product> listData) {
		this.listData = listData;
	}

	/**
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	

}
