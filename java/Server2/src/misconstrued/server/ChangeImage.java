package misconstrued.server;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

import javax.imageio.ImageIO;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ibm.watson.developer_cloud.visual_recognition.v1.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v1.model.RecognizedImage;

public class ChangeImage {
	
//	public static void main(String[] args) {
//		ChangeImage change = new ChangeImage();
//		try {
//			URI pictureURI = new URI("file:/c:/Users/Rowan/Desktop/cat.jpg");
//			File img = new File(pictureURI);
//			Image likeACatButNotACat = change.convert(img);
//			saveImage(likeACatButNotACat);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private static void saveImage(Image img) {
//		try {
//			ImageIO.write((BufferedImage) img, "png", new File("LikeACatButNotACat.jpg"));
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public String convert(File image) {
		VisualRecognition service = new VisualRecognition();
		service.setUsernameAndPassword("6f0055ed-61a1-48c7-b0ee-567a657e8bd5", "N2A379yhZGei");

		RecognizedImage recognizedImage = service.recognize(image);
		
		String searchString = createSearchString(recognizedImage);
		
		return getImage(searchString);
	}
	
	private String createSearchString(RecognizedImage rec) {
		String json = rec.toString();
		JSONArray labels = (new JSONObject(json)).getJSONArray("labels");
		String searchString = "";
		for(int i = 0; i < 3 && i < labels.length(); i++) {
			String category = labels.getJSONObject(i).getString("label_name");
			searchString += category.replaceAll(" ", "%20");
			if(i != labels.length() - 1) {
				searchString += "%20";
			}
		}
		return searchString;
	}
	
	private String getImage(String search) {
		String json = "";
		try {
			BufferedReader page = 
					new BufferedReader(
							new InputStreamReader(
									new URL("http://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=" + search).openStream()));
			String line = page.readLine();

			while (line != null) {
				json += line;
				line = page.readLine(); 
			}

			page.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		boolean notFound = true;
		String imgUrl = "";
		Image image = null;
		int i = 0;
		
		while(notFound) {
			JSONObject obj = new JSONObject(json);
			try {
				imgUrl = obj.getJSONObject("responseData").getJSONArray("results").getJSONObject(i).getString("unescapedUrl");
			} catch(Exception e) {
				notFound = false;
			}
			
			try {
				URL url = new URL(imgUrl);
				image = ImageIO.read(url);
				return url.toString();
			} catch(Exception e) {
				i++;
			}
		}
		
		return null;
	}
}