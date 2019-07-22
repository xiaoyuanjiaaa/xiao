package com.fc.protocol.client.demo.utils;

import com.fc.protocol.demo.request.EchoRequest;

public class RequestUtil {

	public static EchoRequest mockEchoRequest(int number) {
		EchoRequest request = new EchoRequest();
		request.setNumber(number);
		request.setVersion("1.0");
		request.setTraceId("tid_" + number);
		request.setReqCode("demoEcho");
		return request;
	}

}
