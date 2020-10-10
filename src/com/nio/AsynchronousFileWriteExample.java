package com.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
 
public class AsynchronousFileWriteExample {
 
    /**
     * class java.nio.channels.AsynchronousFileChannel for reading, writing and manipulating file. It can perform read, write, and other file operations at a given position in file in asynchronous mode. Here is an AsynchronousFileChannel example of writing to a file using this ( AsynchronousFileChannel Java 7 ) class.

Steps that we follow to write to a file are –

Open a file using AsynchronousFileChannel

This allows us to open a file in different modes from java.nio.file.StandardOpenOption class.  Mostly used modes are to read, write, create, and append. Few special purpose modes are create_new to create new file each time, delete on close to delete file when everything is done and we want to close, truncate existing to truncate all contents to a 0 length file etc.

Define a CompletionHandler for file

This handler is used to handle the two completion scenarios through completed and failed method callbacks. Completed method also populates result integer which is number of bytes written in this case. On failure we are keeping things simple, just printing the exception information.

Write using AsynchronousFileChannel

It writes the string to file using write method and handles result using the CompletionHandler instance.
     */
    public static void main(String[] args) {
        Path file = null;
        AsynchronousFileChannel asynchFileChannel = null;
        String filePath= "D:\\SimpleNIOData.txt";
        try {
        	
            file = Paths.get(filePath);
            asynchFileChannel = AsynchronousFileChannel.open(file,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.CREATE);
 
            CompletionHandler<Integer, Object> handler = new CompletionHandler<Integer, Object>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    System.out.println("Thread: "+ Thread.currentThread().getName()+" File Write Completed with Result:"
                            + result);
                }
 
                @Override
                public void failed(Throwable e, Object attachment) {
                    System.err.println("File Write Failed Exception:");
                    e.printStackTrace();
                }
            };
            System.out.println("Thread: "+Thread.currentThread().getName()+" Before write call");
            asynchFileChannel.write(ByteBuffer
                    .wrap("I am writing using Asynchronous NIO.".getBytes()),
                    0, "File Write", handler);
            System.out.println("Thread: "+Thread.currentThread().getName()+" After write call");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                asynchFileChannel.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
 
}
