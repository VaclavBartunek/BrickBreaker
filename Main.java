import javax.swing.*;
import java.util.Vector;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;


public class Main  { //class 
	
	
	
	public static void main(String[] args){ //main method
	
		int xArenaSize= 500;
		int yArenaSize = 500;
		boolean gameOn= true;
		int xBrickSize= 50;
		int yBrickSize= 50;
		int i=0;
		int xInitialBullOffset=10;
		int yInitialBullOffset=15;
		int numOfBullets= 100;
		int numOfBricks=50;
		int brickScore=60;
		
		
		GameArena ga = new GameArena(xArenaSize,yArenaSize,false); 
		Table table = new Table(ga.getPanel());
		
		//creating the bricks
		Brick[] bricks= new Brick[numOfBricks];
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

		Player p1 = new Player (ga.getArenaWidth()/2,ga.getArenaHeight()-30,"Yellow",10);
	
		
		//p1.addTo(ga);
		ga.update();

		i=0;
		while(true){
		ga.update();
		for(i=0;i<numOfBullets;i++){     
			bullets[i].move(ga);
			bullets[i].bounce(ga,bricks);
			
			}
		}
		
		
	}
}
