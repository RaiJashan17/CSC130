package Main;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

import Data.Vector2D;
import logic.Control;
import timer.stopWatchX;

public class Main{
	// Fields (Static) below...
	public static Color custom=new Color(100,40,150);
	public static Boolean isImageDrawn=false;
	public static stopWatchX timer=new stopWatchX(50);
	public static Queue<Vector2D> vecs1=new LinkedList<>();
	public static Queue<Vector2D> vecs2 = new LinkedList<>();
	public static Vector2D currentVec = new Vector2D(-100, -100);
	
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		for(int i=-256; i<1336; i+=8){
			vecs1.add(new Vector2D(i,300));
		}
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		if(isImageDrawn){
			//ctrl.addSpriteToFrontBuffer(1025, 500, "f0"); // Add a tester sprite to render list by tag (Remove later! Test only!)
			ctrl.addSpriteToFrontBuffer(currentVec.getX(), currentVec.getY(), "f1");
			
			//ctrl.drawString(1050, 650, "Jashan Rai", custom);
		}
		//ctrl.drawString(1050, 650, "Jashan Rai", custom);
		// Test drawing text on screen where you want (Remove later! Test only!)
		if(timer.isTimeUp()){
			currentVec=vecs1.peek();
			vecs2.add(vecs1.remove());
			if(vecs1.isEmpty()==true){
				while(vecs2.isEmpty()==false){
					vecs1.add(vecs2.remove());
				}
				}
			isImageDrawn=!isImageDrawn;
			timer.resetWatch();
		}
	}
	
	// Additional Static methods below...(if needed)

}
