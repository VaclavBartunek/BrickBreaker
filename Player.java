
public class Player{

public double xPosition;
public double yPosition;	
public int xSpeed=10;
	
public Rectangle[] myArray = new Rectangle[2];
public Player (int xPosition,int yPosition, String col, int aXSpeed) {

	myArray[0] = new Rectangle(xPosition,(yPosition - 5),10,10,col); // player-upper box 
	myArray[1]  = new Rectangle(xPosition,(yPosition + 5),30,10,col); //player-lower box
	xSpeed = aXSpeed;
	}
	
	public void addTo (GameArena ga){
		for(int i=0;i< myArray.length;i++) {
			ga.addRectangle(myArray[i]);
			ga.update();
			}
		}	
	public void move(GameArena ga){
		if(ga.rightPressed() == true){
			if((myArray[1].getXPosition() + xSpeed + myArray[1].getWidth()/2) <= ga.getArenaWidth())
				for(int i=0;i< myArray.length;i++){
					myArray[i].setXPosition(myArray[i].getXPosition() + xSpeed);
				}				
		}
		else if(ga.leftPressed() ==true){
			if((myArray[1].getXPosition() - xSpeed - myArray[1].getWidth()/2)>=0)
				for(int i=0;i< myArray.length;i++){
					myArray[i].setXPosition(myArray[i].getXPosition() - xSpeed);
				}	
		}
		//stopping on the right
		/*else if ((myArray[1].getXPosition()+(myArray[1].getWidth()/2))>ga.getArenaWidth()){
			for(int i=0;i< myArray.length;i++){
				myArray[i].setXPosition(ga.getArenaWidth()-(myArray[1].getWidth()/2) );
			}
		}*/	
		//stopping on the left
		else if ((myArray[1].getXPosition()-(myArray[1].getWidth()/2)) == 0){
			for(int i=0;i< myArray.length;i++){
				myArray[i].setXPosition(ga.getArenaWidth()-(myArray[1].getWidth()/2) );	
			}		
		}
		xPosition=myArray[1].getXPosition();
		yPosition=(myArray[1].getYPosition()-10);
	}	
	
	public double  getXLocation(){ //for bullet
		return xPosition;
	}
	public double  getYLocation(){
		return yPosition;	
	}
				
}
/*
public class Baddie{

	public double badPosX;
	public double badPosy;
	public int xSpeed = 1;
	
	public Rectangle[] array = new Rectangle[7];

	public Baddie(int badPosx,int badPosy, String col){  	//constructor
		
	
		array[0] = new Rectangle(badPosx,(badPosy-15),30,20,col);//head
		array[1] = new Rectangle((badPosx-10),(badPosy-15),5,5,"BLACK");//right eye
		array[2] = new Rectangle((badPosx+10),(badPosy-15),5,5,"BLACK"); //right eye
		array[3] = new Rectangle(badPosx,badPosy,50,10,col);//middle part
		array[4] = new Rectangle((badPosx-20),(badPosy+10),10,10,col);// left leg
		array[5] = new Rectangle(badPosx,(badPosy+10),10,10,col);//middle leg
		array[6] = new Rectangle((badPosx+20),(badPosy+10),10,10,col);// right leg
		}	
		
	public void addTo (GameArena ga){
		for(int i=0;i<=array.length;i++) {
			ga.addRectangle(array[i]);
			ga.update();
			}
		}	
	*/	
