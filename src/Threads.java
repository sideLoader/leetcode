
class ExampleThread implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class Threads {
    public static void main(String args[]) {
        Thread t1 = new Thread(new ExampleThread(), "thread1");
        Thread t2 = new Thread(new ExampleThread(), "thread2");

        t2.start();
        t1.start();
    }
}
