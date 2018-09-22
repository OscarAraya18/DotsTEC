package Decoder.Pack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Encoder.Pack.*;

public class Decoder extends Encoder {

	public static void main (String[] args) {
		new Decoder();
		Obtencion();
		DOut();
	}
	@SuppressWarnings("unchecked")
	public static void DOut() {
		JSONObject jsonCode = new JSONObject();
		jsonCode.put("Code", EOut);
		
		JSONParser code_parser = new JSONParser();
		try {
			JSONObject obj_Code = (JSONObject) code_parser.parse(jsonCode.toString());
			JSONArray array_Code = (JSONArray) obj_Code.get("Code");
			
			for(int i=0; i<array_Code.size();i++) {
				JSONObject user = (JSONObject) array_Code.get(i);
				String code = user.get("Code").toString();
				System.out.println(code);
			}
		}catch(org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
	}	
}
