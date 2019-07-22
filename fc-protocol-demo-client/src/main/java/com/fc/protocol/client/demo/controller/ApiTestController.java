package com.fc.protocol.client.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fc.protocol.client.IProtocolClient;
import com.fc.protocol.client.demo.config.ProtocolClientPool;
import com.fc.protocol.client.demo.utils.RequestUtil;
import com.fc.protocol.common.message.body.ProtocolResponse;
import com.fc.protocol.common.utils.IntegerFactory;
import com.fc.protocol.demo.request.EchoRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "ApiTestController", description = "API测试控制器")
@RestController
@RequestMapping("/api/test")
public class ApiTestController {

	private static Logger log = LoggerFactory.getLogger(ApiTestController.class);

	@Autowired
	private ProtocolClientPool protocolClientPool;

	/**
	 * echo测试
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/echo", method = { RequestMethod.POST, RequestMethod.GET })
	@ApiOperation(value = "echo", notes = "echo")
	@ResponseBody
	public Object echo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EchoRequest echoRequest = RequestUtil.mockEchoRequest(IntegerFactory.getInstance().incrementAndGet());
		log.info("echo-request:{}", echoRequest);
		log.info("protocolClientPool==null?===>{}", (protocolClientPool == null));
		IProtocolClient userClient = protocolClientPool.userClient();
		log.info("userClient==null?===>{}", (userClient == null));
		ProtocolResponse echoResponse = protocolClientPool.userClient().sendAndReceived(echoRequest);
		log.info("echo-response:{}", echoResponse);
		return echoResponse;
	}

}
