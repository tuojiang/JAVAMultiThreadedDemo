package Chapter_5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <p>@description: 1) Timer 的 cancel() 是将任务队列中全部任务清除
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-05-下午3:33
 **/
public class Test8 {

    static public class MyTimerTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("AAA 启动了，启动时间为："+new Date());
        }
    }
    static public class MyTimerTaskB extends TimerTask{
        @Override
        public void run() {
            System.out.println("BBBB 启动了，启动时间为："+new Date());
        }
    }
    public static void main(String[] args) throws ParseException, InterruptedException {
        Timer timer = new Timer();
        MyTimerTask myTimerTask = new MyTimerTask();
        MyTimerTaskB myTimerTaskb = new MyTimerTaskB();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stringstr = "2018-06-05 16:39:00";
        Date date = format.parse(stringstr);
        System.out.println("字符串时间："+date+"。。当前时间："+new Date().toLocaleString());
        timer.schedule(myTimerTask,date,1000);
        timer.schedule(myTimerTaskb,date,1000);
        Thread.sleep(5000);
        timer.cancel();
    }
}
