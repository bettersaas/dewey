package common.thread.concurrent.test;

import static java.util.concurrent.TimeUnit.SECONDS;  
import java.util.Date;  
import java.util.concurrent.Callable;  
import java.util.concurrent.Executors;  
import java.util.concurrent.ScheduledExecutorService;  
import java.util.concurrent.ScheduledFuture;  
/* 
 * ScheduledExecutorService     一个 ExecutorService，可安排在给定的延迟后运行或定期执行的命令。 
 * 要安排在某个以后的 Date 运行，可以使用：schedule(task, date.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS)。 
 * 参考网址：http://www.kuqin.com/J2SE6-API/java/util/concurrent/ScheduledExecutorService.html 
 */  
public class TestScheduledThread {  
    public static void job() {  
        final ScheduledExecutorService scheduler = Executors  
                .newScheduledThreadPool(2);  
        final Runnable beeper = new Runnable() {  
            int count = 0;  
            public void run() {  
                System.out.println(new Date() + " beep " + (++count));  
            }  
        };  
        //Callable与Runnable得区别是，它有返回值  
        Callable callable=new Callable(){  
            int count = 0;  
            public Object call() {  
                System.out.println(new Date() + " callbeep " + (++count));  
                return count;  
            }  
        };  
        //1秒钟后运行,只执行1次  
        final ScheduledFuture beeperHandle3 = scheduler.schedule(callable, 1, SECONDS);  
        final ScheduledFuture beeperHandle4 = scheduler.schedule(beeper, 1, SECONDS);  
        // 1秒钟后运行，并每隔2秒运行一次  
        final ScheduledFuture beeperHandle = scheduler.scheduleAtFixedRate(  
                beeper, 1, 2, SECONDS);  
        // 2秒钟后运行，并每次在上次任务运行完后等待5秒后重新运行  
        final ScheduledFuture beeperHandle2 = scheduler.scheduleWithFixedDelay(  
                beeper, 2, 5, SECONDS);  
        // 30秒后结束关闭任务，并且关闭Scheduler  
        scheduler.schedule(new Runnable() {  
            public void run() {  
                beeperHandle.cancel(true);  
                beeperHandle2.cancel(true);  
                beeperHandle3.cancel(true);  
                beeperHandle4.cancel(true);  
                scheduler.shutdown();  
            }  
        }, 30, SECONDS);  
    }  
  
    public static void main(String[] args) {  
        job();  
        System.out.println("我这个执行完了，但是后面还有");  
    }  
} 