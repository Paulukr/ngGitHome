// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package mp2.ng.hw.Battleship;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import mp2.ng.hw.Battleship.Cell;

/************************************************************/
/**
 * 
 */
public class Ship {
	private int size;
	Deque<Cell> cells;
	List<Cell> surround;
	private int hp;
	public Ship(int shipSize) {
		size = shipSize;
		hp = shipSize;
		cells = new ArrayDeque<>();
		surround = new ArrayList<>();
	}
	public boolean surviveBombardment(Cell cell){
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