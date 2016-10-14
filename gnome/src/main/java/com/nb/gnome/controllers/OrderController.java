package com.nb.gnome.controllers;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.nb.gnome.entities.SalesOrder;

import gnome.SalesOrderRepository;

@Named ("order")
@SessionScoped
public class OrderController implements Serializable {
	@Inject
	private SalesOrderRepository salesOrderManager;
	private SalesOrder order;
}