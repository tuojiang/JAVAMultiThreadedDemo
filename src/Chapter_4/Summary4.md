Chapter 4
---
这章开始介绍JDK1.5 提供的 Lock 类对象。
主要是 2 个类 ：
- ReentrantLock 类的使用
- ReentrantReadWriteLock 类的使用

### 1
- ReentrantLock

    ReentrantLock + Condition 可以实现“选择性通知”，Condition 类中默认提供的。
    > synchronized 就像是只注册了一个 Condition 对象。ReentrantLock 扩展性更高，更加灵活。
    1. 创建不同 condition 对象，唤醒自己需要的线程即可。
    - 用ReentrantLock + condition 实现 生产者/消费者 一对一模式的方式和 wait()/notify()一样。
        1. condition 的 await()/signal()/signalAll() 对应 Object 的wait()/notify()/notifyAll() 
    - 用 ReentrantLock + condition 实现 生产者/消费者 多对多模式
        1. 用 signalAll() 解决假死问题。
        2. 出现连续打印的原因：一个condition对象，有可能唤醒的是同类，所以就又打印一次。    
        
    2. 内部 API 
       - getHoldCount() -- 查询当前线程调用 lock() 的次数。
       - getQueueLength() -- 返回等待 lock() 释放的线程数。
       - getWaitQueueLength(Condition var1) -- 返回等待此锁定相关的给定条件 condition 的计数。
       - hasQueuedThread(Thread var1) -- 查询指定线程是否在等待获取此锁定。
       - hasQueuedThreads() -- 查询是否有线程在等待获取此锁定。
       - hasWaiters(Condition var1) -- 查询是否有线程在等待与此锁定有关的condition条件。
       - isFair() -- 判断是否是公平锁。
       - isHeldByCurrentThread() -- 查询当前线程是否保持此锁定。
       - isLocked() -- 查询此锁定是否由任意线程保持。
       - lockInterruptibly() -- 当前线程未被中断，获取锁定，否则出现异常。
       - tryLock() -- 仅在调用时锁定未被另一个线程保持的情况下，才获取该锁定。
       - tryLock(long var1, TimeUnit var3) -- 在给定时间内未被另一个线程锁定，且未被中断，则获取该锁定。
       - awaitUninterruptibly()  -- 查询此锁定是否由任意线程保持。
       - awaitUntil(Date var1) -- 在等待时间到达之前，可被其他线程唤醒。

### 2        
- ReentrantReadWriteLock

    在使用 ReentrantReadWriteLock 时，
    - 读读是异步的
    - 读写、写读、写写都是同步的

    







