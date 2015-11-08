package misconstrued.server;


import org.json.JSONObject;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;

public class Translate {
	private String[] languages;
	
	public static void main(String[] args) {
		Translate trans = new Translate();
		trans.translate("");
	}
	
	public Translate() {
		languages = new String[]{
				"en",
				"es",
				"en",
				"ar",
				"en",
				"fr",
				"en",
				"es",
				"en",
				"ar",
				"en"
		};
	}
	
	public String translate(String msg) {
		String newMsg = msg;
		for(int i = 1; i < languages.length; i++) {
			newMsg = getNextMessage(newMsg, languages[i-1], languages[i]);
		}
		return newMsg;
	}
	
	public String getNextMessage(String msg, String src, String tgt) {
		String newMsg = getJSON(msg,src,tgt);
		System.out.println(newMsg);
		return newMsg;
	}
	
	public String getJSON(String msg, String src, String tgt) {
		LanguageTranslation service = new LanguageTranslation();
		service.setUsernameAndPassword("6f0055ed-61a1-48c7-b0ee-567a657e8bd5", "N2A379yhZGei");

		String translationResult = service.translate(msg, src, tgt).toString();
		JSONObject obj = new JSONObject(translationResult);
		
		return obj.getJSONArray("translations").getJSONObject(0).getString("translation");
	}
}
