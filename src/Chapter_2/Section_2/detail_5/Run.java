package Chapter_2.Section_2.detail_5;

/**
 * @author boboan
 * @version V1.0
 * @description 1)synchronized对class，对所有对象都起作用。
 * @date 2018-05-30-上午8:47
 **/
public class Run {
    public static void main(String[] args) {

        ObjectCom objectCom = new ObjectCom();
        ObjectCom objectComb = new ObjectCom();
        MyTheadA a = new MyTheadA(objectCom);
        MyTheadB b = new MyTheadB(objectComb);
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
                ObjectCom.a();
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
            ObjectCom.b();
        }
    }
    static class ObjectCom{
        private String a = new String();
        synchronized public static void a(){
            try {
                    System.out.println("i'm a");
                    System.out.println(Thread.currentThread().getName()+" bengin time= "+System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+" end time= "+System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        synchronized public static void b(){
            System.out.println("i'm b");
            System.out.println(Thread.currentThread().getName()+" bengin time= "+System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName()+" end time= "+System.currentTimeMillis());
        }

    }
}
