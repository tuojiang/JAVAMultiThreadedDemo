package Chapter_4.Section_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>@description: 用ReentrantLock + condition 实现 生产者/消费者 一对一模式
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-05-上午10:48
 **/
public class Test4 {
    public static void main(String[] args) {

        Myservice myservice = new Myservice();
        TheadA theadA = new TheadA(myservice);
        theadA.start();
        TheadB theadB = new TheadB(myservice);
        theadB.start();

    }
    static class Myservice{
        public boolean isTag = false;
        private Lock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();

        public void methodA(){
            try {
                lock.lock();
                while (isTag == true){
                    conditionA.await();
                }
                System.out.println("A begin ×××××××××××");
                isTag = true;
                conditionA.signal();
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
                    conditionA.await();
                }
                isTag = false;
                System.out.println("B begin =============");
                conditionA.signal();
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
