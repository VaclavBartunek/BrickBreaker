import java.util.Random;


public class Brick{
	
	private double xBrickPos=0;
	private double yBrickPos=0;
	private int xBrickSize=50;
	private int yBrickSize=50;
	private Integer numOfHits;
	
	

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
		
		//ga.update();
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
	public void DecreaseBrickScore(GameArena ga){ //setter ale nevim jak aplikovat
		txt.setText("fifty");    
	}
	
}

/*
	public Rectangle[] bricks= new Rectangle[50];
	private double []xBrickPos= new double[50];
	private double []yBrickPos= new double [50];

	for(int row=0; row<5; row ++){
		for (int col=0; col<10; col++){

		bricks[i]= new Rectangle(xBrickPos,yBrickPos,xBrickSize,yBrickSize,"Yellow");
		xBrickPos[i]= col*xBrickSize;
		yBrickPos[i]= row*yBrickSize;*/



