package Code.Class;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;

import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

public class Code implements JSONStreamAware {
	private int Code;

	public Code(int Code) {
		this.Code = Code;
	}

	public int getCode() {
		return Code;
	}

	public void setCode(int Code) {
		this.Code = Code;
	}
	
	@SuppressWarnings("unchecked")
	public void writeJSONString (Writer Out) throws IOException {
		@SuppressWarnings("rawtypes")
		LinkedHashMap Obj = new LinkedHashMap();
		Obj.put("Code", Code);
	    JSONValue.writeJSONString(Obj, Out);
	}
	
}
