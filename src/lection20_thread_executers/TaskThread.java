package lection20_thread_executers;

public class TaskThread implements Runnable {
    String name;
    long delay;

    TaskThread(String name, long delay) {
        this.name = name;
        this.delay = delay * 1000;
    }

    public void run() {
        System.out.println(String.format("%n%s \n" + "went to sleep", this.name));
        try {
            Thread.sleep(this.delay);
        } catch (InterruptedException ex) {
            System.out.println("Thread has been interrupted");
        }
        System.out.println(String.format("%n%s: i am sleep %d seconds", this.name, this.delay/1000));
    }
}
