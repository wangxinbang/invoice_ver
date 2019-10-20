package test.bang.invoice_ver;

public class ProductTest {
    
    static class Clerk{
        private static final int MAX = 20; 
        private static final int MIN = 0; 
        private int now = 0;
        public synchronized void add(){
            if(now >= MAX){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
            now++;
            System.out.println("生产者生产了第" + now + "个产品");
            notifyAll();
        }
        public synchronized void get(){
            if(now <= MIN){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
            System.out.println("消费者消费了第" + now + "个产品");
            now--;
            notifyAll();
        }
    }
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        new Thread(new Producer(clerk)).start();
        new Thread(new Consumer(clerk)).start();
    }
    static class Producer implements Runnable{
        private Clerk clerk;
        public Producer(Clerk clerk) {
            this.clerk = clerk;
        }
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clerk.add();
            }
        }
    }
    static class Consumer implements Runnable{
        private Clerk clerk;
        public Consumer(Clerk clerk) {
            this.clerk = clerk;
        }
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clerk.get();
            }
        }
    }
}
