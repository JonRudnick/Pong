/*author: Jonathan Rudnick
 *description: starting point for applet animation
 *proposed points: 5, assuming this lab is worth five points
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Pong extends JApplet implements Runnable 
{
	private Ball ball;					// Ball object
	private Paddle paddle;				// Paddle object

	//private variables for app & animation
	private Thread runner = null;
	final private int WIDTH  = 400;
	final private int HEIGHT = 400;
	private Image    image;
	private Graphics graphics;

	public void init()
	{
		//create ball and paddle object
		ball = new Ball();
		paddle = new Paddle();
		ball.setColor(Color.blue);
		paddle.setColor(Color.red);
		paddle.setYPosition(HEIGHT - 20); //paddle is at bottom of screen

		image    = createImage( WIDTH, HEIGHT );
		graphics = image.getGraphics();

		//register mouse motion listener
		addMouseMotionListener(new MyMouseMotionListener());

		setSize(WIDTH,HEIGHT);
	} //end of init method

	public void start() {
		// Create a new thread -- DON'T TOUCH THIS METHOD
		if ( runner == null ) {
			runner = new Thread( this );
			runner.start();
		}
	}

	public void run() {
		//refresh the screen -- DON'T TOUCH THIS METHOD
		while (runner != null) {
			repaint();
			try {
				Thread.sleep( 20 );
			} catch ( InterruptedException e ) {
				// do nothing
			}
		}
	}

	public void paint( Graphics g ) {
		// clear the background to white -- THESE SHOULD BE THE FIRST 3 LINES IN THIS METHOD
		graphics.setColor( Color.white ); // THESE SHOULD BE THE FIRST 3 LINES IN THIS METHOD
		graphics.fillRect( 0, 0, WIDTH, HEIGHT ); //THESE SHOULD BE THE FIRST 3 LINES IN THIS METHOD

		// Update the ball's Y coordinate.
		if (ball.isGoingUp() == true) {
			if (ball.getYPosition() > 0 ){
				ball.moveUp();
			}
			else {
				//ball hits top of applet

				float randomRed = (float) Math.random();
				float randomGreen = (float) Math.random();
				float randomBlue = (float) Math.random();
				
				//create a new Color 
				Color myRandomColor = new Color(randomRed, randomGreen, randomBlue); 
				//set ball to the random color 
				ball.setColor(myRandomColor);
				ball.setGoingUp(false);
			}
		}
		else {
			//going down

			/* PUT COLLISION DETECTION CODE HERE
			 * SEE CLASS NOTES*/
			if (ball.getYPosition() + ball.getHeight() < HEIGHT){
				ball.moveDown(); 
			}
			else {
				//hits the bottom

				float randomRed = (float) Math.random();
				float randomGreen = (float) Math.random();
				float randomBlue = (float) Math.random();
				
				//create a new Color 
				Color myRandomColor = new Color(randomRed, randomGreen, randomBlue); 
				//set ball to the random color 
				ball.setColor(myRandomColor);
				ball.setGoingUp(true);
			}

		}// end of goingUp if statement
		
		//add code here to update the ball's X coordinate
		if (ball.isGoingLeft() == true) {
			//going left
			if (ball.getXPosition() > 0) {
				ball.moveLeft();
			}
			else {
				//hits the left

				float randomRed = (float) Math.random();
				float randomGreen = (float) Math.random();
				float randomBlue = (float) Math.random();
				
				//create a new Color 
				Color myRandomColor = new Color(randomRed, randomGreen, randomBlue); 
				//set ball to the random color 
				ball.setColor(myRandomColor);
				ball.setGoingLeft(false);
			}
		}
		else {
			//going right
			if (ball.getXPosition() < WIDTH - ball.getWidth()) {
				ball.moveRight();
			}
			else {
				//hits the right

				float randomRed = (float) Math.random();
				float randomGreen = (float) Math.random();
				float randomBlue = (float) Math.random();
				
				//create a new Color 
				Color myRandomColor = new Color(randomRed, randomGreen, randomBlue); 
				//set ball to the random color 
				ball.setColor(myRandomColor);
				ball.setGoingLeft(true);
			}
		}

		//draw boundary box
		graphics.setColor(Color.black);  
		graphics.drawRect(0,0,WIDTH-1,HEIGHT-1);

		//draw paddle and ball
		paddle.draw(graphics);
		ball.draw(graphics);

		// copy buffer to screen -- THESE SHOULD BE THE LAST 2 LINES IN THIS METHOD
		g.drawImage( image, 0, 0, this ); // THESE SHOULD BE THE LAST 2 LINES IN THIS METHOD
	}


	private class MyMouseMotionListener implements MouseMotionListener {

		//set x position of mouse to be centered on rectangle
		public void mouseMoved(MouseEvent e) {
			paddle.setXPosition(e.getX());
		}

		public void mouseDragged(MouseEvent e) {
			//not implemented
		}
	}


} //end of Pong class