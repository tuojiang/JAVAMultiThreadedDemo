package Chapter_6;

/**
 * 延迟加载单例模式/"懒汉式"
 * 这种方法在多线程是错误的,synchronized同步来解决
 * Created by boboan on 2018/6/5.
 */
public class MyObject3 {
    private static MyObject3 myObject;

    public MyObject3() {
    }
    //设置同步方法效率比较低
    //给方法加锁
    synchronized public static MyObject3 getInstance(){
        try {
            if (myObject != null) {

            }else {
                Thread.sleep(3000);
                return myObject = new MyObject3();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
