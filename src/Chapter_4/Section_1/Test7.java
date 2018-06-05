package Chapter_4.Section_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>@description: 1)getHoldCount() -- 查询当前线程调用 lock() 的次数。
 *                  2)getQueueLength() -- 返回等待 lock() 释放的线程数
 *                  3)getWaitQueueLength() -- 返回等待此锁定相关的给定条件 condition 的计数。
 * @author boboan
 * @version V1.0
 * @date 2018-06-05-下午1:09
 **/
public class Test7 {
    public static void main(String[] args) {

        MyService myService = new MyService();
        myService.testMthdo();
    }
    static class MyService{
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        public void testMthdo(){
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"一共调用了"+lock.getHoldCount()+"--"+lock.getQueueLength()+"=="+lock.getWaitQueueLength(condition));
            testMthdo1();
            lock.unlock();
        }

        private void testMthdo1() {
            lock.lock();
            try {
//                condition.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("一共调用了"+lock.getHoldCount()+"=="+lock.getWaitQueueLength(condition)+lock.isHeldByCurrentThread());
            lock.unlock();
        }
    }
}
