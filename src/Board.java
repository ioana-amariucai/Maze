import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Board extends JPanel implements ActionListener{
//	public int [][] maze = {    { 0, 0, 0, 0, 0 },
//								{ 1, 0, 1, 0, 0 },
//								{ 1, 1, 1, 0, 0 },
//								{ 0, 1, 1, 1, 1 },
//								{ 0, 0, 0, 0, 0 }
//							};

	private Timer timer;
	
	private Map m;
	
	private Player p;
	
	private boolean win = false;
	
	private String Message = " ";
	
	private Font font = new Font("Serif", Font.BOLD, 48);
	
	public Board(){
		
		m = new Map();
		p = new Player();
		addKeyListener(new Al());
		setFocusable(true);
		
		
		timer = new Timer (25, this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(m.getMap(p.getTileX(), p.getTileY()).equals("2")){
			Message  = "Winner :)";
			win = true;
		}
		repaint();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		
		if(!win){
			for( int y = 0; y < 5; y++){
				for( int x = 0; x < 5; x++){
					
					if(m.getMap(x, y).equals("2")){
						g.drawImage(m.getFinish(), x * 32, y * 32, null);
					
					}
					
					if(m.getMap(x, y).equals("1")){
						g.drawImage(m.getGrass(), x * 32, y * 32, null);
					}
					
					if(m.getMap(x, y).equals("0")){
						g.drawImage(m.getWall(), x * 32, y * 32, null);
					}
				}
			}
			g.drawImage(p.getPlayer(), p.getTileX() * 32, p.getTileY() * 32, null);
		}
		
		if(win){
			g.setColor(Color.ORANGE);
			g.setFont(font);
			g.drawString(Message, 130, 230);
		}	
	}
	
	
	public class Al extends KeyAdapter{
		
		public void keyPressed(KeyEvent e){
			
			int keycode = e.getKeyCode();
			int i = 0, j = 0;
			
			if(keycode == KeyEvent.VK_W){
				if( !m.getMap(p.getTileX(), p.getTileY() - 1 ).equals("0")){
					p.move(0, -1);
				}
				
			}
			
			if(keycode == KeyEvent.VK_S){
				if( !m.getMap(p.getTileX(), p.getTileY() + 1 ).equals("0")){
					p.move(0, 1);	
				}
			}
			
			if(keycode == KeyEvent.VK_A){
				if( !m.getMap(p.getTileX() - 1, p.getTileY() ).equals("0")){
					p.move( -1, 0);
				}
			}
			
			if(keycode == KeyEvent.VK_D){
				if( !m.getMap(p.getTileX() + 1, p.getTileY()).equals("0")){
					p.move(1, 0);
				}
			}
			
			}
		
		public void keyReleased(KeyEvent e){
			
		}
		
		public void keyTyped(KeyEvent e){
			
		}
	}
	
	
}
