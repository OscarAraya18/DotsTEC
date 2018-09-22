package Juego.Pack;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Oscar Araya y Agustín Venegas
 * Clase que desarrolla el juego.
 */
public class Juego extends JFrame{
	public Juego() {
		setTitle("TEC Dots"); 
		setSize(500,700);
		//Frame
		Matriz_puntos puntos=new Matriz_puntos();
		initComponents();
		add(puntos);
	}
	/**
	 * Se crean las dimensiones del juego, el título, y se llama a la clase Matriz_puntos que crea los puntos
	 */
	public static void main(String[] args) {
		Juego matriz=new Juego();
		matriz.setVisible(true);
	}
	/**
	 * Se crea un main en el cual se llama a la clase principal y se hace visible la interfaz.
	 */
	
	ArrayList<Point> lista = new ArrayList<Point>();
	/**
	 * @param evt , obtiene y guarda el evento realizado de cuando el mouse es presionado. 
	 */
	public void mousePressed(java.awt.event.MouseEvent evt) {
        formMousePressed(evt);
    }
	private void formMousePressed(java.awt.event.MouseEvent evt) {
	 
	    Graphics2D g = (Graphics2D)this.getGraphics();
	    g.setStroke(new BasicStroke((float) 5.0));
	    
	    lista.add(new Point(evt.getX(), evt.getY()));
	
	    System.out.println("El punto y es " + evt.getY());
	    System.out.println("El punto x es " + evt.getX());
	/**
	 * Cuando el mouse es presionado, este método imprime las posiciones en el eje x y el eje y de el cursor
	 */
	 
	    
//-----------------------------------------------------------------------------------------------------------------------------------------	    
	    	
	    if(lista.size()>1){
	    	int puntoX1 = lista.get(lista.size()-2).x;
	    	int puntoY1 = lista.get(lista.size()-2).y;
	    	int puntoX2 = lista.get(lista.size()-1).x;
	    	int puntoY2 = lista.get(lista.size()-1).y;
	    	
	    	g.setColor(Color.GREEN);
	    /**
	     * Si el tamaño de la lista es mayor que uno, se asignan valores de puntos "x1", "x2", "y1" y "y2".
	     * Se le da color a la línea que será dibujada posteriormente.
	     */
	//-----------------------------------------------------------------------------------------------------------//    	
	    	 if(puntoX1>=35 && puntoX1<=50 && puntoY1>110 && puntoY1<=125) {
	    		 if(puntoX2>=135 && puntoX2<=150 && puntoY2>110 && puntoY2<=125) {
	    			 g.drawLine(42,116, 142, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=210 && puntoY2<=225){
	    			 g.drawLine(42,116, 142, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(42,116, 42, 212);
	    			 lista.clear();
	    		 }
	    	 }
	    	 	    	 
	    	 else if(puntoX1>=135 && puntoX1<=150 && puntoY1>110 && puntoY1<=125) {
	    		 if(puntoX2>=35 && puntoX2<=50 && puntoY2>110 && puntoY2<=125) {
	    			 g.drawLine(142,116, 42, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=210 && puntoY2<=225){
	    			 g.drawLine(142,116, 42, 215);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(142,116, 142, 212);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(142,116, 42, 212);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=110 && puntoY2<=125) {
	    			 g.drawLine(142,116, 242, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(142,116, 242, 215);
	    			 lista.clear();
	    		 }
	    	 }
	   	 
	    	 else if(puntoX1>=235 && puntoX1<=250 && puntoY1>=110 && puntoY1<=125) {
	    		 if(puntoX2>=135 && puntoX2<=150 && puntoY2>110 && puntoY2<=125) {
	    			 g.drawLine(242,116, 143, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>110 && puntoY2<=125) {
	    			 g.drawLine(242,116, 342, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>210 && puntoY2<=225) {
	    			 g.drawLine(242,116, 342, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>210 && puntoY2<=225) {
	    			 g.drawLine(242,116, 242, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>210 && puntoY2<=225) {
	    			 g.drawLine(242,116, 142, 216);
	    			 lista.clear();
	    		 }
	    	 }
	    	 
	    	 else if(puntoX1>=335 && puntoX1<=350 && puntoY1>=110 && puntoY1<=125) {
	    		 if(puntoX2>=235 && puntoX2<=250 && puntoY2>110 && puntoY2<=125) {
	    			 g.drawLine(342,116, 242, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>210 && puntoY2<=225) {
	    			 g.drawLine(342,116, 242, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>210 && puntoY2<=225) {
	    			 g.drawLine(342,116, 342, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=435 && puntoX2<=450 && puntoY2>110 && puntoY2<=125) {
	    			 g.drawLine(342,116, 442, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=435 && puntoX2<=450 && puntoY2>210 && puntoY2<=225) {
	    			 g.drawLine(342,116, 442, 216);
	    			 lista.clear();
	    		 }
	    	 }
	    	 else if(puntoX1>=435 && puntoX1<=450 && puntoY1>110 && puntoY1<=125) {
	    	 	 if(puntoX2>=335 && puntoX2<=350 && puntoY2>110 && puntoY2<=125) {
	    	 		 g.drawLine(442,116,342, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=210 && puntoY2<=225){
	    			 g.drawLine(442,116, 342, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(442,116, 442, 216);
	    			 lista.clear();
	    		 }
	    	 }
	   //-------------------------------------------------------------------------------------------------------//
	    	 else if(puntoX1>=35 && puntoX1<=50 && puntoY1>210 && puntoY1<=225) {
	    		 if(puntoX2>=35 && puntoX2<=50 && puntoY2>110 && puntoY2<=125) {
	    			 g.drawLine(42, 216, 42, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=110 && puntoY2<=125){
	    			 g.drawLine(42, 216, 142, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(42, 216, 142, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(42, 216, 142, 316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(42, 216, 42,316);
	    			 lista.clear();
	    		 }
	    	 }
	    	 else if(puntoX1>=135 && puntoX1<=150 && puntoY1>210 && puntoY1<=225) {
	    		 if(puntoX2>=35 && puntoX2<=50 && puntoY2>110 && puntoY2<=125) {
	    			 g.drawLine(142, 216, 42, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=110 && puntoY2<=125){
	    			 g.drawLine(142, 216, 142, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=110 && puntoY2<=125) {
	    			 g.drawLine(142, 216, 242, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(142, 216, 242, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(142, 216, 242,316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(142, 216, 142,316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(142, 216, 42,316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(142, 216, 42,216);
	    			 lista.clear();
	    		 }
	    	 }
	    	 else if(puntoX1>=235 && puntoX1<=250 && puntoY1>210 && puntoY1<=225) {
	    		 if(puntoX2>=135 && puntoX2<=150 && puntoY2>110 && puntoY2<=125) {
	    			 g.drawLine(242, 216, 142, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=110 && puntoY2<=125){
	    			 g.drawLine(242, 216, 242, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=110 && puntoY2<=125) {
	    			 g.drawLine(242, 216, 342, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(242, 216, 342, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(242, 216, 342,316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(242, 216, 242,316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(242, 216, 142,316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(242, 216, 142,216);
	    			 lista.clear();
	    		 }
	    	 }
	    	 else if(puntoX1>=335 && puntoX1<=350 && puntoY1>210 && puntoY1<=225) {
	    		 if(puntoX2>=235 && puntoX2<=250 && puntoY2>110 && puntoY2<=125) {
	    			 g.drawLine(342, 216, 242, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=110 && puntoY2<=125){
	    			 g.drawLine(342, 216, 342, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=110 && puntoY2<=125) {
	    			 g.drawLine(342, 216, 442, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(342, 216, 442, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(342, 216, 442,316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(342, 216, 342,316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(342, 216, 242,316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(342, 216, 242,216);
	    			 lista.clear();
	    		 }
	    	 }
	    	 else if(puntoX1>=435 && puntoX1<=450 && puntoY1>210 && puntoY1<=225) {
	    		 if(puntoX2>=435 && puntoX2<=450 && puntoY2>110 && puntoY2<=125) {
	    			 g.drawLine(442, 216, 442, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=110 && puntoY2<=125){
	    			 g.drawLine(442, 216, 342, 116);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(442, 216, 342, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(442, 216, 342, 316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(442, 216, 442,316);
	    			 lista.clear();
	    		 }
	    	 }
	    //----------------------------------------------------------------------------------------------------------//
	    	 else if(puntoX1>=35 && puntoX1<=50 && puntoY1>310 && puntoY1<=325) {
	    		 if(puntoX2>=35 && puntoX2<=50 && puntoY2>210 && puntoY2<=225) {
	    			 g.drawLine(42, 316, 42, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=210 && puntoY2<=225){
	    			 g.drawLine(42, 316, 142, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(42, 316, 142, 316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=410 && puntoY2<=425) {
	    			 g.drawLine(42, 316, 142, 416);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=410 && puntoY2<=425) {
	    			 g.drawLine(42, 316, 42,416);
	    			 lista.clear();
	    		 }
	    	 }
	    	 else if(puntoX1>=135 && puntoX1<=150 && puntoY1>310 && puntoY1<=325) {
	    		 if(puntoX2>=35 && puntoX2<=50 && puntoY2>210 && puntoY2<=225) {
	    			 g.drawLine(142, 316, 42, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=210 && puntoY2<=225){
	    			 g.drawLine(142, 316, 142, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(142, 316, 242, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(142, 316, 242, 316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=410 && puntoY2<=425) {
	    			 g.drawLine(142, 316, 242, 416);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=410 && puntoY2<=425) {
	    			 g.drawLine(142, 316, 142, 416);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=410 && puntoY2<=425) {
	    			 g.drawLine(142, 316, 42, 416);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=35 && puntoX2<=50 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(142, 316, 42, 316);
	    			 lista.clear();
	    		 }
	    	 }
	    	 else if(puntoX1>=235 && puntoX1<=250 && puntoY1>310 && puntoY1<=325) {
	    		 if(puntoX2>=135 && puntoX2<=150 && puntoY2>210 && puntoY2<=225) {
	    			 g.drawLine(242, 316, 142, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=210 && puntoY2<=225){
	    			 g.drawLine(242, 316, 242, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(242, 316, 342, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(242, 316, 342, 316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=410 && puntoY2<=425) {
	    			 g.drawLine(242, 316, 342, 416);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=410 && puntoY2<=425) {
	    			 g.drawLine(242, 316, 242, 416);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=410 && puntoY2<=425) {
	    			 g.drawLine(242, 316, 142, 416);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=135 && puntoX2<=150 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(242, 316, 142, 316);
	    			 lista.clear();
	    		 }
	    	 }
	    	 else if(puntoX1>=335 && puntoX1<=350 && puntoY1>310 && puntoY1<=325) {
	    		 if(puntoX2>=235 && puntoX2<=250 && puntoY2>210 && puntoY2<=225) {
	    			 g.drawLine(342, 316, 242, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=210 && puntoY2<=225){
	    			 g.drawLine(342, 316, 342, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=210 && puntoY2<=225) {
	    			 g.drawLine(342, 316, 442, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(342, 316, 442, 316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=410 && puntoY2<=425) {
	    			 g.drawLine(342, 316, 442,416);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=410 && puntoY2<=425) {
	    			 g.drawLine(342, 316, 342,416);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=410 && puntoY2<=425) {
	    			 g.drawLine(342, 316, 242,416);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=235 && puntoX2<=250 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(342, 316, 242,316);
	    			 lista.clear();
	    		 }
	    	 }
	    	 else if(puntoX1>=435 && puntoX1<=450 && puntoY1>310 && puntoY1<=325) {
	    		 if(puntoX2>=435 && puntoX2<=450 && puntoY2>210 && puntoY2<=225) {
	    			 g.drawLine(442, 316, 442, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=210 && puntoY2<=225){
	    			 g.drawLine(442, 316, 342, 216);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=310 && puntoY2<=325) {
	    			 g.drawLine(442, 316, 342, 316);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=335 && puntoX2<=350 && puntoY2>=410 && puntoY2<=425) {
	    			 g.drawLine(442, 316, 342, 416);
	    			 lista.clear();
	    		 }
	    		 else if(puntoX2>=435 && puntoX2<=450 && puntoY2>=410 && puntoY2<=425) {
	    			 g.drawLine(442, 316, 442,416);
	    			 lista.clear();
	    		 }
	    	 }
	    }
	    /**
	     * Se especifican todas las posibles lineas que se pueden trazar en el tablero
	     */
	    	 
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
	    }
	    
	/**
	 * Se crea un método llamado initComponents para escuchar el comportamiento de un botón. 
	 */
	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
	                formMousePressed(evt);
	            }
	        });
		}
	/**
	 * @author Oscar Araya
	 * Se crea la clase Matriz que dibuja los puntos en una interfaz
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
}