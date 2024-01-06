package ink.wanderer.yukiooim.handler;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.web.socket.*;

public class MessageHandler implements WebSocketHandler {
    private HttpSession httpSession;
    private Session session;
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        session.sendMessage(new TextMessage("Hello, world!"));
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
