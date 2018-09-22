package Paste.Pack;

import org.json.simple.JSONArray;

import Asignation.Pack.Asignation;
/**
 * @author José Agustín Venegas
 * Se crea la clase que importa a la clase Asignation y crea un objeto de esta.
 * Se crea una instancia de la clase JSONArray, a la cual se le adiere una instancia de la clase asignation con su respectivo valor de código
 */
public class Paste {
	@SuppressWarnings("unchecked")
	public JSONArray arrayCode() {
		JSONArray Array = new JSONArray();
		Array.add(new Asignation(4567));
		return Array;
	}
}
