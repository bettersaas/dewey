package common.thread.concurrent.test;

import static java.util.concurrent.TimeUnit.SECONDS;  
import java.util.Date;  
import java.util.concurrent.Callable;  
import java.util.concurrent.Executors;  
import java.util.concurrent.ScheduledExecutorService;  
import java.util.concurrent.ScheduledFuture;  
/* 
 * ScheduledExecutorService     һ�� ExecutorService���ɰ����ڸ������ӳٺ����л���ִ�е���� 
 * Ҫ������ĳ���Ժ�� Date ���У�����ʹ�ã�schedule(task, date.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS)�� 
 * �ο���ַ��http://www.kuqin.com/J2SE6-API/java/util/concurrent/ScheduledExecutorService.html 
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
        //Callable��Runnable�������ǣ����з���ֵ  
        Callable callable=new Callable(){  
            int count = 0;  
            public Object call() {  
                System.out.println(new Date() + " callbeep " + (++count));  
                return count;  
            }  
        };  
        //1���Ӻ�����,ִֻ��1��  
        final ScheduledFuture beeperHandle3 = scheduler.schedule(callable, 1, SECONDS);  
        final ScheduledFuture beeperHandle4 = scheduler.schedule(beeper, 1, SECONDS);  
        // 1���Ӻ����У���ÿ��2������һ��  
        final ScheduledFuture beeperHandle = scheduler.scheduleAtFixedRate(  
                beeper, 1, 2, SECONDS);  
        // 2���Ӻ����У���ÿ�����ϴ������������ȴ�5�����������  
        final ScheduledFuture beeperHandle2 = scheduler.scheduleWithFixedDelay(  
                beeper, 2, 5, SECONDS);  
        // 30�������ر����񣬲��ҹر�Scheduler  
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
        System.out.println("�����ִ�����ˣ����Ǻ��滹��");  
    }  
} 