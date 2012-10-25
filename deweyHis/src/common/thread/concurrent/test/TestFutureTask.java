package common.thread.concurrent.test;

import java.util.concurrent.Callable;  
import java.util.concurrent.ExecutionException;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
import java.util.concurrent.Future;  
import java.util.concurrent.TimeUnit;  
import java.util.concurrent.TimeoutException;  
  
public class TestFutureTask {  
    public static void main(String[] args) throws InterruptedException,  
            ExecutionException, TimeoutException {  
        final ExecutorService exec = Executors.newFixedThreadPool(5);  
        Callable call = new Callable() {  
            public String call() throws Exception {  
                Thread.sleep(1000 * 5);  
                return "Other less important but longtime things.";  
            }  
        };  
        Future task = exec.submit(call);  
        // 重要的事情  
        Thread.sleep(1000 * 3);  
        System.out.println("Let’s do important things.");  
        // 其他不重要的事情(比如发邮件等),30秒内如果不执行完，就返回null  
        Object obj = task.get(30,TimeUnit.SECONDS);  
        System.out.println(obj);  
        // 关闭线程池  
        exec.shutdown();  
    }  
} 