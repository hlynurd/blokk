package com.blokk.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

/**
 * @author     Ottar og Þorsteinn. Edit by Hlynur
 * @version     1.0a                 Alpha
 * @since       2014-10-10        
 */
public class Movable{
	public Boolean typeOne;
	public boolean typeTwo;
	public int col;
	public int row;
	public Texture type;
	public boolean stationary;
	public float speed;
	public float x;
	public float y;
	public float width;
	public float height;
	public boolean isMovable;
	
    /**	
    *Constructs ablock, i.e. Movable
    * @param isMovable A boolean which decides if the block is movable by the user
    */
	public Movable(boolean isMovable) {
		col = randomizeSlot();
		stationary = false;
		
		if (isMovable) {
			typeOne = randomizeType();
			typeTwo = randomizeType();
//			type = createType();
		}
		else {
			typeOne = null;
//			type = black;
		}
	}
	
	/**
	*Constructs a block, i.e. Movable 
	* @param Movable m A Movable block which is cloned 
	*/
	public Movable(Movable m) {
		typeOne = m.typeOne;
		typeTwo = m.typeTwo;
		col = m.col;
		row = m.row;
		type = m.type;
		stationary = m.stationary;
		speed = m.speed;
		x = m.x;
		y = m.y;
		width = m.width;
		height = m.height;
		isMovable = m.isMovable;
	}
	
	/**
 	*Takes the delta time so we can update the entity to correspond to the input of the gameloop
 	* @param dy is the delta time of each frame rendered
 	*/
	public void update(float dy) {
		if (stationary) return;
		
		y -= 1000*dy;
	}
	
	/**
 	*  Returns true if a block is intersecting with another Movable block or the ground
 	* @param Movable m is the Movable block being checked for collision
 	*/
	public boolean intersects(Movable m) {
		if (x < (m.x + m.width) && (x + width) > m.x && (y + height) > m.y && y < (m.y + m.height)) return true;
		else if (y < 0) {
			y = 0;
			return true;
		}
		return false;
	}
	
	/**
 	*  A function for randoming the types of the Movable blocks, each being a combination of two booleans
 	*/
	private boolean randomizeType() {
		boolean type = false;
		
		if (Math.random() < 0.5) type = true;
		
		return type;
	}

	/**
 	* A function for randomizing the column where the Movable block should be spawned
 	*/
	private int randomizeSlot() {
		return MathUtils.random(0, 6);
	}
}