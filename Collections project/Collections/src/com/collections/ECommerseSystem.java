package com.collections;
import java.util.*;
public class ECommerseSystem {
	

	
	    private List<Product> productCatalog = new ArrayList<>();
	    private Cart userCart = new Cart();
	    private List<Order> orderHistory = new LinkedList<>();

	    public void addProduct(int id, String name, double price) {
	        productCatalog.add(new Product(id, name, price));
	    }

	    public void displayProducts() {
	        if (productCatalog.isEmpty()) {
	            System.out.println("No products available.");
	        } else {
	            for (Product p : productCatalog) {
	                System.out.println(p);
	            }
	        }
	    }

	    public Product getProductById(int id) {
	        for (Product p : productCatalog) {
	            if (p.id == id) {
	                return p;
	            }
	        }
	        return null;
	    }

	    public void addToCart(int productId, int quantity) {
	        Product product = getProductById(productId);
	        if (product != null) {
	            userCart.addToCart(productId, quantity);
	            System.out.println(quantity + " x " + product.name + " added to cart.");
	        } else {
	            System.out.println("Product not found.");
	        }
	    }

	    public void checkout() {
	        if (userCart.getCartItems().isEmpty()) {
	            System.out.println("Cart is empty. Add products first.");
	            return;
	        }

	        List<Product> purchasedProducts = new ArrayList<>();
	        for (Map.Entry<Integer, Integer> entry : userCart.getCartItems().entrySet()) {
	            Product product = getProductById(entry.getKey());
	            if (product != null) {
	                purchasedProducts.add(product);
	            }
	        }

	        Order order = new Order(purchasedProducts);
	        orderHistory.add(order);
	        userCart.clearCart();

	        System.out.println("Order placed successfully! " + order);
	    }

	    public void viewOrderHistory() {
	        if (orderHistory.isEmpty()) {
	            System.out.println("No orders placed yet.");
	        } else {
	            for (Order order : orderHistory) {
	                System.out.println(order);
	            }
	        }
	    }

	    public static void main(String[] args) {
	    	ECommerseSystem system = new ECommerseSystem();

	        // Adding products to catalog
	        system.addProduct(1, "Laptop", 55000);
	        system.addProduct(2, "Mobile", 20000);
	        system.addProduct(3, "Headphones", 1500);

	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n==== E-Commerce System ====");
	            System.out.println("1. View Products");
	            System.out.println("2. Add to Cart");
	            System.out.println("3. Checkout");
	            System.out.println("4. View Order History");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    system.displayProducts();
	                    break;
	                case 2:
	                    System.out.print("Enter Product ID: ");
	                    int id = scanner.nextInt();
	                    System.out.print("Enter Quantity: ");
	                    int qty = scanner.nextInt();
	                    system.addToCart(id, qty);
	                    break;
	                case 3:
	                    system.checkout();
	                    break;
	                case 4:
	                    system.viewOrderHistory();
	                    break;
	                case 5:
	                    System.out.println("Exiting system. Thank you!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }
	        } while (choice != 5);

	        scanner.close();
	    }
	}



