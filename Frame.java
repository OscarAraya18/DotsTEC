package InterfazGrafica;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



class Frame extends JFrame{
	public Frame() {
		this.setSize(700, 700);
		this.setLocation(300, 50);
		this.setTitle("Dots");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	
	
		Capa capa1 = new Capa();
		this.add(capa1);
		this.setVisible(true);
	}
}
