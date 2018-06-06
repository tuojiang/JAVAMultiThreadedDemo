package Chapter_6;

/**
 * Created by boboan on 2018/6/5.
 */
public class Run2 {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        t1.start();
    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println(MyObject2.getInstance().hashCode());
        }
    }
}
