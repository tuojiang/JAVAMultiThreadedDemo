package Chapter_1.Section_2;

/**
 * @author boboan
 * @version V1.0
 * @description 当出现i--和sout出现的异常情况，因为sout内部是同步的,进入sout线程前情况发送操作的，所以出现异常，添加synchronized解决
 * @date 2018-05-25-下午1:24
 **/
public class Run4 {
    public static void main(String[] args) {

        ThreadA threadA = new ThreadA();
        Thread a = new Thread(threadA);
        Thread b = new Thread(threadA);
        Thread c = new Thread(threadA);
        Thread d = new Thread(threadA);
        Thread e = new Thread(threadA);
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
    static class ThreadA extends Thread{
        int i = 5;
        @Override
        synchronized public void run() {
            super.run();
            System.out.println("i'm ThreadA and i ="+i--);
        }
    }
}
