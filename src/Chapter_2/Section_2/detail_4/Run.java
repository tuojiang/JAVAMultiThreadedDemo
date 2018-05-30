package Chapter_2.Section_2.detail_4;

/**
 * @author boboan
 * @version V1.0
 * @description 1)静态同步synchronized和synchronized（class）代码块
 *              2)结果都是同步的。
 *              3）区别：静态同步synchronized是对class上锁，synchronized添加到非静态方法是对对象上锁。
 * @date 2018-05-30-上午8:47
 **/
public class Run {
    public static void main(String[] args) {

        ObjectCom objectCom = new ObjectCom();
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
