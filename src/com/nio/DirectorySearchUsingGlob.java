package com.nio;


import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 /*
  written a program to traverse through 
  each and every file/directory for given root, matched pattern in our program.
  
Java 7 provides java.nio.file.Files class static method newDirectoryStream(). 
It takes glob as input parameter. This string is the pattern that we want to search in given directory.
Below is a code example, which searches “D:” drive for different patterns.

One can also use regular expressions as input to this method through glob input parameter.
   
   
  */
public class DirectorySearchUsingGlob {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        DirectorySearchUsingGlob dsg = new DirectorySearchUsingGlob();
        //starting with Dee
        dsg.searchDirectory("D:\\", "Des*");
 
        //containing ee
        dsg.searchDirectory("D:\\", "*Down*");
 
        //.txt, .doc, .pdf, .ppt files
        dsg.searchDirectory("D:\\", "*.{txt,doc,pdf,ppt}");
        dsg.searchDirectory("D:\\", "????");
 
    }
 
    public void searchDirectory(String directory, String pattern){
        DirectoryStream<Path> directoryStream = null;
        try{
            directoryStream = Files.newDirectoryStream(Paths
                    .get(directory), pattern);
            for(Path path : directoryStream){
 
                System.out.println("Files/Directories matching "+ pattern +": "+ path.toString());
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally{
            try{
                directoryStream.close();
            }catch(IOException ioe){
                //Do Nothing
            }
        }
 
    }
 
}