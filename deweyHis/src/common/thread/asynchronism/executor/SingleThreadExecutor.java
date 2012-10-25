package common.thread.asynchronism.executor;

import java.util.Date;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
/* 
 * MVC中的异步执行解决方案 
 * @Author 三上 
 */  
public class SingleThreadExecutor {  
    public static void main(String[] args) {  
        try {  
            // 创建一个单线程执行程序  
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
            System.out.println("我是主线程，先执行我");  
        } catch (Exception e) {  
        }  
    }  
}  