package misconstrued.server;


import org.json.JSONObject;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;

public class Translate {
	private static final String ENGLISH_CODE = "en";
	private static final String[] LANGUAGES = new String[] {"es", "ar", "fr", "es", "ar"};
	
	public static void main(String[] args) {
		Translate trans = new Translate();
		trans.translateMultiple("Haha chat delays you get me");
	}
	
	public Translate() {
	}
	
	/**
	 * Translate a single string multiple times
	 * @param msg
	 * @return
	 */
	public String translateMultiple(String msg) {
		String newMsg = msg;
		
		for(int i = 0; i < LANGUAGES.length; i++) {
			newMsg = translateSingle(newMsg, ENGLISH_CODE, LANGUAGES[i]);
			newMsg = translateSingle(newMsg, LANGUAGES[i], ENGLISH_CODE);
			
			System.out.println(newMsg);
		}
		
		return newMsg;
	}
	
	/**
	 * Translate a string to another language
	 * @param msg original text
	 * @param src source language
	 * @param tgt target language
	 * @return translated text
	 */
	private String translateSingle(String msg, String src, String tgt) {
		LanguageTranslation service = new LanguageTranslation();
		service.setUsernameAndPassword("6f0055ed-61a1-48c7-b0ee-567a657e8bd5", "N2A379yhZGei");

		String translationResult = service.translate(msg, src, tgt).toString();
		JSONObject json = new JSONObject(translationResult);
		
		return json.getJSONArray("translations").getJSONObject(0).getString("translation");
	}
}
