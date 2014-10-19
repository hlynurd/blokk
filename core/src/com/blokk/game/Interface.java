package com.blokk.game;

public class Interface {
	public float x;
	public float y;
	public float width;
	public float height;
	
	/**
 	*  Constructs a user Interface 
 	* @param float newX is the Interface’s lower-left x co-ordinate
 	* @param float newY is the Interface’s upper-left y co-ordinate
 	* @param float newWidth is the Interface’s width
 	* @param float newHeight is the Interface’s height
 	*/
	public Interface(float newX, float newY, float newWidth, float newHeight) {
		x = newX;
		y = newY;		
		width = newWidth;
		height = newHeight;
	}
	
	/**
 	*  Returns an integer based on where the user is touching the Interface
 	* @param float touchX is the x co-ordinate of the touch
 	* @param float touchY is the y co-ordinate of the touch
 	*/
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