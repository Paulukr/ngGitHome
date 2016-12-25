// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package mp2.ng.hw.hw4.Battleship;

import java.util.ArrayDeque;
import java.util.Deque;

/************************************************************/
/**
 * 
 */
public class Ship {
	private int size;
	Deque<Cell> cells;
	Deque<Cell> surround;
	private int hp;
	public Ship(int shipSize) {
		size = shipSize;
		hp = shipSize;
		cells = new ArrayDeque<>();
		surround = new ArrayDeque<>();
	}
	public boolean surviveBombardment(Cell cell){
		for(Cell c:cells){
			System.out.println(c);
		}
		cell.removeShip();
		cell.setWasShip();
		if(--hp > 0)
			return true;
		else{
			surround.forEach(Cell::beenBombed);
			cells = null;//TODO weak reference
			surround = null;
			return false;
		}
	}
	/**
	 * 
	 */
	public int getSize() {
		return size;
	}
};