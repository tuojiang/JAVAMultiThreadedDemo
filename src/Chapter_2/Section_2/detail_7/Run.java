package Chapter_2.Section_2.detail_7;

/**
 * @author boboan
 * @version V1.0
 * @description 1)多线程的死锁
 *              2)进入bin目录下，执行jps,获取当前Run 的 id 号。
 *              3）使用 jstack + id 号 即可查看到死锁现象。
 * @date 2018-05-30-上午8:47
 **/
public class Run {
    public static void main(String[] args) {

        try {
        MyThead a = new MyThead();
        a.setTag("a");
        Thread threada = new Thread(a);
        threada.setName("A");
        threada.start();
        Thread.sleep(2000);
        a.setTag("b");
        Thread threadb = new Thread(a);
        threadb.setName("B");
            threadb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static class MyThead extends Thread{

        private String username;
        private Object object = new Object();
        private Object object2 = new Object();
        public void setTag(String name){
            this.username = name;
        }
            @Override
            public void run() {
                super.run();
                if (username.equals("a")) {
                    synchronized (object) {
                        try {

                            System.out.println("username = " + username);
                            Thread.sleep(2000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (object2) {
                            System.out.println("从 object1 --> object 2");
                        }
                    }
                }
                if (username.equals("b")){
                    synchronized (object2){
                        try {
                        System.out.println("username = "+username);
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (object){
                            System.out.println("从 object2 --> object 1");
                        }
                    }
                }
            }
    }


}
