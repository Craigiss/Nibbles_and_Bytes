package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.richfaces.model.StringChartDataModel;

import com.nb.gnome.entities.Product;
import com.nb.gnome.service.ProductService;

import gnome.InitialData;

import org.richfaces.model.ChartDataModel;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.DataModel;

@Named("graphs")
@SessionScoped
public class GraphController implements Serializable {

	
	@Inject
	private ProductService prodServ;
	@Inject private InitialData initialData;
	StringChartDataModel pie;
	private DataModel<Product> productDataModel;
	
	@PostConstruct
	public void init() {
		generateProductStockLevel();
	}

	public void generateProductStockLevel() {
		pie = new StringChartDataModel(ChartDataModel.ChartType.pie);

		ArrayList<Product> products = new ArrayList<Product>();
		for (Product p : initialData.getProducts()) {
			if (p.isDeleted() == false) {
				pie.put(p.getProductName(), p.getStockLevel());
			}
		}
	}

	public StringChartDataModel getPie() {
		return pie;
	}
	
	public void setPie(String name, int value){
		pie.put(name, value);
	}
	
	public void removeSegment(String name){
		pie.remove(name);
	}
	

	/**
	 * @return the productDataModel
	 */
	public DataModel<Product> getProductDataModel() {
		try{
				if (productDataModel == null){
					productDataModel.setWrappedData(prodServ.findCriticalStock());
				System.out.println(productDataModel.getRowCount());
				}
				
			}
			catch(NullPointerException e){
				System.out.println("Nothing here");
			}
		return productDataModel;
	}
	

	public String reset() {
		return "imsIndex";
	}
}
