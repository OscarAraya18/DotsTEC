package Asignation.Pack;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;

import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

/**
 * @author José Agustín Venegas
 * Se crea la clase que declara el atributo para el código junto con sus métodos get y set.
 * Se crea un constructor
 */

public class Asignation implements JSONStreamAware {
	private int Code ;

	public Asignation(int Code) {
		this.Code=Code;
	}

	public void setCode(int code) {
		Code = code;
	}
	
	public int getCode() {
		return Code;
	}
	/**
	 * Se crea una instancia de la librería LinkedHashMap y se le adieren el string "Code" y su valor respectivo.
	 */
	@SuppressWarnings("unchecked")
	public void writeJSONString (Writer Out) throws IOException {
		@SuppressWarnings("rawtypes")
		LinkedHashMap Obj = new LinkedHashMap();
		Obj.put("Code", Code);
	    JSONValue.writeJSONString(Obj, Out);
	}
}
