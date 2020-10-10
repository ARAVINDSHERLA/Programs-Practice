package com.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.StandardWatchEventKinds;
 
/*
 If you want to implement feature found in many editors, Textpad, Editplus, and even code editors.
  The feature, which notifies you if a file opened in editor is updated outside. 
  Here is a very simple code or example using Java 7 nio WatchService.

In this Java 7 nio WatchService example we are using WatchService, WatchKey and WatchEvent classes mainly.

The steps we follow are –
 */

public class DirectoryWatcherExample {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
    	//It is always directory watcher.  
    	//In following line if we give a file name to watch, it results in java.nio.file.NotDirectoryException.
        Path directory = Paths.get("D:\\");
 
        try{
            WatchService fileSystemWatchService = FileSystems.getDefault().newWatchService();
            //Register the events to be watched.
            //Events supported are Create, Modify, Delete. But Overflow event occurs if any abnormal event occurs.
            //We can take appropriate action with Overflow. Here we are just continuing.
            WatchKey watchKey = directory.register(fileSystemWatchService,
                    StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);
            while(true){
            	//Take and poll the events.
                WatchKey watchKeyActual = fileSystemWatchService.take();
                for(WatchEvent<?> event: watchKeyActual.pollEvents()){
                	//Extract information out of Events.
                    WatchEvent.Kind<?> eventKind = event.kind();
 
                    if(eventKind == StandardWatchEventKinds.OVERFLOW){
                        continue;
                    }
 
                    WatchEvent<Path> eventPath = (WatchEvent<Path>)event;
                    Path fileName = eventPath.context();
                    System.out.println("Event " + eventKind + " occurred on " + fileName);
                }
                /*
                 If this file is modified using notepad, then there is only one event but if it is modified
                  using Textpad or Wordpad applications, then there are duplicate events.
                   You may want to handle this. We can continue receiving subsequent events if we 
                   reset the watch key.watchKeyActual.reset(); 
                 */
                boolean isReset = watchKeyActual.reset();
                if(!isReset){
                    break;
                }
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
 
    }
 
}