package Chapter_1.Section_3;

/**
 * @author boboan
 * @version V1.0
 * @description 1）currentThread()获取当前的线程
 *              2）isAlive()判断当前线程是存活
 *              3) sleep()让当前执行的线程休眠（暂停执行）
 *              4) getId()获得线程的唯一标识
 *              额外话：
 *              1、这两个方法来自不同的类分别是，sleep来自Thread类，和wait来自Object类。

                sleep是Thread的静态类方法，谁调用的谁去睡觉，即使在a线程里调用了b的sleep方法，实际上还是a去睡觉，要让b线程睡觉要在b的代码中调用sleep。

                2、最主要是sleep方法没有释放锁，而wait方法释放了锁，使得其他线程可以使用同步控制块或者方法。

                sleep不出让系统资源；wait是进入线程等待池等待，出让系统资源，其他线程可以占用CPU。一般wait不会加时间限制，因为如果wait线程的运行资源不够，再出来也没用，要等待其他线程调用notify/notifyAll唤醒等待池中的所有线程，才会进入就绪队列等待OS分配系统资源。sleep(milliseconds)可以用时间指定使它自动唤醒过来，如果时间不到只能调用interrupt()强行打断。

                Thread.Sleep(0)的作用是“触发操作系统立刻重新进行一次CPU竞争”。

                3、使用范围：wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在任何地方使用
                synchronized(x){
                x.notify()
                //或者wait()
                }

                4、sleep必须捕获异常，而wait，notify和notifyAll不需要捕获异常
 *
 *
 * @date 2018-05-25-下午1:33
 **/
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(Thread.currentThread().getName()+"i'm id is" + Thread.currentThread().getId());
        System.out.println(myThread.isAlive());
        System.out.println("i'm main ,still "+Thread.currentThread().isAlive());
    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("i'm id is" + Thread.currentThread().getId());
            System.out.println("i'm "+Thread.currentThread().getName()+"currenttume"+System.currentTimeMillis());
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i'm "+Thread.currentThread().getName()+"sleep time"+System.currentTimeMillis());
        }
    }
}
