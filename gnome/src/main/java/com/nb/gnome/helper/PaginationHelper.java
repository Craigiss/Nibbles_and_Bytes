package com.nb.gnome.helper;

import javax.faces.model.DataModel;

/* Code taken from the lectures for pagination */

public abstract class PaginationHelper{
	private int itemsPerPage;
	private int page;
	
	
	public PaginationHelper(int itemsPerPage){
		this.itemsPerPage = itemsPerPage;
		page = 0;
	}
	
	public abstract int getItemsCount();
	public abstract DataModel createPageDataModel();
	
	public int getPageFirstItem(){
		return page * itemsPerPage;
	}
	
	public int getPageLastItem(){
		int i = getPageFirstItem() + itemsPerPage - 1;
		int count = getItemsCount() - 1;
		if (count > i){
			//i = count;
		}
		else{
			i = getItemsCount() - 1;
		}
		if (i < 0){
			i = 0;
		}
		return i;
	}
	
	public boolean isHasNextPage(){
		return (page + 1) * itemsPerPage + 1 <= getItemsCount();
	}
	
	public boolean isHasPreviousPage(){
		return page > 0;
	}
	
	public void nextPage(){
		if (isHasNextPage())
			page++;
	}
	
	public void previousPage(){
		if (isHasPreviousPage())
			page--;
	}
	
	public int getPageSize(){
		return itemsPerPage;
	}
	
	public void setPageSize(int itemsPerPage){
		this.itemsPerPage = itemsPerPage;
	}
}