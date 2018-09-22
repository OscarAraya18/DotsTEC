package Paste.Pack;

import org.json.simple.JSONArray;

import Asignation.Pack.Asignation;
/**
 * @author José Agustín Venegas
 * Se crea la clase que importa a la clase Asignation
 */
public class Paste {
	@SuppressWarnings("unchecked")
	public JSONArray arrayUsers() {
		JSONArray Array = new JSONArray();
		Array.add(new Asignation(4567));
		return Array;
	}
}
