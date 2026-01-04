package 多线程;

/**
 * Java 多线程完整学习笔记
 * 核心涵盖：线程创建方式（继承Thread/实现Runnable/实现Callable）、线程生命周期、线程控制
 *          线程同步（synchronized/Lock）、线程通信、线程池（Executors）
 * 特性：代码可直接运行、注释详尽、易错点高亮、结构清晰
 */
public class MultiThreadDemo {
    public static void main(String[] args) throws Exception {
        // ============== 一、多线程概述（核心认知） ==============
        System.out.println("============== 一、多线程概述 ==============");
        System.out.println("进程：程序的一次运行实例（如QQ、浏览器），系统资源分配的最小单位");
        System.out.println("线程：进程内的执行单元（如QQ的聊天窗口、文件传输），CPU调度的最小单位，共享进程资源");
        System.out.println("多线程优势：提高CPU利用率，实现并发执行（如同时下载多个文件、多窗口操作）");
        System.out.println("线程生命周期：新建（New）-> 就绪（Runnable）-> 运行（Running）-> 阻塞（Blocked）-> 死亡（Dead）");
        System.out.println();

        // ============== 二、线程创建的3种方式 ==============
        System.out.println("============== 二、线程创建的3种方式 ==============");

        // 2.1 方式1：继承Thread类，重写run()方法
        System.out.println("--- 2.1 继承Thread类 ---");
        class MyThread extends Thread {
            @Override
            public void run() {
                // 线程执行的业务逻辑
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                    try {
                        Thread.sleep(100); // 线程休眠100毫秒，模拟耗时操作
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.setName("线程1（继承Thread）");
        thread2.setName("线程2（继承Thread）");
        thread1.start(); // 启动线程（不能直接调用run()，否则为普通方法调用）
        thread2.start();
        Thread.sleep(600); // 等待线程1、2执行完毕
        System.out.println();

        // 2.2 方式2：实现Runnable接口，重写run()方法（推荐，避免单继承限制，共享数据更方便）
        System.out.println("--- 2.2 实现Runnable接口 ---");
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        MyRunnable runnable = new MyRunnable();
        Thread thread3 = new Thread(runnable, "线程3（实现Runnable）");
        Thread thread4 = new Thread(runnable, "线程4（实现Runnable）");
        thread3.start();
        thread4.start();
        Thread.sleep(600);
        System.out.println();

        // 2.3 方式3：实现Callable接口，重写call()方法（支持返回值、支持抛出异常）
        System.out.println("--- 2.3 实现Callable接口（有返回值） ---");
        class MyCallable implements java.util.concurrent.Callable<Integer> {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 10; i++) {
                    sum += i;
                    System.out.println(Thread.currentThread().getName() + "：计算i=" + i + "，当前和=" + sum);
                    Thread.sleep(100);
                }
                return sum; // 返回计算结果
            }
        }
        // Callable需要配合FutureTask使用
        java.util.concurrent.FutureTask<Integer> futureTask1 = new java.util.concurrent.FutureTask<>(new MyCallable());
        java.util.concurrent.FutureTask<Integer> futureTask2 = new java.util.concurrent.FutureTask<>(new MyCallable());
        Thread thread5 = new Thread(futureTask1, "线程5（实现Callable）");
        Thread thread6 = new Thread(futureTask2, "线程6（实现Callable）");
        thread5.start();
        thread6.start();
        // 获取返回值（阻塞等待线程执行完毕）
        Integer result1 = futureTask1.get();
        Integer result2 = futureTask2.get();
        System.out.println("线程5计算结果：" + result1);
        System.out.println("线程6计算结果：" + result2);
        System.out.println();

        // ============== 三、线程控制（休眠、优先级、加入、中断） ==============
        System.out.println("============== 三、线程控制 ==============");
        // 3.1 线程休眠（sleep()：暂停指定时间，不释放锁）
        System.out.println("--- 3.1 线程休眠（sleep） ---");
        Thread sleepThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "：休眠中..." + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "休眠线程");
        sleepThread.start();
        Thread.sleep(700);

        // 3.2 线程优先级（setPriority()：1-10，默认5，优先级高仅表示获取CPU时间片概率高）
        System.out.println("--- 3.2 线程优先级（1-10） ---");
        Thread highPriorityThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "：高优先级");
            }
        }, "高优先级线程");
        Thread lowPriorityThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "：低优先级");
            }
        }, "低优先级线程");
        highPriorityThread.setPriority(Thread.MAX_PRIORITY); // 10
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY); // 1
        highPriorityThread.start();
        lowPriorityThread.start();
        Thread.sleep(100);
        System.out.println();

        // ============== 四、线程同步（解决线程安全问题，共享资源竞争） ==============
        System.out.println("============== 四、线程同步（解决线程安全） ==============");
        // 4.1 方式1：synchronized关键字（同步方法/同步代码块，自动释放锁）
        System.out.println("--- 4.1 synchronized（同步代码块） ---");
        class TicketSeller implements Runnable {
            private int ticketNum = 10; // 共享资源：10张票

            @Override
            public void run() {
                while (true) {
                    // 同步代码块：锁对象可以是this或类对象（确保多个线程共用同一把锁）
                    synchronized (this) {
                        if (ticketNum <= 0) {
                            break;
                        }
                        // 模拟售票耗时
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "：卖出1张票，剩余票数=" + (--ticketNum));
                    }
                }
            }
        }
        TicketSeller ticketSeller = new TicketSeller();
        Thread seller1 = new Thread(ticketSeller, "售票窗口1");
        Thread seller2 = new Thread(ticketSeller, "售票窗口2");
        Thread seller3 = new Thread(ticketSeller, "售票窗口3");
        seller1.start();
        seller2.start();
        seller3.start();
        Thread.sleep(1500); // 等待售票完成
        System.out.println();

        // 4.2 方式2：Lock锁（ReentrantLock，手动获取/释放锁，更灵活）
        System.out.println("--- 4.2 Lock锁（ReentrantLock） ---");
        class TicketSellerLock implements Runnable {
            private int ticketNum = 10;
            // 创建可重入锁
            private java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();

            @Override
            public void run() {
                while (true) {
                    lock.lock(); // 手动获取锁
                    try {
                        if (ticketNum <= 0) {
                            break;
                        }
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "：卖出1张票，剩余票数=" + (--ticketNum));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock(); // 手动释放锁，必须放在finally中，避免死锁
                    }
                }
            }
        }
        TicketSellerLock ticketSellerLock = new TicketSellerLock();
        Thread seller4 = new Thread(ticketSellerLock, "售票窗口4");
        Thread seller5 = new Thread(ticketSellerLock, "售票窗口5");
        Thread seller6 = new Thread(ticketSellerLock, "售票窗口6");
        seller4.start();
        seller5.start();
        seller6.start();
        Thread.sleep(1500);
        System.out.println();

        // ============== 五、线程池（Executors，高效管理线程） ==============
        System.out.println("============== 五、线程池（Executors） ==============");
        // 5.1 创建固定大小线程池
        java.util.concurrent.ExecutorService fixedThreadPool = java.util.concurrent.Executors.newFixedThreadPool(3);
        System.out.println("--- 5.1 固定大小线程池（3个线程） ---");
        for (int i = 0; i < 5; i++) {
            int taskNum = i;
            fixedThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "：执行任务" + taskNum);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        fixedThreadPool.shutdown(); // 关闭线程池（等待任务执行完毕）
        Thread.sleep(1200);
        System.out.println();

        // ============== 六、多线程核心易错点总结 ==============
        System.out.println("============== 六、多线程核心易错点 ==============");
        System.out.println("1. 线程启动：必须调用start()方法，不能直接调用run()（run()为普通方法，不启动新线程）");
        System.out.println("2. 线程安全：多个线程操作共享资源时，必须使用同步（synchronized/Lock），否则出现数据错乱");
        System.out.println("3. 锁的释放：synchronized自动释放锁（异常/方法结束），Lock必须手动unlock（放在finally中）");
        System.out.println("4. sleep() vs wait()：sleep()不释放锁，wait()释放锁；wait()需在同步代码块中调用，依赖notify()唤醒");
        System.out.println("5. 线程池优势：减少线程创建/销毁开销，控制线程数量，避免OOM，优先使用线程池而非手动创建线程");
        System.out.println("6. Callable vs Runnable：Callable有返回值、支持抛出异常，需配合FutureTask使用");
    }
}