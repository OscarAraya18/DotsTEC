package EntityLayer;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;

import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

public class User implements JSONStreamAware {
	private int code;

	public User(int code) {
		super();
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	@SuppressWarnings("unchecked")
	public void writeJSONString (Writer out) throws IOException {
		@SuppressWarnings("rawtypes")
		LinkedHashMap obj = new LinkedHashMap();
		obj.put("Code", code);
	    JSONValue.writeJSONString(obj, out);
	}
	
}
