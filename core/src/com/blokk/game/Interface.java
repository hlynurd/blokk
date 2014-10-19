package com.blokk.game;

public class Interface {
	public float x;
	public float y;
	public float width;
	public float height;
	
	public Interface(float newX, float newY, float newWidth, float newHeight) {
		x = newX;
		y = newY;		
		width = newWidth;
		height = newHeight;
	}
	
	public int isTouched(float touchX, float touchY) {
		float section = width/4;
		if (touchY > y && touchY < y + height) {
			if (touchX > 0 && touchX < section) return 1; // pause slot
			else if (touchX >= section && touchX < 2*section) return 2; // sound on/off slot
			else if (touchX >= 2*section && touchX < 3*section) return 3; // score slot
			else return 4; // current level slot
		}
		return -1;
	}
}
