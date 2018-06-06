package Chapter_6;

/**
 * 枚举类实现单例模式
 * 避免枚举类暴露
 *
 * Created by boboan on 2018/6/5.
 */
public class MyObject9 {
    public enum MyenumSingleton{

    connectionFactory;
    private  int tag;
    private MyenumSingleton() {
        System.out.println("调用了");
        tag = 1;
    }
    public int getTag(){
        return tag;
    }
    }
    public static int getComTag(){
        return MyenumSingleton.connectionFactory.getTag();
    }

}
