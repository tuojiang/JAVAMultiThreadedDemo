package Chapter_2.Section_3.detail_2;

/**
 * <p>@description: 1)Volatile 虽然增加了实例变量在多线程间的可见性，但是却不具备同步行，它是不具备原子性的。
 *                  2)配合上synchronized即可解决问题。
 *
 * @author boboan
 * @version V1.0
 * @date 2018-05-31-上午9:30
 **/
public class Run {
    public static void main(String[] args) {

        MyThread[] myThread = new MyThread[100];
        for (int i=0;i<100;i++){
            myThread[i] = new MyThread();
        }
        for (int i=0;i<100;i++){
            myThread[i].start();
        }
    }
    static class MyThread extends Thread{
            volatile static int count = 0;
            synchronized public static void addrun() {
                for (int i=0;i<100;i++){
                    count++;
                }
                System.out.println("count :"+count);
            }

        @Override
        public void run() {
            super.run();
            addrun();
        }
    }

}
