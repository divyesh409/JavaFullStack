package multiThreding;

public class multithread1{
	public void t1() {
		
		try {
			Thread.sleep(5000);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	       for(int i=1;i<=100;i++){
	           System.out.println(i+" ");
	           
	           try {
						Thread.sleep(100);
					 } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					 }
	       }
		}

      public static void main(String[] args) {
			multithread1 obj = new multithread1();
		    obj.t1();
		}
}
