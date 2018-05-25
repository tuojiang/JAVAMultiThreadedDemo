package Chapter_1.Section_7;

/**
 * @author boboan
 * @version V1.0
 * @description 停止线程的一些方法：
 *              1)interrupt()，在当前线程中打了一个停止的标记。
 *              2）interrupted()，测试当前线程是否中断，执行后将状态标志置清除为false，如果连续调用2此，则第二次为false。
 *              3)isInterrupted(),判断线程是否中断，不清除状态标志。
 *              4)停止线程的方式还有抛异常法，stop()方法，interrupt()+return配合也可以
 *              建议使用抛异常法，向上抛出异常，使得中断事件得以传播开。
 *
 * @date 2018-05-25-下午2:36
 **/
public class Run {
    public static void main(String[] args) {

        try {
//            Thread.currentThread().interrupt();
//            System.out.println("========================");
//            System.out.println("是否中断了"+Thread.interrupted());
//            System.out.println("是否中断了"+Thread.interrupted());
//            System.out.println("是否中断了"+Thread.currentThread().isInterrupted());
            Mythread mythread = new Mythread();
            mythread.start();
            Thread.sleep(2000);
            mythread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("中断了呀");
            e.printStackTrace();
        }

    }

    static class Mythread extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i=0;i<500000;i++){
                System.out.println("i="+i);
            }
        }
    }
}
