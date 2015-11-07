package misconstrued.server;

/**
 * Contains information about a message
 * 
 * @author misha
 *
 */
public class Message {
	/**
	 * The text and sender of the message
	 */
	private String text, sender;

	/**
	 * @param ws
	 *            Sender
	 * @param text
	 *            Text of message
	 */
	public Message(String sender, String text) {
		this.text = text;
		this.sender = sender;
	}

	@Override
	public String toString() {
		return "{\"text\": \"" + this.text + "\", \"sender\": \"" + this.sender + "\"}";
	}
}