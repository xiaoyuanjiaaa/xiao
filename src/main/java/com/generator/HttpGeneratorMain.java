package com.generator;

import java.util.Properties;

import com.generator.utils.PropertiesUtils;


public class HttpGeneratorMain {
	
	public static void main(String[] args){
//		try {
//			Configuration cfg=new Configuration();
//			cfg.setDirectoryForTemplateLoading(new File("D:\\job\\code\\workspace1\\disgenerator\\template"));
//			List<File> srcFiles = FileHelper.searchAllNotIgnoreFile(new File("D:\\job\\code\\workspace1\\disgenerator\\template"));
//			for(int i = 0; i < srcFiles.size(); i++) {
//				String templateFile = FileHelper.getRelativePath(new File("D:\\job\\code\\workspace1\\disgenerator\\template"), srcFiles.get(i));
//				System.out.println("****"+templateFile);
//				//System.out.println(cfg.getTemplate(templateFile));
//				try {
//					cfg.getTemplate(templateFile);
//					System.out.println(cfg.getTemplate(templateFile));
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		HttpGenerator ge=new HttpGenerator();
		ge.setPropertiesPath("D:\\job\\code\\workspace6\\fc-pos\\src\\main\\resources/api.properties");
		ge.generatorProperties("http://192.168.1.206/fengche/oabs.php/CashRegister/get_sstore_info/","http://192.168.1.206/fengche/oabs.php/CashRegister/get_order_by_phone/","http://192.168.1.206/fengche/oabs.php/CashRegister/save_sstore_goods/","http://192.168.1.206/fengche/oabs.php/CashRegister/get_sstore_goods_list/","http://192.168.1.206/fengche/oabs.php/CashRegister/get_sstore_worker/","http://192.168.1.206/fengche/oabs.php/CashRegister/service_list/","http://192.168.1.206/fengche/oabs.php/CashRegister/get_gcategories/","http://192.168.1.206/fengche/oabs.php/CashRegister/get_business_situation/","http://192.168.1.206/fengche/oabs.php/CashRegister/get_income_statistics/");
//	    try {
//			Properties p=PropertiesUtils.getProperties("d://test/test.properties");
//			System.out.println(PropertiesUtils.getAndUnionVar(p, "notification.update_inside_letter"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ge.setTemplateRootDir("D:\\job\\code\\workspace2\\disgenerator\\httptemplate");
		ge.setOutputPath("D:\\job\\code\\workspace6\\fc-pos\\src\\main\\java\\com\\fc\\pos");
		ge.setBasepackage("com.fc.pos");
		ge.generate();
		
	}

}
