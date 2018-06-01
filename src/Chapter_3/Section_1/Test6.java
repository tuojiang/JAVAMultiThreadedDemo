package Chapter_3.Section_1;

/**
 * <p>@description: 1)当线程数很多的时候，之间用notifyAll()唤醒所有线程
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-01-上午9:24
 **/
public class Test6 {
    public static void main(String[] args) {

        ObjService objService = new ObjService();
        ThreadA threadA = new ThreadA(objService);
        ThreadB threadB = new ThreadB(objService);
        ThreadC threadC = new ThreadC(objService);
        ThreadNotify threadNotify = new ThreadNotify(objService);
        threadA.setName("A");
        threadB.setName("B");
        threadC.setName("C");
        threadNotify.setName("GOGO");
        threadA.start();
        threadB.start();
        threadC.start();
        threadNotify.start();
    }
    static class ObjService{
        public void testMethod(Object object){
            synchronized (object){
                try {
                    System.out.println(Thread.currentThread().getName()+"在运行");
                    object.wait();
                    System.out.println(Thread.currentThread().getName()+"停止运行");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void notifyTO(Object object) {
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"在notifyTO运行");
                object.notify();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"停止notifyTO运行");
            }
        }
    }
    static class ThreadA extends Thread{
        private Object object;

        public ThreadA(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            super.run();
            Test4.ObjService objService = new Test4.ObjService();
            objService.testMethod(object);
        }
    }
    static class ThreadB extends Thread{

        private Object object;

        public ThreadB(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            super.run();
            Test4.ObjService objService = new Test4.ObjService();
            objService.testMethod(object);
        }
    }
    static class ThreadC extends Thread{

        private Object object;

        public ThreadC(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            super.run();
            Test4.ObjService objService = new Test4.ObjService();
            objService.testMethod(object);
        }
    }
    static class ThreadNotify extends Thread{

        private Object object;

        public ThreadNotify(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            super.run();
            synchronized (object){
                System.out.println("唤醒线程："+Thread.currentThread().getName());
                object.notifyAll();
            }
        }
    }
}
