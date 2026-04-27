import abstracts.AbstractTask;

class TimerTaskExample {
    public void schedule(AbstractTask task, long delayMs) {
        // 模拟延时执行
        try {
            Thread.sleep(delayMs);
            task.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
