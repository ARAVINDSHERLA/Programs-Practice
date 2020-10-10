package concurrentpacakge;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

class MultiThreading {

   public static int threadPoolSize = 8;
   public static void main(String[] args) {

	   MultiThreading app = new MultiThreading();
        app.process();
     }
    private void process() {
        
        File folder = new File("C:\\temp");
        File[] listOfFiles = folder.listFiles();

        // Create executor - just 1 executor, not multiple.
        ThreadPoolExecutor readExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadPoolSize);

        // Create DB connection pool, using something like Apache DBCP, of same size as number of writer threads.

        // Submit each file to its own thread
        for (int i = 0; i < listOfFiles.length; i++) {
            File f = listOfFiles[i];
            if (f.isFile()) {
                readExecutor.execute(new FileProcessor(f));
            }
        }
    }

    class FileProcessor implements Runnable {

        private File file;
        String record = null;

        private FileProcessor(File f) {
            this.file = f;
        }

        public void run() {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                while((record = reader.readLine()) != null) {
                    //DB insertion needs to be written
                    System.out.println("Record++++++++" + record);
                 }
                // Write record to DB using SQL insert and a Connection got from the created connection pool.
            } catch (IOException ex) {
                Logger.getLogger(MultiThreading.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

