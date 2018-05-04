import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*; //ABSOLUTE VALUE
import java.util.*; // random 
import javafx.embed.swing.JFXPanel;


public class Table /*implements ActionListener*/{
	
	private Integer chooseLevel= 1;
	private Integer currentLevel= 1;
	private Integer score= 0;
	
	private JPanel p0= new JPanel(); // main panel
	private JPanel p1 = new JPanel(); // score panel
	private JPanel p2GamePanel=new JPanel();
	private JFrame f0= new JFrame("Menu Table");
	
	private JLabel changeLevel1 = new JLabel("Change Level to");
	private JTextField changeLevel2= new JTextField("type 1-10");
	
	private JLabel currentLevel1 = new JLabel("Current Level");
	private JLabel currentLevel2 = new JLabel(currentLevel.toString());
	
	private JLabel Score1 = new JLabel("Score");
	private JLabel Score2 = new JLabel(score.toString());
	private GridLayout layout1 = new GridLayout(3,2);
	
	public Table(JFXPanel gamePanel){
		p2GamePanel.add(gamePanel);
		
		f0.setContentPane(p0);
		f0.setSize (500,600);
		f0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // DISPOSE_ON_CLOSE
		f0.setVisible(true);  
		
		p0.add(p1);
		p0.add(p2GamePanel);
		p1.setLayout(layout1);
		p1.add(changeLevel1);
		p1.add(changeLevel2);
		p1.add(currentLevel1);
		p1.add(currentLevel2);
		p1.add(Score1);
		p1.add(Score2);
		

	}	
}
