package Chapter_2.Section_2.detail_2;

/**
 * @author boboan
 * @version V1.0
 * @description 1)当synchronized方法块用的对象是同一个时候，一个线程使用了synchronized（this）同步代码块时，其他使用synchronized（this）的将被阻塞，因为他们使用的是同一个对象监视器。
 *              2)synchronized方法是锁定当前对象的，
 * @date 2018-05-30-上午8:47
 **/
public class Run {
    public static void main(String[] args) {

        ObjectCom objectCom = new ObjectCom();
        MyTheadA a = new MyTheadA(objectCom);
        MyTheadB b = new MyTheadB(objectCom);
        a.start();
        b.start();
    }
    static class MyTheadA extends Thread{
            private ObjectCom objectCom;
            public MyTheadA(ObjectCom objectCom){
                this.objectCom= objectCom;
            }

            @Override
            public void run() {
                super.run();
                objectCom.runComA();
            }
    }
    static class MyTheadB extends Thread{
        private ObjectCom objectCom;
        public MyTheadB(ObjectCom objectCom){
            this.objectCom= objectCom;
        }

        @Override
        public void run() {
            super.run();
            objectCom.runComB();
        }
    }
    static class ObjectCom{
        public void runComA(){
            try {
//                synchronized (this) {
                    System.out.println("A bengin time= "+System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println("A end time= "+System.currentTimeMillis());
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public void runComB(){
            synchronized (this){
                System.out.println("B begin time ="+System.currentTimeMillis());
                System.out.println("B begin end ="+System.currentTimeMillis());
            }
        }
    }
}
