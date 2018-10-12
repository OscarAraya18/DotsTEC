package cliente;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.Socket;

public class Clientex extends JFrame implements ActionListener{
	
	/**
	 * Se crean atributos necesarios para los distintos métodos
	 */
	
	String recibido="0000";
	static String alm="0000";
	LinkedList list=new LinkedList();
	LinkedList listaFiguras=new LinkedList();
	ArrayList<Point> lista = new ArrayList<Point>();
	JButton Enviar = new JButton();
	int puntaje1 = 0;
	int puntaje2 = 0;
	String jugador1="";
	String jugador2="";
	String ipServer="";
	int turno = 1;
	
	
	public static void main(String[] args) {
		Clientex matriz=new Clientex();
		matriz.setVisible(true);}
	/**
	 * Se crea el constructor de la clase cliente
	 */
	
	public Clientex() {
		setTitle("TEC Dots"); 
		setSize(500,700);
		Matriz_puntos puntos=new Matriz_puntos();
		initComponents();
		add(Enviar);
		add(puntos);
		Enviar.setBounds(10, 10, 150, 60);
		Enviar.addActionListener(this);
		Enviar.setText("Enviar");
		Enviar.setVisible(false);
		JOptionPane.showMessageDialog(null, "Bienvenido a DOTS, coloque los datos requeridos para iniciar su partida", "Inicio", 3);
		this.jugador2=JOptionPane.showInputDialog("Introduce el nombre del jugador 1: ");
		this.jugador1=JOptionPane.showInputDialog("Introduce el nombre del jugador 2: ");
		this.ipServer=JOptionPane.showInputDialog("Introduce la dirección IP del servidor: ");
		}
	
	/**
	 * Se crea el método que verifica si se presionó el mouse
	 */
	public void mousePressed(java.awt.event.MouseEvent evt) {
        formMousePressed(evt);}
	
