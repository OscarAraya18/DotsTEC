package Encoder.Pack;

import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONArray;

import Convert.Pack.Convert;

public class Encoder {
	static StringWriter out = new StringWriter();
	public static final Object Envio = null;

	protected static StringWriter EOut;
	
	public static void main (String[] args) {
		new Encoder();
		Obtencion();
	}
	public static Object Obtencion() {
		Convert arrayCode = new Convert();
		JSONArray array = new JSONArray();
		array=arrayCode.arrayUsers();
		
		try {
			array.writeJSONString(out);
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(out);
		EOut=out;
		return out;
	}
}
