import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Server extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	JTextArea Mensaje;
	
	public Server() {
		Mensaje=new JTextArea();
		Mensaje.setBounds(10,10,400,400);
		add(Mensaje);
		
		setLayout(null);
		setTitle("Recíbelo");
		setSize(435,460);
		setVisible(true);
		
		Thread hilo = new Thread(this);
		hilo.start();
	}
	
	public static void main(String[] args) {
		new Server();
	}

	public void run() {
		try {
			@SuppressWarnings("resource")
			ServerSocket servidor = new ServerSocket(9998);
			Socket Cli;
			while(true) {
				Cli = servidor.accept();
				DataInputStream flujo = new DataInputStream(Cli.getInputStream());
				String Message = flujo.readUTF();
				Mensaje.append("\n"+Message);
				Cli.close();
				//if(Message.equalsIgnoreCase("Listo")) {
					//servidor.close();
					//break;
				//}
			}
		}catch (IOException E) {
		E.printStackTrace();
		}
	}
}
