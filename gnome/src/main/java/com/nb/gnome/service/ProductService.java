package com.nb.gnome.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.nb.gnome.managers.ProductRepository;

import gnome.InitialData;

@Stateless
public class ProductService {
	
	@Inject
	private ProductRepository productManager;
	@Inject
	private InitialData initialData;

	
	//To-do
}
