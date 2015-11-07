package misconstrued.server;

import org.java_websocket.WebSocket;

public class Member {
	final private WebSocket ws;
	
	private String name;
	
	public Member(WebSocket ws) {
		this.ws = ws;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public WebSocket getWS() {
		return ws;
	}
	
	@Override
	public String toString() {
		return "{\"name\": \"" + this.name + "\"}";
	}
}
