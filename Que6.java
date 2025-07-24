package day16homeWork;

class Turtle implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Turtle step: " + i);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Turtle interrupted");
            }
        }
    }
}

class Rabbit implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Rabbit step: " + i);
            try {
                Thread.sleep(300); 
            } catch (InterruptedException e) {
                System.out.println("Rabbit interrupted");
            }
        }
    }
}

public class Que6 {
    public static void main(String[] args) {
        Thread turtleThread = new Thread(new Turtle());
        Thread rabbitThread = new Thread(new Rabbit());

        turtleThread.start();
        rabbitThread.start();
    }
}

