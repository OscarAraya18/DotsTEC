import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JTextField Mensaje;
	JButton Enviar;
	int Code=8956;
	
	public Client(){
		Mensaje=new JTextField();
		Mensaje.setBounds(10, 10, 200, 20);
		add(Mensaje);
		
		Enviar=new JButton();
		Enviar.setText("Envíalo");
		Enviar.setBounds(70, 40, 80, 20);
		Enviar.addActionListener(this);
		add(Enviar);
		
		setLayout(null);
		setSize(235,290);
		setVisible(true);  
	}
	
	
	public static void main(String[] args) {
		new Client();
	}

	public void actionPerformed(ActionEvent T) {
		if (T.getSource()==Enviar) {
			try {
				Socket Cli = new Socket("192.168.1.14",9998);//196.168.1.14 
				DataOutputStream flujo = new DataOutputStream(Cli.getOutputStream());
				flujo.writeUTF(Mensaje.getText());
				Cli.close();
			}catch(Exception T2) {
				System.out.println("Error en el cliente"+Mensaje.getText());
			}
		}
	}
}
