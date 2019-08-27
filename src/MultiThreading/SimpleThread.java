package MultiThreading;

class Counter {
    int count;

    public void increment() {
        count++;
    }
}

class IncrementThread implements Runnable {

    Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++)
            counter.increment();
    }
}

public class SimpleThread {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Runnable r1 = new IncrementThread(counter);
        Runnable r2 = new IncrementThread(counter);

        Thread threadA = new Thread(r1);
        Thread threadB = new Thread(r2);

        threadA.start();
        threadB.start();


        threadA.join();
        threadB.join();

        System.out.println(counter.count);
    }
}
