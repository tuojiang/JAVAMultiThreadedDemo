package Chapter_3.Section_1;

/**
 * <p>@description:
 *
 * @author boboan
 * @version V1.0
 * @date 2018-05-31-下午3:14
 **/
public class Test3 {
    public static void main(String[] args) {
        try {
        Object list = new Object();
        ThreadA threadA = new ThreadA(list);
        ThreadB threadB = new ThreadB(list);
        threadA.start();
        Thread.sleep(50);
        threadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class ThreadA extends Thread{
            private Object object;

        public ThreadA(Object list) {
            this.object = list;
        }

        @Override
            public void run() {
                super.run();
                synchronized (object){
                    if (MyList.size()!=5) {
                        try {
                        System.out.println("A begin --" + System.currentTimeMillis());
                        object.wait();
                        System.out.println("A end --" + System.currentTimeMillis());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    }
    static class ThreadB extends Thread{
        private Object object;

        public ThreadB(Object list) {
            this.object = list;
        }

        @Override
        public void run() {
            super.run();
            synchronized (object){
                for (int i=0;i<10;i++){
                    MyList.add();
                    if (MyList.size()==5) {
                        try {
                            System.out.println("B begin --" + System.currentTimeMillis());
                            object.notify();
                            System.out.println("B end --" + System.currentTimeMillis());
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("添加"+(i+1)+"个元素");
                }
            }
        }
    }
}
