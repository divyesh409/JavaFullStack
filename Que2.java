package day16homeWork;

class EvenPrinter implements Runnable {
    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.println("Even: " + i);
        }
    }
}

class OddPrinter implements Runnable {
    public void run() {
        for (int i = 1; i <= 19; i += 2) {
            System.out.println("Odd: " + i);
        }
    }
}

public class Que2 {
    public static void main(String[] args) {
        EvenPrinter even = new EvenPrinter();
        OddPrinter odd = new OddPrinter();

        Thread t1 = new Thread(even);
        Thread t2 = new Thread(odd);

        t1.start(); 
        t2.start(); 
    }
}

