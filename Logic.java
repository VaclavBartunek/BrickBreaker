public class Logic{
	

	//boucing balls from bricks
	public void brickBounce(Brick[] br, Bullet bu ){
	
	for(int j=0;j<50;j++){
			//System.out.print( "Bullet"+bullet.getYPosition()+ " "+ "Brick"+brickArray[j].getYBrickPos()); 
		if(bu.getYBullPos()-bu.getBullOffset() <= br[j].getYBrickPos()+br[j].getYBrickOffset()) //bouncing from bottom of the brick
			{ 
				//ySpeed=-ySpeed;
				//  ga.decreaseBrickScore(br[j]);  //nevim jak vyvolat tuto metodu...
				
				//System.out.println(ySpeed+" ");
				break; //when one bullet reaches brick it break and moves to next ball
			}
			
		}
		
		
		
	}
	
}
