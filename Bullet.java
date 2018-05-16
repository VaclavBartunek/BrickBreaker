
public class Bullet{
	
	private double xPosition=250;
	private double yPosition=490;
	private	double xSpeed = -2; // myArray[1].getXBallSpeed();
	private int ySpeed = 4; 
	private int ballSize=5;
	private int i=0;
	private int brickOffset=25;
	private int ballOffset= ballSize/2; 
	
	//public Rectangle[] myArray= new Rectangle[1];
	public Ball bullet ;
	
	public Bullet(double xLocation, double yLocation){
		xPosition = xLocation;
		yPosition = yLocation;
		bullet= new Ball(xPosition,yPosition,ballSize,"Yellow") ;   
		
	}
	public void addTo (GameArena ga){
		 
			ga.addBall(bullet);   
			ga.update();
		
	}	
	public void move (GameArena ga){
		if(xPosition >= 0 && xPosition<= 3*ga.getArenaWidth()){  //balls can move even if they are not in the panel
			bullet.setXPosition(bullet.getXPosition() + xSpeed);
		}
		
		if(yPosition >= 0 && yPosition <= 3*ga.getArenaWidth()){	
			bullet.setYPosition(bullet.getYPosition() - ySpeed);	
		}
	}
	public void bounce(GameArena ga, Brick[] br){
		// Sides bouncing
		if(bullet.getXPosition() >= (ga.getArenaWidth()- bullet.getSize()) &&  bullet.getYPosition() <= ga.getArenaHeight()  
			|| bullet.getXPosition() <= (0 + bullet.getSize()) &&  bullet.getYPosition() <=ga.getArenaHeight()  ){
			xSpeed=-xSpeed; 
		}
		// TOP bouncing
		if(bullet.getYPosition() <= 0 + bullet.getSize() ){ //TOP bouncing
			ySpeed=-ySpeed;
		}
		// Brick bouncing
		for(int j=0;j<50;j++){
			//System.out.print( "Bullet"+bullet.getYPosition()+ " "+ "Brick"+brickArray[j].getYBrickPos()); 
		if(bullet.getYPosition()-ballOffset <= br[j].getYBrickPos()+brickOffset) //bouncing from bottom of the brick
			{ 
				ySpeed=-ySpeed;
				//  ga.decreaseBrickScore(br[j]);  //nevim jak vyvolat tuto metodu...
				
				//System.out.println(ySpeed+" ");
				break; //when one bullet reaches brick it break and moves to next ball
				
				
			}
			
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
