package projectTask;

import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id, qty;
    String name;

    Product(int id, String name, int qty) {
        this.id = id;
        this.name = name;
        this.qty = qty;
    }

    public String toString() {
        return id + ". " + name + " - Qty: " + qty;
    }
}

public class Project1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<>();

        while (true) {
            System.out.println("\n1.Add Product");
            
            System.out.println("2.Update Product");
            
            System.out.println("3.View All Products");
            
            System.out.println("4.Remove Product");
            
            System.out.println("5.Clear All Products");
            
            System.out.println("6.Exit");
            
            System.out.print("Enter choice: ");
            
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Enter Product ID: ");
                int id = sc.nextInt();
                
                System.out.print("Enter Product Name: ");
                String name = sc.next();
                
                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();
                
                list.add(new Product(id, name, qty));
                System.out.println("Product added!");
                
            }
            else if (ch == 2) {
                System.out.print("Enter ID to update: ");
                int id = sc.nextInt();
                
                for (Product p : list) {
                    if (p.id == id) {
                        System.out.print("Enter new quantity: ");
                        p.qty = sc.nextInt();
                        System.out.println("Updated!");
                        break;
                    }
                }
            }
            else if (ch == 3) {
                if (list.isEmpty())
                	System.out.println("No products.");
                
                else 
                	for (Product p : list) {
                		System.out.println(p);
                	}
                		
            } 
            else if (ch == 4) {
                System.out.print("Enter ID to remove: ");
                
                int id = sc.nextInt();
                list.removeIf(p-> p.id == id);
                System.out.println("Removed!");
                
            }
            else if (ch == 5) {
                list.clear();
                System.out.println("All products cleared!");
                }
            else if (ch == 6) {
                System.out.println("Exiting...");
                break;
            } 
                else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close(); 
    }
    
}
