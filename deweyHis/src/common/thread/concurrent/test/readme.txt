java concurrent ̽��(ת) 
��java�������-Executor���
��Java����--����ִ��.
���������������Thread�ĳ�ʱ�Զ���ֹ

�Ƽ�Ⱥ��: D����
��������Ƽ� java concurrent ̽��(ת) 

���Ƕ�֪������JDK1.5֮ǰ��Java��Ҫ����ҵ�񲢷�ʱ��ͨ����Ҫ�г���Ա������ɴ���ʵ�֣���ȻҲ��һЩ��Դ�Ŀ���ṩ����Щ���ܣ�������Щ��Ȼû��JDK�Դ��Ĺ���ʹ���������㡣������Ը�����Java���̲߳����������ʱ,Ϊ��ֹ���ĵ�����ĳ��֣�����ʹ��java֮ǰ��wait()��notify()��synchronized�ȣ�ÿÿ��Ҫ�������ܡ���������ƽ�ԡ���Դ�����Լ���α����̰߳�ȫ�Է��������Σ����������أ����������һЩ��Ϊ���ӵİ�ȫ���ԣ������˳���Ա�Ŀ�������.���ҵ��ǣ���JDK1.5����֮��Sun����Doug Lea������Ϊ������Щ������С����Ա�Ƴ���java.util.concurrent���߰��Լ򻯲�����ɡ��������ǽ����ڴˣ�����Ч�ļ��پ���������race conditions���������̡߳�concurrent���ܺõĽ������Щ���⣬Ϊ�����ṩ�˸�ʵ�õĲ�������ģ�͡�
 

Executor                  ������Runnable�����ִ���ߡ� 
ExecutorService           ��һ���̳߳ع����ߣ���ʵ�����ж��֣��һ����һ���֡������ܰ�Runnable,Callable�ύ������������ȡ�
 Semaphore                 ��һ�������ź��� 
ReentrantLock             ��һ��������Ļ������� Lock����������synchronized����Ҫǿ��Ķࡣ 
Future                    ������Runnable,Callable���н����Ľӿڣ�����һ���߳�ִ�н�����ȡ���صĽ���ȵȣ����ṩ��cancel��ֹ�̡߳�
 BlockingQueue             ���������С� 
CompletionService         : ExecutorService����չ�����Ի���߳�ִ�н���� 
CountDownLatch            ��һ��ͬ�������࣬�����һ�����������߳���ִ�еĲ���֮ǰ��������һ�������߳�һֱ�ȴ��� 
CyclicBarrier             ��һ��ͬ�������࣬������һ���̻߳���ȴ���ֱ������ĳ���������ϵ� 
Future                    ��Future ��ʾ�첽����Ľ���� 
ScheduledExecutorService ��һ�� ExecutorService���ɰ����ڸ������ӳٺ����л���ִ�е���� 

��������һ���� 

Executors��Ҫ����˵�� 
newFixedThreadPool���̶���С�̳߳أ� 
����һ�������ù̶��̼߳��ϵ��̳߳أ��Թ�����޽���з�ʽ��������Щ�̣߳�ֻ��Ҫ����Ĺ������ͻ���һ��������ȴ�ִ�У�������ڹر�ǰ��ִ���ڼ�����ʧ�ܶ������κ��߳���ֹ����ôһ�����߳̽�������ִ�к��������������Ҫ����
 
newCachedThreadPool���޽��̳߳أ����Խ����Զ��̻߳��գ� 
����һ���ɸ�����Ҫ�������̵߳��̳߳أ���������ǰ������߳̿���ʱ���������ǡ�����ִ�кܶ�����첽����ĳ�����ԣ���Щ�̳߳�ͨ������߳������ܡ����� execute ��������ǰ������̣߳�����߳̿��ã�����������߳�û�п��õģ��򴴽�һ�����̲߳���ӵ����С���ֹ���ӻ������Ƴ���Щ���� 60 ����δ��ʹ�õ��̡߳���ˣ���ʱ�䱣�ֿ��е��̳߳ز���ʹ���κ���Դ��ע�⣬����ʹ�� ThreadPoolExecutor ���췽�����������������Ե�ϸ�ڲ�ͬ�����糬ʱ���������̳߳ء�
 
