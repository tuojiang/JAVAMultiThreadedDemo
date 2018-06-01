package Chapter_3.Section_1;

/**
 * <p>@description: 1)如果通知过早，会影响逻辑性(但是线程启动不是有随机性嘛，小概率事件会正常，不过我运行很多次都是影响的，囧)
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午2:08
 **/
public class Test8 {
    private static Object object = new Object();
    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (object){
                    System.out.println("i'm A awayk");
                    object.wait();
                    System.out.println("i'm A sleep 5s");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private static Runnable runnableb = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (object){
                    System.out.println("i'm B awayk");
                    object.notify();
                    System.out.println("i'm B sleep 5s");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    public static void main(String[] args) {

        Thread thread1 = new Thread(runnableb);
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
