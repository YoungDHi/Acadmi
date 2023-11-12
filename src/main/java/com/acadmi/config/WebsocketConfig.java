package com.acadmi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import com.acadmi.webSocket.ChatWebSocketHandler;
import com.acadmi.webSocket.WebSocketHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer {
	
	@Autowired
	private ChatWebSocketHandler chatWebSocketHandler;
	
	@Autowired
	private WebSocketHandshakeInterceptor webSocketHandshakeInterceptor;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(chatWebSocketHandler, "/chat")
				.setAllowedOrigins("*")
				.addInterceptors(webSocketHandshakeInterceptor);
	}
	
	@Bean
	public ServletServerContainerFactoryBean containerFactoryBean() {
		ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
		container.setMaxTextMessageBufferSize(500000);
		container.setMaxBinaryMessageBufferSize(500000);
		return container;
	}
	
	

}
