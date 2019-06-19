package io.lzg.websocketdemo.config;

import io.lzg.websocketdemo.component.TextSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        //addHandler()注册路径
        //不定长
        WebSocketHandlerRegistration webSocketHandlerRegistration = webSocketHandlerRegistry.addHandler(new TextSocketHandler(), "/user", "/user2", "/user3");
        //允许所有块
        webSocketHandlerRegistration.setAllowedOrigins("*");
    }
}
