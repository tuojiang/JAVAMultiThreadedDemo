package Chapter_5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <p>@description: 1) Timer 负责计划任务。
 *                  2）TimerTask 类来封装任务。
 *                  3) 如果计划的时间早于现在时间，立即执行。
 *                  4) schedule(TimerTask var1, Date var2) -- 在指定日期执行一次某一任务
 * @author boboan
 * @version V1.0
 * @date 2018-06-05-下午3:33
 **/
public class Test {
    private static Timer timer = new Timer(true);
    static public class MyTimerTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("启动了，启动时间为："+new Date());
        }
    }

    public static void main(String[] args) throws ParseException {
        MyTimerTask myTimerTask = new MyTimerTask();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stringstr = "2018-06-05 16:39:00";
        Date date = format.parse(stringstr);
        System.out.println("字符串时间："+date+"。。当前时间："+new Date().toLocaleString());
        timer.schedule(myTimerTask,date);

    }
}
