import javafx.scene.shape.Rectangle;

/*
 * 
 * The following class represents the blocks (body) of the snake.
 *
 */
public class Blocks extends Rectangle {
	
	/*
	 * Global variables for directions of the snake.
	 * @Up Snake going up the field.
	 * @Right Snake going right on field.
	 * @Down Snake going down the field.
	 * @Left Snake going left on field.
	 */
	static final int Up = 0, Right = 1, Down = 2, Left = 3;
	
	/*
	 * Variables for the positions of the snake on the field. 
	 */
	int posX, posY, oldPosX, oldPosY;
	
	Blocks previous;
	
	int direction = Left;
	
	int maxX, maxY;
	
	/*
	 * The following method is a Constructor for the blocks class. This includes a super from the UI class. 
	 */
	public Blocks(int x, int y, Blocks p, SnakeField f) {
		super(UserInterface.blockSize, UserInterface.blockSize);
		posX = x;
		posY = y;
		
		setTranslateX(posX * UserInterface.blockSize);
		setTranslateY(posY * UserInterface.blockSize);
		
		previous = p;
		
		maxX = f.getW();
		maxY = f.getH();
	}
	
	/*
	 * This method updates the snakes position through the use of cases.
	 * Each key pressed to move the snakes direction does accordingly. 
	 */
	public void update() {
		oldPosX = posX;
		oldPosY = posY;
		
		if(previous == null) {
			switch(direction) {
			case Up: 
				moveUp(); 
				break;
			
			case Right: 
				moveRight(); 
				break;
			
			case Down: 
				moveDown(); 
				break;
			
			case Left: 
				moveLeft(); 
				break;
			}
		} else {
			posX = previous.oldPosX;
			posY = previous.oldPosY;
		}
		updatePosition();
	}
	
	/*
	 * The following method allows the snake to move within the border. 
	 * In this case, the snake is able to move up the field.
	 */
	public void moveUp() {
		posY--;
		if (posY < 0) {
			posY = maxY - 1;
		}
	}
	
	/*
	 * The following method allows the snake to move within the border. 
	 * In this case, the snake is able to move down the field.
	 */
	public void moveDown() {
		posY++;
		if (posY >= maxY) {
			posY = 0;
		}
	}
	
	/*
	 * The following method allows the snake to move within the border. 
	 * In this case, the snake is able to move left the field.
	 */
	public void moveLeft() {
		posX--;
		if (posX < 0) {
			posX = maxX - 4;
		}
	}
	
	/*
	 * The following method allows the snake to move within the border. 
	 * In this case, the snake is able to move right the field.
	 */
	public void moveRight() {
		posX++;
		if (posX >= maxX) {
			posX = 0;
		}
	}

	/*
	 * The updatePosition method updates the snakes body.
	 */
	public void updatePosition() {
		setTranslateX(posX * UserInterface.blockSize);
		setTranslateY(posY * UserInterface.blockSize);
	}
	
	
	
	
	
	
	
	
}