newSingleThreadExecutor��������̨�̣߳� 
����һ��ʹ�õ��� worker �̵߳� Executor�����޽���з�ʽ�����и��̡߳���ע�⣬�����Ϊ�ڹر�ǰ��ִ���ڼ����ʧ�ܶ���ֹ�˴˵����̣߳���ô�����Ҫ��һ�����߳̽�������ִ�к��������񣩡��ɱ�֤˳���ִ�и������񣬲��������������ʱ�䲻���ж���߳��ǻ�ġ���������Ч�� newFixedThreadPool(1) ��ͬ���ɱ�֤�����������ô˷��������ص�ִ�г��򼴿�ʹ���������̡߳�
 
��Щ�������صĶ���ExecutorService�����������������Ϊ����һ���̳߳ء� 
����̳߳صĹ��ܻ��ǱȽ����Ƶġ������ύ����submit()���Խ����̳߳�shutdown()�� 

import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 

public class MyExecutor extends Thread { 
private int index; 
public MyExecutor(int i){ 
    this.index=i; 
} 
public void run(){ 
    try{ 
     System.out.println("["+this.index+"] start...."); 
     Thread.sleep((int)(Math.random()*1000)); 
     System.out.println("["+this.index+"] end."); 
    } 
    catch(Exception e){ 
     e.printStackTrace(); 
    } 
} 

public static void main(String args[]){ 
    ExecutorService service=Executors.newFixedThreadPool(4); 
    for(int i=0;i<10;i++){ 
     service.execute(new MyExecutor(i)); 
     //service.submit(new MyExecutor(i)); 
    } 
    System.out.println("submit finish"); 
    service.shutdown(); 
} 
} 

��Ȼ��ӡ��һЩ��Ϣ�����ǿ��Ĳ��Ƿǳ�����������̳߳�����ι����ģ������������ߵ�ʱ�����10���� 
Thread.sleep((int)(Math.random()*10000)); 

�����������������ֻ��ִ��4���̡߳���ִ����һ���̺߳󣬲Ż���ִ��һ���µ��̣߳�Ҳ����˵�����ǽ����е��߳��ύ���̳߳ػ�ȴ�ִ�������shutdown������Ҳ�ᷢ�֣��ύ���̱߳��ŵ�һ�����޽�����������һ��������У�BlockingQueue����������˵������
 
������ʹ����Executors�ľ�̬��������һ���̶����̳߳أ�����˼�壬�̳߳ص��߳��ǲ����ͷŵģ���ʹ����Idle�� 
��ͻ�����������⣬��������̳߳صĴ�СΪ200����ȫ��ʹ����Ϻ����е��̻߳�������ڳ��У���Ӧ���ڴ���߳��л���while(true)+sleepѭ�����������ӡ�
 ���Ҫ����������⣬�ͱ���ֱ��ʹ��ThreadPoolExecutor()�����졣������ͨ�õ��̳߳�һ�����á�����߳�����������С�߳������͡������߳�keepAlive��ʱ�䡱��
 

��������̳߳ػ����÷��� 

Semaphore 
һ�������ź������Ӹ����Ͻ����ź���ά����һ����ɼ��ϡ����б�Ҫ������ɿ���ǰ������ÿһ�� acquire()��Ȼ���ٻ�ȡ����ɡ�ÿ�� release() ���һ����ɣ��Ӷ������ͷ�һ�����������Ļ�ȡ�ߡ����ǣ���ʹ��ʵ�ʵ���ɶ���Semaphore ֻ�Կ�����ɵĺ�����м���������ȡ��Ӧ���ж���
 
Semaphore ͨ���������ƿ��Է���ĳЩ��Դ��������߼��ģ����߳���Ŀ�����磬�������ʹ���ź������ƶ����ݳصķ��ʣ� 

������һ��ʵ�ʵ����������Ŷ��ϲ���������ֻ������λ�ã�����10������Ҫ�Ŷӡ� 

