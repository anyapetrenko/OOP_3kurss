//Phaser

import java.util.concurrent.Phaser;

class MyThread implements Runnable {
    Phaser phaser;
    String title;

    public MyThread(Phaser phaser, String title) {
        this.phaser = phaser;
        this.title = title;

        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Thread: " + title
                + " Phase Zero Started");
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread: " + title
                + " Phase One Started");
        phaser.arriveAndAwaitAdvance();

        // Stop execution to prevent jumbled output
        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread: " + title
                + " Phase Two Started");
        phaser.arriveAndDeregister();
    }
}

public class PhaserExample {
    public static void main(String[] args)
    {
        Phaser phaser = new Phaser();
        phaser.register();
        int currentPhase;

        System.out.println("Starting");

        new MyThread(phaser, "A");
        new MyThread(phaser, "B");
        new MyThread(phaser, "C");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase
                + " Complete");
        System.out.println("Phase Zero Ended");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase
                + " Complete");
        System.out.println("Phase One Ended");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase
                + " Complete");
        System.out.println("Phase Two Ended");

        phaser.arriveAndDeregister();
        if (phaser.isTerminated()) {
            System.out.println("Phaser is terminated");
        }
    }
}
