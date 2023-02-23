package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Data.Vector2D;
import Data.spriteInfo;
import logic.Control;
import timer.stopWatchX;

public class Main{
	// Fields (Static) below...
	public static Color custom=new Color(100,40,150);
	public static Boolean isImageDrawn=false;
	public static stopWatchX timer=new stopWatchX(25);
	public static Queue<Vector2D> vecs1=new LinkedList<>();
	public static Queue<Vector2D> vecs2 = new LinkedList<>();
	public static Vector2D currentVec = new Vector2D(-100, -100);
	public static ArrayList<spriteInfo> sprites=new ArrayList<>();
	public static int currentSpriteIndex=0;
	public static spriteInfo s1 = new spriteInfo(new Vector2D(100, 50), "frame1");
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		int i=-128;
		while(i<1536){
			sprites.add(new spriteInfo(new Vector2D(i, 250), "frame1"));
			i+=8;
			sprites.add(new spriteInfo(new Vector2D(i, 250), "frame2"));
			i+=8;
			sprites.add(new spriteInfo(new Vector2D(i, 250), "frame3"));
			i+=8;
			sprites.add(new spriteInfo(new Vector2D(i, 250), "frame4"));
			i+=8;
		}
		/* for(int i=-128; i<1536; i+=8){
			vecs1.add(new Vector2D(i,300));
		}*/
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		//ctrl.addSpriteToFrontBuffer(currentVec.getX(), currentVec.getY(), "f1");
		ctrl.addSpriteToFrontBuffer(sprites.get(currentSpriteIndex).getCoords().getX(), sprites.get(currentSpriteIndex).getCoords().getY(), sprites.get(currentSpriteIndex).getTag());
		//ctrl.drawString(1050, 650, "Jashan Rai", custom);
		// Test drawing text on screen where you want (Remove later! Test only!)
		if(timer.isTimeUp()){
			currentSpriteIndex++;
			if(currentSpriteIndex==sprites.size()){
				currentSpriteIndex=0;
			}
			/* currentVec=vecs1.peek();
			vecs2.add(vecs1.remove());
			if(vecs1.isEmpty()==true){
				while(vecs2.isEmpty()==false){
					vecs1.add(vecs2.remove());
				}
				} */
			isImageDrawn=!isImageDrawn;
			timer.resetWatch();
		}
	}
	
	// Additional Static methods below...(if needed)

}
