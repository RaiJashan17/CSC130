package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

import Data.BoundingBox;
import Data.Vector2D;
import Data.spriteInfo;
import FileIO.EZFileRead;
import logic.Control;
import timer.stopWatchX;
//AABB Collision Used in Project
public class Main{
	// Fields (Static) below...
	public static Color custom=new Color(100,40,150);
	public static Boolean isImageDrawn=false;
	public static stopWatchX timer=new stopWatchX(50);
	public static Queue<Vector2D> vecs1=new LinkedList<>();
	public static Queue<Vector2D> vecs2 = new LinkedList<>();
	public static Vector2D currentVec = new Vector2D(500, 250);
	public static ArrayList<spriteInfo> sprites=new ArrayList<>();
	public static int currentSpriteIndex=0;
	public static spriteInfo s1 = new spriteInfo(currentVec, "frame1");
	public static EZFileRead ezr=new EZFileRead("TextLines.txt");
	public static HashMap<String,String> map=new HashMap<>();
	public static String raw="";
	public static StringTokenizer st=new StringTokenizer(raw,"*");
	public static String[] phrases=new String[5];
	public static int phrasesIndex=0;
	public static int counter=0;
	public static String trigger="right";
	public static int i=currentVec.getX();
	public static int k=currentVec.getY();
	public static boolean movement=false;
	public static BoundingBox box1=new BoundingBox(currentVec.getX(),currentVec.getY(),28,28);
	public static BoundingBox box2=new BoundingBox(175,450,1,35);
	//public static String key=st.nextToken();
	//public static String Value=st.nextToken();
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		for(int i=0;i<5;i++){
			raw=ezr.getLine(i);
			st=new StringTokenizer(raw,"*");
			String key=st.nextToken();
			String Value=st.nextToken();
			map.put(key, Value);
		}
		int j=0;
		for(Map.Entry<String, String> entry : map.entrySet()){
			phrases[j]=entry.getKey();
			j++;
		}
		sprites.add(s1);
		//int i=currentVec.getX();
		sprites.add(new spriteInfo(new Vector2D(i, k), "frame2right")); //Array: 1
		sprites.add(new spriteInfo(new Vector2D(i, k), "frame4right"));
		sprites.add(new spriteInfo(new Vector2D(i, k), "frame3right"));
		sprites.add(new spriteInfo(new Vector2D(i, k), "frame1left"));
		sprites.add(new spriteInfo(new Vector2D(i, k), "frame2left"));
		sprites.add(new spriteInfo(new Vector2D(i, k), "frame4left"));
		sprites.add(new spriteInfo(new Vector2D(i, k), "frame3left"));
		sprites.add(new spriteInfo(new Vector2D(i, k), "frame2up"));
		sprites.add(new spriteInfo(new Vector2D(i, k), "frame3up"));
		sprites.add(new spriteInfo(new Vector2D(i, k), "frame4up"));
		sprites.add(new spriteInfo(new Vector2D(i, k), "frame2down"));
		sprites.add(new spriteInfo(new Vector2D(i, k), "frame3down"));
		sprites.add(new spriteInfo(new Vector2D(i, k), "frame4down"));
		/*while(i<1536){
			sprites.add(new spriteInfo(new Vector2D(i, 250), "frame1"));
			i+=8;
			sprites.add(new spriteInfo(new Vector2D(i, 250), "frame2"));
			i+=8;
			sprites.add(new spriteInfo(new Vector2D(i, 250), "frame4"));
			i+=8;
			sprites.add(new spriteInfo(new Vector2D(i, 250), "frame3"));
			i+=8;
			currentSpriteIndex=sprites.size()/2;
		}*/
		/* for(int i=-128; i<1536; i+=8){
			vecs1.add(new Vector2D(i,300));
		}*/
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		//ctrl.addSpriteToFrontBuffer(currentVec.getX(), currentVec.getY(), "f1");
		ctrl.addSpriteToFrontBuffer(0, 0, "background");
		ctrl.addSpriteToFrontBuffer(100, 400, "object1");
		ctrl.addSpriteToFrontBuffer(sprites.get(currentSpriteIndex).getCoords().getX(), sprites.get(currentSpriteIndex).getCoords().getY(), sprites.get(currentSpriteIndex).getTag());
		ctrl.drawString(100, 100, Integer.toString(currentSpriteIndex), custom);
		if(map.containsKey(raw)){
			ctrl.drawString(450,200 , map.get(raw), custom);
		}
		ctrl.drawString(500, 20, Boolean.toString(box1.isCollision(box1, box2)), custom);
		ctrl.drawString(600, 20, box1.directionOfCollision(box1, box2), custom);
		ctrl.drawString(700,20, Integer.toString(box1.getx1()),custom);
		ctrl.drawString(700,40, Integer.toString(box1.getx2()),custom);
		ctrl.drawString(800,20, Integer.toString(box2.getx1()),custom);
		ctrl.drawString(800, 40, Integer.toString(box2.getx2()), custom);
		//ctrl.drawString(200, 200, map.get("string3"), custom);
		// Test drawing text on screen where you want (Remove later! Test only!)
		if(timer.isTimeUp()){
		box1=new BoundingBox(sprites.get(currentSpriteIndex).getCoords().getX(),sprites.get(currentSpriteIndex).getCoords().getY(),128,128);
		if(box1.isCollision(box1, box2)==true){
			if(trigger.equalsIgnoreCase(box1.directionOfCollision(box1, box2))){
				movement=false;
			}
		}
		if(movement==false){
			if(trigger.equalsIgnoreCase("right") || trigger.equalsIgnoreCase("up")){
				sprites.get(0).setCoords(i, k);
				currentSpriteIndex=0;
			}else{
				sprites.get(4).setCoords(i, k);
				currentSpriteIndex=4;
			}
			}
			if(movement==true && trigger.equalsIgnoreCase("right")){
				if(currentSpriteIndex==0){
					i+=8;
					sprites.get(1).setCoords(i, k);
					currentSpriteIndex=1;
				}
				else if(currentSpriteIndex==1){
					i+=8;
					sprites.get(2).setCoords(i, k);
					currentSpriteIndex=2;
				}
				else if(currentSpriteIndex==2){
					i+=8;
					sprites.get(3).setCoords(i, k);
					currentSpriteIndex=3;
				}else{
					i+=8;
					sprites.get(0).setCoords(i, k);
					currentSpriteIndex=0;
				}
			}
			if(movement==true && trigger.equalsIgnoreCase("left")){
				if(currentSpriteIndex==4){
					i-=8;
					sprites.get(5).setCoords(i, k);
					currentSpriteIndex=5;
				}
				else if(currentSpriteIndex==5){
					i-=8;
					sprites.get(6).setCoords(i, k);
					currentSpriteIndex=6;
				}
				else if(currentSpriteIndex==6){
					i-=8;
					sprites.get(7).setCoords(i, k);
					currentSpriteIndex=7;
				}else{
					i-=8;
					sprites.get(4).setCoords(i, k);
					currentSpriteIndex=4;
				}
			}
			if(movement==true && trigger.equalsIgnoreCase("up")){
				if(currentSpriteIndex==0){
					k-=8;
					sprites.get(8).setCoords(i, k);
					currentSpriteIndex=8;
				}
				else if(currentSpriteIndex==8){
					k-=8;
					sprites.get(9).setCoords(i, k);
					currentSpriteIndex=9;
				}
				else if(currentSpriteIndex==10){
					k-=8;
					sprites.get(10).setCoords(i, k);
					currentSpriteIndex=10;
				}else{
					k-=8;
					sprites.get(0).setCoords(i, k);
					currentSpriteIndex=0;
				}
			}
			if(movement==true && trigger.equalsIgnoreCase("down")){
				if(currentSpriteIndex==4){
					k+=8;
					sprites.get(11).setCoords(i, k);
					currentSpriteIndex=11;
				}
				else if(currentSpriteIndex==11){
					k+=8;
					sprites.get(12).setCoords(i, k);
					currentSpriteIndex=12;
				}
				else if(currentSpriteIndex==12){
					k+=8;
					sprites.get(13).setCoords(i, k);
					currentSpriteIndex=13;
				}else{
					k+=8;
					sprites.get(4).setCoords(i, k);
					currentSpriteIndex=4;
				}
			}
			//sprites.add(new spriteInfo(new Vector2D(i, 250), "frame1"));
			/*counter++;
			if(counter%32==0){
				phrasesIndex++;
			}
			if(phrasesIndex>4){
				phrasesIndex=0;
			}
			if(counter>160){
				counter=0;
			}*/
			/*if(currentSpriteIndex==sprites.size()){
				currentSpriteIndex=0;
			}*/
			isImageDrawn=!isImageDrawn;
			timer.resetWatch();
		}
	}
	
	// Additional Static methods below...(if needed)

}
