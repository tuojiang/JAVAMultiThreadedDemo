package Chapter_2.Section_2.detail_3;

/**
 * @author boboan
 * @version V1.0
 * @description 1)synchronized代码快如果使用的对象监视器不是同一个，执行的结果就是异步的。
 *              2)synchronized代码快赋予不同的对象监视器可以异步进行提高效率。
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
                objectCom.setUsernameAndPassword("a","aa");
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
            objectCom.setUsernameAndPassword("b","bb");
        }
    }
    static class ObjectCom{
        private String username;
        private String password;
        public void setUsernameAndPassword(String name,String pass){

            try {
                String newLock = new String();
                synchronized (newLock) {
                    System.out.println(Thread.currentThread().getName()+" bengin time= "+System.currentTimeMillis());
                    username = name;
                    Thread.sleep(2000);
                    password = pass;
                    System.out.println(Thread.currentThread().getName()+" end time= "+System.currentTimeMillis());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
