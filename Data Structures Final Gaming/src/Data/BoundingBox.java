/* This class is create a custom data type for the bounding boxes to detect collisions */

package Data;

public class BoundingBox{
	private int x1;
	private int x2;
	private int width;
	private int height;
	private int y1;
	private int y2;
	
	public BoundingBox(int x1, int y1, int width, int height){
		this.x1=x1;
		this.x2=x1+width;
		this.y1=y1;
		this.y2=y1+height;
	}
	
	public int getx1(){
		return x1;
	}
	public int getx2(){
		return x2;
	}
	public int gety1(){
		return y1;
	}
	public int gety2(){
		return y2;
	}
	public void setx1(int x){
		x1=x;
	}
	public void sety1(int y){
		y1=y;
	}
	public void sety2(int y){
		y2=y;
	}
	public boolean isCollision(BoundingBox box1, BoundingBox box2){
		if(box1.getx1()<=box2.getx2() && box1.getx2()>=box2.getx1() && box1.gety1()<=box2.gety2() && box1.gety2()>=box2.gety1()){
			return true;
		}
		return false;
		}
	public String directionOfCollision(BoundingBox box1, BoundingBox box2){
		String direction="";
		if((box1.getx2()-box2.getx1())>-8 && (box1.getx2()-box2.getx1())<8 ){
			direction="right";
		}
		if((box1.getx1()-box2.getx2())>-8 && (box1.getx1()-box2.getx2())<8){
			direction="left";
		}
		if((box1.gety1()-box2.gety2())>-8 && (box1.gety1()-box2.gety2())<8){
			direction="up";
		}
		if((box1.gety2()-box2.gety1())>-8 && (box1.gety2()-box2.gety1())<8){
			direction="down";
		}
		
		return direction;
	}
	}