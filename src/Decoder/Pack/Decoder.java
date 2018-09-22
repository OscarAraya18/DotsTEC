package Decoder.Pack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Encoder.Pack.*;
/**
 * @author José Agustín Venegas
 * Se crea la clase para deserealizar JSON, la cual importa de la clase Server
 */
public class Decoder extends Encoder {
	/**
	 * @param args
	 * Se crea un Main que llama a la clase principal y a su método DOut(), y a su vez llama al método de la clase Encoder Obtencion()	 */
	public static void main (String[] args) {
		new Decoder();
		Obtencion();
		DOut();
	}
	@SuppressWarnings("unchecked")
	/**
	 * Se crea el método DOut que se encarga de deserealizar el código JSON obtenido en la clase Encoder
	 */
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
