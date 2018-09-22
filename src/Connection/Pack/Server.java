package Connection.Pack;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Jos� Agust�n Venegas
 * Se crea la clase servidor que Recibe el dato y lo interpreta
 */
public class Server implements Runnable{
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	public Server() {
		Thread hilo = new Thread(this);
		hilo.start();
	}
	/**
	 * @param args
	 * Se crea el constructor en el cual se crea un Thread para poder estar revisando si se obtuvo un valor mediante el puerto sin que el programa se pegue
	 */
	public static void main(String[] args) {
		new Server();
	}
	/**
	 * Se crea un main en el cual se llama la clase y su m�todo
	 */
	public void run() {
		try {
			System.out.println("Hola");
			@SuppressWarnings("resource")
			ServerSocket servidor = new ServerSocket(8997);
			Socket Cli;
			while(true) {
				Cli = servidor.accept();
				DataInputStream flujo = new DataInputStream(Cli.getInputStream());
				System.out.println(flujo.read());
				Cli.close();
			}
		}catch (IOException E) {
		E.printStackTrace();
		}
	}
	/**
	 * Se crea un m�todo void llamado "run" en el cual se abre el puerto en cuesti�n y espera a que le llegue informaci�n. 
	 */
}
