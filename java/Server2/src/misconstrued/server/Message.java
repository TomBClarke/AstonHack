package misconstrued.server;

/**
 * Contains information about a message
 * 
 * @author Misha
 *
 */
public abstract class Message {
	
	protected String text, sender;

	public Message(String sender) {
		this.sender = sender;
	}
	
	public static Message getMessageFromString(String sender, String text) {
		if (text.indexOf("http") == 0) {
			return new PictureMessage(sender, text);
		} else {
			return new TextMessage(sender, text);
		}
	}
}