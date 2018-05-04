
public class Bullet{
	
	private double xPosition=-1;
	private double yPosition=-1;
	private int xSpeed = 3;
	private int ySpeed = 3;

	private int i=0;
	
	public Rectangle[] myArray= new Rectangle[1];
	
	public Bullet(double xLocation, double yLocation){
		xPosition = xLocation;
		yPosition = yLocation;
		myArray[i]= new Rectangle(xPosition,yPosition,50,50,"Yellow") ;
		//System.out.println("Position = "+xPosition +", "+yPosition);
	}
	
	public void addTo (GameArena ga){
		for(int i=0;i<myArray.length;i++) {
			ga.addRectangle(myArray[i]);
			ga.update();
		}
	}	
	public void move (GameArena ga){
		//System.out.println("Position move = "+xPosition +", "+yPosition);

		if(xPosition > 0 && yPosition > 0){	
			myArray[i].setYPosition(myArray[i].getYPosition() - ySpeed);
		}
		xPosition=myArray[0].getXPosition();
	    yPosition=(myArray[0].getYPosition()/*-10*/);
	         
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
	
	public void removeRec(GameArena ga){
		for(int i=0;i<myArray.length;i++){
			ga.removeRectangle(myArray[i]);
		}
	}
}
