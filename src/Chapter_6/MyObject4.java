package Chapter_6;

/**
 * 延迟加载单例模式/"懒汉式"
 * synchronized同步效率低，采用同步代码块,对关键代码同步效率稍微提升，但是多线程下还是无法解决
 * Created by boboan on 2018/6/5.
 */
public class MyObject4 {
    private static MyObject4 myObject;

    public MyObject4() {
    }

    public static MyObject4 getInstance(){
        try {

                if (myObject != null) {

                }else {
                    synchronized (MyObject4.class) {
                        Thread.sleep(3000);
                        return myObject = new MyObject4();
                    }
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
