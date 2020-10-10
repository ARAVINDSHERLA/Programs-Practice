package com.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
 /*
  Here is an example of using java.nio.channels.FileChannel to read a file from a given location.
   Below are the nio classes that are getting used to accomplish reading of the file using 
   FileChannel of Java 7.

 com.nio.ByteBuffer – Used to read byte buffer from current position using get() method and increment the position.

com.nio.channels.FileChannel - For reading, mapping and manipulating a file.
  */
public class FileChannelExample {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile(
                    "D:\\SimpleNIOData.txt",
                    "r");
            FileChannel fileChannel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(24);
            int bytes = fileChannel.read(buffer);
            bytes = fileChannel.read(buffer);
            System.out.println("output"+bytes);
            while (bytes != -1) {
                buffer.flip();
                 while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
 
                buffer.clear();
                bytes = fileChannel.read(buffer);
 
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
 
    }
 
}
