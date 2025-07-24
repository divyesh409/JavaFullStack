package day16homeWork;

class NumberPrinter implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e);
            }
        }
    }
}

public class Que3 {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();
        Thread t = new Thread(printer);
        t.start();
    }
}

