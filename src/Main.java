import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.chrono.MinguoChronology;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;


/*Scan can be a nasty place. People are always eating in there and leaving their rubbish about.
NO WONDER THERE IS BUGS EVERYWHERE!

collect all 8 bugs in the Game by clicking on them. 

You can move obsticals aside by clicking and dragging them. */


public class Main{
	
	/// cards is the layout manager for the GUI, it allows JFrames to be switched 
	/// out in response to a button
	
	static CardLayout cards;

	/// This array contains each of the bugs in the game
	public static  Bugs[] smushed_bugs = new Bugs[9];
	
	///These are the maib rooms in the Game. 
	/// They have their own classes because original each area was going to have special features. 
	static public Main_Window main_window = new Main_Window();
	static public KitchenLeft kitchenleft = new KitchenLeft();
	static public Near_Wall near_wall = new Near_Wall();
	static public Far_Wall far_wall = new Far_Wall();
	static public Door door = new Door();
	static public Hanging_Thing hanging_thing = new Hanging_Thing();
	public static Kitchen kitchen = new Kitchen();
	
	/// This array stores the areas in the Game. This array is uses to randomly assign bugs to areas  
	public static Main_Window[] rooms = new Main_Window[7];

	/// This is the main JFrame of the Game 
	static public JFrame frame = new JFrame("Bugs in Scan");
	

	/// These are the arrows that allow you to move Left and Right 
    static ImageIcon leftarrow = new ImageIcon("src/Images/left_arrow_pink.png");
    static JButton left_button = new Button(leftarrow);
    
    static ImageIcon rightarrow = new ImageIcon("src/Images/right_arrow_pink.png");
    static JButton right_button = new Button(rightarrow);

    /// This is an object that allows the obsticals to be dragged 
    public static MouseDragger dragger = new MouseDragger(); // For mouse commands 
    
    Random random = new Random();

