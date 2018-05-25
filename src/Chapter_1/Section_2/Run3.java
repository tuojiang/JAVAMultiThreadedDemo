package Chapter_1.Section_2;

/**
 * @author boboan
 * @version V1.0
 * @description 1）解决非线程安全问题：添加synchronized。2）非线程安全：多个线程对同一个对象的同一个变量进行操作时出现值被更改，值不同步的情况，进而影响程序执行流程
 * @date 2018-05-25-上午11:16
 **/
public class Run3 {
    public static void main(String[] args) {

        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();
    }
    static class ThreadA extends Thread{
        @Override
        public void run() {
            super.run();
            LoginServlet.doPost("a","aa");

        }
    }
    static class ThreadB extends Thread{
        @Override
        public void run() {
            super.run();
            LoginServlet.doPost("b","bb");
        }
    }
    static class LoginServlet{
        private static String username;
        private static String password;


       synchronized public static void doPost(String name,String passwd){
            username = name;
            if (username.equals("a")){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            password = passwd;
            System.out.println("username ="+username+"; password =" +passwd);
        }
    }
}
