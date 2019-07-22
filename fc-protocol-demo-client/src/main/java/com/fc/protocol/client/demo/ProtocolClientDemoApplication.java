package com.fc.protocol.client.demo;

import java.io.File;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fc.protocol.client.netty.FinalClientFactory;

@SpringBootApplication
@ComponentScan(basePackages = { "com.fc.protocol" })
public class ProtocolClientDemoApplication implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(ProtocolClientDemoApplication.class);

	@Autowired
	private FinalClientFactory finalClientFactory;

	//@Autowired
	//private ServiceDiscovery serviceDiscovery;

	public static void main(String[] args) {
		SpringApplication.run(ProtocolClientDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("客户端demo应用启动......启动参数：{}", Arrays.asList(args));
		log.info("当前工作目录:" + System.getProperty("user.dir"));
		String protocolClientConfigRootPath = System.getProperty("user.dir") + "/src/main/resources";//args[0];
		finalClientFactory.init(protocolClientConfigRootPath.replace("\\", File.separator));
		//ZooKeeper zk = serviceDiscovery.connectServer();
		//if (zk != null) {
		//	serviceDiscovery.watchNode(zk);
		//}
		/**
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(serviceDiscovery.discover());
				}
			}
		}).start();
		*/
	}

	/**	标准命令行方式 mvn spring-boot:run */

}