	public static void main(String[] args) {

	/*The variable frame contains window in which we will diplay 
	 * the game window and the inventory
	 * */
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(null);
	frame.setSize(1000, 1000);
	frame.setResizable(false);

	cards = new CardLayout();

	
	/*The variable main_window is an instance of 
	 * MAin_WIndow which extends J panel. It contains the 
	 * Images of the room that the user will explore
	 * 
	 */
	
	main_window.setLocation(0,0);
	main_window.setSize(1000, 800);
	main_window.setLayout(cards);
	
	
	/// The Layoutd for these areas must be set to null in order to randomply olace bugs  
	kitchenleft.setLayout(null);

	kitchen.setLayout(null);

	near_wall.setLayout(null);

	far_wall.setLayout(null);

	door.setLayout(null);

	hanging_thing.setLayout(null);

	/// add all the areas to the rooms list 
	rooms[0] = main_window;
	rooms[1] = near_wall;
	rooms[2] = kitchenleft;
	rooms[3] = kitchen;
	rooms[4] = far_wall;
	rooms[5] = hanging_thing;
	rooms[6] = door; 
	/*the variable inventory is an Instance of the 
	 * Inventory class that extends JPanel.
	 * The Layout of inventory is a Flow Layout
	 *
	 * */
	Inventory inventory = new Inventory();
	inventory.setSize(990,199);
	inventory.setLocation(0,800);
	///window.setBackground(Color.RED);
	inventory.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
	inventory.setLayout(new FlowLayout(FlowLayout.LEFT));
	inventory.setBackground(Color.BLACK);
	
	/*Key image is an object that floats above the main window. 
	 * it is displayed by first loading the image into an image icon,
	 * then passing that image as the parameter to the Class Image Panel,
	 * which extends JLabel.
	 * Finally, i set the bounds on the image. This step is nessasary in order to
	 * call setLocation() on the image  
	 * 
	 * Note: the image is saved with a clear background already, this step was
	 * not preformed in Java 
	 * */
	
	//// Action listeners for the Left and Right Buttons 
	/// The Left button will flip to the previous card
	/// the Right Button will flip to the next card 
    
    left_button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			cards.previous(main_window);
			
			frame.repaint();
		}
	});
    
    right_button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			cards.next(main_window);
			
			frame.repaint();
		}
	});
    

	
    /// Add the Obsticals by importing the picture, converting to Jlabel
    /// and setting prefered size 

    ImageIcon fly_swatter = new ImageIcon("src/Images/flyswatter.png");
    JLabel flyswatter = new JLabel(fly_swatter);
    flyswatter.setSize(flyswatter.getPreferredSize());
    
    ImageIcon dog_costume = new ImageIcon("src/Images/dogcostume.png");
    JLabel dogcostume = new JLabel(dog_costume);
    dogcostume.setSize(dogcostume.getPreferredSize());
    
    ImageIcon trash_pic = new ImageIcon("src/Images/trash.png");
    JLabel trash = new JLabel(trash_pic);
    trash.setSize(trash.getPreferredSize());
    
    ImageIcon crumpled_paper = new ImageIcon("src/Images/crumpled_grade.png");
    JLabel crumpledpaper = new JLabel(crumpled_paper);
    crumpledpaper.setSize(crumpledpaper.getPreferredSize());
    
    ImageIcon crumpled_paper_2 = new ImageIcon("src/Images/paper_sized.png");
    JLabel crumpledpaper_2 = new JLabel(crumpled_paper_2);
    crumpledpaper_2.setSize(crumpledpaper_2.getPreferredSize());
    
    ImageIcon lucky_pic = new ImageIcon("src/Images/lucky.png");
    JLabel lucky = new JLabel(lucky_pic);
    lucky.setSize(lucky.getPreferredSize());
    
    ImageIcon cat_pic = new ImageIcon("src/Images/cat_3.png");
    JLabel cat_3 = new JLabel(cat_pic);
    cat_3.setSize(cat_3.getPreferredSize());
    
    ImageIcon cat_pic_2 = new ImageIcon("src/Images/cat2.png");
    JLabel cat_2 = new JLabel(cat_pic_2);
    cat_2.setSize(cat_2.getPreferredSize());
    
    ImageIcon deer_pic = new ImageIcon("src/Images/deer.png");
    JLabel deer = new JLabel(deer_pic);
    deer.setSize(deer.getPreferredSize());
    
    ImageIcon fries_pic = new ImageIcon("src/Images/fries.png");
    JLabel fries = new JLabel(fries_pic);
    fries.setSize(fries.getPreferredSize());
    
    ImageIcon pastery_pic = new ImageIcon("src/Images/pastery.png");
    JLabel pastery = new JLabel(pastery_pic);
    pastery.setSize(pastery.getPreferredSize());

    
    /// Make the obsticals dragable 
    dragger.makeDraggable(lucky);
    dragger.makeDraggable(trash);
    dragger.makeDraggable(dogcostume);
    dragger.makeDraggable(flyswatter);
    dragger.makeDraggable(cat_3);
    dragger.makeDraggable(cat_2);
    dragger.makeDraggable(crumpledpaper);
    dragger.makeDraggable(crumpledpaper_2);
    dragger.makeDraggable(deer);
    dragger.makeDraggable(fries);
    dragger.makeDraggable(pastery);
    
    
    /// Place the obsticals in Random positions 
    Random random = new Random();
    door.add(trash).setLocation(random.nextInt(800), random.nextInt(800));
    door.add(dogcostume).setLocation(random.nextInt(800), random.nextInt(800));
    hanging_thing.add(flyswatter).setLocation(random.nextInt(800), random.nextInt(800));;
    kitchen.add(cat_3).setLocation(random.nextInt(800), random.nextInt(800));
    kitchen.add(crumpledpaper).setLocation(random.nextInt(800), random.nextInt(800));
    far_wall.add(fries).setLocation(random.nextInt(800), random.nextInt(800));
    far_wall.add(cat_2).setLocation(random.nextInt(800), random.nextInt(800));
    near_wall.add(deer).setLocation(random.nextInt(800), random.nextInt(800));
    near_wall.add(crumpledpaper).setLocation(random.nextInt(800), random.nextInt(800));
    kitchenleft.add(pastery).setLocation(random.nextInt(800), random.nextInt(800));
    kitchenleft.add(crumpledpaper_2).setLocation(random.nextInt(800), random.nextInt(800));
    kitchenleft.add(lucky).setLocation(random.nextInt(800), random.nextInt(800));
   
    
    
    /// Create the Bugs
    /// note: Bugs are intilized with a smushed variable set to false 
    ImageIcon roach = new ImageIcon("src/Images/roach.png");
    Bugs roach_1 = new Bugs(roach);
    Bugs roach_2 = new Bugs(roach);
    Bugs roach_3 = new Bugs(roach);
    Bugs roach_4 = new Bugs(roach);
    Bugs roach_5 = new Bugs(roach);
    Bugs roach_6 = new Bugs(roach);
    Bugs roach_7 = new Bugs(roach);
    Bugs roach_8 = new Bugs(roach);
    Bugs roach_9 = new Bugs(roach);
    
    
    /// Add bugs to the array 
    smushed_bugs[0] = roach_1;
    smushed_bugs[1] = roach_2;
    smushed_bugs[2] = roach_3;
    smushed_bugs[3] = roach_4;
    smushed_bugs[4] = roach_5;
    smushed_bugs[5] = roach_6;
    smushed_bugs[6] = roach_7;
    smushed_bugs[7] = roach_8;
    smushed_bugs[8] = roach_9;

    /// Create the Card Layout 
	cards.show(main_window, "Kitchen");

	main_window.add(door, "Door");
	main_window.add(near_wall, "Near Wall");
	main_window.add(kitchenleft, "KitchenLeft");
	main_window.add(kitchen, "Kitchen");
	main_window.add(far_wall, "Far Wall");
	main_window.add(hanging_thing, "Hanging Thing");
