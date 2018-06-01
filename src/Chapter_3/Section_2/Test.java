package Chapter_3.Section_2;

/**
 * <p>@description: 1)join() 等待线程对象的销毁
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午5:54
 **/
public class Test {
    public static void main(String[] args) {

        try {
            MyThread myThread = new MyThread();
            myThread.start();
            myThread.join();
            System.out.println("等你运行完了我在来把～～～");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    static class MyThread extends Thread{

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

}
