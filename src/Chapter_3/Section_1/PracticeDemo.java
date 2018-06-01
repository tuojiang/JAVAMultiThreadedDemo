package Chapter_3.Section_1;

/**
 * <p>@description: 等待/通知之交叉备份
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-下午4:45
 **/
public class PracticeDemo {

    public static void main(String[] args) {
        Dbtools dbtools = new Dbtools();
        for (int i=0;i<20;i++) {
            MyThreadB myThreadB = new MyThreadB(dbtools);
            myThreadB.start();
            MyThreadA myThreadA = new MyThreadA(dbtools);
            myThreadA.start();
        }
    }
    static class MyThreadA extends Thread{

        private Dbtools dbtools;

        public MyThreadA(Dbtools dbtools) {
            this.dbtools = dbtools;
        }

        @Override
            public void run() {
                super.run();
            dbtools.backupA();
            }
    }
    static class MyThreadB extends Thread{

        private Dbtools dbtools;

        public MyThreadB(Dbtools dbtools) {
            this.dbtools = dbtools;
        }

        @Override
        public void run() {
            super.run();
            dbtools.backupB();
        }
    }
}
