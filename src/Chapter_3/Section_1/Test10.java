package Chapter_3.Section_1;

/**
 * <p>@description: 多生产者-多消费者：假死
 *                  原因：有可能唤醒的是同类，积少成多，造成假死
 *                  解决：将异类一起唤醒即可，使用notifyAll()
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午2:29
 **/
public class Test10 {
    public static void main(String[] args) {
        String value = "";
        C2 c1 = new C2(value);
        P2 p1 = new P2(value);
        ThreadC[] threadC = new ThreadC[2];
        ThreadP[] threadP = new ThreadP[2];
        for (int i=0;i<2;i++){
            threadC[i] = new ThreadC(c1);
            threadC[i].setName("消费者"+(i+1));
            threadP[i] = new ThreadP(p1);
            threadP[i].setName("生产者"+(i+1));
            threadC[i].start();
            threadP[i].start();
        }
    }
    static class ThreadP extends Thread{
            private P2 p1;

        public ThreadP(P2 p1) {
            this.p1 = p1;
        }

        @Override
            public void run() {
                super.run();
                while (true) {
                    p1.setValue();
                }
            }
    }
    static class ThreadC extends Thread{

        private  C2 c1;

        public ThreadC(C2 c1) {
            this.c1 = c1;
        }

        @Override
            public void run() {
                super.run();
                while (true){
                    c1.getValue();

                }
            }
    }
}
