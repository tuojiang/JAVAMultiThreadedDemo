package Chapter_1.Section_10;

/**
 * @author boboan
 * @version V1.0
 * @description 1)setPriority()为线程设置优先级，设置范围为1~10；不在范围内的会抛出IllegalArgumentException异常
 *              2）线程的优先级具有继承性.
 *              3)优先级具有规则性:高优先级的线程总是大部分先执行完，但不代表高优先级的线程全部执行完。CPU尽量把资源让给优先级高的线程。
 *              4）优先级具有随机性：优先级高的线程不一定每次都都先执行完。
 * @date 2018-05-28-上午9:55
 **/
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setPriority(10);
        myThread.start();
        MyThread2 myThread2 = new MyThread2();
//        myThread2.setPriority(5);
        myThread2.start();
    }

    static class MyThread extends Thread{

            @Override
            public void run() {
                super.run();
                System.out.println("My Priority is "+Thread.currentThread().getPriority());
//                MyThread2 myThread2 = new MyThread2();
//                myThread2.start();
            }
    }
    static class MyThread2 extends MyThread{

        @Override
        public void run() {
            super.run();
            System.out.println("My 2 Priority is "+Thread.currentThread().getPriority());
        }
    }
}
