package zy.cy6.dqyt.zygl.webui.resource;


import org.springframework.hateoas.Resource;

import zy.cy6.dqyt.zygl.query.product.ProductEntry;

public class ProductResource  extends Resource<ProductEntry>{
	                                  
	public static final String PRODUCT = "product";
	public static final String PRODUCTS = "products";
	public static final String PRODUCTS_PATH = "/products";
	

	public ProductResource(ProductEntry productEntry) {
		super(productEntry);
	}


}


