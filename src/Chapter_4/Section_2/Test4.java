package Chapter_4.Section_2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>@description: 1)ReentrantReadWriteLock 写读互斥
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-05-下午2:07
 **/
public class Test4 {
    public static void main(String[] args) {

        Service service = new Service();
        MyThreadB myThreadB = new MyThreadB(service);
        myThreadB.setName("B");
        myThreadB.start();
        MyThreadA myThreadA = new MyThreadA(service);
        myThreadA.setName("A");
        myThreadA.start();
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
                service.testMethod2();
            }
    }
    static class Service{
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        public void testMethod(){
            try {
                lock.writeLock().lock();
                System.out.println(" 获得写锁"+Thread.currentThread().getName()+"，时间="+System.currentTimeMillis());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.writeLock().unlock();
            }
        }
        public void testMethod2(){
            try {
                lock.readLock().lock();
                System.out.println(" 获得读锁"+Thread.currentThread().getName()+"，时间="+System.currentTimeMillis());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.readLock().unlock();
            }
        }
    }
}
