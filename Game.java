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
	private double angle=-Math.PI/2; 
	private Bullet[] bullets;
	private double xInitialBullOffset/*=16*/;
	private double yInitialBullOffset/*=16*/;
	private boolean wasMouseClicked= false;
	
	
		public Game(){ 
		int xArenaSize= 500;
		int yArenaSize = 500;
		boolean gameOn= true;
		int xBrickSize= 50;
		int yBrickSize= 50;
		int i=0;
		
		int numOfBullets= 30;
		int numOfBricks=50;
		int brickScore=3;
		
		
		GameArena ga = new GameArena(xArenaSize,yArenaSize,false,this); 
		Table table = new Table(ga.getPanel());
		
		//creating bricks
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
		bullets= new Bullet[numOfBullets];
		i=0;
		for(i=0;i<numOfBullets;i++){
			bullets[i]= new Bullet(ga.getArenaWidth()/2+ i* xInitialBullOffset, ga.getArenaHeight()-6 +i* yInitialBullOffset);
			bullets[i].addTo(ga);
			bullets[i].move(ga);
		}
		
		//create the arrow
		arrow = new Arrow(250,490,250,490-arrowLength,5,"YELLOW",ga);
	
		ga.update();
		
		//main while loop
		i=0;
		while(true){
			ga.update();
			for(i=0;i<numOfBullets;i++){   
				bullets[i].move(ga);
				bullets[i].bounce(ga,bricks);
				brickBounce(bullets[i],ga);			
			}
		}		
	}
	
	// Brick bouncing
	public void brickBounce(Bullet bullet,GameArena ga){
	for(int j=0;j<50;j++){
		if (bricks[j].getBrickDisappeared()==false){
			
				//bottom of the brick	
				//System.out.println("BULLET Y pos: "+  (bullet.getYBullPos()-bullet.getBullOffset()  ) );
			if (bullet.getYBullPos()-bullet.getBullOffset() <= bricks[j].getYBrickPos()+bricks[j].getYBrickOffset() &&   	// if the ball entres 5px wide area in the bottom of the brick, it bounces
				bullet.getYBullPos()-bullet.getBullOffset() >= bricks[j].getYBrickPos()+bricks[j].getYBrickOffset()-10 &&  	// 5 because of the speed of the ball
				bullet.getXBullPos()-bullet.getBullOffset() >= bricks[j].getXBrickPos()-bricks[j].getXBrickOffset()-0 && 	// left side (2 because ball Position is in not float and it dont detect the edges) 
				bullet.getXBullPos()+bullet.getBullOffset() <= bricks[j].getXBrickPos()+bricks[j].getXBrickOffset()+0 )  	// right side 
				{ 
					bullet.setYBulletSpeed(-bullet.getYBulletSpeed()); 
					System.out.println("Y pos: " + bricks[j].getYBrickPos() + "   X pos: " + bricks[j].getXBrickPos()  );
					bricks[j].setDecrease(ga);
					break; //when one bullet reaches brick it breaks and moves to next ball
				}
				//right side of the brick
			if ( bullet.getXBullPos()-bullet.getBullOffset() <= bricks[j].getXBrickPos()+bricks[j].getXBrickOffset()&&		// right side
				  bullet.getXBullPos()-bullet.getBullOffset() >= bricks[j].getXBrickPos()+bricks[j].getXBrickOffset()-10 &&	// 5px forbidden area
				  bullet.getYBullPos()-bullet.getBullOffset() >= bricks[j].getYBrickPos()-bricks[j].getYBrickOffset()-0 && 	// top of the brick
				  bullet.getYBullPos()+bullet.getBullOffset() <= bricks[j].getYBrickPos()+bricks[j].getYBrickOffset()+0 )   // bottom of the brick
				{ 
					bullet.setXBulletSpeed( - bullet.getXBulletSpeed() ); 
					bricks[j].setDecrease(ga);
					break;
				}
				//left side brick bouncing 
			if ( bullet.getXBullPos()+bullet.getBullOffset() >= bricks[j].getXBrickPos()-bricks[j].getXBrickOffset()&&     // left side of the brick
				  bullet.getXBullPos()+bullet.getBullOffset() <= bricks[j].getXBrickPos()-bricks[j].getXBrickOffset()+10 &&  // forbidden area of the brick
				  bullet.getYBullPos()-bullet.getBullOffset() >= bricks[j].getYBrickPos()-bricks[j].getYBrickOffset()-0 &&	// top of the brick
				  bullet.getYBullPos()+bullet.getBullOffset() <= bricks[j].getYBrickPos()+bricks[j].getYBrickOffset()+0 )	// bottom of the brick
				{ 
					bullet.setXBulletSpeed( - bullet.getXBulletSpeed() ); 
					bricks[j].setDecrease(ga);
					break;
				}	
				//Top collision with brick
			if (bullet.getYBullPos()+bullet.getBullOffset() >= bricks[j].getYBrickPos()-bricks[j].getYBrickOffset() &&    	// top of the brick
					bullet.getYBullPos()+bullet.getBullOffset() <= bricks[j].getYBrickPos()-bricks[j].getYBrickOffset()+10 &&  	// forbidden area
					bullet.getXBullPos()-bullet.getBullOffset() >= bricks[j].getXBrickPos()-bricks[j].getXBrickOffset()-0 && 	// left side
					bullet.getXBullPos()+bullet.getBullOffset() <= bricks[j].getXBrickPos()+bricks[j].getXBrickOffset()+0 ) 	// right side 
				{ 
					bullet.setYBulletSpeed(-bullet.getYBulletSpeed()); 
					bricks[j].setDecrease(ga);
					break; //when one bullet reaches brick it break and moves to next ball
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
		setArrow(e.getX(),e.getY());	
	}
	
    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) { 
    }

    public void mouseClicked(MouseEvent e) {	
    }
    
    private void setArrow(double mouseX, double mouseY){
		while (wasMouseClicked==false){
			angle=-Math.PI/2;
			if(mouseX > 250)
				 angle = Math.atan((490-mouseY)/(250-mouseX));
			else if(mouseX < 250)
				 angle = -Math.PI+Math.atan((490-mouseY)/(250-mouseX));
			//set the arrow 
			arrow.setEnd(250+arrowLength*Math.cos(angle),490+arrowLength*Math.sin(angle));
			setBullets();				 // sets speed and initial offset of bullets
			wasMouseClicked=true;
		}
	}
	private void setBullets(){
		for(int i=0;i<50;i++){	
			bullets[i].setXBulletSpeed(5*Math.cos(angle)); //ball speed * cos angle
			bullets[i].setYBulletSpeed(5*Math.sin(angle)); //ball speed * sin angle
			bullets[i].setXBullPos(/*ga.getArenaWidth()/ 2*/250+ i*16*Math.cos(Math.PI-angle));
			bullets[i].setYBullPos(/*ga.getArenaHeight()-6*/494 +i*16*Math.sin(Math.PI+angle));
		}
	}
}
