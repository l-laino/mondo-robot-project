package mappa;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import game.ModelGameHandler;
import mappa.Tile;

public class TileHandler {
	ModelGameHandler gh;
	Tile[] tile;
	int [][] mapTiles;
	
	public TileHandler(ModelGameHandler gp) {
		this.gh = gp;
		this.tile = new Tile[10];
		mapTiles = new int [gp.getHEIGHT()][gp.getWIDTH()];
		getTileImage();
		// loadMap();
	}
	
	public void getTileImage() {
		try {
			tile[0] = new Tile();
			tile[0].setImage(ImageIO.read(getClass().getResourceAsStream("/components/ground.png")));
			tile[1] = new Tile();
			tile[1].setImage(ImageIO.read(getClass().getResourceAsStream("/components/wall.png")));
			tile[2] = new Tile();
			tile[2].setImage(ImageIO.read(getClass().getResourceAsStream("/components/ceil.png")));
			tile[3] = new Tile();
			tile[3].setImage(ImageIO.read(getClass().getResourceAsStream("/components/water.png")));
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g) {
		int row = 0, col = 0, x = 0, y = 0;
		while( row < gh.getHEIGHT()) {
			int tNum = mapTiles[row][col];
			g.drawImage(tile[tNum].getImage(), x, y, gh.getTILESIZE(), gh.getTILESIZE(), null);
			col++;
			x += gh.getTILESIZE();
			if(col == gh.getWIDTH()) {
				col = 0;
				x = 0;
				y += gh.getTILESIZE();
				row++;
			}
		}
	}
	
    /*  Questo è il metodo per creare la mappa nel file in modo da continuarla   (per me si può pure togliere questa funzionalità)
	public void newMap() {
		int row = 0, col = 0;
		try {
		      // Create a new file
		      File file = new File("res/maps/output.txt");

		      // Create a FileWriter that will write to the file
		      FileWriter fileWriter = new FileWriter(file);

		      // Write the content to the file
		      
		      while(row < gh.getHEIGHT()){
					while(col < gh.getWIDTH()) {
						if (col > 0 && col < gh.getWIDTH() - 1 && row > 1 && row < gh.getWIDTH()) {
							fileWriter.write("0 ");
						}
						if(col > 0 && col < gh.getWIDTH() - 1 && row == 1 || (row == gh.getHEIGHT() - 1)) {
							fileWriter.write("1 ");
						}
						if ((col == 0 && row < gh.getWIDTH()) || (col == gh.getWIDTH() - 1) && row < gh.getWIDTH() || row == 0 || row == gh.getWIDTH()) {
							fileWriter.write("2 ");
						}
						col++;
					}
					col = 0;
					row++;
					if (row < gh.getHEIGHT()) fileWriter.write(System.lineSeparator());
		        }
		      // Close the FileWriter
		      fileWriter.close();
		    } catch (IOException e) {
		      // Print an error message if there is a problem writing to the file
		      System.out.println("There was a problem writing to the file: " + e.getMessage());
		    }
	}
	
    */ 

    /* Questo metodo dovrebbe essere collegato a quello sopra giusto? 
	public void loadMap() {
		try {
			InputStream map = getClass().getResourceAsStream("/maps/output.txt");
			BufferedReader buffer = new BufferedReader(new InputStreamReader (map));
			
			int row = 0, col = 0;
			while(row < gh.getHEIGHT() && col < gh.getWIDTH()) {
				String line = buffer.readLine();
				while(col < gh.getWIDTH()) {
					String[] numbers = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapTiles[row][col] = num;
					col++;
				}
				if(col == gh.getWIDTH()) {
					col = 0;
					row++;
				}
			}
			buffer.close();
			
		}catch(Exception e){
			
		}
	}
    */
	
}

