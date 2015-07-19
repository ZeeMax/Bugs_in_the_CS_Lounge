import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Kitchen extends Main_Window{
	public BufferedImage room_image; 
	
	public Kitchen() {
		try{
			room_image = ImageIO.read( new File(
					"src/Images/kitchen.jpg"));
		}catch(IOException e){
			e.printStackTrace();
		}

	}
	
	@Override
	/// This function overrides the paintComponent Function and
	///paints the room as the Jpanel background
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(room_image,0 ,0, getWidth(), getHeight(), this);

}

}