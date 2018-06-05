package Chapter_4.Section_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>@description: 多个 Condtion 实现通知部分线程
 *                  1)创建不同 condition 对象，唤醒自己需要的。
 * @author boboan
 * @version V1.0
 * @date 2018-06-05-上午10:14
 **/
public class Test3 {
    public static void main(String[] args) throws InterruptedException {

        MyService myService = new MyService();
        MyThread myThread = new MyThread(myService);
        MyThreadB myThreadB = new MyThreadB(myService);
        myThread.start();
        myThreadB.start();
        Thread.sleep(3000);
//        myService.singnalA();
        myService.singnalB();

    }
    static class MyThread extends Thread{

        private MyService myService;

        public MyThread(MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            super.run();
            myService.awaitA();
        }
    }
    static class MyThreadB extends Thread{

        private MyService myService;

        public MyThreadB(MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            super.run();
            myService.awaitB();
        }
    }
    static class MyService{
        private Lock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();
        public void awaitA(){
            try {
                lock.lock();
                System.out.println("AAA,我马上就要等待啦～～～"+System.currentTimeMillis());
                conditionA.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void singnalA(){
            lock.lock();
            System.out.println("AAAA,我马上醒啦～～～"+System.currentTimeMillis());
            conditionA.signalAll();
            lock.unlock();
        }
    public void awaitB(){
        try {
            lock.lock();
            System.out.println("BBBBB,我马上就要等待啦～～～"+System.currentTimeMillis());
            conditionB.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void singnalB(){
        lock.lock();
        System.out.println("BBBBB,我马上醒啦～～～"+System.currentTimeMillis());
        conditionB.signalAll();
        lock.unlock();
    }
    }
}
