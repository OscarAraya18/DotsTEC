package InterfazGrafica;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;


class Capa extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String guardado="";
	String linea="";
	
	JButton botonA0 = new JButton("A0");
	JButton botonA1 = new JButton("A1");
	JButton botonA2 = new JButton("A2");
	JButton botonA3 = new JButton("A3");
	JButton botonA4 = new JButton("A4");
	JButton botonA5 = new JButton("A5");
	
	JButton botonB0 = new JButton("B0");
	JButton botonB1 = new JButton("B1");
	JButton botonB2 = new JButton("B2");
	JButton botonB3 = new JButton("B3");
	JButton botonB4 = new JButton("B4");
	JButton botonB5 = new JButton("B5");
	
	JButton botonC0 = new JButton("C0");
	JButton botonC1 = new JButton("C1");
	JButton botonC2 = new JButton("C2");
	JButton botonC3 = new JButton("C3");
	JButton botonC4 = new JButton("C4");
	JButton botonC5 = new JButton("C5");
	
	JButton botonD0 = new JButton("D0");
	JButton botonD1 = new JButton("D1");
	JButton botonD2 = new JButton("D2");
	JButton botonD3 = new JButton("D3");
	JButton botonD4 = new JButton("D4");
	JButton botonD5 = new JButton("D5");
	
	JButton botonE0 = new JButton("E0");
	JButton botonE1 = new JButton("E1");
	JButton botonE2 = new JButton("E2");
	JButton botonE3 = new JButton("E3");
	JButton botonE4 = new JButton("E4");
	JButton botonE5 = new JButton("E5");
	
	JButton botonF0 = new JButton("F0");
	JButton botonF1 = new JButton("F1");
	JButton botonF2 = new JButton("F2");
	JButton botonF3 = new JButton("F3");
	JButton botonF4 = new JButton("F4");
	JButton botonF5 = new JButton("F5");
	
	public Capa() {
		
		this.setLayout(new GridLayout(6,6,68,68));
	
		this.add(botonA0);
		this.add(botonA1);
		this.add(botonA2);
		this.add(botonA3);
		this.add(botonA4);
		this.add(botonA5);
		
		this.add(botonB0);
		this.add(botonB1);
		this.add(botonB2);
		this.add(botonB3);
		this.add(botonB4);
		this.add(botonB5);
		
		this.add(botonC0);
		this.add(botonC1);
		this.add(botonC2);
		this.add(botonC3);
		this.add(botonC4);
		this.add(botonC5);
		
		this.add(botonD0);
		this.add(botonD1);
		this.add(botonD2);
		this.add(botonD3);
		this.add(botonD4);
		this.add(botonD5);
		
		this.add(botonE0);
		this.add(botonE1);
		this.add(botonE2);
		this.add(botonE3);
		this.add(botonE4);
		this.add(botonE5);
		
		this.add(botonF0);
		this.add(botonF1);
		this.add(botonF2);
		this.add(botonF3);
		this.add(botonF4);
		this.add(botonF5);
		
		
		botonA0.addActionListener(this);
		botonA1.addActionListener(this);
		botonA2.addActionListener(this);
		botonA3.addActionListener(this);
		botonA4.addActionListener(this);
		botonA5.addActionListener(this);
		
		botonB0.addActionListener(this);
		botonB1.addActionListener(this);
		botonB2.addActionListener(this);
		botonB3.addActionListener(this);
		botonB4.addActionListener(this);
		botonB5.addActionListener(this);
		
		botonC0.addActionListener(this);
		botonC1.addActionListener(this);
		botonC2.addActionListener(this);
		botonC3.addActionListener(this);
		botonC4.addActionListener(this);
		botonC5.addActionListener(this);
		
		botonD0.addActionListener(this);
		botonD1.addActionListener(this);
		botonD2.addActionListener(this);
		botonD3.addActionListener(this);
		botonD4.addActionListener(this);
		botonD5.addActionListener(this);
		
		botonE0.addActionListener(this);
		botonE1.addActionListener(this);
		botonE2.addActionListener(this);
		botonE3.addActionListener(this);
		botonE4.addActionListener(this);
		botonE5.addActionListener(this);
		
		botonF0.addActionListener(this);
		botonF1.addActionListener(this);
		botonF2.addActionListener(this);
		botonF3.addActionListener(this);
		botonF4.addActionListener(this);
		botonF5.addActionListener(this);
	}	
	
	
	public void actionPerformed(ActionEvent e) {
		Object pulsado = e.getSource();
		
		//***********************************************************************
		if (pulsado==botonA0) {
			if(guardado.equals("")) {
				guardado="botonA0";
			}
			else{
				if (guardado.equals("botonA1")) {
					linea="A0A1";
					System.out.println("Lineaaaa");
					paintComponent(null);
					guardado="";
					
				}
				if (guardado.equals("botonB0")) {
					System.out.println("Lineaaaa");
					linea="A0B0";
					guardado="";
				}
				if (guardado.equals("botonB1")) {
					System.out.println("Lineaaaa");
					linea="A0B1";
					guardado="";
				}
			}
		}
		//**********************************************************************
		if (pulsado==botonA1) {
			if(guardado.equals("")) {
				guardado="botonA1";
			}
			else{
				if (guardado.equals("botonA0")) {
					System.out.println("Lineaaaa");
					
					guardado="";
				}
				if (guardado.equals("botonA2")) {
					System.out.println("Lineaaaa");
					linea="A1A2";
					guardado="";
				}
				if (guardado.equals("botonB0")) {
					System.out.println("Lineaaaa");
					linea="A1B0";
					guardado="";
				}
				if (guardado.equals("botonB1")) {
					System.out.println("Lineaaaa");
					linea="A1B1";
					guardado="";
				}
				if (guardado.equals("botonB2")) {
					System.out.println("Lineaaaa");
					linea="A1B2";
					guardado="";
				}	
			}
		}
		//**********************************************************************
		if (pulsado==botonA2) {
			if(guardado.equals("")) {
				guardado="botonA2";
			}
			else{
				if (guardado.equals("botonA1")) {
					System.out.println("Lineaaaa");
					linea="A2A1";
					guardado="";
				}
				if (guardado.equals("botonA3")) {
					System.out.println("Lineaaaa");
					linea="A2A3";
					guardado="";
				}
				if (guardado.equals("botonB1")) {
					System.out.println("Lineaaaa");
					linea="A2B1";
					guardado="";
				}
				if (guardado.equals("botonB2")) {
					System.out.println("Lineaaaa");
					linea="A2B2";
					guardado="";
				}
				if (guardado.equals("botonB3")) {
					System.out.println("Lineaaaa");
					linea="A2B3";
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonA3) {
			if(guardado.equals("")) {
				guardado="botonA3";
			}
			else{
				if (guardado.equals("botonA2")) {
					System.out.println("Lineaaaa");
					linea="A3B3";
					guardado="";
				}
				if (guardado.equals("botonA4")) {
					System.out.println("Lineaaaa");
					linea="A3A4";
					guardado="";
				}
				if (guardado.equals("botonB2")) {
					linea="A3B2";
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonA4) {
			if(guardado.equals("")) {
				guardado="botonA4";
			}
			else{
				if (guardado.equals("botonA3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonA5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonA5) {
			if(guardado.equals("")) {
				guardado="botonA5";
			}
			else{
				if (guardado.equals("botonA4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
			}
		}		
		//**********************************************************************
		if (pulsado==botonB0) {
			if(guardado.equals("")) {
				guardado="botonBO";
			}
			else{
				if (guardado.equals("botonA0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonA1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonB1) {
			if(guardado.equals("")) {
				guardado="botonB1";
			}
			else{
				if (guardado.equals("botonA0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonA1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonA2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonB2) {
			if(guardado.equals("")) {
				guardado="botonB2";
			}
			else{
				if (guardado.equals("botonA1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonA2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonA3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonB3) {
			if(guardado.equals("")) {
				guardado="botonB3";
			}
			else{
				if (guardado.equals("botonA2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonA3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonA4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonB4) {
			if(guardado.equals("")) {
				guardado="botonB4";
			}
			else{
				if (guardado.equals("botonA3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonA4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonA5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonB5) {
			if(guardado.equals("")) {
				guardado="botonB5";
			}
			else{
				if (guardado.equals("botonA4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonA5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
			}
		}		
		//**********************************************************************
		if (pulsado==botonC0) {
			if(guardado.equals("")) {
				guardado="botonC0";
			}
			else{
				if (guardado.equals("botonB0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
			}
		}		
		//**********************************************************************
		if (pulsado==botonC1) {
			if(guardado.equals("")) {
				guardado="botonC1";
			}
			else{
				if (guardado.equals("botonB0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonC2) {
			if(guardado.equals("")) {
				guardado="botonC2";
			}
			else{
				if (guardado.equals("botonB1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}				
		//**********************************************************************
		if (pulsado==botonC3) {
			if(guardado.equals("")) {
				guardado="botonC3";
			}
			else{
				if (guardado.equals("botonB2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}				
		//**********************************************************************
		if (pulsado==botonC4) {
			if(guardado.equals("")) {
				guardado="botonC4";
			}
			else{
				if (guardado.equals("botonB3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}				
		//**********************************************************************
		if (pulsado==botonC5) {
			if(guardado.equals("")) {
				guardado="botonC5";
			}
			else{
				if (guardado.equals("botonB4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonB5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
			}
		}				
		//**********************************************************************
		if (pulsado==botonD0) {
			if(guardado.equals("")) {
				guardado="botonD0";
			}
			else{
				if (guardado.equals("botonC0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}				
		//**********************************************************************
		if (pulsado==botonD1) {
			if(guardado.equals("")) {
				guardado="botonD1";
			}
			else{
				if (guardado.equals("botonC0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}				
		//**********************************************************************
		if (pulsado==botonD2) {
			if(guardado.equals("")) {
				guardado="botonD2";
			}
			else{
				if (guardado.equals("botonC1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonD3) {
			if(guardado.equals("")) {
				guardado="botonD3";
			}
			else{
				if (guardado.equals("botonC2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonD4) {
			if(guardado.equals("")) {
				guardado="botonD4";
			}
			else{
				if (guardado.equals("botonC3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonD5) {
			if(guardado.equals("")) {
				guardado="botonD5";
			}
			else{
				if (guardado.equals("botonC4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonC5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
			}
		}		
		//**********************************************************************
		if (pulsado==botonE0) {
			if(guardado.equals("")) {
				guardado="botonE0";
			}
			else{
				if (guardado.equals("botonD0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
			}
		}		
		//**********************************************************************
		if (pulsado==botonE1) {
			if(guardado.equals("")) {
				guardado="botonE1";
			}
			else{
				if (guardado.equals("botonD0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonE2) {
			if(guardado.equals("")) {
				guardado="botonE2";
			}
			else{
				if (guardado.equals("botonD1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonE3) {
			if(guardado.equals("")) {
				guardado="botonE3";
			}
			else{
				if (guardado.equals("botonD2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonE4) {
			if(guardado.equals("")) {
				guardado="botonE4";
			}
			else{
				if (guardado.equals("botonD3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}	
			}
		}		
		//**********************************************************************
		if (pulsado==botonE5) {
			if(guardado.equals("")) {
				guardado="botonE5";
			}
			else{
				if (guardado.equals("botonD4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonD5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
			}
		}		
		//**********************************************************************
		if (pulsado==botonF0) {
			if(guardado.equals("")) {
				guardado="botonF0";
			}
			else{
				if (guardado.equals("botonE0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
			}
		}			
		//**********************************************************************
		if (pulsado==botonF1) {
			if(guardado.equals("")) {
				guardado="botonF1";
			}
			else{
				if (guardado.equals("botonE0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF0")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
			}
		}				
		//**********************************************************************
		if (pulsado==botonF2) {
			if(guardado.equals("")) {
				guardado="botonF2";
			}
			else{
				if (guardado.equals("botonE1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF1")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
			}
		}			
		//**********************************************************************
		if (pulsado==botonF3) {
			if(guardado.equals("")) {
				guardado="botonF3";
			}
			else{
				if (guardado.equals("botonE2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF2")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
			}
		}			
		//**********************************************************************
		if (pulsado==botonF4) {
			if(guardado.equals("")) {
				guardado="botonF4";
			}
			else{
				if (guardado.equals("botonE3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF3")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
			}
		}			
		//**********************************************************************
		if (pulsado==botonF5) {
			if(guardado.equals("")) {
				guardado="botonF5";
			}
			else{
				if (guardado.equals("botonE4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonE5")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
				if (guardado.equals("botonF4")) {
					System.out.println("Lineaaaa");
					guardado="";
				}
			}
		}			
		
		
		
		
		
		
		
		
		
		else {
			pulsado="";
		}
		
	}
}
