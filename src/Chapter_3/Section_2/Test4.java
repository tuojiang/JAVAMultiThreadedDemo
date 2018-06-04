package Chapter_3.Section_2;

/**
 * <p>@description: 1)join(long) 后面的代码提前运行 why?
 *                  2)设置等待时间超时，释放锁，执行后面的代码
 *
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午5:54
 **/
public class Test4 {
    public static void main(String[] args) {

        try {
            MyThreadB myThreadb = new MyThreadB();
            MyThread myThread = new MyThread(myThreadb);
            myThread.start();
            myThreadb.start();
            myThreadb.join();
            System.out.println("main time"+System.currentTimeMillis());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    static class MyThread extends Thread{
            private MyThreadB myThreadB;

        public MyThread(MyThreadB myThreadB) {
            this.myThreadB = myThreadB;
        }

        @Override
            public void run() {
            synchronized (myThreadB) {
                try {
                    super.run();
                    System.out.println("A begin time" + System.currentTimeMillis());
                    Thread.sleep(5000);
                    System.out.println("A end time" + System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class MyThreadB extends Thread{

        @Override
       synchronized public void run() {
            try {
                super.run();
                System.out.println("B begin time"+System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("B end time"+System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
