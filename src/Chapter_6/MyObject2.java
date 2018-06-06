package Chapter_6;

/**
 * 延迟加载单例模式/"懒汉式"
 * 这种方法在多线程是错误的
 * Created by boboan on 2018/6/5.
 */
public class MyObject2 {
    private static MyObject2 myObject;

    public MyObject2() {
    }
    public static MyObject2 getInstance(){
        if (myObject != null) {

        }else {
            return myObject = new MyObject2();
        }
        return myObject;
    }
}
