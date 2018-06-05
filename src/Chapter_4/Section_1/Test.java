package Chapter_4.Section_1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>@description: ReentrantLock 类也是同步执行的,一样能实现同步互斥效果。
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-04-上午11:12
 **/
public class Test {
    public static void main(String[] args) {


        MyService myService = new MyService();
        MyThread myThread = new MyThread(myService);
        MyThread myThread2 = new MyThread(myService);
        MyThread myThread3 = new MyThread(myService);
        MyThread myThread4 = new MyThread(myService);
        myThread.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
    }
    static class MyThread extends Thread{

        private MyService myService;

        public MyThread(MyService myService) {
            this.myService = myService;
        }

        @Override
            public void run() {
                super.run();
                myService.testMethod();
            }
    }
    static class MyService{
        private Lock lock = new ReentrantLock();
        public void testMethod(){
            lock.lock();
            for (int i=0;i<5;i++){
                System.out.println("Thread name="+Thread.currentThread().getName()+(""+(i+1)));
            }
            lock.unlock();

        }
    }
}
