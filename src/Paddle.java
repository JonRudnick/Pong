/*author: Jonathan Rudnick
 * description: A paddle class that will draw a rectangluar paddle in an applet
 */
import java.awt.*;

public class Paddle extends DrawableObject{

	/**
	 * Paddle constructor
	 * initialize a black paddle to be located at (0,0), colored black, and 100 units wide and 20 units high
	 */

	public Paddle() {
		xPosition = 0;
		yPosition = 0;
		width = 100;
		height = 20;
		color = Color.black;
	}

	public void draw(Graphics g){
		//draw the paddle
		g.setColor(color);
		g.fillRect(xPosition, yPosition, width, height);		
	}

	/**
	 * setXPosition -- override this method so mouse is centered on Paddle
	 * @param xPosition
	 */
	public void setXPosition(int xPosition) {
		this.xPosition = xPosition - width/2;
	}
}