import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.concurrent.Semaphore; 

public class MySemaphore extends Thread { 
Semaphore position; 
private int id; 
public MySemaphore(int i,Semaphore s){ 
    this.id=i; 
    this.position=s; 
} 

public void run(){ 
    try{ 
     if(position.availablePermits()>0){ 
      System.out.println("�˿�["+this.id+"]����������п�λ"); 
     } 
     else{ 
      System.out.println("�˿�["+this.id+"]���������û��λ���Ŷ�"); 
     } 
     position.acquire(); 
     System.out.println("�˿�["+this.id+"]��ÿ�λ"); 
     Thread.sleep((int)(Math.random()*1000)); 
     System.out.println("�˿�["+this.id+"]ʹ�����"); 
     position.release(); 
    } 
    catch(Exception e){ 
     e.printStackTrace(); 
    } 
} 
public static void main(String args[]){ 
    ExecutorService list=Executors.newCachedThreadPool(); 
    Semaphore position=new Semaphore(2); 
    for(int i=0;i<10;i++){ 
     list.submit(new MySemaphore(i+1,position)); 
    } 
    list.shutdown(); 
    position.acquireUninterruptibly(2); 
    System.out.println("ʹ����ϣ���Ҫ��ɨ��"); 
    position.release(2); 
} 
} 



ReentrantLock 
һ��������Ļ������� Lock����������ʹ�� synchronized ��������������ʵ���ʽ������������ͬ��һЩ������Ϊ�����壬�����ܸ�ǿ�� 

ReentrantLock ��������ɹ�������������һ�û���ͷŸ��������߳���ӵ�С�������û�б���һ���߳���ӵ��ʱ������ lock ���߳̽��ɹ���ȡ�����������ء������ǰ�߳��Ѿ�ӵ�и��������˷������������ء�����ʹ�� isHeldByCurrentThread() �� getHoldCount() ��������������Ƿ�����
 
����Ĺ��췽������һ����ѡ�Ĺ�ƽ������ 
������Ϊ trueʱ���ڶ���̵߳������£���Щ���������ڽ�����Ȩ����ȴ�ʱ������̡߳�������������޷���֤�κ��ض�����˳�� 
�����Ĭ�����ã�ʹ�ò���ƽ��������ȣ�ʹ�ù�ƽ�����ĳ���������̷߳���ʱ����Ϊ�ܵ͵����������������ٶȺ������������������������ڻ�������ͱ�֤��������ľ�����ʱ�����С������Ҫע����ǣ���ƽ�������ܱ�֤�̵߳��ȵĹ�ƽ�ԡ���ˣ�ʹ�ù�ƽ�������ڶ��߳��е�һԱ���ܻ�ö౶�ĳɹ����ᣬ�������������������߳�û�б�������Ŀǰ��δ��������ʱ����Ҫע����ǣ�δ��ʱ�� tryLock ������û��ʹ�ù�ƽ���á���Ϊ��ʹ�����߳����ڵȴ���ֻҪ�������ǿ��õģ��˷����Ϳ��Ի�óɹ���
 
�������� ����ʵ����ʹ�� try �������� lock����֮ǰ/֮��Ĺ����У�����͵Ĵ������£� 
class X { 
    private final ReentrantLock lock = new ReentrantLock(); 
    // ... 

    public void m() { 
      lock.lock(); // block until condition holds 
      try { 
        // ... method body 
      } finally { 
        lock.unlock() 
      } 
    } 
} 

�ҵ����ӣ� 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.concurrent.locks.ReentrantLock; 

public class MyReentrantLock extends Thread{ 
TestReentrantLock lock; 
private int id; 
public MyReentrantLock(int i,TestReentrantLock test){ 
    this.id=i; 
    this.lock=test; 
} 

public void run(){ 
    lock.print(id); 
} 

public static void main(String args[]){ 
    ExecutorService service=Executors.newCachedThreadPool(); 
    TestReentrantLock lock=new TestReentrantLock(); 
    for(int i=0;i<10;i++){ 
     service.submit(new MyReentrantLock(i,lock)); 
    } 
    service.shutdown(); 
} 
} 
class TestReentrantLock{ 
private ReentrantLock lock=new ReentrantLock(); 
public void print(int str){ 
    try{ 
     lock.lock(); 
     System.out.println(str+"���"); 
     Thread.sleep((int)(Math.random()*1000)); 
    } 
    catch(Exception e){ 
     e.printStackTrace(); 
    } 
    finally{ 
     System.out.println(str+"�ͷ�"); 
     lock.unlock(); 
    } 
} 
} 

