package Chapter_1.Section_8;

/**
 * @author boboan
 * @version V1.0
 * @description 暂停线程：
 *              1)suspend()
 *              2)resume()
 * @date 2018-05-25-下午3:57
 **/
public class Run {
    public static void main(String[] args) {

        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(2000);
            System.out.println("i'm A have rest time"+System.currentTimeMillis()+"i="+myThread.getI());
            myThread.suspend();
            System.out.println("i'm A have rest time"+System.currentTimeMillis()+"i="+myThread.getI());
            Thread.sleep(5000);
            System.out.println("i'm B have rest time"+System.currentTimeMillis()+"i="+myThread.getI());
            myThread.resume();
            System.out.println("i'm B have rest time"+System.currentTimeMillis()+"i="+myThread.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class MyThread extends Thread{
        int i;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            super.run();
            while (true){
                i++;
            }
        }
    }
}
