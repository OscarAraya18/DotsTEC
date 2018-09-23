package App;

import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import BusinessLayer.BL_User;

public class Execute {
	@SuppressWarnings("unchecked")
	public static void main (String[] args) {
		BL_User bl_Code = new BL_User();
		JSONArray array = new JSONArray();
		array=bl_Code.arrayUsers();
		
		StringWriter out = new StringWriter();
		try {
			array.writeJSONString(out);
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(out);
		
		
		JSONObject jsonCode = new JSONObject();
		jsonCode.put("Code", out);
		
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
