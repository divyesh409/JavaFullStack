package day16homeWork;

class AlphabetPrinter implements Runnable {
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println("Alphabet: " + ch);
        }
    }
}

class Number implements Runnable {
    public void run() {
        for (int i = 1; i <= 26; i++) {
            System.out.println("Number: " + i);
        }
    }
}

public class Que5 {
    public static void main(String[] args) {
        AlphabetPrinter alpha = new AlphabetPrinter();
        NumberPrinter num = new NumberPrinter();

        Thread t1 = new Thread(alpha);
        Thread t2 = new Thread(num);

        t1.start();
        t2.start();
    }
}
