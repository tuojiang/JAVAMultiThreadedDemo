package Chapter_3.Section_1;


/**
 * <p>@description:
 *
 * @author boboan
 * @version V1.0
 * @date 2018-05-31-下午1:51
 **/
public class MyThreadB extends Thread{
    private MyList list;
    public MyThreadB(MyList list){
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
            try {
                while (true){
                    if (list.size() == 5) {
                        System.out.println("线程为5了，B要退出了～～");
                        throw new InterruptedException();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }
}