	/**
	 * @param evt
	 * Método que toma posicion del mouse al hacer click
	 */
	private void formMousePressed(java.awt.event.MouseEvent evt) {
	    lista.add(new Point(evt.getX(), evt.getY()));
	
	    if(lista.size()>1){
	    	int puntoX1 = lista.get(lista.size()-2).x;
	    	int puntoY1 = lista.get(lista.size()-2).y;
	    	int puntoX2 = lista.get(lista.size()-1).x;
	    	int puntoY2 = lista.get(lista.size()-1).y;
	    	
	    	if(puntoX1>=35 && puntoX1<=50 && puntoY1>110 && puntoY1<=125) {
	    		if(puntoX2>=135 && puntoX2<=150 && puntoY2>110 && puntoY2<=125) {
	    			lista.clear();
	    			alm="A0A1";
	    			Enviar.doClick();    			
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=210 && puntoY2<=225){
	    			lista.clear();
	    			alm="A0B1";
	 	    		Enviar.doClick(); 	    		
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear();
	    			alm="A0B0";
		 	    	Enviar.doClick();
	    		}
	    	}    	 	 
	    	else if(puntoX1>=135 && puntoX1<=150 && puntoY1>110 && puntoY1<=125) {
	    		if(puntoX2>=35 && puntoX2<=50 && puntoY2>110 && puntoY2<=125) {
	    			lista.clear();
	    			alm="A0A1";
		 	    	Enviar.doClick(); 	    			
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=210 && puntoY2<=225){
	    			lista.clear();
	    			alm="A1B0";
		 	    	Enviar.doClick();	    				
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear();
	    			alm="A1B1";
		 	    	Enviar.doClick(); 	   
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=110 && puntoY2<=125) {
	    			lista.clear();
	    			alm="A1A2";
		 	    	Enviar.doClick();		   
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear();
	    			alm="A1B2";
			 	    Enviar.doClick();
	    		}
	    	}	   	 
	    	else if(puntoX1>=235 && puntoX1<=250 && puntoY1>=110 && puntoY1<=125) {
	    		if(puntoX2>=135 && puntoX2<=150 && puntoY2>110 && puntoY2<=125) {
	    			lista.clear();
	    			alm="A1A2";
				 	Enviar.doClick();	    
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>110 && puntoY2<=125) {
	    			lista.clear();
	    			alm="A2A3";
					Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>210 && puntoY2<=225) {
	    			lista.clear();
	    			alm="A2B3";
					Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>210 && puntoY2<=225) {
	    			lista.clear();
	    			alm="A2B2";
					Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>210 && puntoY2<=225) {
	    			lista.clear();
	    			alm="A2B1";
					Enviar.doClick();
	    		}
	    	}	    	 
	    	else if(puntoX1>=335 && puntoX1<=350 && puntoY1>=110 && puntoY1<=125) {
	    		if(puntoX2>=235 && puntoX2<=250 && puntoY2>110 && puntoY2<=125) {
	    			lista.clear();
	    			alm="A2A3";
	    			Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>210 && puntoY2<=225) {
	    			lista.clear();
	    			alm="A3B2";
					Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>210 && puntoY2<=225) {
	    			lista.clear();
	    			alm="A3B3";
					Enviar.doClick();
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>110 && puntoY2<=125) {
	    			lista.clear(); 
	    			alm="A3A4";
					Enviar.doClick();				
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>210 && puntoY2<=225) {
	    			lista.clear(); 
		    		alm="A3B4";
					Enviar.doClick();
	    		}
	    	}	    	
	    	else if(puntoX1>=435 && puntoX1<=450 && puntoY1>110 && puntoY1<=125) {
	    	 	if(puntoX2>=335 && puntoX2<=350 && puntoY2>110 && puntoY2<=125) {
	    	 		lista.clear(); 
		    		alm="A3A4";
					Enviar.doClick();    		
	    	 	}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=210 && puntoY2<=225){
	    	 		lista.clear(); 
		    		alm="A4B3";
					Enviar.doClick();
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear(); 
		    		alm="A4B4";
					Enviar.doClick();
	    		}
	    	}    	
	    	else if(puntoX1>=35 && puntoX1<=50 && puntoY1>210 && puntoY1<=225) {
	    		if(puntoX2>=35 && puntoX2<=50 && puntoY2>110 && puntoY2<=125) {
	    			lista.clear(); 
			    	alm="A0B0";
					Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=110 && puntoY2<=125){
	    			lista.clear(); 
			    	alm="A1B0";
					Enviar.doClick();	    		
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear(); 
			    	alm="B0B1";
					Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
			    	alm="B0C1";
					Enviar.doClick();
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
			    	alm="B0C0";
			    	Enviar.doClick();
	    		}
	    	}	    	
	    	else if(puntoX1>=135 && puntoX1<=150 && puntoY1>210 && puntoY1<=225) {
	    		if(puntoX2>=35 && puntoX2<=50 && puntoY2>110 && puntoY2<=125) {
	    			lista.clear(); 
			    	alm="A0B1";
			    	Enviar.doClick();			    	
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=110 && puntoY2<=125){
	    			lista.clear(); 
			    	alm="A1B1";
			    	Enviar.doClick();			    	
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=110 && puntoY2<=125) {
	    			lista.clear(); 
			    	alm="A2B1";
			    	Enviar.doClick();			    	
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear(); 
			    	alm="B1B2";
			    	Enviar.doClick();	    		 
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
			    	alm="B1C2";
			    	Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
			    	alm="B1C1";
			    	Enviar.doClick();
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
			    	alm="B1C0";
			    	Enviar.doClick();
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear(); 
			    	alm="B0B1";
			    	Enviar.doClick();
	    		}
	    	}
	    	else if(puntoX1>=235 && puntoX1<=250 && puntoY1>210 && puntoY1<=225) {
	    		if(puntoX2>=135 && puntoX2<=150 && puntoY2>110 && puntoY2<=125) {
	    			lista.clear(); 
			    	alm="A1B2";
			    	Enviar.doClick();			    	
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=110 && puntoY2<=125){
	    			lista.clear(); 
			    	alm="A2B2";
			    	Enviar.doClick();			    	
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=110 && puntoY2<=125) {
	    			lista.clear(); 
			    	alm="A3B2";
			    	Enviar.doClick();			   
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear(); 
			    	alm="B2B3";
			    	Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
			    	alm="B2C3";
			    	Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
			    	alm="B2C2";
			    	Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
			    	alm="B2C1";
			    	Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear(); 
			    	alm="B1B2";
			    	Enviar.doClick();
	    		} 		
	    	}
	    	else if(puntoX1>=335 && puntoX1<=350 && puntoY1>210 && puntoY1<=225) {
	    		if(puntoX2>=235 && puntoX2<=250 && puntoY2>110 && puntoY2<=125) {
	    			lista.clear(); 
			    	alm="A2B3";
			    	Enviar.doClick();	    	
	    		}
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=110 && puntoY2<=125){
	    			lista.clear(); 
				    alm="A3B3";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=110 && puntoY2<=125) {
	    			lista.clear(); 
				    alm="A4B3";
				    Enviar.doClick();		    
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear(); 
				    alm="B3B4";
				    Enviar.doClick();		    
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
				    alm="B3C4";
				    Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
				    alm="B3C3";
				    Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
				    alm="B3C2";
				    Enviar.doClick();	    		
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear(); 
				    alm="B2B3";
				    Enviar.doClick();
	    		}
	    	}    	
	    	else if(puntoX1>=435 && puntoX1<=450 && puntoY1>210 && puntoY1<=225) {
	    		if(puntoX2>=435 && puntoX2<=450 && puntoY2>110 && puntoY2<=125) {
	    			lista.clear(); 
				    alm="A4B4";
				    Enviar.doClick();			    
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=110 && puntoY2<=125){
	    			lista.clear(); 
				    alm="A3B4";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear(); 
				    alm="B3B4";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
				    alm="B4C3";
				    Enviar.doClick();
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
				    alm="B4C4";
				    Enviar.doClick();
	    		}
	    	}	    	
	    	else if(puntoX1>=35 && puntoX1<=50 && puntoY1>310 && puntoY1<=325) {
	    		if(puntoX2>=35 && puntoX2<=50 && puntoY2>210 && puntoY2<=225) {
	    			lista.clear(); 
				    alm="B0C0";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=210 && puntoY2<=225){
	    			lista.clear(); 
				    alm="B1C0";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
				    alm="C0C1";
				    Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=410 && puntoY2<=425) {
	    			lista.clear(); 
				    alm="C0D1";
				    Enviar.doClick();
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=410 && puntoY2<=425) {
	    			lista.clear(); 
				    alm="C0D0";
				    Enviar.doClick();
	    		}
	    	}	    	
	    	else if(puntoX1>=135 && puntoX1<=150 && puntoY1>310 && puntoY1<=325) {
	    		if(puntoX2>=35 && puntoX2<=50 && puntoY2>210 && puntoY2<=225) {
	    			lista.clear(); 
				    alm="B0C1";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=210 && puntoY2<=225){
	    			lista.clear(); 
				    alm="B1C1";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear(); 
				    alm="B2C1";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
				    alm="C1C2";
				    Enviar.doClick();	    			
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=410 && puntoY2<=425) {
	    			lista.clear(); 
				    alm="C1D2";
				    Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=410 && puntoY2<=425) {
	    			lista.clear(); 
				    alm="C1D1";
				    Enviar.doClick();
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=410 && puntoY2<=425) {
	    			lista.clear(); 
				    alm="C1D0";
				    Enviar.doClick();
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
				    alm="C0C1";
				    Enviar.doClick();
	    		}
	    	}    	
	    	else if(puntoX1>=235 && puntoX1<=250 && puntoY1>310 && puntoY1<=325) {
	    		if(puntoX2>=135 && puntoX2<=150 && puntoY2>210 && puntoY2<=225) {
	    			lista.clear(); 
				    alm="B1C2";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=210 && puntoY2<=225){
	    			lista.clear(); 
				    alm="B2C2";
				    Enviar.doClick();			    
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear(); 
				    alm="B3C2";
				    Enviar.doClick();			    
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
				    alm="C2C3";
				    Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=410 && puntoY2<=425) {
	    			lista.clear(); 
				    alm="C2D3";
				    Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=410 && puntoY2<=425) {
	    			lista.clear(); 
				    alm="C2D2";
				    Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=410 && puntoY2<=425) {
	    			lista.clear(); 
				    alm="C2D1";
				    Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
				    alm="C1C2";
				    Enviar.doClick();
	    		}
	    	}    	
	    	else if(puntoX1>=335 && puntoX1<=350 && puntoY1>310 && puntoY1<=325) {
	    		if(puntoX2>=235 && puntoX2<=250 && puntoY2>210 && puntoY2<=225) {
	    			lista.clear(); 
				    alm="B2C3";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=210 && puntoY2<=225){
	    			lista.clear(); 
				    alm="B3C3";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=210 && puntoY2<=225) {
	    			lista.clear(); 
				    alm="B4C3";
				    Enviar.doClick();			    
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
				    alm="C3C4";
				    Enviar.doClick();
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=410 && puntoY2<=425) {
	    			lista.clear(); 
				    alm="C3D4";
				    Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=410 && puntoY2<=425) {
	    			lista.clear(); 
				    alm="C3D3";
				    Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=410 && puntoY2<=425) {
	    			lista.clear(); 
				    alm="C3D2";
				    Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=310 && puntoY2<=325) {
	    			lista.clear(); 
				    alm="C2C3";
				    Enviar.doClick();
	    		}
	    	}	    	
	    	else if(puntoX1>=435 && puntoX1<=450 && puntoY1>310 && puntoY1<=325) {
	    		if(puntoX2>=435 && puntoX2<=450 && puntoY2>210 && puntoY2<=225) {	    			 
	    			lista.clear(); 
				    alm="B4C4";
				    Enviar.doClick();			    
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=210 && puntoY2<=225){	    			 
	    			lista.clear(); 
				    alm="B3C4";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=310 && puntoY2<=325) {	    			 
	    			lista.clear(); 
				    alm="C3C4";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
				    alm="C4D3";
				    Enviar.doClick();
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
				    alm="C4D4";
				    Enviar.doClick();
				}
	    	}
	    	else if(puntoX1>=35 && puntoX1<=50 && puntoY1>410 && puntoY1<=425) {
	    		if(puntoX2>=35 && puntoX2<=50 && puntoY2>310 && puntoY2<=325) {	    			
	    			lista.clear(); 
				    alm="C0D0";
				    Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=310 && puntoY2<=325){	    			 
	    			lista.clear(); 
				    alm="C1D0";
				    Enviar.doClick();				    
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=410 && puntoY2<=425) {	    			 
	    			 lista.clear(); 
					 alm="D0D1";
					 Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="D0E1";
					Enviar.doClick();
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=510 && puntoY2<=525) {	    		
	    			lista.clear(); 
					alm="D0E0";
					Enviar.doClick();
	    		}
	    	}	    	
	    	else if(puntoX1>=135 && puntoX1<=150 && puntoY1>410 && puntoY1<=425) {
	    		if(puntoX2>=35 && puntoX2<=50 && puntoY2>410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D0D1";
					Enviar.doClick();					
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=310 && puntoY2<=325){	    			 
	    			lista.clear(); 
					alm="C1D1";
					Enviar.doClick();
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=310 && puntoY2<=325) {	    			 
	    			lista.clear(); 
					alm="C0D1";
					Enviar.doClick();					
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=310 && puntoY2<=325) {	    			 
	    			lista.clear(); 
					alm="C2D1";
					Enviar.doClick();					
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D1D2";
					Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=510 && puntoY2<=525){	    			 
	    			lista.clear(); 
					alm="D1E2";
					Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=510 && puntoY2<=525) {	    			
	    			lista.clear(); 
					alm="D1E1";
					Enviar.doClick();
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="D1E0";
					Enviar.doClick();
	    		}
	    	}		    	
	    	else if(puntoX1>=235 && puntoX1<=250 && puntoY1>410 && puntoY1<=425) {
	    		if(puntoX2>=135 && puntoX2<=150 && puntoY2>410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D1D2";
					Enviar.doClick();					
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=310 && puntoY2<=325){	    			 
	    			lista.clear(); 
					alm="C1D2";
					Enviar.doClick();					
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=310 && puntoY2<=325) {	    			 
	    			lista.clear(); 
					alm="C2D2";
					Enviar.doClick();					
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=310 && puntoY2<=325) {	    			 
	    			lista.clear(); 
					alm="C3D2";
					Enviar.doClick();					
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D2D3";
					Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=510 && puntoY2<=525){	    			 
	    			lista.clear(); 
					alm="D2E3";
					Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="D2E2";
					Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=510 && puntoY2<=525) {
	    			lista.clear(); 
					alm="D2E1";
					Enviar.doClick();
	    		}
	    	}		    	
	    	else if(puntoX1>=335 && puntoX1<=350 && puntoY1>410 && puntoY1<=425) {
	    		if(puntoX2>=235 && puntoX2<=250 && puntoY2>410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D2D3";
					Enviar.doClick();					
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=310 && puntoY2<=325){	    			 
	    			lista.clear(); 
					alm="C2D3";
					Enviar.doClick();					
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=310 && puntoY2<=325) {	    			 
	    			lista.clear(); 
					alm="C3D3";
					Enviar.doClick();					
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=310 && puntoY2<=325) {	    			 
	    			lista.clear(); 
					alm="C4D3";
					Enviar.doClick();					
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D3D4";
					Enviar.doClick();
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=510 && puntoY2<=525){	    			 
	    			lista.clear(); 
					alm="D3E4";
					Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="D3E3";
					Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="D3E2";
					Enviar.doClick();
	    		}
	    	}	    	
	    	else if(puntoX1>=435 && puntoX1<=450 && puntoY1>410 && puntoY1<=425) {
	    		if(puntoX2>=335 && puntoX2<=350 && puntoY2>410 && puntoY2<=425) {	  
	    			lista.clear(); 
					alm="D3D4";
					Enviar.doClick();					
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=310 && puntoY2<=325) {	    			 
	    			lista.clear(); 
					alm="C3D4";
					Enviar.doClick();					
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=310 && puntoY2<=325) {	    			 
	    			lista.clear(); 
					alm="C4D4";
					Enviar.doClick();					
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=510 && puntoY2<=525){	    			 
	    			lista.clear(); 
					alm="D4E4";
					Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="D4E3";
					Enviar.doClick();
	    		}	    		 
	    	}		    	
	    	else if(puntoX1>=35 && puntoX1<=50 && puntoY1>510 && puntoY1<=525) {
	    		if(puntoX2>=35 && puntoX2<=50 && puntoY2>410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D0E0";
					Enviar.doClick();					
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=410 && puntoY2<=425){	    			 
	    			lista.clear(); 
					alm="D1E0";
					Enviar.doClick();					
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E0E1";
					Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="E0F1";
					Enviar.doClick();
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="E0F0";
					Enviar.doClick();
	    		}	  
	    	}	    	
	    	else if(puntoX1>=135 && puntoX1<=150 && puntoY1>510 && puntoY1<=525) {
	    		if(puntoX2>=35 && puntoX2<=50 && puntoY2>510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E0E1";
					Enviar.doClick();					
	    		}else if(puntoX2>=135 && puntoX2<150 && puntoY2>=410 && puntoY2<=425){	    			 
	    			lista.clear(); 
					alm="D0E1";
					Enviar.doClick();					
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D1E1";
					Enviar.doClick();					
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D2E1";
					Enviar.doClick();					
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E1E2";
					Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=610 && puntoY2<=625){	    			 
	    			lista.clear(); 
					alm="E1F2";
					Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="E1F1";
					Enviar.doClick();
	    		}else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="E1F0";
					Enviar.doClick();
	    		}
	    	}		    	
	    	else if(puntoX1>=235 && puntoX1<=250 && puntoY1>510 && puntoY1<=525) {
	    		if(puntoX2>=135 && puntoX2<=150 && puntoY2>510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E1E2";
					Enviar.doClick();					
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=410 && puntoY2<=425){	    			 
	    			lista.clear(); 
					alm="D1E2";
					Enviar.doClick();	
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D2E2";
					Enviar.doClick();					
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D3E2";
					Enviar.doClick();					
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E2E3";
					Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=610 && puntoY2<=625){	    			 
	    			lista.clear(); 
					alm="E2F3";
					Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="E2F2";
					Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="E2F1";
					Enviar.doClick();
	    		}
	    	}	    	    	
	    	else if(puntoX1>=335 && puntoX1<=350 && puntoY1>510 && puntoY1<=525) {
	    		if(puntoX2>=235 && puntoX2<=250 && puntoY2>510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E2E3";
					Enviar.doClick();					
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=410 && puntoY2<=425){	    			 
	    			lista.clear(); 
					alm="D2E3";
					Enviar.doClick();					
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D3E3";
					Enviar.doClick();					
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D4E3";
					Enviar.doClick();				
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E3E4";
					Enviar.doClick();
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=610 && puntoY2<=625){	    			 
	    			lista.clear(); 
					alm="E3F4";
					Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="E3F3";
					Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="E3F2";
					Enviar.doClick();
	    		}
	    	}	  	    	
	    	else if(puntoX1>=435 && puntoX1<=450 && puntoY1>510 && puntoY1<=525) {
	    		if(puntoX2>=335 && puntoX2<=350 && puntoY2>510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E3E4";
					Enviar.doClick();					
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=410 && puntoY2<=425){	    			 
	    			lista.clear(); 
					alm="D3E4";
					Enviar.doClick();					
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=410 && puntoY2<=425) {	    			 
	    			lista.clear(); 
					alm="D4E4";
					Enviar.doClick();					
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="E4F3";
					Enviar.doClick();	   			 
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="E4F4";
					Enviar.doClick();
	    		} 
	    	}	
	    	else if(puntoX1>=35 && puntoX1<=50 && puntoY1>610 && puntoY1<=625) {
	    		if(puntoX2>=35 && puntoX2<=50 && puntoY2>510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E0F0";
					Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=510 && puntoY2<=525){	    			 
	    			lista.clear(); 
					alm="E1F0";
					Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="F0F1";
					Enviar.doClick();
	    		}
	    	 }
	    	 else if(puntoX1>=135 && puntoX1<=150 && puntoY1>610 && puntoY1<=625) {
	    		if(puntoX2>=35 && puntoX2<=50 && puntoY2>610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="F0F1";
					Enviar.doClick();
	    		}else if(puntoX2>=35 && puntoX2<50 && puntoY2>=510 && puntoY2<=525){	    			 
	    			lista.clear(); 
					alm="E0F1";
					Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E1F1";
					Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E2F1";
					Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=610 && puntoY2<=625) {
	    			lista.clear(); 
					alm="F1F2";
					Enviar.doClick();
	    		 }
	    	 }	    	 
	    	 else if(puntoX1>=235 && puntoX1<=250 && puntoY1>610 && puntoY1<=625) {
	    		if(puntoX2>=135 && puntoX2<=150 && puntoY2>610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="F1F2";
					Enviar.doClick();
	    		}else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=510 && puntoY2<=525){	    			 
	    			lista.clear(); 
					alm="E1F2";
					Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E2F2";
					Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E3F2";
					Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="F2F3";
					Enviar.doClick();
	    		 }
	    	 }	    	 
	    	 else if(puntoX1>=335 && puntoX1<=350 && puntoY1>610 && puntoY1<=625) {
	    		if(puntoX2>=235 && puntoX2<=250 && puntoY2>610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="F2F3";
					Enviar.doClick();
	    		}else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=510 && puntoY2<=525){	    			 
	    			lista.clear(); 
					alm="E2F3";
					Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E3F3";
					Enviar.doClick();
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E4F3";
					Enviar.doClick();
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="F3F4";
					Enviar.doClick();
	    		}
	    	 }	    	 
	    	 else if(puntoX1>=435 && puntoX1<=450 && puntoY1>610 && puntoY1<=625) {
	    		if(puntoX2>=335 && puntoX2<=350 && puntoY2>610 && puntoY2<=625) {	    			 
	    			lista.clear(); 
					alm="F3F4";
					Enviar.doClick();
	    		}else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=510 && puntoY2<=525){	    			 
	    			lista.clear(); 
					alm="E3F4";
					Enviar.doClick();
	    		}else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=510 && puntoY2<=525) {	    			 
	    			lista.clear(); 
					alm="E4F4";
					Enviar.doClick();
	    		 } 
	    	 }	    	 	 
	    }
	}  
	   
	/**
	 * @param figura
	 * Se crea la clase la clase que dibuja una figura después de ser verificada por el servidor
	 */
	
