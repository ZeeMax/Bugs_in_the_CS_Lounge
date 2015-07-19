import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Far_Wall extends Main_Window {

	public Far_Wall() {
		try{
			room_image = ImageIO.read( new File(
					"src/Images/far_wall.jpg"));
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