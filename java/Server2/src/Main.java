import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Set;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class Main extends WebSocketServer {
	
	private HashMap<WebSocket, String> connections;
	
	public Main() throws UnknownHostException {
		super(new InetSocketAddress(3000));
		
		connections = new HashMap<WebSocket, String>();
	}

	@Override
	public void onClose(WebSocket ws, int code, String reason, boolean remote) {
		System.out.println("Close");
	}

	@Override
	public void onError(WebSocket ws, Exception e) {
		e.printStackTrace();
	}
	
	@Override
	public void onMessage(WebSocket ws, String message) {
		broadcast(message);
	}

	@Override
	public void onOpen(WebSocket ws, ClientHandshake chs) {
		connections.put(ws, "");
	}
	
	private void broadcast(String message) {
		Set<WebSocket> keySet = connections.keySet();
		
		for (WebSocket ws : keySet) {
			System.out.println("Broadcasting to " + ws);
			System.out.println("Name: " + connections.get(ws));
			ws.send(message);
		}
	}
	
	public static void main(String[] args) {
		try {
			Main m = new Main();
			m.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}

/*
 * 
 * */