package Day18;

import java.util.ArrayList;
import java.util.Stack;

public class CollectionFramework {
    
	public static void main(String[] args) {
		ArrayList<String>arr = new ArrayList<>();
		
		arr.add("A");     //A
		arr.add("B");     //B
		arr.add("C");     //C
		arr.add("D");     //D
		arr.add("E");     //E
		
		System.out.println(arr);     //[A, B, C, D, E]
		
//		arr.remove(6);              //Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 6 out of bounds for length 5
		
		
		System.out.println(arr.remove(3));    //D
		
		System.out.println(arr);         //[A, B, C, E]
		
		System.out.println(arr.set(3, "F"));      //E
		System.out.println(arr);        //[A, B, C, F]
		
//		System.out.println(arr.clear());     //Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
//		The method println(boolean) in the type PrintStream is not applicable for the arguments (void)
		
		arr.clear();

		System.out.println(arr);         //[]
		
		
		Stack <String> s = new Stack<>();
		
		s.push("1");
		s.push("2");
		s.push("3");
		s.push("4");
		s.push("5");
		s.push("6");
		
		System.out.println(s);       //[1, 2, 3, 4, 5, 6]
		
		System.out.println(s.pop());     // 6 is popped 
		
		System.out.println(s);
		
		
		
		
	}
}
