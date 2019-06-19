package io.lzg.websocketdemo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class TextSocketHandler extends TextWebSocketHandler{
    private Integer count = 0;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {
        logger.info("receive message : {}", message.getPayload());
        count++;

        session.sendMessage(new TextMessage("count:" + count));
    }
}
