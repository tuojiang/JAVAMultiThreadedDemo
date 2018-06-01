package Chapter_3.Section_1;

/**
 * <p>@description: 生产者
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午2:29
 **/
public class P2 {
    private String lock;

    public P2(String lock) {
        this.lock = lock;
    }
    public void setValue(){
        synchronized (lock){
                try {
                    while (!O1.value.equals("")) {
                        System.out.println("生产者"+Thread.currentThread().getName()+"のWARITING ，のの");
                        lock.wait();
                    }
                    System.out.println("生产者 "+Thread.currentThread().getName()+"Runnable");
                    String value = System.currentTimeMillis()+"_"+System.nanoTime();
                    O1.value = value;
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
