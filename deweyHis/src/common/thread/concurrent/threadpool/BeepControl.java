package common.thread.concurrent.threadpool;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/**
 * 一个简单的任务调度
 * @author Administrator
 *
 */
public class BeepControl {
 
    // 创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
 
    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
 
            public void run() {
                // 调用系统的beep
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
        };
        // 创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；也就是将在 initialDelay 后开始执行，
        // 然后在 initialDelay+period 后执行，接着在 initialDelay + 2 * period 后执行，依此类推。
        final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 0, 1, SECONDS);
 
        // 在60*60 SECONDS后,试图取消对beeperHandle任务的执行
        scheduler.schedule(new Runnable() {
 
            public void run() {
                // 取消对beeperHandle任务的执行
                beeperHandle.cancel(true);
            }
        }, 60 * 60, SECONDS);
    }
 
    public static void main(String[] args) {
        BeepControl ctr = new BeepControl();
        ctr.beepForAnHour();
    }
}
