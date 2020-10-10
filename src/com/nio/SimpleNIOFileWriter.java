package com.nio;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
/*
 Here is a code example of creating a new file using Java’s new IO i.e. nio package. It creates a file and writes one line to the file. We are going to use following nio classes to achieve our goal.

com.nio.charset.Charset – It defines file encoding, we are using UTF-8 character encoding in this example.

com.nio.file.Files – It exposes many static methods required to operate on files, directories, etc. We are going use this class to create a file and create a BufferedWritter to write in this file.

com.nio.file.Path - In simple terms it represents a file object on file system.

com.nio.file.Paths – It exposes static methods to return Path object by taking String and URI format path.

Write file With Java nio:

Note:
Along with classes of nio package to get handle of file, we are using Charset class with UTF-8 encoding. This class is used to define encoding of the file in which we want to write the file.
In this example we are focusing on writing to the file, we are not taking care of exceptions properly. You may want to use appropriate exception handling as per requirement.
Ensure the buffer writer is closed after the writing work is done.
 * 
 */





public class SimpleNIOFileWriter {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        Path file = null;
        BufferedWriter bufferedWriter  = null;
        try{
            file = Files.createFile(Paths.get(
             "D:\\SimpleNIOData.txt"));
 
            Charset charset = Charset.forName("UTF-8");
 
            String line = "I am writing using NIO.";
 
            bufferedWriter = Files.newBufferedWriter(file, charset);
            bufferedWriter.write(line, 0, line.length());
 
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                bufferedWriter.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
    }