package Chapter_7;

/**
 * <p>@description:
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-06-下午3:42
 **/
public class Test {
    public static void main(String[] args) {

        ThreadGroup threadGroup = new ThreadGroup("AAA");
        MyTread myTread = new MyTread();
        Thread thread = new Thread(threadGroup,myTread);
        thread.start();
    }
    static class MyTread extends Thread{

            @Override
            public void run() {
                super.run();
                System.out.println("lalalal");
            }
    }

}
