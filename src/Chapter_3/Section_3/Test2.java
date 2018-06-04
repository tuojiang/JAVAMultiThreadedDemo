package Chapter_3.Section_3;

/**
 * <p>@description: 1)ThreadLocal 设置初始值
 *                  2)
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-04-上午9:52
 **/
public class Test2 {
    private static ThreadLocalExt local = new ThreadLocalExt();
    public static void main(String[] args) {
        if (local.get() == null) {
            System.out.println("我没值");
            local.set("波波安");
            System.out.println("我设值了");
        }
        System.out.println(local.get());
    }
    static class ThreadLocalExt extends ThreadLocal{
        @Override
        protected Object initialValue() {
            return "我是初始值呀～～～";
        }
    }
}
