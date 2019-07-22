package com.fc.protocol.client.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 协议客户端连接池配置
 * @author zhanjq
 *
 */
@Configuration
public class ProtocolClientGlobalConfig {

	@Bean
	public ProtocolClientPool protocolClientPool() {
		return new ProtocolClientPool();
	}

}
