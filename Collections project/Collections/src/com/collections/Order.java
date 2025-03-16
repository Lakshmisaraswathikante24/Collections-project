package com.collections;

import java.util.LinkedList;
import java.util.List;

public class Order {
	
	    static int orderCount = 1;
	    int orderId;
	    List<Product> orderedProducts = new LinkedList<>();

	    public Order(List<Product> products) {
	        this.orderId = orderCount++;
	        this.orderedProducts.addAll(products);
	    }

	    @Override
	    public String toString() {
	        return "Order ID: " + orderId + ", Products: " + orderedProducts;
	    }
	}



