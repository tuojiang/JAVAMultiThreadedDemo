package Chapter_2.Section_1.detail_1;

/**
 * @author boboan
 * @version V1.0
 * @description 1)方法内的变量为线程安全的
 * @date 2018-05-28-下午2:12
 **/
public class Run {

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
            hasSelfPrivateNum.addNum("a");
        }

        @Override
        public void run() {
            super.run();

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

        public void addNum(String name){
            try {
                int num = 0;
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
