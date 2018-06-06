package Chapter_6;

import java.io.Serializable;

/**
 * 序列化与反序列化实现单例模式
 * 避免枚举类暴露
 *
 * Created by boboan on 2018/6/5.
 */
public class MyObject10 implements Serializable{
    public static  final  long seriVersionUID = 898L;
    public static class MyObjectHandler{
        private static final MyObject10 myObject10= null;
    }
    private  MyObject10(){

    }
    public  static MyObject10 getInstance(){
        return MyObjectHandler.myObject10;
    }
    protected Object readResolve(){
        System.out.println("调用了 read 方法");
        return MyObjectHandler.myObject10;
    }
}
