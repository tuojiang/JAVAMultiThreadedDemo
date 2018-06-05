Chapter 5
---
第五章主要就是介绍了定时计划任务功能 Timer 对象的用法，它的内部使用多线程方式进行处理。
主要核心内容如下：
- 如何实现指定时间执行任务
- 如何实现指定周期执行任务

### 1
- 常用API
    - schedule(TimerTask var1, Date var2) -- 在指定日期执行一次某一任务
    - schedule(TimerTask var1, Date var2, long var3) -- 在指定日期之后，按指定周期无限循环执行某一任务。
    - schedule(TimerTask var1, long var2) -- 以当前时间为参考，延迟指定毫秒数后执行某一任务
    - schedule(TimerTask var1, long var2, long var4) -- 以当前时间延迟指定毫秒数，在以某一时间间隔无限循环的执行某一任务
    - scheduleAtFixedRate(TimerTask var1, long var2, long var4) -- 
    - cancel(TimerTask类中) -- 是将自身从任务队列中清除
    - cancel(Timer类中) -- 是将任务队列中全部任务清除(偶尔是无效的原因是可能没抢到队列锁)
    
Timer 类负责计划任务。TimerTask 类来封装任务。如果计划的时间早于现在时间，立即执行。

- schedule 和 scheduleAtFixedRate 比较

| 条目     | schedule| scheduleAtFixedRate|
|:--------|---------:|:-------:|
| 延时| 下次任务执行时间参考的是上一次任务的结束时间| 下次任务执行时间参考的是上一次任务的结束时间      |
| 非延时| 下次任务执行时间参考的是上一次任务的开始时间| 下次任务执行时间参考的是上一次任务的结束时间      |
   1. 它们俩在延时情况下是相同的，都是下次任务执行时间参考的是上一次任务的结束时间。
   2. schedule 不具有追赶执行性，scheduleAtFixedRate 有追赶执行性。



