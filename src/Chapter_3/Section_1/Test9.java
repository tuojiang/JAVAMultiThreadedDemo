package Chapter_3.Section_1;

/**
 * <p>@description: 一生产者-一消费者：操作值
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午2:29
 **/
public class Test9 {
    public static void main(String[] args) {
        String value = "";
        C1 c1 = new C1(value);
        P1 p1 = new P1(value);
        ThreadC threadC = new ThreadC(c1);
        ThreadP threadP = new ThreadP(p1);
        threadC.start();
        threadP.start();
    }
    static class ThreadP extends Thread{
            private P1 p1;

        public ThreadP(P1 p1) {
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

        private  C1 c1;

        public ThreadC(C1 c1) {
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