BlockingQueue 
֧���������Ӳ����� Queue�������������ǣ�����Ԫ��ʱ�ȴ����б�Ϊ�ǿգ��Լ��洢Ԫ��ʱ�ȴ��ռ��ÿ��á� 

BlockingQueue ������ null Ԫ�ء���ͼ add��put �� offer һ�� null Ԫ��ʱ��ĳЩʵ�ֻ��׳� NullPointerException��null ������ָʾ poll ����ʧ�ܵľ���ֵ��
 
BlockingQueue �������޶������ġ������������ʱ�䶼������һ�� remainingCapacity�����������������޷��������� put �����Ԫ�ء�
 û���κ��ڲ�����Լ���� BlockingQueue ���Ǳ��� Integer.MAX_VALUE ��ʣ�������� 

BlockingQueue ʵ����Ҫ����������-ʹ���߶��У��������⻹֧�� Collection �ӿڡ���ˣ�������˵��ʹ�� remove(x) �Ӷ������Ƴ�����һ��Ԫ�����п��ܵġ�
 Ȼ�������ֲ���ͨ���� ����Чִ�У�ֻ���мƻ���ż��ʹ�ã�������ȡ���Ŷ���Ϣʱ�� 

BlockingQueue ʵ�����̰߳�ȫ�ġ������Ŷӷ���������ʹ���ڲ�������������ʽ�Ĳ����������Զ��ﵽ���ǵ�Ŀ�ġ� 
Ȼ���������� Collection ������addAll��containsAll��retainAll �� removeAll��û�� ��Ҫ�Զ�ִ�У�������ʵ�����ر�˵����
 ��ˣ�������˵����ֻ����� c �е�һЩԪ�غ�addAll(c) �п���ʧ�ܣ��׳�һ���쳣���� 

BlockingQueue ʵ���ϲ� ֧��ʹ���κ�һ�֡�close����shutdown��������ָʾ��������κ�� 
���ֹ��ܵ������ʹ����������ʵ�ֵ��������磬һ�ֳ��õĲ����ǣ����������ߣ���������� end-of-stream �� poison ���󣬲�����ʹ���߻�ȡ��Щ�����ʱ���������ǽ��н��͡�
 
�����������ʾ������������еĻ������ܡ� 

import java.util.concurrent.BlockingQueue; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.concurrent.LinkedBlockingQueue; 

public class MyBlockingQueue extends Thread { 
public static BlockingQueue<String> queue = new LinkedBlockingQueue<String>(3); 

private int index; 

public MyBlockingQueue(int i) { 
   this.index = i; 
} 

public void run() { 
   try { 
    queue.put(String.valueOf(this.index)); 
    System.out.println("{" + this.index + "} in queue!"); 
   } catch (Exception e) { 
    e.printStackTrace(); 
   } 
} 

public static void main(String args[]) { 
   ExecutorService service = Executors.newCachedThreadPool(); 
   for (int i = 0; i < 10; i++) { 
    service.submit(new MyBlockingQueue(i)); 
   } 
   Thread thread = new Thread() { 
    public void run() { 
     try { 
      while (true) { 
       Thread.sleep((int) (Math.random() * 1000)); 
       if(MyBlockingQueue.queue.isEmpty()) 
        break; 
       String str = MyBlockingQueue.queue.take(); 
       System.out.println(str + " has take!"); 
      } 
     } catch (Exception e) { 
      e.printStackTrace(); 
     } 
    } 
   }; 
   service.submit(thread); 
   service.shutdown(); 
} 
} 
---------------------ִ�н��----------------- 
{0} in queue! 
{1} in queue! 
{2} in queue! 
{3} in queue! 
0 has take! 
{4} in queue! 
1 has take! 
{6} in queue! 
2 has take! 
{7} in queue! 
3 has take! 
{8} in queue! 
4 has take! 
{5} in queue! 
6 has take! 
{9} in queue! 
7 has take! 
8 has take! 
5 has take! 
9 has take! 

