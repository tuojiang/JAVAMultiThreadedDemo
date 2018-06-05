package Chapter_5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static Chapter_5.Test9.MyThread.timer;

/**
 * <p>@description: schedule 不延时情况
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-05-下午5:37
 **/
public class Test9 {
    public static void main(String[] args) throws ParseException {

        MyThread myThread = new MyThread();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = "2018-06-05 17:40:00";
        Date date = format.parse(str);
        System.out.println("字符串时间:"+date+",当前时间:"+new Date().toLocaleString());
//        timer.schedule(myThread,date,2000);
        timer.schedule(myThread,2000,2000);
    }
    static class MyThread extends TimerTask {

        public static Timer timer = new Timer();
        static int count =1;
            @Override
            public void run() {
                try {
                    System.out.println("time"+new Date()+"begin");
                    Thread.sleep(1000);
                    System.out.println("time"+new Date()+"end");
                    count++;
                    if (count==5) {
                        timer.cancel();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
    }        
}
