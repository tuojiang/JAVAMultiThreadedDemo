package Chapter_5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <p>@description: 1) schedule(TimerTask var1, long var2, long var4) -- 以当前时间延迟指定毫秒数，在以某一时间间隔无限循环的执行某一任务
 *
 * @author boboan
 * @version V1.0
 * @date 2018-06-05-下午3:33
 **/
public class Test5 {
    static public class MyTimerTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("启动了，启动时间为："+new Date());
        }
    }

    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();
        MyTimerTask myTimerTask = new MyTimerTask();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stringstr = "2018-06-05 16:39:00";
        Date date = format.parse(stringstr);
        System.out.println("字符串时间："+date+"。。当前时间："+new Date().toLocaleString());
        timer.schedule(myTimerTask,2000,3000);

    }
}
