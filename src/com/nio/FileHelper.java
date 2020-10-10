package com.nio;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
public class FileHelper {
 
  public static String getFilePathToSave() {
 
	Properties prop = new Properties();
	String filePath = "";
 
	try {
 
	  InputStream inputStream = 
	    FileHelper.class.getClassLoader().getResourceAsStream("app.properties");
 
	  prop.load(inputStream);
	  filePath = prop.getProperty("firstName");
 
	} catch (IOException e) {
		e.printStackTrace();
	}
 
	return filePath;
 
  }
  public static void main(String[] args)
  {
	  System.out.println(getFilePathToSave());
  }
 
}