;
	
/// Randoly place the bugs in areas of the confrence room 
for (int i = 0; i <= smushed_bugs.length - 1; i ++){
	
	if (smushed_bugs[i].collected == false){

		//Random random = new Random();
		int room_index= random.nextInt(7);
		Main_Window room = rooms[room_index];
		int x = random.nextInt(800);
		int y = random.nextInt(800);
		
		room.add(smushed_bugs[i]).setLocation(x,y);
	
	}

}


	/// Add everything to the screen 
	frame.add(left_button).setLocation(0,400);
	frame.add(right_button).setLocation(850, 400);
	
	/// add the inventory to the frame 
	frame.add(inventory);
	frame.add(main_window);
	

	/// Make Everything visiable 
	frame.setVisible(true);
	//main_window.repaint();
	
	}

	
	/// This is the class that makes things visiable 
    public static class MouseDragger extends MouseAdapter {
        private Point lastLocation;
        private Point lastLocation1;
        private Component draggedComponent;
        private Component draggedComponent1;

        @Override
        public void mousePressed(MouseEvent e) {
            draggedComponent = e.getComponent();
            lastLocation = SwingUtilities.convertPoint(draggedComponent, e.getPoint(), draggedComponent.getParent());
            
            draggedComponent1 = e.getComponent();
            lastLocation1 = SwingUtilities.convertPoint(draggedComponent1, e.getPoint(), draggedComponent1.getParent());
        }

       // @Override
       
        public void mouseDragged(MouseEvent e) {
            Point location = SwingUtilities.convertPoint(draggedComponent, e.getPoint(), draggedComponent.getParent());
            if (draggedComponent.getParent().getBounds().contains(location)) {
                Point newLocation = draggedComponent.getLocation();
               newLocation.translate(location.x - lastLocation.x, location.y - lastLocation.y);
                newLocation.x = Math.max(newLocation.x , 0);
                newLocation.x = Math.min(newLocation.x, draggedComponent.getParent().getWidth() - draggedComponent.getWidth());
                newLocation.y = Math.max(newLocation.y, 0);
                newLocation.y = Math.min(newLocation.y, draggedComponent.getParent().getHeight() - draggedComponent.getHeight());
                draggedComponent.setLocation(newLocation);
                lastLocation = location;
            }
            
            
            
       
        
        }
   
        @Override
        public void mouseReleased(MouseEvent e) {
            lastLocation = null;
            draggedComponent = null;
        }

        public void makeDraggable(Component component) {
            component.addMouseListener(this);
            component.addMouseMotionListener(this);
        }

    }
	

}
