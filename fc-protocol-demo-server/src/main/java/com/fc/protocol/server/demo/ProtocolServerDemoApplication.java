package com.fc.protocol.server.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fc.protocol.server.IProtocolServer;
import com.fc.protocol.server.callback.IProtocolServerStartedCallback;

@SpringBootApplication
@ComponentScan(basePackages = { "com.fc.protocol" })
public class ProtocolServerDemoApplication implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(ProtocolServerDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProtocolServerDemoApplication.class, args);
	}

	@Autowired
	private IProtocolServer protocolServer;

	@Autowired
	private IProtocolServerStartedCallback registryServerNode;

	@Override
	public void run(String... args) throws Exception {
		log.info("服务端demo应用启动......");
		protocolServer.start(registryServerNode);//blocking
	}

	/**	标准命令行方式 mvn spring-boot:run */

}
