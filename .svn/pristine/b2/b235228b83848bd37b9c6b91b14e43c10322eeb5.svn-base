package com.generator;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.org.rapid_framework.generator.util.FileHelper;
import cn.org.rapid_framework.generator.util.FreemarkerHelper;

import com.generator.utils.PropertiesUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HttpGenerator {

	private static Log log = LogFactory.getLog(HttpGenerator.class);

	private String propertiesPath;

	private String outputPath;

	private String outputPathName;

	private String templateRootDir;
	
	private String basepackage;

	/**
	 * @return the basepackage
	 */
	public String getBasepackage() {
		return basepackage;
	}

	/**
	 * @param basepackage the basepackage to set
	 */
	public void setBasepackage(String basepackage) {
		this.basepackage = basepackage;
	}

	private Map<String, String> mp= new HashMap<String, String>();

	/**
	 * @return the templateRootDir
	 */
	public String getTemplateRootDir() {
		return templateRootDir;
	}

	/**
	 * @param templateRootDir
	 *            the templateRootDir to set
	 */
	public void setTemplateRootDir(String templateRootDir) {
		this.templateRootDir = templateRootDir;
	}

	/**
	 * @return the outRootDir
	 */
	public String getOutRootDir() {
		return outRootDir;
	}

	/**
	 * @param outRootDir
	 *            the outRootDir to set
	 */
	public void setOutRootDir(String outRootDir) {
		this.outRootDir = outRootDir;
	}

	private String outRootDir;

	/**
	 * @return the outputPathName
	 */
	public String getOutputPathName() {
		return outputPathName;
	}

	/**
	 * @param outputPathName
	 *            the outputPathName to set
	 */
	public void setOutputPathName(String outputPathName) {
		this.outputPathName = outputPathName;
	}

	/**
	 * @return the propertiesPath
	 */
	public String getPropertiesPath() {
		return propertiesPath;
	}

	/**
	 * @param propertiesPath
	 *            the propertiesPath to set
	 */
	public void setPropertiesPath(String propertiesPath) {
		this.propertiesPath = propertiesPath;
	}

	/**
	 * @return the outputPath
	 */
	public String getOutputPath() {
		return outputPath;
	}

	/**
	 * @param outputPath
	 *            the outputPath to set
	 */
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public void generatorProperties(String... urls) {
		for (int i = 0; i < urls.length; i++) {
			try {
				String url = urls[i];
				if (url == null || url.trim().equals("")) {
					log.error("没有url");
					continue;
				}
				String[] urlArr = url.split("/");
				String propertiesName = null;
				String modulName = null;
				if (urlArr.length > 0) {
					for (int ix = urlArr.length-1; ix >= 0; ix--) {
						if (urlArr[ix].contains("?")) {
							continue;
						} else {
							propertiesName = urlArr[ix];
							modulName = urlArr[ix - 1];
							break;
						}
					}
					//String token_from="${mall.from}";
					//拆分url
					String url_branch=url.substring(url.lastIndexOf(".php")+4,url.length());
					String host=url.substring(0,url.lastIndexOf(".php")+4);
					String hostName=host.substring(host.lastIndexOf("/")+1,host.lastIndexOf(".php")+4);
					//插入host
                    if (!PropertiesUtils.isPropertiesFileExists(propertiesPath)) {
						// 新建properties
						Properties pro = new Properties();
						pro.setProperty(hostName + ".host" , host+"/");
						PropertiesUtils.saveProperties(pro, propertiesPath);
					} else {
						Properties pro = PropertiesUtils.getProperties(propertiesPath);
						if (pro.containsKey(hostName + ".host")) {
							log.error("有重复属性，需手工添加方法:" + hostName + ".host");
						} else {
							pro.setProperty(hostName + ".host" , host+"/");
							PropertiesUtils.saveProperties(pro, propertiesPath);
						}
						
					}
                    //插入模块
					if (!PropertiesUtils.isPropertiesFileExists(propertiesPath)) {
						// 新建properties
						Properties pro = new Properties();
						pro.setProperty(modulName + "." + propertiesName, "${"+hostName + ".host"+"}"+url_branch+"?from=pos");
						PropertiesUtils.saveProperties(pro, propertiesPath);
						String methods = mp.get(modulName);
						if (methods == null) {
							mp.put(modulName, propertiesName);
						} else {
							mp.put(modulName, methods + "," + propertiesName);
						}
					} else {
						Properties pro = PropertiesUtils.getProperties(propertiesPath);
						
						if (pro.containsKey(modulName + "." + propertiesName)) {
							log.error("有重复属性，需手工添加方法:" + propertiesName);
						} else {
							pro.put(modulName + "." + propertiesName, "${"+hostName + ".host"+"}"+url_branch+"?from=pos");
							PropertiesUtils.saveProperties(pro, propertiesPath);
							
						}
						String methods = mp.get(modulName);
						if (methods == null) {
							mp.put(modulName, propertiesName);
						} else {
							mp.put(modulName, methods + ","
									+ propertiesName);
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void generate() {
		if (templateRootDir == null
				|| templateRootDir.trim().equalsIgnoreCase("")) {
			log.error("没有模板目录");
			return;
		}
		if (outputPath == null || outputPath.trim().equalsIgnoreCase("")) {
			log.error("没有java文件输出目录");
			return;
		}

		// 处理module和方法
		Iterator<String> it = mp.keySet().iterator();
		while (it.hasNext()) {
			String module = it.next();
			HttpModuleHeader mh = new HttpModuleHeader();
			mh.setModule(module);
			String[] ps = mp.get(module).split(",");
			if (ps != null) {
				for (int i = 0; i < ps.length; i++) {
					if (ps[i].endsWith("_list")) {
						MethodData d=new MethodData();
						d.setClassName(firstCharLowercase(getClassName(ps[i])));
						d.setMethod(ps[i]);
						d.setProperties(module + "." + ps[i]);
						mh.getPropertiesEndList().add(d);
					} else {
						MethodData d=new MethodData();
						d.setClassName(firstCharLowercase(getClassName(ps[i])));
						d.setMethod(ps[i]);
						d.setProperties(module + "." + ps[i]);
						mh.getPropertiesNoList().add(d);
					}
				}
			}
			generateWithModel(mh);
		}
	}

	public void generateWithModel(HttpModuleHeader mh) {
		try {
			if (templateRootDir != null
					|| !templateRootDir.trim().equalsIgnoreCase("")) {
				Configuration cfg = new Configuration();
				cfg.setDirectoryForTemplateLoading(new File(templateRootDir));
				List<File> srcFiles = FileHelper
						.searchAllNotIgnoreFile(new File(templateRootDir));
				List<Exception> exceptions = new ArrayList();
				for (int i = 0; i < srcFiles.size(); i++) {
					String templateFile = FileHelper.getRelativePath(new File(
							templateRootDir), srcFiles.get(i));
					try {
						Template template = cfg.getTemplate(templateFile);
						Map model = new HashMap();
						model.put("className", getClassName(mh.getModule()));
						model.put("classNameLowerCase", getClassName(mh.getModule()).toLowerCase());
						model.put("classNameFirstLower", firstCharLowercase(getClassName(mh.getModule())));
						model.put("basepackage", basepackage);
						model.put("propertiesEndList", mh.getPropertiesEndList());
						model.put("propertiesNoList", mh.getPropertiesNoList());
						String outputFile = FreemarkerHelper
								.processTemplateString(outputPath+"/"+templateFile, model,
										new Configuration());
						FileHelper.parentMkdir(outputFile);
						FreemarkerHelper.processTemplate(template, model,
								new File(outputFile), "utf-8");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String firstCharUpercase(String name){
    	name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return  name;
    }
	
	public static String firstCharLowercase(String name){
    	name = name.substring(0, 1).toLowerCase() + name.substring(1);
        return  name;
    }
	
	public static String getClassName(String name){
    	String [] tableNameArrs=name.split("_");
    	String result="";
    	for(String n:tableNameArrs){
    		result=result+firstCharUpercase(n);
    	}
    	return result;
    }
}
