package com.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
 
/*
 to check if a Path is mapping to a directory or a file, we need to use different method. 
 Below is a code example that checks if given location is a directory or file.

To check directory in Java 7:

We are going to use BasicFileAttributeView class
of Java 7 nio package. We can read BasicFileAttributes of given path using this class. 
Instead of this generic view class, one can also go for OS specific class e.g. DosFileAttributeView.
 */


public class DirectoryCheckUsingPath {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        Path file = null;
        try{
            file = Paths.get(
                    "D:\\RegularExpressions.java");
            BasicFileAttributeView basicfileAttribView = Files.getFileAttributeView(file, BasicFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
            BasicFileAttributes basicFileAttributes = basicfileAttribView.readAttributes();
            System.out.println("isDirectory "+ basicFileAttributes.isDirectory());
 
        }catch(IOException e){
            e.printStackTrace();
        }
    }
 
}
