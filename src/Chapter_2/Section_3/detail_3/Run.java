package Chapter_2.Section_3.detail_3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>@description: 1)AtomicInteger是原子类，也能够实现同步。
 *
 * @author boboan
 * @version V1.0
 * @date 2018-05-31-上午9:59
 **/
public class Run {
    public static void main(String[] args) {

        Addcount addcount = new Addcount();
        Thread thread = new Thread(addcount);
        thread.start();
        Thread thread2 = new Thread(addcount);
        thread2.start();
        Thread thread3 = new Thread(addcount);
        thread3.start();
        Thread thread4 = new Thread(addcount);
        thread4.start();

    }
    static class Addcount extends Thread{

        private AtomicInteger atomicInteger = new AtomicInteger(0);

            @Override
            public void run() {
                super.run();
                for (int i=0;i<100;i++){
                    System.out.println(atomicInteger.incrementAndGet());
                }
            }
    }        
}
