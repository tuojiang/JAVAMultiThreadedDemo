package Chapter_3.Section_1;

/**
 * <p>@description: 消费者
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午2:29
 **/
public class C2 {
    private String lock;

    public C2(String lock) {
        this.lock = lock;
    }
    public void getValue(){
        synchronized (lock){
            try {
                while (O1.value.equals("")) {
                    System.out.println("消费者"+Thread.currentThread().getName()+"WAITINGLlのののののの");
                    lock.wait();
                }
                System.out.println("消费者 "+Thread.currentThread().getName()+"Runnable");
                O1.value = "";
                lock.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
