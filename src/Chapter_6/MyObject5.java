package Chapter_6;

/**
 * 延迟加载单例模式/"懒汉式"
 * DCL 双检查锁机制来解决问题，保证了不需要同步代码块的异步执行，又保证了单例的效果
 * Created by boboan on 2018/6/5.
 */
public class MyObject5 {
    private volatile static MyObject5 myObject;

    public MyObject5() {
    }

    public static MyObject5 getInstance(){
        try {

                if (myObject != null) {

                }else {
                        Thread.sleep(3000);
                        synchronized (MyObject5.class) {
                            if (myObject==null) {
                                myObject = new MyObject5();
                            }
                        }
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
