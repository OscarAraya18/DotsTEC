package Asignation.Pack;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;

import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

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

	@SuppressWarnings("unchecked")
	public void writeJSONString (Writer Out) throws IOException {
		@SuppressWarnings("rawtypes")
		LinkedHashMap Obj = new LinkedHashMap();
		Obj.put("Code", Code);
	    JSONValue.writeJSONString(Obj, Out);
	}
}
