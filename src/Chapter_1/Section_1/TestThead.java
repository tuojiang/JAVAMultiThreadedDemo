package Chapter_1.Section_1;

/**
 * @author boboan
 * @version V1.0
 * @description 2中创建线程的方式 1.继承Thread，重写run() 2.实现Runnable
 * @date 2018-05-25-上午10:31
 **/
public class TestThead {
    public static void main(String[] args) {

        Thread1 thread1 = new Thread1();
        thread1.start();
        Thread2 thread2 = new Thread2();
        Thread thread = new Thread(thread2);
        thread.start();

        System.out.println("i'm main"+Thread.currentThread().getName());
    }
    static class Thread1 extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("i'm thread 1");
        }
    }
    static class Thread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("i'm thread 2");
        }
    }
}
