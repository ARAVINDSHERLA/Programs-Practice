package concurrentpacakge;

import java.util.concurrent.*;

public class CallableThreadPoolTest {
   public static void main(String[] args) {
      int numWorkers =5; //Integer.parseInt(args[0]);

      ExecutorService pool = Executors.newCachedThreadPool();
      CallableWorkerThread workers[] = new CallableWorkerThread[numWorkers];
      Future[] futures = new Future[numWorkers];

      for (int i = 0; i < numWorkers; ++i) {
         workers[i] = new CallableWorkerThread(i + 1);
         futures[i] = pool.submit(workers[i]);
      }
      for (int i = 0; i < numWorkers; ++i) {
         try {
            System.out.println(futures[i].get() + " ended");
         } catch (InterruptedException ex) {
            ex.printStackTrace();
         } catch (ExecutionException ex) {
            ex.printStackTrace();
         }
      }
   }
}