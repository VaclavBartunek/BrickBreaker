
public class Bullet{
	
	private double xPosition=-1;
	private double yPosition=-1;
	private	double xSpeed = -2; // myArray[1].getXBallSpeed();
	private int ySpeed = 4;

	private int i=0;
	
	//public Rectangle[] myArray= new Rectangle[1];
	public Ball[] myArray= new Ball[1];  // new
	
	public Bullet(double xLocation, double yLocation){
		xPosition = xLocation;
		yPosition = yLocation;
		myArray[i]= new Ball(xPosition,yPosition,5,"Yellow",10,10) ;   // new
		
	}
	
	public void addTo (GameArena ga){
		for(int i=0;i<myArray.length;i++) {
			ga.addBall(myArray[i]);   //new
			ga.update();
		}
	}	
	public void move (GameArena ga){
		if(xPosition >= 0 && xPosition<= 3*ga.getArenaWidth()){  //balls can move even if they are not in the panel
			myArray[i].setXPosition(myArray[i].getXPosition() + xSpeed);
		}
		
		if(yPosition >= 0 && yPosition <= 3*ga.getArenaWidth()){	
			myArray[i].setYPosition(myArray[i].getYPosition() - ySpeed);	
		}
  
	}
	
	public void bounce(GameArena ga){
		if(myArray[i].getXPosition() >= (ga.getArenaWidth()- myArray[i].getSize()) &&  myArray[i].getYPosition() <= ga.getArenaHeight()  
			|| myArray[i].getXPosition() <= (0 + myArray[i].getSize()) &&  myArray[i].getYPosition() <=ga.getArenaHeight()  ){
			xSpeed=-xSpeed;
		}
		if(myArray[i].getYPosition() <= 0 + myArray[i].getSize() ){ //TOP bouncing
			ySpeed=-ySpeed;
		}
	}
	
	
	
	public double  getXBullPos(){ //for bullet
		return xPosition;
	}
	public double  getYBullPos(){
		return yPosition;	
	}
	public double  getXBullSpeed(){
		return xSpeed;	
	}
	public double  getYBullSpeed(){
		return ySpeed;	
	}	
	 public void setXBullPos(double x)
    {
        this.xPosition = x;	
    }
	 public void setYBullPos(double y)
    {
        this.yPosition = y;
    }
	
	/*public void removeRec(GameArena ga){
		for(int i=0;i<myArray.length;i++){
			ga.removeRectangle(myArray[i]);
		}
	}*/
}
