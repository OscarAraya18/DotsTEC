package Final;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Server extends JFrame implements Runnable {
	public static final long serialVersionUID = 1L;
	JTextArea Mensaje;
	LinkedList list1=new LinkedList();
	LinkedList listaFiguras=new LinkedList();
	
	public LinkedList getList() {
		return list1;}
	
	
	public Server() {
		Mensaje = new JTextArea();
		Mensaje.setBounds(10, 10, 400, 400);
		add(Mensaje);
		setLayout(null);
		setTitle("Recíbelo");
		setSize(435,460);
		setVisible(true);
		Thread hilo = new Thread(this);
		hilo.start();}
	
	
	public static void main(String[] args) {
		new Server();}

	
	public void run() {
		Socket ServerC1;
		BufferedReader EntradaC1;
		String MensajeC1;
		DataOutputStream SalidaC1;
		String RespuestaC = "0000";
		try {
			@SuppressWarnings("resource")
			ServerSocket ServidorC1 = new ServerSocket(8766);
			while(true) {
				ServerC1 = ServidorC1.accept();
				EntradaC1 = new BufferedReader(new InputStreamReader(ServerC1.getInputStream()));
				MensajeC1 = EntradaC1.readLine();
				String codigo="0000";
				
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
				if(MensajeC1.contains("A0A1")){
					codigo="A0A1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG1Q") {
							RespuestaC="FG1Q";
							listaFiguras.agregarDelante("FG1Q");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				
				if(MensajeC1.contains("A0B0")){
					codigo="A0B0";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG1Q") {
							RespuestaC="FG1Q";
							listaFiguras.agregarDelante("FG1Q");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("A0B1")){
					codigo="A0B1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1D";
					}else if(listaFiguras.revisarContencion("FG1Q")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("A1B0")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
					}
				}
				if(MensajeC1.contains("A1B1")){
					codigo="A1B1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG1Q") {
							RespuestaC="FG1Q";
							listaFiguras.agregarDelante("FG1Q");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG2S") {
							RespuestaC="FG2S";
							listaFiguras.agregarDelante("FG2S");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("A1B2")){
					codigo="A1B2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG2S")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("A2B1")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("A1A2")){
					codigo="A1A2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG2S") {
							RespuestaC="FG2S";
							listaFiguras.agregarDelante(RespuestaC);
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("A2B1")){
					codigo="A2B1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG2S")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("A1B2")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("A2B2")){
					codigo="A2B2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG2S") {
							RespuestaC="FG2S";
							listaFiguras.agregarDelante("FG2S");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG3") {
							RespuestaC="FG3";
							listaFiguras.agregarDelante("FG3");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("A2B3")){
					codigo="A2B3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG3")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("A3B2")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("A2A3")){
					codigo="A2A3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG3") {
							RespuestaC="FG3";
							listaFiguras.agregarDelante("FG3");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("A3B2")){
					codigo="A3B2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG3")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("A2B3")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("A3B3")){
					codigo="A3B3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG3") {
							RespuestaC="FG3";
							listaFiguras.agregarDelante("FG3");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG4") {
							RespuestaC="FG4";
							listaFiguras.agregarDelante("FG4");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("A3B4")){
					codigo="A3B4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG4")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("A4B3")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("A3A4")){
					codigo="A3A4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG4") {
							RespuestaC="FG4";
							listaFiguras.agregarDelante("FG4");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("A4B3")){
					codigo="A4B3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG4")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("A3B4")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("A4B4")){
					codigo="A4B4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG4") {
							RespuestaC="FG4";
							listaFiguras.agregarDelante("FG4");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				
				
			
				
				
				
				
				if(MensajeC1.contains("B0B1")){
					codigo="B0B1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG1Q") {
							RespuestaC="FG1Q";
							listaFiguras.agregarDelante("FG1Q");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG5") {
							RespuestaC="FG5";
							listaFiguras.agregarDelante("FG5");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("B0C1")){
					codigo="B0C1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG5")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("B1C0")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("B0C0")){
					codigo="B0C0";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG5") {
							RespuestaC="FG5";
							listaFiguras.agregarDelante("FG5");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("B1B2")){
					codigo="B1B2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG2S") {
							RespuestaC="FG2S";
							listaFiguras.agregarDelante("FG2S");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG6") {
							RespuestaC="FG6";
							listaFiguras.agregarDelante("FG6");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("B1C2")){
					codigo="B1C2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG6")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("B2C1")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("B1C1")){
					codigo="B1C1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG5") {
							RespuestaC="FG5";
							listaFiguras.agregarDelante("FG5");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG6") {
							RespuestaC="FG6";
							listaFiguras.agregarDelante("FG6");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("B1C0")){
					codigo="B1C0";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG5")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("B0C1")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("B2B3")){
					codigo="B2B3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG3") {
							RespuestaC="FG3";
							listaFiguras.agregarDelante("FG3");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG7") {
							RespuestaC="FG7";
							listaFiguras.agregarDelante("FG7");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("B2C3")){
					codigo="B2C3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG7")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("B3C2")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("B2C2")){
					codigo="B2C2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG6") {
							RespuestaC="FG6";
							listaFiguras.agregarDelante("FG6");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG7") {
							RespuestaC="FG7";
							listaFiguras.agregarDelante("FG7");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("B2C1")){
					codigo="B2C1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG6")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("B1C2")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("B3B4")){
					codigo="B3B4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG4") {
							RespuestaC="FG4";
							listaFiguras.agregarDelante("FG4");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG8") {
							RespuestaC="FG8";
							listaFiguras.agregarDelante("FG8");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("B3C4")){
					codigo="B3C4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG8")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("B4C3")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("B3C3")){
					codigo="B3C3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG7") {
							RespuestaC="FG7";
							listaFiguras.agregarDelante("FG7");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG8") {
							RespuestaC="FG8";
							listaFiguras.agregarDelante("FG8");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("B3C2")){
					codigo="B3C2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG7")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("B2C3")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("B4C3")){
					codigo="B4C3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG8")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("B3C4")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("B3C3")){
					codigo="B3C3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG8") {
							RespuestaC="FG8";
							listaFiguras.agregarDelante("FG8");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("C0C1")){
					codigo="C0C1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG5") {
							RespuestaC="FG5";
							listaFiguras.agregarDelante("FG5");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG9") {
							RespuestaC="FG9";
							listaFiguras.agregarDelante("FG9");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("C0D1")){
					codigo="C0D1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG9")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("C1D0")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("C0D0")){
					codigo="C0D0";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG9") {
							RespuestaC="FG9";
							listaFiguras.agregarDelante("FG9");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("C1C2")){
					codigo="C1C2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG6") {
							RespuestaC="FG6";
							listaFiguras.agregarDelante("FG6");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG10") {
							RespuestaC="FG10";
							listaFiguras.agregarDelante("FG10");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("C1D2")){
					codigo="C1D2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG10")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("C2D1")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("C1D1")){
					codigo="C1D1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG9") {
							RespuestaC="FG9";
							listaFiguras.agregarDelante("FG9");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG10") {
							RespuestaC="FG10";
							listaFiguras.agregarDelante("FG10");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("C1D0")){
					codigo="C1D0";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG9")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("C0D1")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("C2C3")){
					codigo="C2C3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG7") {
							RespuestaC="FG7";
							listaFiguras.agregarDelante("FG7");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG11") {
							RespuestaC="FG11";
							listaFiguras.agregarDelante("FG11");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("C2D3")){
					codigo="C2D3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG11")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("C3D2")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("C2D2")){
					codigo="C2D2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG10") {
							RespuestaC="FG10";
							listaFiguras.agregarDelante("FG10");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG11") {
							RespuestaC="FG11";
							listaFiguras.agregarDelante("FG11");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("C2D1")){
					codigo="C2D1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG10")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("C1D2")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("C3C4")){
					codigo="C3C4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG8") {
							RespuestaC="FG8";
							listaFiguras.agregarDelante("FG8");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG12") {
							RespuestaC="FG12";
							listaFiguras.agregarDelante("FG12");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("C3D4")){
					codigo="C3D4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG12")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("C4D3")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("C3D3")){
					codigo="C3D3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG11") {
							RespuestaC="FG11";
							listaFiguras.agregarDelante("FG11");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG12") {
							RespuestaC="FG12";
							listaFiguras.agregarDelante("FG12");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("C3D2")){
					codigo="C3D2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG11")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("C2D3")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("C4D3")){
					codigo="C4D3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG12")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("C3D4")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("C4D4")){
					codigo="C4D4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG12") {
							RespuestaC="FG12";
							listaFiguras.agregarDelante("FG12");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("D0D1")){
					codigo="D0D1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG9") {
							RespuestaC="FG9";
							listaFiguras.agregarDelante("FG9");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG13") {
							RespuestaC="FG13";
							listaFiguras.agregarDelante("FG13");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("D0E1")){
					codigo="D0E1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG13")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("D1E0")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("D0E0")){
					codigo="D0E0";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG13") {
							RespuestaC="FG13";
							listaFiguras.agregarDelante("FG13");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("D1D2")){
					codigo="D1D2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG10") {
							RespuestaC="FG10";
							listaFiguras.agregarDelante("FG10");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG14") {
							RespuestaC="FG14";
							listaFiguras.agregarDelante("FG14");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("D1E2")){
					codigo="D1E2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG14")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("D2E1")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("D1E1")){
					codigo="D1E1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG13") {
							RespuestaC="FG13";
							listaFiguras.agregarDelante("FG13");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG14") {
							RespuestaC="FG14";
							listaFiguras.agregarDelante("FG14");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("D1E0")){
					codigo="D1E0";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG13")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("D0E1")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("D2D3")){
					codigo="D2D3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG11") {
							RespuestaC="FG11";
							listaFiguras.agregarDelante("FG11");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG15") {
							RespuestaC="FG15";
							listaFiguras.agregarDelante("FG15");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("D2E3")){
					codigo="D2E3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG15")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("D3E2")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("D2E2")){
					codigo="D2E2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG14") {
							RespuestaC="FG14";
							listaFiguras.agregarDelante("FG14");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG15") {
							RespuestaC="FG15";
							listaFiguras.agregarDelante("FG15");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("D2E1")){
					codigo="D2E1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG14")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("D1E2")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("D3D4")){
					codigo="D3D4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG12") {
							RespuestaC="FG12";
							listaFiguras.agregarDelante("FG12");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG16") {
							RespuestaC="FG16";
							listaFiguras.agregarDelante("FG16");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("D3E4")){
					codigo="D3E4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG16")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("D4E3")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("D3E3")){
					codigo="D3E3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG15") {
							RespuestaC="FG15";
							listaFiguras.agregarDelante("FG15");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG16") {
							RespuestaC="FG16";
							listaFiguras.agregarDelante("FG16");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("D3E2")){
					codigo="D3E2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG15")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("D2E3")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("D4E3")){
					codigo="D4E3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG16")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("D3E4")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("D4E4")){
					codigo="D4E4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG16") {
							RespuestaC="FG16";
							listaFiguras.agregarDelante("FG16");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("E0E1")){
					codigo="E0E1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG13") {
							RespuestaC="FG13";
							listaFiguras.agregarDelante("FG13");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG17") {
							RespuestaC="FG17";
							listaFiguras.agregarDelante("FG17");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("E0F1")){
					codigo="E0F1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG17")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("E1F0")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("E0F0")){
					codigo="E0F0";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG17") {
							RespuestaC="FG17";
							listaFiguras.agregarDelante("FG17");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("E1E2")){
					codigo="E1E2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG14") {
							RespuestaC="FG14";
							listaFiguras.agregarDelante("FG14");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG18") {
							RespuestaC="FG18";
							listaFiguras.agregarDelante("FG18");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("E1F2")){
					codigo="E1F2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG18")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("E2F1")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("E1F1")){
					codigo="E1F1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG17") {
							RespuestaC="FG17";
							listaFiguras.agregarDelante("FG17");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG18") {
							RespuestaC="FG18";
							listaFiguras.agregarDelante("FG18");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("E1F0")){
					codigo="E1F0";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG17")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("E0F1")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("E2E3")){
					codigo="E2E3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG15") {
							RespuestaC="FG15";
							listaFiguras.agregarDelante("FG15");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG19") {
							RespuestaC="FG19";
							listaFiguras.agregarDelante("FG19");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("E2F3")){
					codigo="E2F3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG19")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("E3F2")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("E2F2")){
					codigo="E2F2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG18") {
							RespuestaC="FG18";
							listaFiguras.agregarDelante("FG18");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG19") {
							RespuestaC="FG19";
							listaFiguras.agregarDelante("FG19");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("E2F1")){
					codigo="E2F1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG18")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("E1F2")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("E3E4")){
					codigo="E3E4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG16") {
							RespuestaC="FG16";
							listaFiguras.agregarDelante("FG16");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG20") {
							RespuestaC="FG20";
							listaFiguras.agregarDelante("FG20");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("E3F4")){
					codigo="E3F4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG20")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("E4F3")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("E3F3")){
					codigo="E3F3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG19") {
							RespuestaC="FG19";
							listaFiguras.agregarDelante("FG19");
							list1.agregarDelante(codigo);
						}else if(list1.revisarFigura(codigo)=="FG20") {
							RespuestaC="FG20";
							listaFiguras.agregarDelante("FG20");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("E3F2")){
					codigo="E3F2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG19")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("E2F3")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("E4F3")){
					codigo="E4F3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else if(listaFiguras.revisarContencion("FG20")){
						RespuestaC="2N";
					}else if(list1.revisarContencion("E3F4")){
						RespuestaC="3W";
					}else{
						RespuestaC="0P";
						list1.agregarDelante(codigo);
						}
					}
				if(MensajeC1.contains("E4F4")){
					codigo="E4F4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG20") {
							RespuestaC="FG20";
							listaFiguras.agregarDelante("FG20");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("F0F1")){
					codigo="F0F1";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG17") {
							RespuestaC="FG17";
							listaFiguras.agregarDelante("FG17");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("F1F2")){
					codigo="F1F2";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG18") {
							RespuestaC="FG18";
							listaFiguras.agregarDelante("FG18");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("F2F3")){
					codigo="F2F3";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG19") {
							RespuestaC="FG19";
							listaFiguras.agregarDelante("FG19");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				if(MensajeC1.contains("F3F4")){
					codigo="F3F4";
					if (list1.revisarContencion(codigo)) {			
						RespuestaC="1Z";
					}else{
						if(list1.revisarFigura(codigo)=="FG20") {
							RespuestaC="FG20";
							listaFiguras.agregarDelante("FG20");
							list1.agregarDelante(codigo);
						}else{
							RespuestaC="0P";
							list1.agregarDelante(codigo);
						}
					}
				}
				
				
				
				
				
				
				
				SalidaC1 = new DataOutputStream(ServerC1.getOutputStream());
				SalidaC1.writeUTF(RespuestaC);
				Mensaje.append("\n"+MensajeC1);
				
				EntradaC1=null;
				MensajeC1=null;
				ServerC1.close();
				
				
			}
				
				
				
				
				
				
				
				
				
				
				
				
			}
		catch(IOException E) {
		E.printStackTrace();
		}
	}
}