package Chapter_3.Section_3;

import java.util.Date;

/**
 * <p>@description: 1)InheritableThreadLocal 使子线程从父线程中取值
 *                  2)子线程取到值的同时，主线程更改值，那么会取到旧值
 *
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-04-上午9:52
 **/
public class Test4 {
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            System.out.println("main :"+ToolsInheritable.local.get());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MyThreadA myThreadA = new MyThreadA();

        myThreadA.start();
    }
    static class MyThreadA extends Thread{

            @Override
            public void run() {
                super.run();
                for (int i=0;i<10;i++){

                    System.out.println("A :"+ToolsInheritable.local.get());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}
