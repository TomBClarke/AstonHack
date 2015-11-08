package misconstrued.server;

public class TextMessage extends Message {

	private static final Translate translate = new Translate();
	
	public TextMessage(String sender, String text) {
		super(sender);
		this.text = translate.translateMultiple(text);
	}

	@Override
	public String toString() {
		return "{\"text\": \"" + this.text + "\", \"sender\": \"" + this.sender + "\"}";
	}
}
