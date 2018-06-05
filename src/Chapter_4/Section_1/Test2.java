package Chapter_4.Section_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>@description: 1）ReentrantLock + Condition 可以实现“选择性通知”，Condition 类中默认提供的。更加灵活。
 *                  2）synchronized 就像是只注册了一个 Condition 对象。
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-05-上午9:36
 **/
public class Test2 {

    public static void main(String[] args) throws InterruptedException {

        MyService myService = new MyService();
        MyThread myThread = new MyThread(myService);
        myThread.start();
        Thread.sleep(3000);
        myService.singnal();

    }
    static class MyThread extends Thread{

        private MyService myService;

        public MyThread(MyService myService) {
            this.myService = myService;
        }

        @Override
            public void run() {
                super.run();
                myService.await();
            }
    }
    static class MyService{
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        public void await(){
            try {
                lock.lock();
                System.out.println("AAAA,我马上就要等待啦～～～"+System.currentTimeMillis());
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void singnal(){
            lock.lock();
            System.out.println("AAAA,我马上醒啦～～～"+System.currentTimeMillis());
            condition.signal();
            lock.unlock();
        }
    }
}
