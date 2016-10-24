package com.nb.gnome.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.nb.gnome.entities.Supplier;

@Named("selectedSupplier")
@SessionScoped
public class SelectedSupplier implements Serializable {
	private Supplier supplier;

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