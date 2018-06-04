package Chapter_3.Section_2;

/**
 * <p>@description: 1)join() 运行中出现中断，抛出异常
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午5:54
 **/
public class Test2 {
    public static void main(String[] args) {

        try {
            MyThread myThread = new MyThread();
            MyThreadB myThreadB = new MyThreadB(myThread);
            myThreadB.start();
            System.out.println("等你运行完了我在来把～～～");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static class MyThreadB extends Thread{

        private MyThread myThread;

        public MyThreadB(MyThread myThread) {
            this.myThread = myThread;
        }

        @Override
        public void run() {
                myThread.interrupt();
            }
        }
    }
    class MyThreadA extends Thread{

        @Override
        public void run() {
            try {
                super.run();
                MyThread myThread = new MyThread();
                myThread.start();
                myThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class MyThread extends Thread{

            @Override
            public void run() {
                try {
                super.run();
                    int max = (int) (Math.random()*10000);
                    System.out.println(max);
                    Thread.sleep(max);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }


