import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Button extends JButton{

	public Button(ImageIcon image) {

	    this.setSize(126,136);
	    this.setIcon(image);
	    this.setOpaque(false);
	    this.setContentAreaFilled(false);
	    this.setBorderPainted(false);
	   /// this.addActionListener(this);
	}
	

}
