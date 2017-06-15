/*author: Jonathan Rudnick
 * description: A ball class that will draw a circular ball in an applet
 */

import java.awt.*;

public class Ball extends DrawableObject {

	private int speed;
	private boolean goingUp;
	private boolean goingLeft;

	/**
	 * Ball constructor
	 * initialize a ball to be located at (100, 100), red, and have a diameter of 20.
	 * speed = 3 and goingUp = true;
	 */
	public Ball() {
		//
		color = Color.red;
		width = 20;
		height = 20;
		speed = 3;
		xPosition = 100;
		yPosition = 100;
		goingUp = true;
	}

	public void draw(Graphics g){
		//draw the paddle
		g.setColor(color);
		g.fillOval(xPosition, yPosition, width, height);		
	}

	public void moveUp() {
		yPosition = yPosition - speed;
	}

	public void moveDown() {
		yPosition = yPosition + speed;
	}

	//Note, you should add moveLeft and moveRight methods
	public void moveLeft() {
		xPosition = xPosition - speed;
	}

	public void moveRight() {
		xPosition = xPosition + speed;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isGoingUp() {
		return goingUp;
	}

	public void setGoingUp(boolean goingUp) {
		this.goingUp = goingUp;
	}

	public boolean isGoingLeft() {
		return goingLeft;
	}

	public void setGoingLeft(boolean goingLeft) {
		this.goingLeft = goingLeft;
	}
}