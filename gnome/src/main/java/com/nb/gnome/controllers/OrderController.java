package com.nb.gnome.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.SalesOrder;
import com.nb.gnome.helper.PaginationHelper;
import com.nb.gnome.managers.SalesOrderRepository;

@Named ("order")
@SessionScoped
public class OrderController implements Serializable {
	@Inject
	private SalesOrderRepository salesOrderManager;
	private SalesOrder salesOrder;
	private PaginationHelper pagination;
	private int selected;
	private DataModel<SalesOrder> dataModel = null; 
	
	private void recreateModel(){
		dataModel = null; 
	}
	
	public PaginationHelper getPagination(){
		if (pagination == null) pagination = new PaginationHelper(10){
			@Override public int getItemsCount(){
				return salesOrderManager.findAll().size();
			}
			
			@Override public DataModel<SalesOrder>createPageDataModel(){
				try{ 
					return new ListDataModel<SalesOrder>(salesOrderManager.findAll().subList(getPageFirstItem(),getPageFirstItem() + getPageSize()));
				} catch (Exception e){ return new ListDataModel<SalesOrder>(salesOrderManager.findAll().subList(getPageFirstItem(),getItemsCount()));
			}
		}
	}
}
