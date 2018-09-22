package Encoder.Pack;

import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONArray;

import Convert.Pack.Convert;

/**
 * @author Jos� Agust�n Venegas
 * Esta clase importa de la clase convert y crea una instancia de �sta.
 */
public class Encoder {
	static StringWriter out = new StringWriter();
	public static final Object Envio = null;
	/**
	 * @param out, es una instancia de la clase de la librer�a StringWriter
	 */
	protected static StringWriter EOut;
	/**
	 * 
	 * @param EOut, objecto StringWriter en el cual se almacenar� el valor de out 
	 */
	public static void main (String[] args) {
		new Encoder();
		Obtencion();
	}
	/**
	 * Se crea la clase que serializa el c�digo en formato JSON
	 * @return out, para ser utilizado posteriormente en su deserealizaci�n
	 */
	public static Object Obtencion() {
		Convert arrayCode = new Convert();
		JSONArray array = new JSONArray();
		array=arrayCode.arrayCode();
		
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
