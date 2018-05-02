import javax.swing.*;
import java.util.Vector;
import java.awt.event.*;
import java.awt.*;


public class Main /*implements ActionListener*/ { //class 
	public static void main(String[] args){ //main method
	
	int xArenaSize= 500;
	int yArenaSize = 300;
	boolean gameOn= true;
	
	GameArena ga = new GameArena(xArenaSize,yArenaSize); 
	Ball b1 = new Ball(xArenaSize/2,yArenaSize-20,5,"#FFFF00");
	Player p1 = new Player (ga.getArenaWidth()/2,ga.getArenaHeight()-30,"Yellow",10);
	Vector<Bullet> bullVector= new Vector<Bullet>();//list- like array but change positions of rows when one row is deleted
	
	p1.addTo(ga);
	ga.addBall(b1);
	ga.update();
	//ga.addActionListener(this);
	

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
