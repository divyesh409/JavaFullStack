package day13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {
    	
       TryCatchs1 obj1 = new TryCatchs1();
       obj1.m1();
       
       TryCatchs2 obj2 = new TryCatchs2();
       obj2.m2();
    }
}

class TryCatchs1{
	public void m1() {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter First Number");
	        int a = sc.nextInt();
	        
	       System.out.println("Enter Second Number");
	       int b = sc.nextInt();
	      
	       int c = a / b;  
	       System.out.println("Result: " + c);
	       
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
			
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		
		 sc.close();
	}
}

class TryCatchs2 {

    public void m2() {
        Scanner sc = new Scanner(System.in);
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        try {
            
            int i = sc.nextInt();    //Index

            
            arr[i] = sc.nextInt();   //Value

            System.out.println("Updated value at index " + i + ": " + arr[i]);
            
        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        } 

        sc.close();
    }
}
