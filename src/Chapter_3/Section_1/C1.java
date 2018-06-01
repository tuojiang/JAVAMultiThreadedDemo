package Chapter_3.Section_1;

/**
 * <p>@description: 消费者
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午2:29
 **/
public class C1 {
    private String lock;

    public C1(String lock) {
        this.lock = lock;
    }
    public void getValue(){
        synchronized (lock){
            try {
                if (O1.value.equals("")) {
                    lock.wait();
                }
                System.out.println("get 的值是：" + O1.value);
                O1.value = "";
                lock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
