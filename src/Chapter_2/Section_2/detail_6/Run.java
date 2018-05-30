package Chapter_2.Section_2.detail_6;

/**
 * @author boboan
 * @version V1.0
 * @description 1)String字符串具有缓存功能，使用synchronized代码快时避免使用String作为锁对象，使用其他的。
 * @date 2018-05-30-上午8:47
 **/
public class Run {
    public static void main(String[] args) {

        ObjectCom objectCom = new ObjectCom();
        ObjectCom objectComb = new ObjectCom();
        MyTheadA a = new MyTheadA(objectCom);
        MyTheadB b = new MyTheadB(objectCom);
        a.setName("A");
        a.start();
        b.setName("B");
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
//                objectCom.a("AA");
                objectCom.a(new Object());
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
//            objectCom.a("AA");
            objectCom.a(new Object());
        }
    }
    static class ObjectCom{
        private String a = new String();
        public  void a(Object str){
            try {
                synchronized(str) {
                    while (true) {
                        System.out.println("i'm a");
                        System.out.println(Thread.currentThread().getName() + " bengin time= " + System.currentTimeMillis());
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + " end time= " + System.currentTimeMillis());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