----------------------------------------- 


CompletionService 

�������µ��첽������ʹ�����������Ľ�����뿪���ķ��������� submit ִ�е�����ʹ���� take ����ɵ����� 
�����������Щ�����˳�������ǵĽ�������磬CompletionService �������������첽 IO ��ִ�ж�������������Ϊ�����ϵͳ��һ�����ύ�� 
Ȼ�󣬵���ɶ�����ʱ�����ڳ���Ĳ�ͬ����ִ������������ִ�в�����˳��������������˳��ͬ�� 

ͨ����CompletionService ������һ�������� Executor ��ʵ��ִ����������������£� 
CompletionService ֻ����һ���ڲ���ɶ��С�ExecutorCompletionService ���ṩ�˴˷�����һ��ʵ�֡� 


import java.util.concurrent.Callable; 
import java.util.concurrent.CompletionService; 
import java.util.concurrent.ExecutorCompletionService; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 

public class MyCompletionService implements Callable<String> { 
private int id; 

public MyCompletionService(int i){ 
   this.id=i; 
} 
public static void main(String[] args) throws Exception{ 
   ExecutorService service=Executors.newCachedThreadPool(); 
   CompletionService<String> completion=new ExecutorCompletionService<String>(service);
    for(int i=0;i<10;i++){ 
    completion.submit(new MyCompletionService(i)); 
   } 
   for(int i=0;i<10;i++){ 
    System.out.println(completion.take().get()); 
   } 
   service.shutdown(); 
} 
public String call() throws Exception { 
   Integer time=(int)(Math.random()*1000); 
   try{ 
    System.out.println(this.id+" start"); 
    Thread.sleep(time); 
    System.out.println(this.id+" end"); 
   } 
   catch(Exception e){ 
    e.printStackTrace(); 
   } 
   return this.id+":"+time; 
} 
} 


CountDownLatch 


һ��ͬ�������࣬�����һ�����������߳���ִ�еĲ���֮ǰ��������һ�������߳�һֱ�ȴ��� 

�ø����ļ��� ��ʼ�� CountDownLatch�����ڵ����� countDown() �����������ڵ�ǰ����������֮ǰ��await ������һֱ�������� 
֮�󣬻��ͷ����еȴ����̣߳�await �����к������ö����������ء���������ֻ����һ�Ρ��������޷������á������Ҫ���ü������뿼��ʹ�� CyclicBarrier��
 
CountDownLatch ��һ��ͨ��ͬ�����ߣ����кܶ���;�������� 1 ��ʼ���� CountDownLatch ����һ���򵥵Ŀ�/���������� 
����ڣ���ͨ������ countDown() ���̴߳����ǰ�����е��� await ���̶߳�һֱ����ڴ��ȴ��� 
�� N ��ʼ���� CountDownLatch ����ʹһ���߳��� N ���߳����ĳ�����֮ǰһֱ�ȴ�������ʹ����ĳ�������� N ��֮ǰһֱ�ȴ��� 

CountDownLatch ��һ�����������ǣ�����Ҫ����� countDown �������̵߳ȵ�����������ʱ�ż����� 
���������̶߳���ͨ��֮ǰ����ֻ����ֹ�κ��̼߳���ͨ��һ�� await�� 
һ�µ������Ǳ���д�ģ��ǳ����� 

import java.util.concurrent.CountDownLatch; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 

