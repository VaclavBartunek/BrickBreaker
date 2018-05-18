import javax.swing.*;
import java.util.Vector;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

import java.awt.event.WindowEvent;
import java.awt.event.InputEvent.*;
import java.awt.event.*;

public class Game implements MouseListener { //class 
	
	private Brick[] bricks;
	private Arrow arrow;
	private double arrowLength = 100;
	 
		public Game(){ 
	
		int xArenaSize= 500;
		int yArenaSize = 500;
		boolean gameOn= true;
		int xBrickSize= 50;
		int yBrickSize= 50;
		int i=0;
		int xInitialBullOffset=16;
		int yInitialBullOffset=8;
		int numOfBullets= 100;
		int numOfBricks=50;
		int brickScore=60;
		
		
		GameArena ga = new GameArena(xArenaSize,yArenaSize,false,this); 
		Table table = new Table(ga.getPanel());
		
		//creating the bricks
		bricks= new Brick[numOfBricks];
		i=0;
		for(int row=0; row<5; row ++){
			for (int col=0; col<10; col++){	
			bricks[i]= new Brick(col*xBrickSize+25,row*yBrickSize+25,brickScore);
			bricks[i].addBrickTo(ga);  
			i++;
			}	
		}
		
		//creating bullets
		Bullet[] bullets= new Bullet[numOfBullets];
		i=0;
		for(i=0;i<numOfBullets;i++){
			bullets[i]= new Bullet(ga.getArenaWidth()/2+ i*xInitialBullOffset, ga.getArenaHeight()-6 +i*yInitialBullOffset);
			bullets[i].addTo(ga);
			bullets[i].move(ga);
		}
		
		//create the arrow
		arrow = new Arrow(250,490,250,490-arrowLength,5,"YELLOW",ga);
		

		Player p1 = new Player (ga.getArenaWidth()/2,ga.getArenaHeight()-30,"Yellow",10);
	
		
		//p1.addTo(ga);		xPosition = bullet.getXPosition() + xSpeed;
		ga.update();

		i=0;
		while(true){
			ga.update();
			for(i=0;i<numOfBullets;i++){   
				bullets[i].move(ga);
				bullets[i].bounce(ga,bricks);
				brickBounce(bullets[i],ga);
				//bullets[i].brickBounce(bricks,bullets);
				for(int  j=0;j<numOfBricks;j++){  
				}
			}
		}		
	}
	
	
			
		// Brick bouncing
		public void brickBounce(Bullet bullet,GameArena ga){
		for(int j=0;j<50;j++){
			if (bricks[j].getBrickDisappeared()==false){
			
					//bottom of the brick	
									//System.out.println("BULLET Y pos: "+  (bullet.getYBullPos()-bullet.getBullOffset()  ) );
				
				if (bullet.getYBullPos()-bullet.getBullOffset() <= bricks[j].getYBrickPos()+bricks[j].getYBrickOffset() &&    //  if the ball entres 5px wide area in the bottom of the brick, it bounces
					bullet.getYBullPos()-bullet.getBullOffset() >= bricks[j].getYBrickPos()+bricks[j].getYBrickOffset()-5 &&  // 5 because of the speed of the ball
					bullet.getXBullPos()-bullet.getBullOffset() >= bricks[j].getXBrickPos()-bricks[j].getXBrickOffset()-2 && // left side (2 because ball Position is in not float and it dont detect the edges) 
					bullet.getXBullPos()+bullet.getBullOffset() <= bricks[j].getXBrickPos()+bricks[j].getXBrickOffset()+2 )  // right side 
					{ 
						bullet.setYBulletSpeed(-bullet.getYBulletSpeed()); 
						
						System.out.println("Y pos: " + bricks[j].getYBrickPos() + "   X pos: " + bricks[j].getXBrickPos()  );
						bricks[j].setDecrease(ga);
						break; //when one bullet reaches brick it break and moves to next ball
						
						
					}
					//right side of the brick
				if 	( bullet.getXBullPos()-bullet.getBullOffset() <= bricks[j].getXBrickPos()+bricks[j].getXBrickOffset()&&
					  bullet.getXBullPos()-bullet.getBullOffset() >= bricks[j].getXBrickPos()+bricks[j].getXBrickOffset()-5 &&
					  bullet.getYBullPos()-bullet.getBullOffset() >= bricks[j].getYBrickPos()-bricks[j].getYBrickOffset()-2 &&
					  bullet.getYBullPos()+bullet.getBullOffset() <= bricks[j].getYBrickPos()+bricks[j].getYBrickOffset()+2 )
					{
						 
						bullet.setXBulletSpeed( - bullet.getXBulletSpeed() ); 
						bricks[j].setDecrease(ga);
						break;
					}
				}
		}
	
		
		
		
		
	}	
	
	

 //methods for the mouse listener
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
		System.out.println("x = "+e.getX());
		System.out.println("y = "+e.getY());
		calculateAngle(e.getX(),e.getY());		
	}
	
    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) { 
    }

    public void mouseClicked(MouseEvent e) {	
    }
    
    private void calculateAngle(double mouseX, double mouseY){
		double angle=-Math.PI/2;
		if(mouseX > 250)
			 angle = Math.atan((490-mouseY)/(250-mouseX));
		else if(mouseX < 250)
			 angle = -Math.PI+Math.atan((490-mouseY)/(250-mouseX));
		//set the arrow
		arrow.setEnd(250+arrowLength*Math.cos(angle),490+arrowLength*Math.sin(angle));
		
	}
   


}
