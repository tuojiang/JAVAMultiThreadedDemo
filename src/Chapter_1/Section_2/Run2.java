package Chapter_1.Section_2;

/**
 * @author boboan
 * @version V1.0
 * @description 数据共享状态，加上synchronized关键字使方法变成同步方法，同时会给线程加锁，变成“临界区/互斥区”，其他线程会不停的尝试拿到这把锁，直到拿到为止。
 * @date 2018-05-25-上午10:55
 **/
public class Run2 {
    public static void main(String[] args) {

        MyThread threada = new MyThread();
//        MyThreadshare threada = new MyThreadshare();
        Thread a = new Thread(threada,"A");
        Thread b = new Thread(threada,"B");
        Thread c = new Thread(threada,"C");
        Thread d = new Thread(threada,"D");
        a.start();
        b.start();
        c.start();
        d.start();
    }
    /**
     * 数据共享状态
     */
    static class MyThreadshare extends Thread{
        private int a = 5;

        @Override
        synchronized public void run() {
            super.run();
                a--;
                System.out.println("i'm count :"+a+";由线程"+Thread.currentThread().getName()+"执行");
        }
    }
    /**
     * 数据不共享状态
     */
    static class MyThread extends Thread{
        int a = 5;


        @Override
        public void run() {
            super.run();
            while (a>0){
                a--;
                System.out.println("i'm count :"+a+";由线程"+Thread.currentThread().getName()+"执行");
            }
        }
    }
}
