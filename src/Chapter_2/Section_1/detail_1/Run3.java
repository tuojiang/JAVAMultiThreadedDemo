package Chapter_2.Section_1.detail_1;



/**
 * @author boboan
 * @version V1.0
 * @description 多个线程访问多个对象，则JVM会创建多个锁。会异步进行
 * @date 2018-05-28-下午3:55
 **/
public class Run3 {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNum2 = new HasSelfPrivateNum();
        MyThreadA myThreadA = new MyThreadA(hasSelfPrivateNum);
        MyThreadB myThreadB = new MyThreadB(hasSelfPrivateNum2);
        myThreadA.start();
        myThreadB.start();

    }
    static class MyThreadA extends Thread{
        private HasSelfPrivateNum hasSelfPrivateNum;

        public MyThreadA(HasSelfPrivateNum hasSelfPrivateNum) {
            this.hasSelfPrivateNum = hasSelfPrivateNum;
        }

        @Override
        public void run() {
            super.run();
            hasSelfPrivateNum.addNum("a");

        }
    }
    static class MyThreadB extends Thread{
        private HasSelfPrivateNum hasSelfPrivateNum;

        public MyThreadB( HasSelfPrivateNum hasSelfPrivateNum) {
            this.hasSelfPrivateNum = hasSelfPrivateNum;
        }

        @Override
        public void run() {
            super.run();
            hasSelfPrivateNum.addNum("b");
        }
    }
    static class HasSelfPrivateNum {

        private int num = 0;
       synchronized public void addNum(String name){
            try {
                if (name.equals("a")) {
                    num = 100;
                    System.out.println("a set over");
                    Thread.sleep(2000);
                }else {
                    num = 200;
                    System.out.println("other set over");
                }
                System.out.println(name+"; num ="+num);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
