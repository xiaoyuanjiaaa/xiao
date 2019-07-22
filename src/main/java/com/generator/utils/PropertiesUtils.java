package com.generator.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * propertis操作类
 * 
 * @author Administrator
 * 
 */
public class PropertiesUtils {

	private static final Pattern PATTERN = Pattern.compile("\\$\\{([^\\}]+)\\}");
	/**
	 * 根据key读取value
	 * @param filePath
	 *            文件路径
	 * @param key
	 *            属性key值
	 * @return String 属性值
	 */
	public static String readValue(String filePath, String key)throws Exception {
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 增加属性文件值  
	 * @param key 属性key值
	 * @param value 属性value值
	 * @param filePath 文件路径
	 */
	public static void addProperties(String key[], String value[], String filePath)throws Exception {  
	       Properties iniFile = getProperties(filePath);  
	       FileOutputStream oFile = null;  
	       try {  
	           iniFile.put(key, value);  
	           oFile = new FileOutputStream(filePath, true);  
	           iniFile.store(oFile, "modify properties file");  
	       } catch (FileNotFoundException e) {  
	           e.printStackTrace();  
	       } catch (IOException e) {  
	           e.printStackTrace();  
	       } finally {  
	           try {  
	               if (oFile != null) {  
	                   oFile.close();  
	               }  
	           } catch (IOException e) {  
	               throw e;
	           }  
	       }  
	   }  
	 

	/**
	 * 读取配置文件
	 * @param filePath 文件路径
	 * @return properties 返回properties
	 */
	public static Properties getProperties(String filePath)throws Exception {  
	       Properties pro = null;  
	       FileInputStream in = null;  
	       try {  
	           in = new FileInputStream(filePath);  
	           pro = new Properties();  
	           pro.load(in);  
	       } catch (Exception e) {  
	           throw e;
	       } finally {  
	           try {  
	               if (in != null) {  
	                   in.close();  
	               }  
	           } catch (IOException ioe) {  
	               throw ioe;
	           }  
	       }  
	       return pro;  
	   }  
	 
	/**
	 * 保存属性到文件中  
	 * @param pro Properties
	 * @param filePath 文件路径
	 */
	public static void saveProperties(Properties pro, String filePath) throws Exception {  
	       if (pro == null) {  
	           return;  
	       }  
	       FileOutputStream oFile = null;  
	       try {  
	           oFile = new FileOutputStream(filePath, false);  
	           pro.store(oFile, "modify properties file");  
	       } catch (FileNotFoundException fe) {  
	           throw fe;
	       } catch (Exception e) {  
	           throw e;
	       } finally {  
	           try {  
	               if (oFile != null) {  
	                   oFile.close();  
	               }  
	           } catch (IOException ioe) {  
	               throw ioe;
	           }  
	       }  
	   }  
	
	    /**
	     * 修改属性文件
	     * @param key 属性key值
	     * @param value 属性value值
	     * @param filePath 文件路径
	     */
	    public static void updateProperties(String key, String value, String filePath) throws Exception{  
	        // key为空则返回  
	        if (key == null || "".equalsIgnoreCase(key)) {  
	            return;  
	        }  
	        Properties pro = getProperties(filePath);  
	        if (pro == null) {  
	            pro = new Properties();  
	        }  
	        pro.put(key, value);  
	        // 保存属性到文件中  
	        saveProperties(pro, filePath);  
	    }  
	    
	    /**
	     * 判断属性文件是否存在
	     * @param filePath 文件路径
	     * @return Boolean 是否存在
	     * @throws Exception
	     */
	    public static Boolean isPropertiesFileExists(String filePath) throws Exception{
	    	File f=new File(filePath);
	    	return f.exists();
	    }
	    
	    /**
	     * 获取使用属性值中含变量的值，如file=${root}/c
	     * @param properties 属性
	     * @param key key
	     * @return String 属性值
	     */
	    public static String getAndUnionVar(Properties properties, String key) {
	    	String value = properties.getProperty(key);
	    	Matcher matcher = PATTERN.matcher(value);
	    	StringBuffer buffer = new StringBuffer();
	    	while (matcher.find()) {
	    		String matcherKey = matcher.group(1);
	    		String matchervalue = properties.getProperty(matcherKey);
	    		if (matchervalue != null) {
	    			matcher.appendReplacement(buffer, matchervalue);
	    			}
	    		}
	    	matcher.appendTail(buffer);
	    	return buffer.toString();
	    }


}
