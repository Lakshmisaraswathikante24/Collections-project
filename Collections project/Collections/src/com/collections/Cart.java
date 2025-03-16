package com.collections;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	    private Map<Integer, Integer> cartItems = new HashMap<>();

	    public void addToCart(int productId, int quantity) {
	        cartItems.put(productId, cartItems.getOrDefault(productId, 0) + quantity);
	    }

	    public Map<Integer, Integer> getCartItems() {
	        return cartItems;
	    }

	    public void clearCart() {
	        cartItems.clear();
	    }
	}



