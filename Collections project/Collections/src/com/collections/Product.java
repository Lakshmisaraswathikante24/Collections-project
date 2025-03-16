package com.collections;

import java.util.*;
public class Product {
	

	
	    int id;
	    String name;
	    double price;

	    public Product(int id, String name, double price) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	    }

	    @Override
	    public String toString() {
	        return "Product ID: " + id + ", Name: " + name + ", Price: " + price;
	    }
	}


