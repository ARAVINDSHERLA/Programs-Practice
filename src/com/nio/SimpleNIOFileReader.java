package com.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
public class SimpleNIOFileReader {
 
    /**
     * @param args
     */
	/*
	It reads a file line from a given location. We are going to use following nio classes to achieve our goal in this Java nio file read example.

com.nio.file.Files – It exposes many static methods required to operate on files, directories, etc. We are going use this class to create data stream of the file and create a BufferedReader to read a line in this file.

com.nio.file.Path - In simple terms it represents a file object on file system.

com.nio.file.Paths – It exposes static methods to return Path object by taking String and URI format path.

In this example we have used nio classes mainly to locate a file and get a handle to read 
data from this file. Rest of the classes are from earlier Java io packages only. Instead of printing the exceptions, you can choose to handle those properly as per requirement of program.




	 */
    public static void main(String[] args) {
        Path file = null;
        BufferedReader bufferedReader = null;
        try {
            file = Paths
                    .get("D:\\SimpleNIOData.txt");
            InputStream inputStream = Files.newInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader(
                    inputStream));
            System.out.println("Reading Line: "
                    + bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
 
}