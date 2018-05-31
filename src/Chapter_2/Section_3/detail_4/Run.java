package Chapter_2.Section_3.detail_4;

import java.util.concurrent.atomic.AtomicLong;
/**
 * <p>@description:  1)原子类在具有逻辑的情况下不一定正确。
 *                   2)用同步解决
 * @author boboan
 * @version V1.0
 * @date 2018-05-31-上午10:19
 **/
public class Run {
    public static void main(String[] args) {


        AtmoicNotSafe atmoicNotSafe = new AtmoicNotSafe();
        MyThrea[] myThrea = new MyThrea[5];
        for (int i=0;i<myThrea.length;i++){
            myThrea[i]=new MyThrea(atmoicNotSafe);
        }
        for (int i=0;i<myThrea.length;i++){
            myThrea[i].start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(AtmoicNotSafe.atomicLong);
    }

    static class AtmoicNotSafe{
        private static AtomicLong atomicLong = new AtomicLong();
        synchronized public void addLong(){
            System.out.println("Name :" +Thread.currentThread().getName()+"加100的值是"+atomicLong.addAndGet(100));
            atomicLong.addAndGet(1);
        }
    }
    static class MyThrea extends Thread{
        private AtmoicNotSafe atmoicNotSafe;

        public MyThrea(AtmoicNotSafe atmoic){
            this.atmoicNotSafe = atmoic;
        }
            @Override
            public void run() {
                super.run();
                atmoicNotSafe.addLong();
            }
    }
}
