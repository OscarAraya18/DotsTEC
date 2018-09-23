package Convert.Class;

import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Array.Class.Array;

public class Convert {
	static StringWriter out = new StringWriter();
	public static void main (String[] args) {
		Enco();
		Deco();
	}
	public static Object Enco() {
		Array arrayCode = new Array();
		JSONArray array = new JSONArray();
		array=arrayCode.arrayUsers();
		
		try {
			array.writeJSONString(out);
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(out);	
		return out;
	}
	@SuppressWarnings("unchecked")
	public static void Deco() {
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

