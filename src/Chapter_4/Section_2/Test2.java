package Chapter_4.Section_2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>@description: 1)ReentrantReadWriteLock 写写互斥
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-05-下午2:07
 **/
public class Test2 {
    public static void main(String[] args) {

        Service service = new Service();
        MyThreadA myThreadA = new MyThreadA(service);
        MyThreadB myThreadB = new MyThreadB(service);
        myThreadA.start();
        myThreadB.start();
    }
    static class MyThreadB extends Thread{

        Service service;

        public MyThreadB(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            super.run();
            service.testMethod();
        }
    }
    static class MyThreadA extends Thread{

       Service service;

        public MyThreadA(Service service) {
            this.service = service;
        }

        @Override
            public void run() {
                super.run();
                service.testMethod();
            }
    }
    static class Service{
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        public void testMethod(){
            try {
                lock.writeLock().lock();
                System.out.println("获得写锁"+Thread.currentThread().getName()+"，时间="+System.currentTimeMillis());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.writeLock().unlock();
            }
        }
    }
}
