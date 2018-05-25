package Chapter_1.Section_8;

/**
 * @author boboan
 * @version V1.0
 * @description 1)suspend()
 *              2)resume()
 *              出现暂停现象导致数据不同步
 * @date 2018-05-25-下午5:11
 **/
public class Run3 {
    public static void main(String[] args) throws InterruptedException {

        Myobject myobject = new Myobject();
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                myobject.setValues("a","aa");
            }
        };
        thread.setName("a");
        thread.start();
        Thread.sleep(5000);
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                myobject.printUandP();
            }
        };
        thread1.start();
    }
    static class Myobject{
        private String username = "x";
        private String password = "xx";

        public void setValues(String u, String pwd) {
            this.username = u;
            if (Thread.currentThread().getName().equals("a")) {
                System.out.println("糟糕，线程要停止了～～");
                Thread.currentThread().suspend();
            }
            this.password = pwd;
        }
        public void printUandP(){
            System.out.println(username+password);
        }

    }
}
