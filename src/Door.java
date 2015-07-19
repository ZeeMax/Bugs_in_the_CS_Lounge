import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Door extends Main_Window {

	public Door() {
		try{
			room_image = ImageIO.read( new File(
					"src/Images/door.jpg"));
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