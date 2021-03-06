// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package mp2.ng.hw.Battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mp2.ng.hw.Battleship.Field;
import mp2.ng.hw.Battleship.Player;
import mp2.ng.hw.Battleship.Player.Point;

/************************************************************/
/**
 * 
 */
//class A{
//	void m(){
//		System.out.println(a);
//	}
//}
public class Game {
	/**
	 * 
	 */
	private Field field1;
	private Field field2;
	
	private Player player1;
	private Player player2;
	
	private Player currentPlayer;
	private Field currentField;
	private Field.Target target = null;
	
	
	public void initGame(){
		field1 = new Field();
		field2 = new Field();
		
		player1 = new PC("pc1");
		player2 = new PC("pc2");
		
		// PC vs PC
		currentPlayer = player1;
		currentField = field2;
		
		field1.populate();
		field2.populate();
	}
	void nextPlayer(){
		if(currentPlayer == player1){
			currentPlayer = player2;
			currentField = field1;
		}else{
			currentPlayer = player1;
			currentField = field2;
		}
		
	}
	
	public void startGame(){
		//choose who's first
		Random random = new Random();
		if(random.nextBoolean())
			nextPlayer();
		
		Point point;
		do{
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {}

			point = currentPlayer.makeShot();
			target = currentField.surviveBombardment(point.x, point.y);
			System.out.println(currentPlayer.name  +" " + point.x +" " + point.y);
			
			
			currentPlayer.setResult(target.toString());
			currentPlayer.updateEnemyView(currentField.renderForEnemy());
			if(target == Field.Target.MISS)
				nextPlayer();
			else
				System.out.println(currentField.renderForEnemy());

		}while(target != Field.Target.WIN);

		System.out.println("Player " + currentPlayer + "wins" );
	}
	public static void main(String[] args){
		Game game = new Game();
		game.target = Field.Target.MISS;
		game.initGame();
		game.startGame();
	}
}
