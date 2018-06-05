package Chapter_4.Section_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>@description: 1)用 ReentrantLock + condition 实现 生产者/消费者 多对多模式
 *                  2)用 signalAll() 解决假死问题。
 *                  3）出现连续打印的原因：一个condition对象，有可能唤醒的是同类，所以就又打印一次。
 * @author boboan
 * @version V1.0
 * @date 2018-06-05-上午10:48
 **/
public class Test5 {
    public static void main(String[] args) {

        Myservice myservice = new Myservice();
        TheadA[] theadAS = new TheadA[10];
        TheadB[] theadBS = new TheadB[10];
        for (int i = 0; i < 10; i++) {
            theadAS[i] = new TheadA(myservice);
            theadBS[i] = new TheadB(myservice);
            theadAS[i].start();
            theadBS[i].start();
        }

    }
    static class Myservice{
        public boolean isTag = false;
        private Lock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();

        public void methodA(){
            try {
                lock.lock();
                while (isTag == true){
                    System.out.println("A 连接×××××××××××");
                    conditionA.await();
                }
                System.out.println("A begin ×××××××××××");
                isTag = true;
                conditionA.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();

            }
        }
        public void methodB(){
            try {
                lock.lock();
                while (isTag == false){
                    System.out.println("B 连接×××××××××××");
                    conditionA.await();
                }
                isTag = false;
                System.out.println("B begin =============");
                conditionA.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();

            }
        }

    }
    static class TheadA extends Thread{

        private Myservice myservice;


        public TheadA(Myservice myservice) {
            this.myservice = myservice;
        }

        @Override
            public void run() {
                super.run();
            for (int i = 0; i < 5; i++) {
                myservice.methodA();

            }
        }
    }
    static class TheadB extends Thread{

        private Myservice myservice;


        public TheadB(Myservice myservice) {
            this.myservice = myservice;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 5; i++) {
            myservice.methodB();

            }
            }
        }

}
