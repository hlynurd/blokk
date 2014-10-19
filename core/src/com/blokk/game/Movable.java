package com.blokk.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

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
	
	public void update(float dy) {
		if (stationary) return;
		
		y -= 1000*dy;
	}
	
	public boolean intersects(Movable m) {
		if (x < (m.x + m.width) && (x + width) > m.x && (y + height) > m.y && y < (m.y + m.height)) return true;
		else if (y < 0) {
			y = 0;
			return true;
		}
		return false;
	}
	
//	private Texture createType() {
//		stationary = false;
//		
//		if (typeOne && typeTwo) return square;
//		else if (!typeOne && typeTwo) return triangle;
//		else if (typeOne && !typeTwo) return circle;
//		else return ex;
//	}
	
	private boolean randomizeType() {
		boolean type = false;
		
		if (Math.random() < 0.5) type = true;
		
		return type;
	}
	
//	private Boolean randomizeType_B() {
//		Boolean type = false;
//		
//		if (Math.random() < 0.5) type = true;
//		
//		return type;
//	}
	
	private int randomizeSlot() {
		return MathUtils.random(0, 6);
	}
}
