package Chapter_6;

/**
 * 静态内置类实现单例模式
 *
 * Created by boboan on 2018/6/5.
 */
public class MyObject6 {
    private static class MyObjectHandler{
        private static MyObject myObject = new MyObject();
    }

    public MyObject6() {
    }

    public static MyObject getInstance(){
        return MyObjectHandler.myObject;
    }
}
