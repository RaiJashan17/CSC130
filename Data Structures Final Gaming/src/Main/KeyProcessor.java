/* This will handle the "Hot Key" system. */

package Main;

import logic.Control;
import timer.stopWatchX;

public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			// For debouncing purposes
	private static stopWatchX sw = new stopWatchX(250);
	
	// Static Method(s)
	public static void processKey(char key){
		if(key == ' '){
			Main.movement=false;
			return;
		}
		// Debounce routine below...
		if(key == last)
			if(sw.isTimeUp() == false)			return;
		last = key;
		sw.resetWatch();
		
		/* TODO: You can modify values below here! */
		switch(key){
		case 'w':
			Main.movement=true;
			Main.trigger="up";
			Main.raw="";
			break;
		case 'a':
			Main.movement=true;
			Main.trigger="left";
			Main.raw="";
			break;
		case '%':								// ESC key
			System.exit(0);
			break;
		case 'd':
			Main.movement=true;
			Main.trigger="right";
			Main.raw="";
			break;
		case 't':
			Main.trigger="t is triggered";
			break;
		case 'u':
			Main.trigger="u is triggered";
			break;
		case '$':
			if(Main.box1.isCollision(Main.box1, Main.box2)==true){
				Main.raw="string3";
			}
			break;
		case 's':
			Main.movement=true;
			Main.trigger="down";
			Main.raw="";
			break;
		case 'm':
			// For mouse coordinates
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			break;
		}
	}
}