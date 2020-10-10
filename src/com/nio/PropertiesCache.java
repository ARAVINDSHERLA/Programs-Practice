package com.nio;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
 
public class PropertiesCache
{
   private final Properties configProp = new Properties();
    
   private PropertiesCache()
   {
      //Private constructor to restrict new instances
      InputStream in = this.getClass().getClassLoader().getResourceAsStream("D:\\app.properties");
	  // InputStream in = Class.getResourceAsStream("D:\\app.properties");
      System.out.println("Read all properties from file");
      try {
    	  if(in==null)
    		  System.out.println("in the null");
          configProp.load(in);
      } catch (IOException e) {
          e.printStackTrace();
      }
   }
 
   //Bill Pugh Solution for singleton pattern
   private static class LazyHolder
   {
     private  static final PropertiesCache INSTANCE = new PropertiesCache();
   }
 
   public static PropertiesCache getInstance()
   {
      return LazyHolder.INSTANCE;
   }
    
   public String getProperty(String key){
      return configProp.getProperty(key);
   }
    
   public Set<String> getAllPropertyNames(){
      return configProp.stringPropertyNames();
   }
    
   public boolean containsKey(String key){
      return configProp.containsKey(key);
   }
   public void setProperty(String key, String value){
	   configProp.setProperty(key, value);
	 }
   public static void main(String[] args)
   {
     //Get individual properties
     System.out.println(PropertiesCache.getInstance().getProperty("firstName"));
     System.out.println(PropertiesCache.getInstance().getProperty("lastName"));
      
     //All property names
     System.out.println(PropertiesCache.getInstance().getAllPropertyNames());
     
     PropertiesCache cache = PropertiesCache.getInstance();
     if(cache.containsKey("country") == false){
      cache.setProperty("country", "INDIA");
     }
     //Verify property
     System.out.println(cache.getProperty("country")); 
   }
}