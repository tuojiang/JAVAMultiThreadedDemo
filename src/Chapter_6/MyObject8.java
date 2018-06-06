package Chapter_6;

/**
 * 枚举类实现单例模式
 *
 * Created by boboan on 2018/6/5.
 */
public enum  MyObject8 {
    connectionFactory;
    private  int tag;
    private MyObject8() {
        System.out.println("调用了");
        tag = 1;
    }
    public int getTag(){
        return tag;
    }

}
