import java.util.ArrayList;

import javafx.scene.paint.Color;

/*
 * The following class is for the snake itself. 
 * The blocks of the snake are placed into an array list. 
 * 
 * @param head Snakes head. 
 * @param tail Snakes body, or tail. 
 */
public class Snake {
	
	ArrayList <Blocks> block = new ArrayList<Blocks>();
	
	Blocks head;
	Blocks tail;
	
	/*
	 * The Snake method takes parameters of the initial length and SnakeField.
	 * The snake initial position on the field is defined by the following parameters. 
	 * @param ipx initial position from x axis.
	 * @param ipy initial position from y axis. 
	 * 
	 * The head of the snake is created as a new block with the given parameters ipx, ipy, null and field. 
	 * 
	 * Colour of the head is separate from the body. 
	 * 
	 */
	public Snake(int il, SnakeField f) {
		int ipx = f.getW() / 2;
		int ipy = f.getH() / 2;
		
		head = new Blocks(ipx, ipy, null, f);
		block.add(head);
		
		head.setFill(Color.BROWN.desaturate());
		
		tail = head;
		
		for(int i = 1; i < il; i++) {
			Blocks b = new Blocks(ipx + i, ipy, tail, f);
			block.add(b);
			tail = b;
		}
	}
	
	/*
	 * The getDirection method returns the head of the snakes direction. 
	 */
	public int getDirection() {
		return head.direction;
	}
	
	/*
	 * The setDirection method takes the parameter direction. 
	 * The snakes head direction is equal to the direction in general. 
	 */
	public void setDirection(int d) {
		head.direction = d;
	}
	
	

}
