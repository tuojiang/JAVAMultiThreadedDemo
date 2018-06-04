package Chapter_3.Section_3;

import java.util.Date;

/**
 * <p>@description: 1)验证 ThreadLocal 的隔离性
 *
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-04-上午9:52
 **/
public class Test3 {
    public static void main(String[] args) {
        MyThreadA myThreadA = new MyThreadA();
        MyThreadB myThreadB = new MyThreadB();
        myThreadA.start();
        myThreadB.start();
    }
    static class MyThreadA extends Thread{

            @Override
            public void run() {
                super.run();
                System.out.println("time A :"+new Date());
                if (Tools.threadLocal.get() == null) {
                    System.out.println("A 没有初始值");
                    try {
                        Tools.threadLocal.set(new Date());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (int i=0;i<10;i++){

                    System.out.println("A :"+Tools.threadLocal.get());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
    static class MyThreadB extends Thread{

        @Override
        public void run() {
            super.run();
            System.out.println("time B :"+new Date());
            if (Tools.threadLocal.get() == null) {
                System.out.println("B 没有初始值");
            }
            for (int i=0;i<10;i++){

                System.out.println("B :"+Tools.threadLocal.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
