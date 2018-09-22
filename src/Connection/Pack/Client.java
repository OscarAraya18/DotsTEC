package Connection.Pack;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

//import Encoder.Pack.*;
/**
 * @author Jos� Agust�n Venegas
 * Se crea la clase cliente que se encargar� de enviar mediante socket un valor de c�digo
 */
public class Client {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	static int Code;
	/**
	 * @param code, Almacena el valor de c�digo, y lo env�a
	 */
	public Client(int code) {
		super();
		Code = code;
	}
	/**
	 * Se crea un constructor para asignar un valor al atributo Code
	 */
	public static void Socket() {
		try {
			Socket Cli = new Socket("196.168.1.14 ",8997);
			DataOutputStream flujo = new DataOutputStream(Cli.getOutputStream());
			flujo.write(Code);
			Cli.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 * Se crea la clase Socket que importa de esta librer�a y mediante un ip y puerto de computador espec�fico, env�a el valor del atributo Code
	 */
	public static void main(String[] args) {
		new Client(12);
		Socket();
	}
	/**
	 * Se crea un main que llama a la clase cliente y a su m�todo Socket()
	 */
}


