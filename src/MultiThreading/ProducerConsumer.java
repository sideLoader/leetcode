package MultiThreading;

class Holder {
    int value;
    boolean isSet = false;

    public synchronized int get() {
        while(!isSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("get : " + value);
        isSet = false;
        notify();
        return value;
    }

    public synchronized void set(int value) {
        while(isSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }
        }

        System.out.println("set : " + value);
        isSet = true;
        this.value = value;
        notify();
    }
}

class Producer implements Runnable {

    Holder holder;
    public Producer(Holder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        int i = 0;
        while(true) {
             holder.set(i++);
             try {
                 Thread.sleep(5000);
             } catch (Exception e) {
                 e.printStackTrace();
             }
        }
    }
}

class Consumer implements Runnable {

    Holder holder;
    public Consumer(Holder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        while(true) {
            holder.get();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
 public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        Holder holder  = new Holder();

        Thread prod = new Thread(new Producer(holder));
        Thread cons = new Thread(new Consumer(holder));

        prod.start();
        cons.start();

        prod.join();
        cons.join();
        System.out.println("in main");
    }
}