public class TestCountDownLatch { 
public static void main(String[] args) throws InterruptedException { 
   // ��ʼ�ĵ����� 
   final CountDownLatch begin = new CountDownLatch(1); 
   // �����ĵ����� 
   final CountDownLatch end = new CountDownLatch(10); 
   // ʮ��ѡ�� 
   final ExecutorService exec = Executors.newFixedThreadPool(10); 
  
   for (int index = 0; index < 10; index++) { 
    final int NO = index + 1; 
    Runnable run = new Runnable() { 
     public void run() { 
      try { 
       begin.await();//һֱ���� 
       Thread.sleep((long) (Math.random() * 10000)); 
       System.out.println("No." + NO + " arrived"); 
      } catch (InterruptedException e) { 
      } finally { 
       end.countDown(); 
      } 
     } 
    }; 
    exec.submit(run); 
   } 
   System.out.println("Game Start"); 
   begin.countDown(); 
   end.await(); 
   System.out.println("Game Over"); 
   exec.shutdown(); 
} 
} 
CountDownLatch����Ҫ�ķ�����countDown()��await()��ǰ����Ҫ�ǵ���һ�Σ������ǵȴ�������0�����û�е���0����ֻ�������ȴ��ˡ� 


CyclicBarrier 

һ��ͬ�������࣬������һ���̻߳���ȴ���ֱ������ĳ���������ϵ� (common barrier point)�� 
���漰һ��̶���С���̵߳ĳ����У���Щ�̱߳��벻ʱ�ػ���ȴ�����ʱ CyclicBarrier �����á���Ϊ�� barrier ���ͷŵȴ��̺߳�������ã����Գ���Ϊѭ�� �� barrier��
 
CyclicBarrier ֧��һ����ѡ�� Runnable �����һ���߳��е����һ���̵߳���֮�󣨵����ͷ������߳�֮ǰ���� 
������ֻ��ÿ�����ϵ�����һ�Ρ����ڼ������в����߳�֮ǰ���¹���״̬�������ϲ��� �����á� 

ʾ���÷���������һ���ڲ��зֽ������ʹ�� barrier �����ӣ��ܾ�������������ӣ� 
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.concurrent.BrokenBarrierException; 
import java.util.concurrent.CyclicBarrier; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
public class TestCyclicBarrier { 
  // ͽ����Ҫ��ʱ��: Shenzhen, Guangzhou, Shaoguan, Changsha, Wuhan 
  private static int[] timeWalk = { 5, 8, 15, 15, 10 }; 
  // �Լ��� 
  private static int[] timeSelf = { 1, 3, 4, 4, 5 }; 
  // ���δ�� 
  private static int[] timeBus = { 2, 4, 6, 6, 7 }; 
  
  static String now() { 
     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
     return sdf.format(new Date()) + ": "; 
  } 

  static class Tour implements Runnable { 
     private int[] times; 
     private CyclicBarrier barrier; 
     private String tourName; 
     public Tour(CyclicBarrier barrier, String tourName, int[] times) { 
       this.times = times; 
       this.tourName = tourName; 
       this.barrier = barrier; 
     } 
     public void run() { 
       try { 
         Thread.sleep(times[0] * 1000); 
         System.out.println(now() + tourName + " Reached Shenzhen"); 
         barrier.await(); 
         Thread.sleep(times[1] * 1000); 
         System.out.println(now() + tourName + " Reached Guangzhou"); 
         barrier.await(); 
         Thread.sleep(times[2] * 1000); 
         System.out.println(now() + tourName + " Reached Shaoguan"); 
         barrier.await(); 
         Thread.sleep(times[3] * 1000); 
         System.out.println(now() + tourName + " Reached Changsha"); 
         barrier.await(); 
         Thread.sleep(times[4] * 1000); 
         System.out.println(now() + tourName + " Reached Wuhan"); 
         barrier.await(); 
       } catch (InterruptedException e) { 
       } catch (BrokenBarrierException e) { 
       } 
     } 
  } 

  public static void main(String[] args) { 
     // ���������� 
     CyclicBarrier barrier = new CyclicBarrier(3); 
     ExecutorService exec = Executors.newFixedThreadPool(3); 
     exec.submit(new Tour(barrier, "WalkTour", timeWalk)); 
     exec.submit(new Tour(barrier, "SelfTour", timeSelf)); 
//�����ǰ��������δ���ע�ͺ󣬻ᷢ�֣����������ˣ��޷�����������ȥ�� 
     exec.submit(new Tour(barrier, "BusTour", timeBus)); 
     exec.shutdown(); 
  } 
} 

