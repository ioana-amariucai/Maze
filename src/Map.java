import java.awt.*;
import java.io.File;
import java.util.*;

import javax.swing.ImageIcon;

public class Map {
	
	public int actions [][];
	
	private Scanner m;
	private String Map[] = new String[5];
	private Image grass, wall, finish;
	
	public Map(){
		
		ImageIcon img = new ImageIcon("D://Licenta//Maze//utils//grass.png");
		grass = img.getImage();
		
		img = new ImageIcon("D://Licenta//Maze//utils//wall.png");
		wall = img.getImage();
		
		img = new ImageIcon("D://Licenta//Maze//utils//finish.png");
		finish = img.getImage();
		
		openFile();
		readFile();
		closeFile();
	}
	
	public Image getGrass(){
		return grass;
	}
	
	public Image getFinish(){
		return finish;
	}
	
	public Image getWall(){
		return wall;
	}
	
	
	public String getMap(int x, int y){
		String index = Map[y].substring(x, x + 1);
		return index;
	}
	
	public void openFile(){
		try{
			m = new Scanner(new File("D://Licenta//Maze//utils//Map.txt"));
		}catch(Exception e){
			System.out.println("ERROR loading map");
		}
	}
	
	public void readFile(){
		while(m.hasNext()){
			for(int i = 0; i < 5; i++){
				Map[i] = m.next(); //
			}
		}
		
	}
	
	public void closeFile(){
		m.close();
	}

}
