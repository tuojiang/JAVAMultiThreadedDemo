package Chapter_3.Section_1;

/**
 * <p>@description: 1）不使用wait()/notify()实现进程间通信。
 *                  2）但是没有捕获到异常？why?
 *
 * @author boboan
 * @version V1.0
 * @date 2018-05-31-下午1:56
 **/
public class Test {
    public static void main(String[] args) {
        MyList myList = new MyList();
        MyThread myThread = new MyThread(myList);
        MyThreadB myThreadB = new MyThreadB(myList);
        myThread.setName("A");
        myThread.start();
        myThreadB.setName("B");
        myThreadB.start();
    }
}
