import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ImagePanel extends JLabel{
/*	This class takes an image and creates an Image Icon out of it
	*/
	ImageIcon image;
	
	  public ImagePanel(ImageIcon image) {
		  this.image = image;
		  this.setIcon(image);
		 
		  
	  }

}
