package com.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.org.rapid_framework.generator.util.FileHelper;
import cn.org.rapid_framework.generator.util.FreemarkerHelper;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class ControllerMethodsGeneratorMain {
		public static void main(String[] args){
			String templateRootDir="D:\\job\\code\\workspace2\\disgenerator\\controllerg";
			String outputPath="d://outttt";
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
						System.out.println("__________"+templateFile);
						try {
							Template template = cfg.getTemplate(templateFile);
							//接口url
							String url="business/overview?sstore_id=98&type=0&time=2016-01-01|2016-01-02";
							String[] ss=url.split("[?]") ;
							String methodPath=ss[0];
							String methodName=methodPath.substring(methodPath.indexOf("/")+1, methodPath.length());
							List<Map<String,String>> paramList=new ArrayList<Map<String,String>>();
							String[] pp=ss[1].split("&");
							for(String p:pp){
								String name=p.substring(0, p.indexOf("="));
								Map par=new HashMap<String, String>();
								par.put("name", name);
								par.put("remark", "字段注释");
								paramList.add(par);
							}
							Map model = new HashMap();
							model.put("methodRemark", "方法注释");
							model.put("methodName", firstCharLowercase(methodName));
							model.put("paramList", paramList);
							model.put("methodPath", methodPath);
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
		
		public static String firstCharLowercase(String name){
	    	name = name.substring(0, 1).toLowerCase() + name.substring(1);
	        return  name;
	    }
}
