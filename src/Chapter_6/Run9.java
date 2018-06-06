package Chapter_6;

/**
 * Created by boboan on 2018/6/5.
 */
public class Run9 {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t3.start();
        t2.start();
    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 5; i++) {
                System.out.println(MyObject9.getComTag());
            }
        }
    }

}
