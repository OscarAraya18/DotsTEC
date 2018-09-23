package BusinessLayer;

import org.json.simple.JSONArray;

import DataAccess.DA_User;

public class BL_User {
	public JSONArray arrayUsers() {
		DA_User da_Code = new DA_User();
		return da_Code.arrayUsers();
	}
}