private void dibujarFigura(String figura) {
	String jugador="";
	if (this.turno%2==0) {
		jugador=jugador1;
	}else {
		jugador=jugador2;
	}
	
	Graphics2D g = (Graphics2D)this.getGraphics();
    g.setStroke(new BasicStroke((float) 5.0));
    
    Graphics2D g1 = (Graphics2D)this.getGraphics();
    g1.setStroke(new BasicStroke((float) 5.0));
    
    if (turno%2==0) {
    	g1.setColor(Color.LIGHT_GRAY);
    	g.setColor(Color.GREEN);
    }else {
    	g1.setColor(Color.GRAY);
    	g.setColor(Color.BLUE);
    }
    	
    
    
	if (figura=="FG1") {
		Rectangle2D r1 = new Rectangle2D.Double(42, 116, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
    	JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 1);
	}else if(figura=="FG2") {
		Rectangle2D r1 = new Rectangle2D.Double(142, 116, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG3") {
		Rectangle2D r1 = new Rectangle2D.Double(242, 116, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null, jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG4") {
		Rectangle2D r1 = new Rectangle2D.Double(342, 116, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG5") {
		Rectangle2D r1 = new Rectangle2D.Double(42, 216, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG6") {
		Rectangle2D r1 = new Rectangle2D.Double(142, 216, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG7") {
		Rectangle2D r1 = new Rectangle2D.Double(242, 216, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG8") {
		Rectangle2D r1 = new Rectangle2D.Double(342, 216, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);	
	}else if(figura=="FG9") {
		Rectangle2D r1 = new Rectangle2D.Double(42, 316, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG10") {
		Rectangle2D r1 = new Rectangle2D.Double(142, 316, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG11") {
		Rectangle2D r1 = new Rectangle2D.Double(242, 316, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG12") {
		Rectangle2D r1 = new Rectangle2D.Double(342, 316, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);	
	}else if(figura=="FG13") {
		Rectangle2D r1 = new Rectangle2D.Double(42, 416, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG14") {
		Rectangle2D r1 = new Rectangle2D.Double(142, 416, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG15") {
		Rectangle2D r1 = new Rectangle2D.Double(242, 416, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG16") {
		Rectangle2D r1 = new Rectangle2D.Double(342, 416, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG17") {
		Rectangle2D r1 = new Rectangle2D.Double(42, 516, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG18") {
		Rectangle2D r1 = new Rectangle2D.Double(142, 516, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG19") {
		Rectangle2D r1 = new Rectangle2D.Double(242, 516, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);
	}else if(figura=="FG20") {
		Rectangle2D r1 = new Rectangle2D.Double(342, 516, 100, 100);
		g.draw(r1);
		g1.fill(r1);
		this.aumentarPuntos(10);
		JOptionPane.showMessageDialog(null,jugador + " ha creado un cuadrado. Gana 10 puntos.","Figura creada por " + jugador , 2);	
	}else{
	}
	if (this.puntaje1==50) {
    	juegoFinalizado(1);
    }
	if (this.puntaje2==50) {
		juegoFinalizado(2);
	}
	
    }

/**
 * Se crea la clase que aumenta el puntaje de los clientes
 */
private void aumentarPuntos(int i) {
	if (turno%2==0) {
		this.puntaje2=this.puntaje2+10;
		System.out.println(jugador1 + ":" + " " + puntaje2 + " puntos");
	}else {
		this.puntaje1=this.puntaje1+10;
		System.out.println(jugador2 + ":" + " " + puntaje1 + " puntos");
	}
}

/**
 * Clase que indica los requerimientos de finalización de juego
 * @param ganador, indica el cliente ganador
 */
@SuppressWarnings("static-access")
private void juegoFinalizado(int ganador) {
	if (ganador==1){
		int respuesta = JOptionPane.showConfirmDialog(null, "¡" + jugador2 + " ha ganado por alcanzar los 50 puntos! ¿Deseas iniciar otra partida?", "Juego finalizado.", JOptionPane.YES_NO_OPTION);
		if(respuesta==JOptionPane.YES_OPTION) {
			this.setVisible(false);
			this.main(null);
		}else{
			System.exit(0);
		}
	}else {
		int respuesta = JOptionPane.showConfirmDialog(null, "¡" + jugador1 + " ha ganado por alcanzar los 50 puntos! ¿Deseas iniciar otra partida?", "Juego finalizado.", JOptionPane.YES_NO_OPTION);
		if(respuesta==JOptionPane.YES_OPTION) {
			this.setVisible(false);
			this.main(null);
		}else{
			System.exit(0);
		}
	}
}

	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
	                formMousePressed(evt);
	            }
	        });
		}
	
	@SuppressWarnings("serial")
	/**
	 * Método que dibuja puntos en la interfaz
	 */
	class Matriz_puntos extends JPanel{
	    ArrayList<Point> lista1 = new ArrayList<Point>();

	    

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int i=30;i<600;i+=100) {
				for (int j=80;j<700;j+=100) {
					g.setColor (Color.black);
					g.fillOval (i,j,10,10);
					lista1.add(new Point(i,j));
					}
				}
			}
	}
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Clase que crea un array JSON con los componentes necesarios
	 */
	public static class Codigo implements JSONStreamAware{
		String Codigo;
		public String getCode() {
			return Codigo;
		}
		
		public void setCode(String Codigo) {
			this.Codigo = Codigo;
		}
		
		public Codigo(String Codigo) {
			super();
			this.Codigo = Codigo;
		}
		
		@SuppressWarnings("unchecked")
		public void writeJSONString (Writer out) throws IOException {
			@SuppressWarnings("rawtypes")
			LinkedHashMap obj = new LinkedHashMap();
			obj.put("Code", Codigo);
		    JSONValue.writeJSONString(obj, out);
		}
	}
	/**
	 * Clase que asigna el código al JSONArray
	 */
	public static class DA {
		@SuppressWarnings("unchecked")
		public JSONArray arrayCodes() {
			JSONArray array = new JSONArray();
			array.add(new Codigo(alm));
			return array;
		}
	}
	/**
	 * Clase que crea una instancia de la clase DA con el JSONArray 
	 */
	public static class BL {
		public static JSONArray arrayCodes() {
			DA da_Code = new DA();
			return da_Code.arrayCodes();
		}
	}
	@SuppressWarnings({ "unused", "static-access", "unchecked" })
	/**
	 * Se crea el método que al presionar con el mouse, envía un valor válido al servidor
	 */
	public void actionPerformed(ActionEvent T) {
		PrintStream Salida2;
		BufferedReader Entrada;
		JSONArray Mesage;
		
		if(T.getSource()==Enviar) {
			try {
				Socket Cliente = new Socket(ipServer,8766);
				PrintStream Salida=new PrintStream(Cliente.getOutputStream());
				Entrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
				BL Serializar = new BL();
				JSONArray array = new JSONArray();
				array=BL.arrayCodes();
				StringWriter salida = new StringWriter();
				/**
				 * Envía el JSONArray al server
				 */
				try {
					array.writeJSONString(salida);
				}catch(IOException e) {
					e.printStackTrace();
				}
				System.out.println(salida);
				
				Salida.println(this.alm);
				String Message = Entrada.readLine();
				
				StringWriter out = new StringWriter();
				try {
					array.writeJSONString(out);
				}catch(IOException e) {
						e.printStackTrace();
				}

				JSONObject jsonCode = new JSONObject();
				jsonCode.put("Code", out);
					
				JSONParser code_parser = new JSONParser();
				
				/**
				 * Recibe el JSONArray enviado por el servidor y lo deserializa
				 */
				try {
					JSONObject obj_Code = (JSONObject) code_parser.parse(jsonCode.toString());
					JSONArray array_Code = (JSONArray) obj_Code.get("Code");
					for(int i=0; i<array_Code.size();i++) {
						JSONObject user = (JSONObject) array_Code.get(i);
						String code = user.get("Code").toString();
					}
				}catch(org.json.simple.parser.ParseException e) {
					e.printStackTrace();
				}
				/**
				 * Utiliza el código desearializado para devolver al programa un valor válido el cuál dibuja o no dibuja dependiendo de su analizacion
				 */
				if (Message.contains("0P")) {
					this.recibido="0";
				}else if(Message.contains("1Z")) {
					this.recibido="1";
				}else if(Message.contains("2N")) {
					this.recibido="2";
				}else if(Message.contains("3W")) {
					this.recibido="3";
				}else if(Message.contains("FG1Q")) {
					this.recibido="FG1";
				}else if(Message.contains("FG2S")) {
					this.recibido="FG2";
				}else if(Message.contains("FG2")) {
					this.recibido="FG2";
				}else if(Message.contains("FG3")) {
					this.recibido="FG3";
				}else if(Message.contains("FG4")) {
					this.recibido="FG4";
				}else if(Message.contains("FG5")) {
					this.recibido="FG5";
				}else if(Message.contains("FG6")) {
					this.recibido="FG6";
				}else if(Message.contains("FG7")) {
					this.recibido="FG7";
				}else if(Message.contains("FG8")) {
					this.recibido="FG8";
				}else if(Message.contains("FG9")) {
					this.recibido="FG9";
				}else if(Message.contains("FG10")) {
					this.recibido="FG10";
				}else if(Message.contains("FG11")) {
					this.recibido="FG11";
				}else if(Message.contains("FG12")) {
					this.recibido="FG12";
				}else if(Message.contains("FG13")) {
					this.recibido="FG13";
				}else if(Message.contains("FG14")) {
					this.recibido="FG14";
				}else if(Message.contains("FG15")) {
					this.recibido="FG15";
				}else if(Message.contains("FG16")) {
					this.recibido="FG16";
				}else if(Message.contains("FG17")) {
					this.recibido="FG17";
				}else if(Message.contains("FG18")) {
					this.recibido="FG18";
				}else if(Message.contains("FG19")) {
					this.recibido="FG19";
				}else if(Message.contains("FG20")) {
					this.recibido="FG20";
				}
				dibujar(this.alm);
				Entrada.close();
				Salida.close();
				Cliente.close();
			}catch(Exception T2) {
				System.out.println("Error al conectar con el servidor");
			}
		}
	}
	/**
	 * Método que dibuja la línea con el código recibo por el servidor
	 */
	private void dibujar(String linea) {
		Graphics2D g = (Graphics2D)this.getGraphics();
	    g.setStroke(new BasicStroke((float) 5.0));
	    if(turno%2==0) {
	    	g.setColor(Color.GREEN);
	    }else {
	    	g.setColor(Color.BLUE);}
	    
	    
	    if (this.recibido=="0") {
	    	if(alm=="A0A1") {g.drawLine(142,116,42 ,116);}
	    	if(alm=="A0B1") {g.drawLine(42 ,116,142,216);}
	    	if(alm=="A0B0") {g.drawLine(42 ,116,42 ,212);}
	    	if(alm=="A1B0") {g.drawLine(142,116,42 ,215);}
	    	if(alm=="A1B1") {g.drawLine(142,116,142,212);}
	    	if(alm=="A1B2") {g.drawLine(142,116,242,215);}
	    	if(alm=="A1A2") {g.drawLine(242,116,143,116);}
	    	if(alm=="A2B1") {g.drawLine(242,116,142,216);}
	    	if(alm=="A2B2") {g.drawLine(242,116,242,216);}
	    	if(alm=="A2B3") {g.drawLine(242,116,342,216);}
	    	if(alm=="A2A3") {g.drawLine(342,116,242,116);}
	    	if(alm=="A3B2") {g.drawLine(342,116,242,216);}
	    	if(alm=="A3B3") {g.drawLine(342,116,342,216);}
	    	if(alm=="A3B4") {g.drawLine(342,116,442,216);}
	    	if(alm=="A3A4") {g.drawLine(442,116,342,116);}
	    	if(alm=="A4B3") {g.drawLine(442,116,342,216);}
	    	if(alm=="A4B4") {g.drawLine(442,116,442,216);}
	    	if(alm=="B0B1") {g.drawLine(42 ,216,142,216);}
	    	if(alm=="B0C1") {g.drawLine(42 ,216,142,316);}
	    	if(alm=="B0C0") {g.drawLine(42 ,216,42 ,316);}
	    	if(alm=="B1B2") {g.drawLine(142,216,242,216);}
	    	if(alm=="B1C2") {g.drawLine(142,216,242,316);}
	    	if(alm=="B1C1") {g.drawLine(142,216,142,316);}
	    	if(alm=="B1C0") {g.drawLine(142,216,42 ,316);}
	    	if(alm=="B2B3") {g.drawLine(242,216,342,216);}
	    	if(alm=="B2C3") {g.drawLine(242,216,342,316);}
	    	if(alm=="B2C2") {g.drawLine(242,216,242,316);}
	    	if(alm=="B2C1") {g.drawLine(242,216,142,316);}
	    	if(alm=="B3B4") {g.drawLine(342,216,442,216);}
	    	if(alm=="B3C4") {g.drawLine(342,216,442,316);}
	    	if(alm=="B3C3") {g.drawLine(342,216,342,316);}
	    	if(alm=="B3C2") {g.drawLine(342,216,242,316);}
	    	if(alm=="B4C4") {g.drawLine(442,216,442,316);}
	    	if(alm=="B4C3") {g.drawLine(442,216,342,316);}
	    	if(alm=="C0C1") {g.drawLine(42 ,316,142,316);}
	    	if(alm=="C0D1") {g.drawLine(42 ,316,142,416);}
	    	if(alm=="C0D0") {g.drawLine(42 ,316,42 ,416);}
	    	if(alm=="C1C2") {g.drawLine(142,316,242,316);}
	    	if(alm=="C1D2") {g.drawLine(142,316,242,416);}
	    	if(alm=="C1D1") {g.drawLine(142,316,142,416);}
	    	if(alm=="C1D0") {g.drawLine(442,216,342,316);}
	    	if(alm=="C1D0") {g.drawLine(142,316,42 ,416);}
	    	if(alm=="C2C3") {g.drawLine(242,316,342,316);}
	    	if(alm=="C2D3") {g.drawLine(242,316,342,416);}
	    	if(alm=="C2D2") {g.drawLine(242,316,242,416);}
	    	if(alm=="C2D1") {g.drawLine(242,316,142,416);}
	    	if(alm=="C3C4") {g.drawLine(342,316,442,316);}
	    	if(alm=="C3D4") {g.drawLine(342,316,442,416);}
	    	if(alm=="C3D3") {g.drawLine(342,316,342,416);}
	    	if(alm=="C3D2") {g.drawLine(342,316,242,416);}
	    	if(alm=="C4D3") {g.drawLine(442,316,342,416);}
	    	if(alm=="C4D4") {g.drawLine(442,316,442,416);}
	    	if(alm=="D0D1") {g.drawLine(42 ,416,142,416);}
	    	if(alm=="D0E1") {g.drawLine(42 ,416,142,516);}
	    	if(alm=="D0E0") {g.drawLine(42 ,416,42 ,516);}
	    	if(alm=="D1D2") {g.drawLine(142,416,242,416);}
	    	if(alm=="D1E2") {g.drawLine(142,416,242,516);}
	    	if(alm=="D1E1") {g.drawLine(142,416,142,516);}
	    	if(alm=="D1E0") {g.drawLine(42 ,516,142,416);}
	    	if(alm=="D2D3") {g.drawLine(242,416,342,416);}
	    	if(alm=="D2E3") {g.drawLine(242,416,342,516);}
	    	if(alm=="D2E2") {g.drawLine(242,416,242,516);}
	    	if(alm=="D2E1") {g.drawLine(242,416,142,516);}
	    	if(alm=="D3D4") {g.drawLine(342,416,442,416);}
	    	if(alm=="D3E4") {g.drawLine(342,416,442,516);}
	    	if(alm=="D3E3") {g.drawLine(342,416,342,516);}
	    	if(alm=="D3E2") {g.drawLine(342,416,242,516);}
	    	if(alm=="D4E3") {g.drawLine(442,416,342,516);}
	    	if(alm=="D4E4") {g.drawLine(442,416,442,516);}
	    	if(alm=="E0E1") {g.drawLine(42 ,516,142,516);}
	    	if(alm=="E0F1") {g.drawLine(42 ,516,142,616);}
	    	if(alm=="E0F0") {g.drawLine(42 ,516,42 ,616);}
	    	if(alm=="E1E2") {g.drawLine(142,516,242,516);}
	    	if(alm=="E1F2") {g.drawLine(142,516,242,616);}
	    	if(alm=="E1F1") {g.drawLine(142,516,142,616);}
	    	if(alm=="E1F0") {g.drawLine(142,516,42 ,616);}
	    	if(alm=="E2E3") {g.drawLine(242,516,342,516);}
	    	if(alm=="E2F3") {g.drawLine(242,516,342,616);}
	    	if(alm=="E2F2") {g.drawLine(242,516,242,616);}
	    	if(alm=="E2F1") {g.drawLine(242,516,142,616);}
	    	if(alm=="E3E4") {g.drawLine(342,516,442,516);}
	    	if(alm=="E3F4") {g.drawLine(342,516,442,616);}
	    	if(alm=="E3F3") {g.drawLine(342,516,342,616);}
	    	if(alm=="E3F2") {g.drawLine(342,516,242,616);}
	    	if(alm=="E4F3") {g.drawLine(442,516,342,616);}
	    	if(alm=="E4F4") {g.drawLine(442,516,442,616);}	  
	    	if(alm=="F0F1") {g.drawLine(42 ,616,142,616);}
	    	if(alm=="F1F2") {g.drawLine(142,616,142,516);}
	    	if(alm=="F2F3") {g.drawLine(242,616,342,616);}
	    	if(alm=="F3F4") {g.drawLine(342,616,442,616);}
	    	
	    	turno++;}
	    
	    
	    if(recibido=="FG1")   {dibujarFigura("FG1");turno++;}
	    if(recibido=="FG2")   {dibujarFigura("FG2");turno++;}	    
	    if(recibido=="FG3")   {dibujarFigura("FG3");turno++;}	    
	    if(recibido=="FG4")   {dibujarFigura("FG4");turno++;}
	    if(recibido=="FG5")   {dibujarFigura("FG5");turno++;}
	    if(recibido=="FG6")   {dibujarFigura("FG6");turno++;}
	    if(recibido=="FG7")   {dibujarFigura("FG7");turno++;}
	    if(recibido=="FG8")   {dibujarFigura("FG8");turno++;}	    
	    if(recibido=="FG9")   {dibujarFigura("FG9");turno++;}
	    if(recibido=="FG10") {dibujarFigura("FG10");turno++;}
	    if(recibido=="FG11") {dibujarFigura("FG11");turno++;}  
	    if(recibido=="FG12") {dibujarFigura("FG12");turno++;}
	    if(recibido=="FG13") {dibujarFigura("FG13");turno++;}
	    if(recibido=="FG14") {dibujarFigura("FG14");turno++;}
	    if(recibido=="FG15") {dibujarFigura("FG15");turno++;}
	    if(recibido=="FG16") {dibujarFigura("FG16");turno++;}
	    if(recibido=="FG17") {dibujarFigura("FG17");turno++;}
	    if(recibido=="FG18") {dibujarFigura("FG18");turno++;}
	    if(recibido=="FG19") {dibujarFigura("FG19");turno++;}
	    if(recibido=="FG20") {dibujarFigura("FG20");turno++;}
	    

	    if (this.recibido=="1") {JOptionPane.showMessageDialog(null, "La línea ya existe, intente con una nueva.", "Línea ya existente.", 2);turno++;}
	    if (this.recibido=="3") {JOptionPane.showMessageDialog(null, "La línea es incompatible, ya que interseca a otra línea previamente creada.", "Línea incompatible.", 2);turno++;}
	    if (this.recibido=="2") {JOptionPane.showMessageDialog(null, "La línea es incompatible, ya que ya hay una figura en esta zona.", "Línea incompatible.", 2);turno++;}
	    
	    /**
	     * Analiza a quien pertenece el turno actual
	     */
	    
	    if(turno%2==0) {
	    	JOptionPane.showMessageDialog(null, "Turno de "+ jugador1, "Turno finalizado", 3);
	    }else {
	    	JOptionPane.showMessageDialog(null, "Turno de "+ jugador2, "Turno finalizado", 3);
	    }
	}
}






