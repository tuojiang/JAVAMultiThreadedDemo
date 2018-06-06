Chapter 2
---
有了第一章学习的一些基本 API 基础之后，第二章开始介绍Java 多线程中的同步以及出现了非线程安全的问题如何解决。
核心内容如下：
- synchronized 对象监视器为 Object 时的使用
- synchronized 对象监视器为 Class 时的使用
- 非线程安全是如何出现的
- Volatitle 关键字的主要作用
- Volatitle 与 synchronized 的区别及使用情况

### 1
- synchronized 同步方法
    1. sychronized 具有锁重入功能：自己可以再次获取自己的内部锁。
    2. synchronized方法内的变量为线程安全的
    3. 多个线程访问一个对象中的实例，有可能出现线程安全问题。加上synchronized即可解决。
    4. 多个线程访问多个对象，则JVM会创建多个锁。会异步进行。
    5. synchronized可以解决脏读的情况。
    6. 同步不可以被继承。

### 2
- synchronized 同步代码快
    - 为了提高CPU的效率，避免synchronized方法时的长时间等待。（出现原因）
    - synchronized代码快赋予不同的对象监视器可以异步进行提高效率。（解决）
    1. 当synchronized方法块用的对象是同一个时候，一个线程使用了synchronized（this）同步代码块时，其他使用synchronized（this）的将被阻塞，因为他们使用的是同一个对象监视器。
    2. synchronized代码快如果使用的对象监视器不是同一个，执行的结果就是异步的。
    3. synchronized对class，对所有对象都起作用。
    4. String字符串具有缓存功能，使用synchronized代码快时避免使用String作为锁对象，使用其他的。
    5. 查看多线程死锁方式
        1. 进入bin目录下，执行jps,获取当前 Run 的 id 号。
        2. 使用 jstack + id 号 即可查看到死锁现象。
    
    
    
    | 比较     | 静态同步synchronized| synchronized（class）代码块|
    |:--------|---------:|:-------:|
    | 区别| 都是同步的|
    | 结果| 静态同步synchronized是对class上锁| synchronized添加到非静态方法是对对象上锁      |
    
### 3
- Volatile -- 使变量在多个线程间可见
    - Volatile 虽然增加了实例变量在多线程间的可见性，但是却不具备同步行，它是不具备原子性的。
      配合上synchronized即可解决问题。
    - AtomicInteger是原子类，也能够实现同步。
      1. 原子类在具有逻辑的情况下不一定正确。
      2. 用同步解决。
    - synchronized代码块有Volatile同步功能
      能够使多线程访问同一个资源同步性，能将工作内存中的私有变量和公共内存中的变量同步功能。
    - synchronized具有互斥性和可见性。


