package Chapter_3.Section_1;


/**
 * <p>@description: 1)wait()停止线程。
 *                  2)notify()唤醒线程。
 *
 * @author boboan
 * @version V1.0
 * @date 2018-05-31-下午2:25
 **/
public class Test2 {
    public static void main(String[] args) {

        Object lock = new Object();
        MyThreadA myThreadA = new MyThreadA(lock);
        myThreadA.start();
        MyThreadB myThreadB = new MyThreadB(lock);
        myThreadB.start();

    }

    static class MyThreadA extends Thread {

        private Object lock;

        public MyThreadA(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                super.run();
                synchronized (lock) {
                    System.out.println("A begin --" + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("A end --" + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class MyThreadB extends Thread {

        private Object lock;

        public MyThreadB(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                super.run();
                synchronized (lock) {
                    System.out.println("B begin --" + System.currentTimeMillis());
                    lock.notify();
                    System.out.println("B end --" + System.currentTimeMillis());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
