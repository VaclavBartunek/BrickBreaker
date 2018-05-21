
public class Bullet{
	
	private double xPosition=250;
	private double yPosition=490;
	private	double xSpeed  /*=-3*/; 
	private double ySpeed  /*=-3*/; 
	private double bullRadius=3.5;
	private double bullSize=bullRadius*2; 
	private int i=0;
	private int brickOffset=25;
	private double bullOffset= bullRadius; 
	
	
	
	public Ball bullet ;
	
	public Bullet(double xLocation, double yLocation){
		xPosition = xLocation;
		yPosition = yLocation;
		bullet= new Ball(xPosition,yPosition,bullSize,"Yellow") ;   
	}
	//add bullet to game arena
	public void addTo (GameArena ga){
			ga.addBall(bullet);   
			ga.update();
	}	
	// move bullet
	public void move (GameArena ga){
		
			bullet.setXPosition(bullet.getXPosition() + xSpeed);
			xPosition = bullet.getXPosition() + xSpeed;
			System.out.println("xPosition  : "+ bullet.getXPosition());
			System.out.println("xSpeed  : "+ xSpeed);
			bullet.setYPosition(bullet.getYPosition() + ySpeed);	
			yPosition = bullet.getYPosition() + ySpeed;

	}
	//bouncing of bullets from sides
	public void bounce(GameArena ga, Brick[] br/*,Bullet[] bu*/){
		// left side bouncing
		if(bullet.getXPosition()-bullOffset <= 0  &&  bullet.getYPosition()+bullOffset <= ga.getArenaHeight()){ 
			bullet.setXPosition(0+10); //fixing ataching balls to the sides
			xSpeed=-xSpeed; 
			//System.out.println("xSpeed  : "+ xSpeed);
		}
		// right side bouncing
		if(bullet.getXPosition()+bullOffset >= (ga.getArenaWidth()) &&  bullet.getYPosition()+bullOffset <= ga.getArenaHeight()){ 
		   bullet.setXPosition((ga.getArenaWidth()-10));//trying to fix ataching balls to the sides
		   xSpeed=-xSpeed; 
		}
		// TOP bouncing
		if(bullet.getYPosition() <= 0 + bullet.getSize() ){ 
			ySpeed=-ySpeed;	
		}
		// bottom side= remove ball
		if(bullet.getYPosition()>= ga.getArenaHeight()&& ySpeed>=0){
			ga.removeBall(bullet);
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
        bullet.setXPosition(x);
    }
	 public void setYBullPos(double y)
    {
        this.yPosition = y;
        bullet.setYPosition(y);
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
}
