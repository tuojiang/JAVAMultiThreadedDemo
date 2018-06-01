package Chapter_3.Section_1;

/**
 * <p>@description: 1)wait(long) 在某个时间内是否有线程对其唤醒，否则超时自动唤醒
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-上午11:08
 **/
public class Test7 {
    private static Object object = new Object();
    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
                try {
                    synchronized (object){
                        System.out.println("i'm awayk");
                        object.wait(4000);
                        System.out.println("i'm sleep 5s");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    };

    public static void main(String[] args) {
        Thread thread = new Thread(runnable);
        thread.start();

    }
}