CyclicBarrier����Ҫ�����Ծ��ǲ����߸�����������Ҫ������await()���������̶߳�������await()�󣬾ͱ�ʾ��Щ�̶߳����Լ���ִ�У�����ͻ�ȴ���
 
Future 

Future ��ʾ�첽����Ľ�������ṩ�˼������Ƿ���ɵķ������Եȴ��������ɣ�����������Ľ���� 
������ɺ�ֻ��ʹ�� get ������������������б�Ҫ���������ǰ���������˷�����ȡ������ cancel ������ִ�С� 
���ṩ��������������ȷ��������������ɻ��Ǳ�ȡ���ˡ�һ��������ɣ��Ͳ�����ȡ�����㡣 
���Ϊ�˿�ȡ���Զ�ʹ�� Future���ֲ��ṩ���õĽ������������� Future<?> ��ʽ���͡������� null ��Ϊ��������Ľ���� 

���������ǰ��CompletionService�Ѿ������ˣ����Future�Ĺ��ܣ���������������ύ�̵߳�ʱ��ָ��Ϊһ�����ض���ġ� 


ScheduledExecutorService 

һ�� ExecutorService���ɰ����ڸ������ӳٺ����л���ִ�е���� 

schedule ����ʹ�ø����ӳٴ������񣬲�����һ��������ȡ������ִ�е��������scheduleAtFixedRate �� scheduleWithFixedDelay ����������ִ��ĳЩ��ȡ��ǰһֱ�������е�����
 
�� Executor.execute(java.lang.Runnable) �� ExecutorService �� submit �������ύ�����ͨ��������� 0 �ӳٽ��а��š�
 schedule ������������� 0 �͸����ӳ٣����������ڣ���������Щ��Ϊһ������ִ�е����� 

���е� schedule ������������� �ӳٺ�������Ϊ�����������Ǿ��Ե�ʱ������ڡ����� Date ����ʾ�ľ���ʱ��ת����Ҫ�����ʽ�����ס� 
���磬Ҫ������ĳ���Ժ���������У�����ʹ�ã�schedule(task, date.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS)��
 ����Ҫע�⣬��������ʱ��ͬ��Э�顢ʱ��Ư�ƻ��������صĴ��ڣ��������ӳٵ��������ڲ�������������ĵ�ǰ Date ����� 
Executors ��Ϊ�˰������ṩ�� ScheduledExecutorService ʵ���ṩ�˱�ݵĹ��������� 

һ�µ�����Ҳ�����ϱȽ����еġ� 

import static java.util.concurrent.TimeUnit.SECONDS; 
import java.util.Date; 
import java.util.concurrent.Executors; 
import java.util.concurrent.ScheduledExecutorService; 
import java.util.concurrent.ScheduledFuture; 

public class TestScheduledThread { 
public static void main(String[] args) { 
   final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
    final Runnable beeper = new Runnable() { 
    int count = 0; 

    public void run() { 
     System.out.println(new Date() + " beep " + (++count)); 
    } 
   }; 
   // 1���Ӻ����У���ÿ��2������һ�� 
   final ScheduledFuture beeperHandle = scheduler.scheduleAtFixedRate(beeper, 1, 2, SECONDS);
    // 2���Ӻ����У���ÿ�����ϴ������������ȴ�5����������� 
   final ScheduledFuture beeperHandle2 = scheduler.scheduleWithFixedDelay(beeper, 2, 5, SECONDS);
    // 30�������ر����񣬲��ҹر�Scheduler 
   scheduler.schedule(new Runnable() { 
    public void run() { 
     beeperHandle.cancel(true); 
     beeperHandle2.cancel(true); 
     scheduler.shutdown(); 
    } 
   }, 30, SECONDS); 
} 
} 

�������ǾͰ�concurrent���±Ƚ���Ҫ�Ĺ��ܶ��Ѿ��ܽ����ˣ�ϣ��������������а�����