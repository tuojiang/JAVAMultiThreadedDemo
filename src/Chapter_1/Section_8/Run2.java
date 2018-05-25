package Chapter_1.Section_8;

/**
 * @author boboan
 * @version V1.0
 * @description 1)suspend()
 *              2)resume()
 *              注意：都是过时的方法，他们使用时，容易造成对公共对象的锁独占，使其他对象无法访问公共对象
 *
 * @date 2018-05-25-下午4:53
 **/
public class Run2 {
    public static void main(String[] args) {

        try {
        MyObject myObject = new MyObject();
        Thread a = new Thread(){
            @Override
            public void run() {
                super.run();
                myObject.printString();
            }
        };

        Thread b =new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("B start～～");
                myObject.printString();
            }
        };
            a.setName("a");
            a.start();
            Thread.sleep(5000);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class MyObject{
        synchronized public void printString(){
            System.out.println("start～～");
            if (Thread.currentThread().getName().equals("a")) {
                System.out.println("x 线程停止咯～～");
                Thread.currentThread().suspend();
                System.out.println("end～～");
            }
        }
    }
}
