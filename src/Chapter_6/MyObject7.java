package Chapter_6;

/**
 * static 代码块实现单例模式
 *
 * Created by boboan on 2018/6/5.
 */
public class MyObject7 {
    private static MyObject myObject = null;

    public MyObject7() {
    }

    static {
        myObject = new MyObject();
    }
    public static MyObject getInstance(){
        return myObject;
    }
}
