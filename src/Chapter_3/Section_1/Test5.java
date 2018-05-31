package Chapter_3.Section_1;

/**
 * <p>@description: 1)notify()一次只唤醒一个线程。
 *
 * @author boboan
 * @version V1.0
 * @date 2018-05-31-下午3:30
 **/
public class Test5 {
    public static void main(String[] args) {

        ObjService objService = new ObjService();
        ThreadA threadA = new ThreadA(objService);
        ThreadB threadB = new ThreadB(objService);
        threadA.setName("A");
        threadB.setName("B");
        threadA.start();
        threadB.start();
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
                ObjService objService = new ObjService();
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
            ObjService objService = new ObjService();
            objService.notifyTO(object);
            }
    }
}
