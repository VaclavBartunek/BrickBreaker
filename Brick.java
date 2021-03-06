import java.util.Random;


public class Brick{
	
	private double xBrickPos=0;
	private double yBrickPos=0;
	private int xBrickSize=50;
	private int yBrickSize=50;
	private Integer numOfHits;
	private boolean brickDisappeared= false;
	

	private Rectangle rect;
	private Text txt;
	
	public Brick(double x, double y, int hits ){
		xBrickPos=x;
		yBrickPos= y;
		numOfHits= hits;	
		rect= new Rectangle(xBrickPos,yBrickPos,xBrickSize,yBrickSize,"Blue");
		txt= new Text(numOfHits.toString(), xBrickPos,yBrickPos,xBrickSize/3,"Yellow");
	}

	public void addBrickTo (GameArena ga){
		ga.addRectangle(rect);
		ga.addText(txt);
	}	
	
	public double getXBrickPos(){
		return xBrickPos;
	}
	public double getYBrickPos(){
		return yBrickPos;
	}
	public double getYBrickSize(){
		return yBrickSize;
	}
	public double geXtBrickSize(){
		return xBrickSize;
	} 
	public int getXBrickOffset(){
		return xBrickSize/2;
	}
	public int getYBrickOffset(){
		return yBrickSize/2;
	}
	public void setDecrease(GameArena ga){
		numOfHits=numOfHits-1;
		if(numOfHits > 0){
			txt.setText(numOfHits.toString());		
		}
		else {
			ga.removeRectangle(rect);
			ga.removeText(txt);
			brickDisappeared=true;
		}
	}
	public boolean getBrickDisappeared(){
	return brickDisappeared;	
	}
	
	
	
}





