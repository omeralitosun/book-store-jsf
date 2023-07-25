package com.jakarta;


import java.io.Serializable;

import com.dataAccess.ProductModel;
import com.entities.Product;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;


@Named
@SessionScoped
public class ProductManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product;
	private String result = "None";

	public Product getProduct() {
		return product;
	}
	public String onload() {
		return "index";
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setResult(String result) {
		this.result=result;
	}
	public String getResult() {
		return this.result;
	}
	public ProductManagedBean() {
		this.product = new Product();
	}

	public String save() {
		this.product.setId(0);
		ProductModel productModel = new ProductModel();
		this.result = productModel.create(this.product);
		return "index";
	}

}