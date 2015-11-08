package misconstrued.server;

import java.io.File;
import java.net.URL;

public class PictureMessage extends Message {

	public PictureMessage(String sender, String text) {
		super(sender);

		ChangeImage change = new ChangeImage();
		try {
			URL url = new URL(text);
			File image = new File(url.toURI());
			this.text = change.convert(image);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "{\"image\": \"" + this.text + "\", \"sender\": \"" + this.sender + "\"}";
	}
	
}
