package com.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



/*
 I will read the content of file line by line and check if any line contains word "password" then print it.


Lokesh
Gupta
Never
store
password
except
in mind.
 */



public class ReadLineByLineUsingStreamsJava8Feature {

	
	/*
	 1) Normal IO operation till java 7

Normal IO operation till java 7 will look like this. There may be other effective 
and better variations of this code but that is not the man point of this post. I am giving just as reminder. 
	 */
	private static void readLinesUsingFileReader() throws IOException
	{
	    File file = new File("c:/temp/data.txt");
	    FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    while((line = br.readLine()) != null){
	        if(line.contains("password")){
	            System.out.println(line);
	        }
	    }
	    br.close();
	    fr.close();
	}
	
	/*
	 * 
	 2) Read file lazily as stream of lines

In this example, I will read the lines as stream and 
fetch each line one at a time and check it for word "password".
	private static void readStreamOfLinesUsingFiles() throws IOException
	{
	    Stream<String> lines = Files.lines(Paths.get("c:/temp", "data.txt"));
	    Optional<String> hasPassword = lines.filter(s -> s.contains("password")).findFirst();
	    if(hasPassword.isPresent()){
	        System.out.println(hasPassword.get());
	    }
	    //Close the stream and it's underlying file as well
	    lines.close();
	}*/
	/*
	 3) Read file as stream of lines with try-with-resources

Above example is already good enough for usage. But if you still want to make it further better 
then we can use try-with-resources which will eliminate the need of closing the stream. 
	private static void readStreamOfLinesUsingFilesWithTryBlock() throws IOException
	{
	    Path path = Paths.get("c:/temp", "data.txt");
	    //The stream hence file will also be closed here
	    try(Stream<String> lines = Files.lines(path)){
	        Optional<String> hasPassword = lines.filter(s -> s.contains("password")).findFirst();
	        if(hasPassword.isPresent()){
	            System.out.println(hasPassword.get());
	        }
	    }
	}*/
	
	/*
	 When a stream spawns another, close methods are also chained. Therefore you can also write:
	private static void readStreamOfLinesUsingFilesWithTryBlock1() throws IOException
	{
	    Path path = Paths.get("c:/temp", "data.txt");
	    //When filteredLines is closed, it closes underlying stream as well as underlying file.
	    try(Stream<String> filteredLines = Files.lines(path).filter(s -> s.contains("password"))){
	        Optional<String> hasPassword = filteredLines.findFirst();
	        if(hasPassword.isPresent()){
	            System.out.println(hasPassword.get());
	        }
	    }
	}*/
	/*If you want to test if the underlying file is closed or not, you can check it like this:
	private static void readStreamOfLinesUsingFilesWithTryBlock() throws IOException
	{
	    Path path = Paths.get("c:/temp", "data.txt");
	    //When filteredLines is closed, it closes underlying stream as well as underlying file.
	    try(Stream<String> filteredLines = Files.lines(path)
	                                    //test if file is closed or not
	                                    .onClose(() -> System.out.println("File closed"))
	                                    .filter(s -> s.contains("password"))){
	        Optional<String> hasPassword = filteredLines.findFirst();
	        if(hasPassword.isPresent()){
	            System.out.println(hasPassword.get());
	        }
	    }
	}*/
	 
	/*Output:
	 
	password
	File closed*/
	
	
	
}
