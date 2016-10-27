package com.nb.gnome.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.nb.gnome.entities.Product;
import com.nb.gnome.entities.Supplier;
import com.nb.gnome.helper.PaginationHelper;
import com.nb.gnome.service.SupplierService;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "suppliers")
@SessionScoped
public class SupplierController implements Serializable {
	@Inject
	private SupplierService supplierService;

	// private Supplier supplier;
	@Inject
	private SelectedSupplier supplier;
	private String company;
	private String name;
	private String email;
	private String phone;
	private String description;
	private PaginationHelper pagination;
	private DataModel<Supplier> dataModel = null;

	public void recreateModel() {
		dataModel = null;
	}

	public String reset() {
		dataModel = null;
		return "imsIndex";

	}

	public PaginationHelper getPagination() {
		if (pagination == null)
			pagination = new PaginationHelper(10) {
				@Override
				public int getItemsCount() {
					if (dataModel == null) {
						return supplierService.findAll().size();
					} else {
						//return amount of products in the whole data model (think in terms of search results - not all suppliers)
						return dataModel.getRowCount() + (pagination.getPage() * pagination.getPageSize());
					}
				}

				@Override
				public DataModel<Supplier> createPageDataModel() {
					try {
						return new ListDataModel<Supplier>(supplierService.findAll().subList(getPageFirstItem(),
								getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Supplier>(
								supplierService.findAll().subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};
		return pagination;
	}

	public DataModel<Supplier> getDataModel() {
		if (dataModel == null)
			dataModel = getPagination().createPageDataModel();
		return dataModel;

	}

	public void setData(ArrayList<Supplier> model) {
		dataModel.setWrappedData(model);
	}

	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "browse";
	}

	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "imsSuppliers";
	}

	public String view(Supplier s) {
		supplier.setSupplier(s);
		return "imsSupplierDeets";
	}

	public List<Supplier> findAll() {
		return supplierService.findAll();
	}

	/**
	 * adds a new supplier via various convoluted methods in different classes
	 */

	public String persistSupplier() {
		supplierService.persistSupplier(company, name, phone, email, description);
		recreateModel();
		getDataModel();

		company = "";
		name = "";
		phone = "";
		email = "";
		description = "";

		return "imsSuppliers";
	}

	/**
	 * finds a supplier by a given company name
	 * 
	 * @param comp
	 */
	public void findSupplierByCompany(String comp) {
		supplierService.findSupplierByCompany(comp);
	}

	/**
	 * @return the supplierService
	 */
	public SupplierService getSupplierService() {
		return supplierService;
	}

	/**
	 * @param supplierService
	 *            the supplierService to set
	 */
	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set (these auto-generated comments are lol)
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param pagination
	 *            the pagination to set
	 */
	public void setPagination(PaginationHelper pagination) {
		this.pagination = pagination;
	}

	/**
	 * @param dataModel
	 *            the dataModel to set
	 */
	public void setDataModel(DataModel<Supplier> dataModel) {
		this.dataModel = dataModel;
	}
}
