package Chapter_4.Section_1;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>@description: 1)Lock 锁分为公平锁和非公平锁
 *                  2）公平锁就是线程获取锁是按照 FIFO 先进先出顺序的
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-05-下午12:06
 **/
public class Test6 {
    public static void main(String[] args) {
        ServiceA serviceA = new ServiceA(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("===="+Thread.currentThread().getName()+"运行了");
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {

            threads[i].start();

        }
    }
    static class ServiceA{
        private ReentrantLock lock;
        ServiceA(boolean fair){
            lock = new ReentrantLock(fair);

        }
        public void testMethod(){
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获得锁");
        }
    }
}
