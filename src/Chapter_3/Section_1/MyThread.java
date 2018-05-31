package Chapter_3.Section_1;

import java.util.List;

/**
 * <p>@description:
 *
 * @author boboan
 * @version V1.0
 * @date 2018-05-31-下午1:51
 **/
public class MyThread extends Thread{
    private MyList list;
    public MyThread(MyList list){
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
            try {
                for (int i=0;i<10;i++){
                    list.add();
                    System.out.println("添加了"+(i+1)+"个元素");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
        }
    }
}
