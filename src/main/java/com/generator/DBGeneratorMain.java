package com.generator;

import cn.org.rapid_framework.generator.Generator;
import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.util.FreemarkerHelper;

public class DBGeneratorMain {

	/**
	 * 代码生成器入口
	 * 数据库配置：generator.properties
	 * 模板路径(可修改)：项目下的fc-template文件夹中
	 * 生成路径(可修改)：项目下的output文件夹中
	 * fc-template 模板包路径可以修改，按实际开发为准
	 */
	public static void main(String[] args) throws Exception {
		Generator ge = new Generator();

		System.out.println("当前工作目录:" + System.getProperty("user.dir"));
		ge.addTemplateRootDir(System.getProperty("user.dir") + "\\fc-template"); // 模板路径,项目下的fc-template文件夹中
		// com.fc.member.shop
		/*
		 * 文件生成路径 建议跟配置文件里导入的包名一致，这样有利过复制到项目中
		 * generator.properties
		 * <!-- 类导入包名 配置 -->
		 * <entry key="basepackage">com.fc.member.store.user</entry>
		 * TODO 注意修改生成文件路径
		 */
		ge.setOutRootDir("E:\\会员中心\\fc-member-server\\src\\main\\java\\com\\fc\\member\\wechatmaintain\\user"); // 生成路径,项目下的output文件夹中；也可以写绝对路径 如: D:\\outFile
		//ge.setOutRootDir("D:\\out");
		GeneratorFacade g = new GeneratorFacade();
		g.setGenerator(ge);

		/*g.deleteOutRootDir();// 删除生成器的输出目录
*/
		String[] test = new String[] { "wechat_maintain_sstore_user"};

		/*
		 * 通过数据库表生成文件,template为模板的根目录
		 * 多个表以数组的形式传入
		 * new String[] { "table_name1", "table_name2" }
		 */
		System.out.println("生成表：" + test);
		g.generateByTable(test); // 单个表
		//g.generateBySql("select * from pos_user as user");
		FreemarkerHelper f;

	}
}
