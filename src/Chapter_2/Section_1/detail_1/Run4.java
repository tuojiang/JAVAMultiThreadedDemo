package Chapter_2.Section_1.detail_1;



/**
 * @author boboan
 * @version V1.0
 * @description 1）A线程先持有对象 LOCK 锁， B线程是可以异步调用对象中非synchronized类型的方法。
 *              2）A线程先持有对象 LOCK 锁，B线程调用对象中的synchronized类型方法，需要等待。
 *              3）synchronized可以解决脏读的情况
 * @date 2018-05-28-下午3:55
 **/
public class Run4 {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        MyThreadA myThreadA = new MyThreadA(hasSelfPrivateNum);
        MyThreadB myThreadB = new MyThreadB(hasSelfPrivateNum);
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
            hasSelfPrivateNum.addNumB("b");
        }
    }
    static class HasSelfPrivateNum {

        private int num = 0;
       synchronized public void addNum(String name){
            try {
                    num = 100;
                    System.out.println("a set over");
                System.out.println(name+"; num ="+num);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       synchronized public void addNumB(String name){
            try {
                    num = 200;
                    System.out.println("other set over");
                System.out.println(name+"; num ="+num);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
