import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
 * The following class represents the food of the snake.
 */
public class SnakeFood extends Rectangle {
	
	/*
	 * Global variables for position of food.
	 * @param posX position of food on x axis.
	 * @param posY position of food on y axis.
	 */
	int posX, posY;
	
	/*
	 * Getter method for position x of food.
	 */
	public int getPosX() {
		return posX;
	}

	/*
	 * Getter method for position y of food.
	 */
	public int getPosY() {
		return posY;
	}

	/*
	 * The following method is a constructor for the SnakeFood class. 
	 * The SnakeFood is filled with the colour light green.
	 */
	public SnakeFood(int x, int y) {
		super(UserInterface.blockSize, UserInterface.blockSize);
		
		posX = x;
		posY = y;
		
		setTranslateX(posX * UserInterface.blockSize);
		setTranslateY(posY * UserInterface.blockSize);
		
		setFill(Color.LIGHTGREEN);
		setStroke(Color.GREEN);
		
		
	}

}
