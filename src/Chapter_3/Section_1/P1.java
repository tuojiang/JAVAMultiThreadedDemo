package Chapter_3.Section_1;

/**
 * <p>@description: 生产者
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午2:29
 **/
public class P1 {
    private String lock;

    public P1(String lock) {
        this.lock = lock;
    }
    public void setValue(){
        synchronized (lock){
                try {
                    if (!O1.value.equals("")) {
                        lock.wait();
                    }
                    String value = System.currentTimeMillis()+"_"+System.nanoTime();
                    System.out.println("set 的值是：" + value);
                    O1.value = value;
                    lock.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
