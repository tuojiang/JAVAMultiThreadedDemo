package Chapter_2.Section_3.detail_5;

/**
 * <p>@description:  1)synchronized代码块有Volatile同步功能
 *                   2）能够使多线程访问同一个资源同步性，能将工作内存中的私有变量和公共内存中的变量同步功能。
 *                   3)synchronized具有互斥性和可见性。
 * @author boboan
 * @version V1.0
 * @date 2018-05-31-上午10:30
 **/
public class Run {
    public static void main(String[] args) {

        ServiceDemo serviceDemo = new ServiceDemo();
        MyThreadA myThreadA = new MyThreadA(serviceDemo);
        MyThreadB myThreadB = new MyThreadB(serviceDemo);
        myThreadA.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThreadB.start();
        System.out.println("发起停止");

    }
    static class MyThreadA extends Thread{

        ServiceDemo serviceDemo;
        public MyThreadA(ServiceDemo service){
            this.serviceDemo = service;
        }
            @Override
            public void run() {
                super.run();
                serviceDemo.startnow();
            }
    }
    static class MyThreadB extends Thread{

        ServiceDemo serviceDemo;
        public MyThreadB(ServiceDemo service){
            this.serviceDemo = service;
        }
        @Override
        public void run() {
            super.run();
            serviceDemo.stopnow();
        }
    }
    static class ServiceDemo{
        private boolean isTag = true;
        String any = new String();
        public void startnow(){
            while (isTag==true){
                synchronized (any) {
                    System.out.println("i'm die");
                }
            }
            System.out.println("停不下来啦～");
        }
        public void stopnow(){
            isTag = false;
        }
    }
}
