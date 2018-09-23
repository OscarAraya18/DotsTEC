package DataAccess;

import org.json.simple.JSONArray;
import EntityLayer.User;

public class DA_User {
	@SuppressWarnings("unchecked")
	public JSONArray arrayUsers() {
		JSONArray array = new JSONArray();
		array.add(new User(1234));
		return array;
	}
}
