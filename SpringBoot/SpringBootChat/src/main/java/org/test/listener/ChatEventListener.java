package org.test.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.test.domain.ChatMessage;

@Component
public class ChatEventListener {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@EventListener
	public void handleSocketConnectListener(SessionConnectedEvent event) {
		System.out.println("received a new web socket connection");
	}

	@EventListener
	public void handleSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		String userName = (String) headerAccessor.getSessionAttributes().get("username");
		if (userName != null) {
			ChatMessage chatMessage = new ChatMessage();
			chatMessage.setType("Leave");
			chatMessage.setSender(userName);
			messagingTemplate.convertAndSend("/topic/public", chatMessage);
		}
	}

}
