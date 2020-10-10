package com.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Recursive Delete with FileVisitor in Java 7 nio
/*
 Java 7 nio package provides classes that make recursive operations on contents of a directory very easy.
 In previous versions, if we had to delete contents of directory, we would have written all logic, traversing,
 identifying if it is file or directory, and checking if directory is empty, on our own. Java 7 nio provides classes (which is FileVisitor in Java) that leave us
  to write only the actual operation to be done on the contents of directory.
 Traversing through contents is no more a programmer’s worry. Here is a FileVisitor Java example code explaining details of it.

Let us delete all contents of a directory by traversing through all child directories.
 We would use a special purpose class provided in nio,  SimpleFileVisitor. 
 It implements FileVisitor interface to provide simple implementation on visit of a file.
  We are creating a file visitor that deletes files/directories on visit. We call it DeletingFileVisitor.
It overrides methods to delete regular files, and directories (post visit to ensure those are empty).
 */
 /*
  Next we use this visitor class in a simple method of Files class “walkFileTree”,
 which walks through all nodes inside. While going through all nodes, it calls back methods on the visitor. 
  * 
  */
public class RecursiveDeleteUsingFileTree {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        Path directoryToDelete = Paths.get("D:\\");
        DeletingFileVisitor delFileVisitor = new DeletingFileVisitor();
        try{
            Files.walkFileTree(directoryToDelete, delFileVisitor);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
 
    }
 
}