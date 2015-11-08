package misconstrued.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.java_websocket.WebSocket;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Conversation {
	private static final Logger __logger = LoggerFactory.getLogger(Conversation.class);

	private List<Member> members;

	public Conversation() {
		members = new ArrayList<Member>();
	}

	public void addMember(Member member) {
		this.members.add(member);
	}

	/**
	 * Broadcast a message to all connected clients
	 * 
	 * @param message
	 */
	public void broadcast(String message) {
		__logger.info("Broadcasting message");

		// List containing what WS to remove
		List<Member> toRemove = new ArrayList<Member>();

		// Loop through and broadcast to all connected
		for (Member m : members) {
			__logger.info("Broadcasting to " + m.getName());

			try {
				m.getWS().send(message);
			} catch (WebsocketNotConnectedException e) {
				__logger.warn("WebSocket not connected - adding to remove list");
				toRemove.add(m);
			}
		}

		// Remove all the WS that we needed to
		for (Member m : toRemove) {
			members.remove(m);
		}
	}

	public boolean hasMember(Member m) {
		return members.contains(m);
	}

	@Override
	public String toString() {
		String rawJSON = "{\"members\": [";

		for (int i = 0; i < members.size(); i++) {
			rawJSON += members.get(i).toString() + ((i == members.size() - 1) ? "" : ", ");
		}

		rawJSON += "]}";

		return rawJSON;
	}
}
