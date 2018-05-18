
public class Bullet{
	
	private double xPosition=250;
	private double yPosition=490;
	private	double xSpeed = -3; // myArray[1].getXBallSpeed();
	private double ySpeed = -3; 
	private double bullSize=10; // its actually radius
	private int i=0;
	private int brickOffset=25;
	private double bullOffset= bullSize/2; 
	
	//public Rectangle[] myArray= new Rectangle[1];
	public Ball bullet ;
	
	public Bullet(double xLocation, double yLocation){
		xPosition = xLocation;
		yPosition = yLocation;
		bullet= new Ball(xPosition,yPosition,bullSize,"Yellow") ;   
		
	}
	public void addTo (GameArena ga){
		 
			ga.addBall(bullet);   
			ga.update();
		
	}	
	public void move (GameArena ga){
		if(xPosition >= 0 && xPosition<= 3*ga.getArenaWidth()){  //balls can move even if they are not in the panel
			bullet.setXPosition(bullet.getXPosition() + xSpeed);
				xPosition = bullet.getXPosition() + xSpeed;
				System.out.println("xPosition  : "+ bullet.getXPosition());
				//System.out.println("xSpeed  : "+ xSpeed);
		}
		
		if(yPosition >= 0 && yPosition <= 3*ga.getArenaWidth()){	
			bullet.setYPosition(bullet.getYPosition() + ySpeed);	
			
					yPosition = bullet.getYPosition() + ySpeed;
		}	

	}
	public void bounce(GameArena ga, Brick[] br){
		// Sides bouncing
		if(bullet.getXPosition()+bullOffset >= (ga.getArenaWidth()) &&  bullet.getYPosition()+bullOffset <= ga.getArenaHeight()|| //right side
			bullet.getXPosition()-bullOffset <= 0  &&  bullet.getYPosition() <=ga.getArenaHeight()  ){ //left side
			xSpeed=-xSpeed; 
			System.out.println("xSpeed  : "+ xSpeed);
		}
		
		// TOP bouncing
		if(bullet.getYPosition() <= 0 + bullet.getSize() ){ //TOP bouncing
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
    public double getBullOffset(){
		return bullOffset;
	}
	public double getXBulletSpeed(){
		return xSpeed;
	}
	 public void setXBulletSpeed(double x){
        this.xSpeed = x;	
    }
    public double getYBulletSpeed(){
		return ySpeed;
	}
	 public void setYBulletSpeed(double y){
        this.ySpeed = y;	
    }
	 public double getBulletOffset(){
		return bullSize/2;
	}
	
	
	
	
	/*public void removeBullet(GameArena ga,Bullet bullets){
		ga.bullets.removeBall(); 
	}*/
	
	/*public void removeRec(GameArena ga){
		for(int i=0;i<myArray.length;i++){
			ga.removeRectangle(myArray[i]);
		}
	}*/
}
