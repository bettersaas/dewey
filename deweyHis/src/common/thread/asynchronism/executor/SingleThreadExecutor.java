package common.thread.asynchronism.executor;

import java.util.Date;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
/* 
 * MVC�е��첽ִ�н������ 
 * @Author ���� 
 */  
public class SingleThreadExecutor {  
    public static void main(String[] args) {  
        try {  
            // ����һ�����߳�ִ�г���  
            ExecutorService executorService = Executors  
                    .newSingleThreadExecutor();  
            final Runnable beeper = new Runnable() {  
                int count = 0;  
  
                public void run() {  
                    System.out.println(new Date() + " beep " + (++count));  
                }  
            };  
            for (int i = 0; i < 100; i++) {  
                executorService.execute(beeper);  
            }  
            executorService.shutdown();  
            System.out.println("�������̣߳���ִ����");  
        } catch (Exception e) {  
        }  
    }  
}  