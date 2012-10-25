package common.thread.concurrent.threadpool;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/**
 * һ���򵥵��������
 * @author Administrator
 *
 */
public class BeepControl {
 
    // ����һ���̳߳أ����ɰ����ڸ����ӳٺ�����������߶��ڵ�ִ�С�
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
 
    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
 
            public void run() {
                // ����ϵͳ��beep
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
        };
        // ������ִ��һ���ڸ�����ʼ�ӳٺ��״����õĶ��ڲ����������������и��������ڣ�Ҳ���ǽ��� initialDelay ��ʼִ�У�
        // Ȼ���� initialDelay+period ��ִ�У������� initialDelay + 2 * period ��ִ�У��������ơ�
        final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 0, 1, SECONDS);
 
        // ��60*60 SECONDS��,��ͼȡ����beeperHandle�����ִ��
        scheduler.schedule(new Runnable() {
 
            public void run() {
                // ȡ����beeperHandle�����ִ��
                beeperHandle.cancel(true);
            }
        }, 60 * 60, SECONDS);
    }
 
    public static void main(String[] args) {
        BeepControl ctr = new BeepControl();
        ctr.beepForAnHour();
    }
}
