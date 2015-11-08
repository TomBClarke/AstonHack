package misconstrued.server;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class PictureMessage extends Message {

	public PictureMessage(String sender, String text) {
		super(sender);
		ChangeImage change = new ChangeImage();
		try {
			File image = getFile(text);
			this.text = change.convert(image);
			image.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private File getFile(String url) {
		String fileName = url.substring(url.lastIndexOf("/") + 1);
		try {
			URL link = new URL(url);

			InputStream in = new BufferedInputStream(link.openStream());
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int n = 0;
			while (-1 != (n = in.read(buf))) {
				out.write(buf, 0, n);
			}
			out.close();
			in.close();
			byte[] response = out.toByteArray();

			FileOutputStream fos = new FileOutputStream(fileName);
			fos.write(response);
			fos.close();
			
			return new File(url.substring(url.lastIndexOf("/") + 1));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String toString() {
		return "{\"image\": \"" + this.text + "\", \"sender\": \"" + this.sender + "\"}";
	}

}
