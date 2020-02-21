import java.awt.Image;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Map {
	
	private Scanner m;
	private String Map[] = new String[14];
	private Image grass, wall, finish;
	
	public Map(){
		ImageIcon img = new ImageIcon("grass.jpg");
		grass = img.getImage();
		img = new ImageIcon("wall.jpg");
		wall = img.getImage();
		img = new ImageIcon("finish.jpg");
		finish = img.getImage();
		openFile();
		readFile();
		closeFile();
	}
	
	public Image getGrass(){
		return grass;
	}
	
	public Image getWall(){
		return wall;
	}
	
	public Image getFinish(){
		return finish;
	}
	
	public String getMap(int x, int y){
		String index = Map[y].substring(x, x+1);
		return index;
	}

	private void closeFile() {
		m.close();
	}

	private void readFile() {
		while(m.hasNext()){
			for(int i = 0; i < 14; i++){
				Map[i] = m.next();
			}
		}
		
	}

	private void openFile() {
		try {
			m = new Scanner(new File("map.txt"));
		} catch (Exception e) {
			System.out.print("Error loading file map.txt");
		}
		
	}

}
