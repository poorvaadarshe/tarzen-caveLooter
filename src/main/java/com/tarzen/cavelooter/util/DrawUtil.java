package com.tarzen.cavelooter.util;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DrawUtil extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Define constants
	   public static final int CANVAS_WIDTH  = 640;
	   public static final int CANVAS_HEIGHT = 480;
	 
	   // Declare an instance of the drawing canvas,
	   // which is an inner class called DrawCanvas extending javax.swing.JPanel.
	   private DrawCanvas canvas;
	 
	   // Constructor to set up the GUI components and event handlers
	   public DrawUtil() {
	      canvas = new DrawCanvas();    // Construct the drawing canvas
	      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
	 
	      // Set the Drawing JPanel as the JFrame's content-pane
	      Container cp = getContentPane();
	      cp.add(canvas);
	      // or "setContentPane(canvas);"
	 
	      setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // Handle the CLOSE button
	      pack();              // Either pack() the components; or setSize()
	      setTitle("CaveLooterGame");  // "super" JFrame sets the title
	      setVisible(true);    // "super" JFrame show
	   }
	 
	   /**
	    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
	    */
	   private class DrawCanvas extends JPanel {
	      // Override paintComponent to perform your own painting
	      @Override
	      public void paintComponent(Graphics g) {
	         super.paintComponent(g);     // paint parent's background
	         setBackground(Color.BLACK);  // set background color for this JPanel
	 
	         // Your custom painting codes. For example,
	         // Drawing primitive shapes
	         g.setColor(Color.YELLOW);    // set the drawing color
	         g.drawOval(50, 90, 15, 15);
	         g.drawLine(60, 105, 75, 125);
	         g.drawLine(55, 105, 45, 125);
	         g.drawLine(45, 125, 75, 125);
	         g.drawLine(55,125,55,150);
	         g.drawLine(65,125,65,150);
	         
	         g.drawLine(30, 40, 600, 40);
	         g.drawLine(30, 150, 600, 150);
	         g.fillRect(90, 40, 20, 110);
	         g.fillRect(290, 40, 20, 110);
	         g.fillRect(490, 40, 20, 110);
	         
	         g.setColor(Color.YELLOW);       
	         g.fillOval(150, 90, 50, 50);
	         g.setColor(Color.RED);
	         g.fillOval(160, 80, 35, 10);
	         g.setFont(new Font("Monospaced", Font.BOLD, 20));
	         g.drawString("$$", 165, 130);
	         //2
	         g.setColor(Color.YELLOW);       
	         g.fillOval(340, 90, 50, 50);
	         g.setColor(Color.RED);
	         g.fillOval(350, 80, 35, 10);
	         g.setFont(new Font("Monospaced", Font.BOLD, 20));
	         g.drawString("$$", 355, 130);
	         //3
	         g.setColor(Color.YELLOW);       
	         g.fillOval(540, 90, 50, 50);
	         g.setColor(Color.RED);
	         g.fillOval(550, 80, 35, 10);
	         g.setFont(new Font("Monospaced", Font.BOLD, 20));
	         g.drawString("$$", 555, 130);
	         
	        
	         g.drawString("Cave Looter Game App ...", 10, 20);
	      }
	   }
	 
	   // The entry main method
	   public static void main(String[] args) {
	      // Run the GUI codes on the Event-Dispatching thread for thread safety
	      SwingUtilities.invokeLater(new Runnable() {
	         @Override
	         public void run() {
	            new DrawUtil(); // Let the constructor do the job
	         }
	      });
	   }
}
