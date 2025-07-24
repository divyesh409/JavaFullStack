package day16homeWork;

public class Que4 {
    public static void main(String[] args) {
        System.out.println("Countdown starts:");

        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Countdown interrupted: " + e);
            }
        }

        System.out.println("Time's up!");
    }
}

