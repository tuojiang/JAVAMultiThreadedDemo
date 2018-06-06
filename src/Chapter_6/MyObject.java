package Chapter_6;

/**
 * 立即加载单例模式/”饿汉式“
 * Created by boboan on 2018/6/5.
 */
public class MyObject {
    private static MyObject myObject = new MyObject();

    public MyObject() {
    }
    public static MyObject getInstance(){
        return myObject;
    }
}
