package Chapter_1.Section_2;

/**
 * @author boboan
 * @version V1.0
 * @description 线程运行的时间是随机的
 * @date 2018-05-25-上午10:45
 **/
public class Run {
    public static void main(String[] args) {
        Mythread mythread = new Mythread(0);
        Mythread mythread1 = new Mythread(1);
        Mythread mythread2 = new Mythread(2);
        Mythread mythread3 = new Mythread(3);
        Mythread mythread4 = new Mythread(4);
        Mythread mythread5 = new Mythread(5);
        Mythread mythread6 = new Mythread(6);
        Mythread mythread7 = new Mythread(7);
        mythread.start();
        mythread1.start();
        mythread2.start();
        mythread3.start();
        mythread4.start();
        mythread5.start();
        mythread6.start();
        mythread7.start();
        System.out.println("i'm main"+Thread.currentThread().getName());
    }
    static class Mythread extends Thread{
        private int a ;
        public Mythread(int s) {
            this.a = s;
        }

        @Override
        public void run() {
            super.run();
            System.out.println(a);
        }
    }
}
