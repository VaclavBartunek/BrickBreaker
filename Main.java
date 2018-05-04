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
	
	GameArena ga = new GameArena(xArenaSize,yArenaSize,false); 
	Table table = new Table(ga.getPanel());
	Ball b1 = new Ball(xArenaSize/2,yArenaSize-20,5,"#FFFF00",3,3);
	
	/*Ball balls=new Ball[50];
	Ball[] balls = new Ball[50];// All the balls in our program
	double[] xSpeeds = new double[50];  // The speed of the balls in X
	double[] ySpeeds = new double[50];	// The speed of the balls in Y
	
	for (int i = 0 ; i < balls.length; i++){
		balls[i] = new Ball(Math.random()*500, Math.random()*500, 10, “GREEN” );
		xSpeeds[i] = Math.random() * 10;
		ySpeeds[i] = Math.random() * 10;
		ga.addBall(balls[i]);
	}*/
	
	//creating the bricks
	Brick[] bricks= new Brick[50];
	for(int row=0; row<5; row ++){
		for (int col=0; col<10; col++){

		bricks[i]= new Brick(col*xBrickSize+25,row*yBrickSize+25,60);
		bricks[i].addBrickTo(ga);  
		i++;
		}	
	}

	Player p1 = new Player (ga.getArenaWidth()/2,ga.getArenaHeight()-30,"Yellow",10);
	Vector<Bullet> bullVector= new Vector<Bullet>();//list- like array but change positions of rows when one row is deleted
	
	
	/*Text lives = new Text[50];
	for (int i = 0 ; i < 50; i++){
		lives[i] = new Text(deset, 10,10,10,“Yellow”);
		ga.addText(lives[i]);
	}*/
	
	
	
	p1.addTo(ga);
	ga.addBall(b1);
	ga.update();
	
	

	double x=6;
	double y=6;
	int xSpeed= 3;	
	int ySpeed= -6;
		while(true){
		b1.setXPosition(b1.getXPosition()+x);
		b1.setYPosition(b1.getYPosition()-y);
		//bouncing from sides
		if (b1.getXPosition() >ga.getArenaWidth()){
			x=-xSpeed;	
		}
		if (b1.getXPosition() < 0+b1.getSize()/2){
			x=xSpeed;
		}	
		if (b1.getYPosition() < 0+b1.getSize()/2){
			y=ySpeed;
		}	
		
		ga.update();	
		}
	} 
}
