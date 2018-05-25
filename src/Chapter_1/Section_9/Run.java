package Chapter_1.Section_9;

/**
 * @author boboan
 * @version V1.0
 * @description yield()放弃当前的CPU资源，将它让给其他的任务去占用CPU执行时间，但是放弃时间不确定，可能马上放弃，又立刻获取。
 * @date 2018-05-25-下午5:19
 **/
public class Run {
    public static void main(String[] args) {

        MyThread myThread =new MyThread();
        myThread.start();
    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            long start = System.currentTimeMillis();
            int count =0;
            for (int i=0;i<5000000;i++){
                Thread.yield();
                count = i+count;
            }
            long end =System.currentTimeMillis();
            System.out.println("耗费时间："+(end-start));
        }
    }
}
