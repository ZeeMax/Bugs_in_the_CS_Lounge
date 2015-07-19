import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Bugs extends JButton implements ActionListener{
	
	boolean collected = false;
	ImageIcon image;

	public Bugs(ImageIcon image) {
		this.image = image;
		this.setIcon(image);
		this.setOpaque(false);
	    this.setContentAreaFilled(false);
	    this.setBorderPainted(false);
	    this.setBounds(0,0, 100, 100);
	    this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this){
			this.collected = true;
			this.setVisible(false);
			System.out.println("Clicked");
		}
		
	}

}
