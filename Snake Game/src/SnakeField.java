import java.util.ArrayList;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/*
 * This class represents the SnakeField for the game.
 * 
 * The snake body, or tail is within an ArrayList. 
 * @param w width of the window. 
 * @param h height of the window. 
 * @param score game score.
 * @param sf SnakeFood. 
 * @param Snake Players snake.
 */
public class SnakeField extends Pane{
	
	private int w, h;
	
	ArrayList <Blocks> block = new ArrayList<Blocks>();
	int score = 0;
	SnakeFood sf;
	Snake snake;
	
	/*
	 * The SnakeField method initialises the SnakeField window.
	 */
	public SnakeField(int width, int height) {
		w = width;
		h = height;
		
		setMinSize(w * UserInterface.blockSize, h * UserInterface.blockSize);
		setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1) )));
		
		addSnakeFood();
		
	}
	
	/*
	 * The addSnake method adds a block on to the snake. 
	 */
	public void addSnake(Snake s) {
		snake = s;
		for(Blocks b:s.block) {
			addBlock(b);
		}
	}
	
	/*
	 * The update method updates the snakes block when consuming the snake food. 
	 */
	public void update() {
		for (Blocks b:block) {
			b.update();
		}
		if (isEaten(sf)) {
			score += 10;
			addSnakeFood();
			
			// Adding new block to tail
			addNewBlock();
			
		}
	}
	
	/*
	 * The isDead method indicates whether the snake is dead, which essentially means the end of game. 
	 * This only happens when the snake hits its own body or tail.
	 */
	public boolean isDead() {
		for (Blocks b:block) {
			if (b != snake.head) {
				if (b.oldPosX == snake.head.oldPosX && b.oldPosY == snake.head.oldPosY) {
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * The addNewBlock method adds a new block to the tail of the snake.
	 * Essentially, elongating the tail of the snake during the game.
	 */
	public void addNewBlock() {
		Blocks b = new Blocks(snake.tail.oldPosX, snake.tail.oldPosY, snake.tail, this);
		snake.tail = b;
		addBlock(b);
	}
	
	private void addBlock(Blocks b) {
		getChildren().add(b);
		block.add(b);
	}
	
	/*
	 * The addSnakeFood method populates the snakeField with snakeFood randomly.
	 * The snakeFood only comes once in between the snake eating it.
	 */
	public void addSnakeFood() {
		int randomX = (int) (Math.random() * w);
		int randomY = (int) (Math.random() * h);
		
		SnakeFood food = new SnakeFood(randomX, randomY);
		getChildren().add(food);
		getChildren() .remove(sf);
		sf = food;
	}
	
	/*
	 * This isEaten is a boolean method. It essentially determines whether the snake has eaten
	 * the food or not. 
	 */
	public boolean isEaten(SnakeFood sf) {
		if (sf == null) {
			return false;
		}
		return sf.getPosX() == snake.head.posX && sf.getPosY() == snake.head.posY;
	}

	/*
	 * the getW method returns the width of the window.
	 */
	public int getW() {
		return w;
	}

	/*
	 * The getH method returns the height of the window. 
	 */
	public int getH() {
		return h;
	}

}
