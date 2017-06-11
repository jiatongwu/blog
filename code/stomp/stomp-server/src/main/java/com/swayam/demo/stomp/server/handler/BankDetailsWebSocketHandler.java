package com.swayam.demo.stomp.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.swayam.demo.stomp.server.dto.BankDetailSortOrder;
import com.swayam.demo.stomp.server.service.BankDetailService;

public class BankDetailsWebSocketHandler extends TextWebSocketHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(BankDetailsWebSocketHandler.class);

	private final BankDetailService bankDetailService;
	private final RequestType requestType;

	public BankDetailsWebSocketHandler(BankDetailService bankDetailService, RequestType requestType) {
		this.bankDetailService = bankDetailService;
		this.requestType = requestType;
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) {
		LOGGER.info("recieved message from client");
		BankDetailSortOrder group = BankDetailSortOrder.valueOf(message.getPayload().toUpperCase());
		bankDetailService.getBankDetailsAsync(group, new DataListenerForStompHandlerImpl(session, requestType));
	}

	public static enum RequestType {
		PLAIN_TEXT, GZIP;
	}

}
