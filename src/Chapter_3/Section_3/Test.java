package Chapter_3.Section_3;

/**
 * <p>@description: 1)ThreadLocal 让每个线程都有自己的共享变量。就像一个全局存放数据的盒子，盒子中存储每个线程的私有数据。
 *                  2)让每个线程绑定自己的值
 *                  3) get() set()
 * @author boboan
 * @version V1.0
 * @date 2018-06-04-上午9:52
 **/
public class Test {
    private static ThreadLocal local = new ThreadLocal();
    public static void main(String[] args) {
        if (local.get() == null) {
            System.out.println("我没值");
            local.set("波波安");
            System.out.println("我设值了");
        }
        System.out.println(local.get());
    }
}
